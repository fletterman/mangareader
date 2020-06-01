var urlpath = window.location.pathname;
console.log(urlpath);
const splitUrl = urlpath.split("/", 4);
console.log(splitUrl)


var xmlhttp = new XMLHttpRequest();
var url = "restservices/reader/0/15";

xmlhttp.onreadystatechange = function () {
    if(this.readyState == 4 && this.status == 200){
        var myArr = JSON.parse(this.responseText);
        loadImages(myArr);
        loadName(myArr[0]);
        loadNumber(myArr[1]);
    }
};

xmlhttp.open("GET", url, true);
xmlhttp.send();

function loadImages(arr) {
    var out = "";
    for (let i = 2; i < arr.length; i++) {
        // if(arr[i].contains("-")){
        //     out+= "<img class=\"images\" src=\"" + array[i] + "\"";
        // }else{
        var img = document.createElement("img");
        img.src = arr[i];
        img.className = "image";
        img.alt = "page";
        var src = document.getElementById("images");
        src.appendChild(img);
            // out+= "<img class=\"image\" src=\"" + arr[i] + "\""
        // }
    }
    console.log(out);
    // document.write(out);
}

function loadName(chapterName) {
    document.getElementById("chaptername").innerHTML = chapterName;
}

function loadNumber(chapterNumber) {
    document.getElementById("chapternumber").innerHTML = "Chapter " + chapterNumber + ":";
}