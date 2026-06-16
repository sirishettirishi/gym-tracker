const SessionManager = {
    set(name, value) {
        sessionStorage.setItem(name, value);
    },
    get(name) {
        return sessionStorage.getItem(name);
    },
    erase(name) {
        sessionStorage.removeItem(name);
    },
    isAuthenticated() {
        return sessionStorage.getItem("userId") !== null;
    },
    logout() {
        sessionStorage.clear();
        window.location.href = "index.html";
    }
};