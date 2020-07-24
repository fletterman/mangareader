function reader() {

    var chapterInfo = window.location.hash.substring(1);

    var xmlhttp = new XMLHttpRequest();
    var url = "restservices/reader/" + chapterInfo;

    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.responseText);
            console.log(myArr);
            if (myArr.length === 0) {
                document.getElementById("chapternumber").innerHTML = "This chapter doesn't exist."
                document.getElementById("chaptername").innerHTML = "Please try with another chapter"
            } else {
                loadImages(myArr);
                loadImages.onerror = function () {
                    var text = document.createElement("p");
                    var info = document.createTextNode("The reader couldn't find the chapter. Please try again with another chapter");
                    text.appendChild(info);
                    var src = document.getElementById("error");
                    src.appendChild(text);
                }
                loadName(myArr[0]);
                loadNumber(myArr[1]);
                setPrevNext(myArr[1], myArr[2], myArr[3]);
            }
        }
    };

    xmlhttp.open("GET", url, true);
    xmlhttp.send();

    function loadImages(arr) {
        for (let i = 2; i < arr.length; i++) {
            var img = document.createElement("img");
            img.src = arr[i];
            if (arr[i].split("-")) {
                img.className = "images";
            } else {
                img.className = "image";
            }
            var altID = i - 1
            img.alt = altID;
            var src = document.getElementById("images");
            src.appendChild(img);
        }
    }

    function loadName(chapterName) {
        document.getElementById("chaptername").innerHTML = chapterName;
    }

    function loadNumber(chapterNumber) {
        document.getElementById("chapternumber").innerHTML = "Chapter " + chapterNumber + ":";
    }

    function setPrevNext(number, prev, next) {
        if (prev){
            var previous = document.getElementById("previous");
            previous.onclick = function () {
                location.href = "reader.html#" + chapterInfo[0] + "/" + (parseInt(number)-1);
            }
        }
        if (next){
            var next = document.getElementById("next");
            next.onclick = function () {
                location.href = "reader.html#" + chapterInfo[0] + "/" + (parseInt(number)+1);
            }
        }
    }
}

window.onload = function () {
    reader();
}

window.onhashchange = function () {
    var div = document.getElementById("images");
    while (div.firstChild){
        div.removeChild(div.firstChild);
    }
    reader();
}