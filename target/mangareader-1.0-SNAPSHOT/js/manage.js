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
                var src = document.getElementById("columnBackground");
                var back = document.createElement("button");
                back.innerHTML = "Back";
                back.className = "backbutton";
                back.id = "backbutton";
                back.onclick = function () {
                    location.href = "manage.html#" + urlVariables[0];
                    location.reload();
                }
                src.appendChild(back);
                var div = document.createElement("div");
                src.appendChild(div);
                var item = document.createElement("form");
                item.id = "serieInfo";
                item.className = "form";
                item.enctype = "multipart/form-data";
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
                coverInput.accept = "image/*";
                coverInput.formEnctype = "multipart/form-data";
                divCover.appendChild(coverInput);
                divCover.appendChild(br);
                // var coverButton = document.createElement("button");
                // coverButton.id = "coverbutton";
                // coverButton.innerHTML = "Submit";
                // coverButton.onclick = function () {
                //
                // }
                // divCover.appendChild(coverButton);
                item.appendChild(divCover);
                var title = document.createElement("h1");
                title.className = "serieTitle";
                title.id = "serieTitle";
                title.innerHTML = currentSerie["seriesName"];
                item.appendChild(title);
                var titleInput = document.createElement("input");
                titleInput.id = "titleInput";
                titleInput.type = "text";
                titleInput.placeholder = "Enter new title";
                item.appendChild(titleInput);
                var summary = document.createElement("p");
                summary.innerHTML = currentSerie["seriesSummary"];
                summary.id = "serieSummary";
                item.appendChild(summary);
                var summaryInput = document.createElement("input");
                summaryInput.type = "text";
                summaryInput.id = "summaryInput";
                summaryInput.placeholder = "Enter new summary";
                item.appendChild(summaryInput);
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
                var chapterAdd = document.createElement("button");
                chapterAdd.id = "createChapter";
                chapterAdd.innerHTML = "New chapter";
                chapterAdd.onclick = function (){
                    newChapter();
                }
                item.appendChild(chapterAdd);
                div.appendChild(item);
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

function postCover() {
    var cover = document.getElementById("cover-input").files[0];
    var formData = new FormData();
    var xmlhttp = new XMLHttpRequest();
    var url = "restservices/manage/cover/" + urlVariables[1];

    formData.append("cover", cover);
    xmlhttp.open("POST", url, true);
    xmlhttp.setRequestHeader("enctype", "multipart/form-data")
    xmlhttp.send(formData);
}

function newChapter() {
    var backButton = document.getElementById("backbutton");
    backButton.onclick = function () {
        location.href = "manage.html#" + urlVariables[0] + "&" + urlVariables[1];
        location.reload();
    }
    var div = document.getElementById("serieInfo");
    while (div.firstChild){
        div.removeChild(div.firstChild);
    }
    var titleLable = document.createElement("label");
    titleLable.for = "title";
    titleLable.innerHTML = "Title:";
    div.appendChild(titleLable);
    var titleInput = document.createElement("input");
    titleInput.type = "text";
    titleInput.placeholder = "Enter title";
    titleInput.id = "title";
    titleInput.name = "title";
    div.appendChild(titleInput);
    var chapterNumber = document.createElement("label");
    chapterNumber.for = "chapterNumber";
    chapterNumber.innerHTML = "Chapternumber:";
    div.appendChild(chapterNumber);
    var numberInput = document.createElement("input");
    numberInput.id = "chapterNumber";
    numberInput.type = "number";
    numberInput.placeholder = "Enter chapternumber";
    numberInput.step = "0.1";
    div.appendChild(numberInput);
    var zipLabel = document.createElement("label");
    zipLabel.for = "chapterInput";
    zipLabel.innerHTML = "Chapter:";
    div.appendChild(zipLabel);
    var zipInput = document.createElement("input");
    zipInput.type = "file";
    zipInput.accept = ".zip, .rar, .7zip";
    zipInput.id = "chapterInput";
    div.appendChild(zipInput);
    var addChapterButton = document.createElement("button");
    addChapterButton.id = "addChapterButton";
    addChapterButton.innerHTML = "Create chapter";
    addChapterButton.onclick = function () {
        createChapter();
    }
    div.appendChild(addChapterButton);
    return;
}

function createChapter() {
    // var formData = new FormData(document.getElementById("serieInfo"));
    // console.log(formData);
    var textPost = false;
    var filePost = false;
    var title = document.getElementById("title").value;
    var number = document.getElementById("chapterNumber").value;
    var jsonData = JSON.stringify({"title": title, "number":number, "serieID":urlVariables[1]})
    console.log(jsonData);
    var zip = document.getElementById("chapterInput");
    var xmlhttpText = new XMLHttpRequest();
    var xmlhttpFile = new XMLHttpRequest();
    var url = "restservices/chapter/addChapter/text/" + urlVariables[1];
    var message = "restservices/chapter/addChapter/file/" + urlVariables[1];

    xmlhttpText.open("POST", url, true);
    xmlhttpText.setRequestHeader("Content-Type", "appliation/json;charset=UTF-8");
    xmlhttpText.send(jsonData);

    // xmlhttpFile.open("POST", message, true);
    // xmlhttpFile.setRequestHeader()
}