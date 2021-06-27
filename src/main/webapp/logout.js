function logout(){
    let httpr = new XMLHttpRequest();

    httpr.onreadystatechange = function() {

    }

    httpr.open("POST", "/rest/account/logout", true)
    httpr.setRequestHeader("Content-type", "application/xml")
    httpr.send();

}