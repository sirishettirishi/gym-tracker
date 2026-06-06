const SessionManager = {
    set(name, value) {
        localStorage.setItem(name, value);
    },

    get(name) {
        return localStorage.getItem(name);
    },

    erase(name) {
        localStorage.removeItem(name);
    },

    isAuthenticated() {
        return localStorage.getItem("userId") !== null;
    },

    logout() {
        localStorage.removeItem("userId");
        localStorage.removeItem("username");
        window.location.href = "index.html";
    }
};