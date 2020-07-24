document.getElementById("loginbutton").onclick = function login() {
    var xmlhttp = new XMLHttpRequest();
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var run = true;
    if (!username){
        alert("Please fill in an username");
        return;
    }
    if (!password){
        alert("Please fill in a password");
        return;
    }
    var message = "restservices/login/" + username + "/" + password;
    console.log(message);

    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200){
            var admin = JSON.parse(this.responseText);
            console.log(admin);
            if(admin.length == 0){
                alert("Incorrect login")
            }else{
                location.href = "manage.html#" + username;
            }
        } else if (this.status == 400 && run){
            run = false;
            alert("400 error")
        }
    }

    xmlhttp.open("GET", message, true);
    xmlhttp.send();
}