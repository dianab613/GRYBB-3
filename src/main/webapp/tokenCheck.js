function tokenCheck() {


    let httpr = new XMLHttpRequest();

    httpr.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            let token = localStorage.getItem('token');
            console.log(token + " | " + this.response)
            if (token === null) {
                window.location.replace("/loginportal.html");
            } else if (this.response !== token) {
                window.location.replace("/loginportal.html");
            }
        }
    }

    httpr.open("POST", "/rest/account/tokencheck", true);
    httpr.setRequestHeader("Content-type", "application/xml");
    httpr.send();
}



