// Session and Cookie Management
const SessionManager = {
    set(name, value, days = 1) {
        let expires = "";
        if (days) {
            let date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            expires = "; expires=" + date.toUTCString();
        }
        document.cookie = name + "=" + (value || "") + expires + "; path=/; SameSite=Lax";
    },

    get(name) {
        let nameEQ = name + "=";
        let ca = document.cookie.split(';');
        for (let i = 0; i < ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) === ' ') c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    },

    erase(name) {
        document.cookie = name + '=; Max-Age=-99999999; path=/; SameSite=Lax';
    },

    isAuthenticated() {
        return this.get("userId") !== null;
    },

    logout() {
        this.erase("userId");
        this.erase("username");
        window.location.href = "index.html";
    }
};
