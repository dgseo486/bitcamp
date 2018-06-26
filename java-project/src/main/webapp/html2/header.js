var xhr = new XMLHttpRequest();
xhr.open("GET", "/java-project/html/header.html", false);
xhr.send();
header.innerHTML = xhr.responseText;

var xhr = new XMLHttpRequest();
xhr.open("GET", "/java-project/json/auth/loginUser", false);
xhr.send();
if(xhr.responseText == ""){
	location.href = "/java-project/html/auth/login.html";
} else {
	var data = JSON.parse(xhr.responseText);
	username.textContent = data.id;
}