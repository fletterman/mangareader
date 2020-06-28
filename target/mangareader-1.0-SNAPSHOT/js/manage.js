var xmlhttp = new XMLHttpRequest();
var url = "restservices/series";

var urlVariables = window.location.hash.substring(1).split("&");
console.log(urlVariables);

function loadAllSeries() {
    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var myArr = JSON.parse(this.responseText);
            myArr = sortBySeriesID(myArr, "seriesID");
            if (myArr.length === 0) {
                var src = document.getElementById("columnBackground");
                var title = document.createElement("h1");
                title.innerHTML("ERROR 404");
                src.appendChild(title);
                var text = document.createElement("p");
                text.innerHTML("We couldn't find the items you were looking for, please contact the admins for help");
                src.appendChild(text);
            } else {
                sessionStorage.setItem("series", JSON.stringify(myArr));
                for (series of myArr) {
                    var item = document.createElement("div")
                    item.className = "serie";
                    var cover = document.createElement("a");
                    cover.id = series["seriesID"];
                    cover.onclick = function () {
                        location.href = "manage.html#" + urlVariables[0] + "&" + this.id;
                        location.reload();
                    }
                    var image = document.createElement("img");
                    image.alt = series["seriesName"];
                    image.className = "seriesImage";
                    imageSource = "images/" + series["seriesID"] + ".jpg";
                    image.src = imageSource;
                    cover.appendChild(image);
                    item.appendChild(cover);
                    var title = document.createElement("h3");
                    title.className = "seriesTitle";
                    title.id = series["seriesID"];
                    title.innerHTML = series["seriesName"];
                    title.onclick = function () {
                        location.href = "manage.html#" + urlVariables[0] + "&" + this.id;
                        location.reload();
                    }
                    item.appendChild(title);
                    var src = document.getElementById("columnBackground");
                    src.appendChild(item);
                }
            }
        }
    }

    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function loadSerie(){
    var xmlhttp = new XMLHttpRequest();
    var message = "restservices/series/" + urlVariables[1];

    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var currentSerie = JSON.parse(this.responseText);
            if (currentSerie.length == 0) {

            } else {
                sessionStorage.setItem("serie", currentSerie)
                currentSerie["allChapters"] = sortChapter(currentSerie["allChapters"], "chapterID");
                console.log(currentSerie);
                document.title = currentSerie["seriesName"];
                var item = document.createElement("div");
                item.id = "serieInfo";
                var back = document.createElement("button");
                back.innerHTML = "Back";
                back.className = "backbutton";
                back.onclick = function () {
                    location.href = "manage.html#" + urlVariables[0];
                    location.reload();
                }
                item.appendChild(back);
                var linebreak = document.createElement("br");
                item.appendChild(linebreak);
                var divCover = document.createElement("div");
                divCover.id = currentSerie["seriesID"];
                var cover = document.createElement("a");
                var image = document.createElement("img");
                image.alt = currentSerie["seriesName"];
                image.className = "cover";
                image.src = "images/" + currentSerie["seriesID"] + ".jpg";
                cover.appendChild(image);
                divCover.appendChild(cover);
                var br = document.createElement("br");
                divCover.appendChild(br);
                var coverInput = document.createElement("input");
                coverInput.id = "cover-input";
                coverInput.type = "file";
                coverInput.accept = "image/*"
                divCover.appendChild(coverInput);
                divCover.appendChild(br);
                var coverButton = document.createElement("button");
                coverButton.id = "coverbutton";
                coverButton.innerHTML = "Submit";
                coverButton.onclick = function () {

                }
                divCover.appendChild(coverButton);
                item.appendChild(divCover);
                var title = document.createElement("h1");
                title.className = "serieTitle";
                title.id = "serieTitle";
                title.innerHTML = currentSerie["seriesName"];
                item.appendChild(title);
                var summary = document.createElement("p");
                summary.innerHTML = currentSerie["seriesSummary"];
                summary.id = "serieSummary";
                item.appendChild(summary);
                var list = document.createElement("ul");
                list.className = "ul";
                list.id = "allChapters";
                list.innerHTML = "All chapters:"
                var chapters = currentSerie["allChapters"];

                for (var chapterName in chapters) {
                    var entry = document.createElement("li");
                    entry.innerHTML = "Chapter " + chapters[chapterName]["chapterID"] + ": " + chapterName;
                    entry.id = chapters[chapterName]["chapterID"];
                    entry.onclick = function () {
                        location.href = "reader.html#" + currentSerie["seriesID"] + "/" + this.id;
                    }
                    list.appendChild(entry);
                }

                item.appendChild(list);

                var src = document.getElementById("columnBackground");
                src.appendChild(item);
            }
        }
        if (this.status === 404) {
            var item = document.createElement("div");
            item.id = "serieInfo";
            var title = document.createElement("h1");
            title.innerHTML = "Error 404";
            item.appendChild(title);
            var paragraph = document.createElement("p");
            paragraph.innerHTML = "Please contact any of the mods and try again later";
            item.appendChild(paragraph);
        }
    }

    xmlhttp.open("GET", message, true);
    xmlhttp.send();
}



window.onload = function () {
    document.getElementById("username").innerHTML = urlVariables[0];
    if (urlVariables.length == 1){
        loadAllSeries();
    } else if (urlVariables.length > 1){
        loadSerie();
    }
}

// window.onhashchange = function () {
//     var div = document.getElementById("columnBackground");
//     while (div.firstChild){
//         div.removeChild(div.firstChild);
//     }
//     if (urlVariables[1]){
//         loadSerie();
//     }else{
//         loadAllSeries()
//     }
// }

function sortBySeriesID(array, key) {
    return array.sort(function (a,b) {
        var x = a[key];
        var y = b[key];
        return ((x < y) ? -1: ((x > y) ? 1 : 0));
    });
}

function sortChapter(array) {
    var newArray = new Array();
    for (var keyArray in array) {
        newArray.push(keyArray);
        newArray.push(array[keyArray]);
    }
    newArray.reverse();
    var newJSON = {};
    for (let i = 0; i < newArray.length; i+=2) {
        newJSON[newArray[i+1]] = newArray[i];
    }
    return newJSON;
}