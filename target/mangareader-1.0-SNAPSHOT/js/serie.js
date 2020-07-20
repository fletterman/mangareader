function serie() {
    var xmlhttp = new XMLHttpRequest();
    var hash = window.location.hash.substring(1);
    var message = "restservices/series/" + hash;

    xmlhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var currentSerie = JSON.parse(this.responseText);
            sessionStorage.setItem("serie", currentSerie)
            // console.log(currentSerie);
            currentSerie["allChapters"] = sortChapter(currentSerie["allChapters"], "chapterID");
            console.log(currentSerie);
            document.title = currentSerie["seriesName"];
            var item = document.createElement("div");
            item.id = "serieInfo";
            var cover = document.createElement("a");
            var image = document.createElement("img");
            image.alt = currentSerie["seriesName"];
            image.className = "cover";
            image.src = "images/" + currentSerie["seriesID"] + ".jpg";
            cover.appendChild(image);
            item.appendChild(cover);
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

            for (var chapterName in chapters){
                var entry = document.createElement("li");
                entry.innerHTML = "Chapter " + chapters[chapterName]["chapterID"] + ": " + chapterName;
                entry.id = chapters[chapterName]["chapterID"];
                entry.onclick = function (){
                    location.href = "reader.html#" + currentSerie["seriesID"] + "/" + this.id;
                }
                list.appendChild(entry);
                // console.log(chapters[chapterName])
            }

            item.appendChild(list);

            var src = document.getElementById("columnBackground");
            src.appendChild(item);
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
    serie();
}

window.onhashchange = function () {
    var div = document.getElementById('columnBackground');
    while (div.firstChild){
        div.removeChild(div.firstChild);
    }
    serie();
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