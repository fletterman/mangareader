// var mysql = require('mysql');

// var con = mysql.createConnection({
//     host: "localhost",
//     user: "root",
//     password: ""
// });

// con.connect(function(err) {
//     if (err) throw err;
//     console.log("Connected");
// });

// const chapterName = () => {
//     var myClass = Java.type("java.src.domeinlaag.SQLDatabaseConnection");
//     document.getElementById("chaptername").innerHTML = myClass.chaptername();
// }
//
// "reader".onclick(function(event){
//     var pWidth = $(this).innerWidth();
//     var pOffset = $(this).offset();
//     var x = e.pageX - pOffset.left;
//     if (pWidth/2 > x){
//
//     }
// });
//
// window.onclick = function(event) {
//     if (event.target.matches('.reader')) {
//         var pWidth = $(this).innerWidth();
//         var pOffset = $(this).offset();
//         var x = e.pageX - pOffset.left;
//         if (pWidth / 2 > x) {
//             $(this).text('left');
//         } else {
//             $(this).text('right');
//         }
//     }
// }
// fetch("restservices/reader/1/1")
// .then(function () {
//     for (let i = 0; i < array.length(); i++) {
//         if (array[i].contains("-")){
//             document.write("<img class=\"images\" src=\"" + array[i] + "\"")
//         }else{
//             document.write("<img class=\"image\" src=\"" + array[i] + "\"")
//         }
//     }
// })
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