var xmlhttp = new XMLHttpRequest();
var url = "restservices/series";
console.log(url);

xmlhttp.onreadystatechange = function () {
    if(this.readyState == 4 && this.status == 200){
        var myArr = JSON.parse(this.responseText);
        myArr = sortBySeriesID(myArr, "seriesID");
        console.log(myArr);
        if(myArr.length === 0){
            var src = document.getElementById("columnBackground");
            var title = document.createElement("h1");
            title.innerHTML("ERROR 404");
            src.appendChild(title);
            var text = document.createElement("p");
            text.innerHTML("We couldn't find the items you were looking for, please contact the admins for help");
            src.appendChild(text);
        }else{
            // sessionStorage.setItem("series", JSON.stringify(myArr));
            for (series of myArr){
                var item = document.createElement("div")
                item.className = "column";
                var cover = document.createElement("a");
                cover.id = series["seriesID"];
                cover.onclick = function () {
                    location.href = "serie.html#" + this.id;
                }
                var image = document.createElement("img");
                image.alt = series["seriesName"];
                image.className = "columnImage";
                imageSource = "images/" + series["seriesID"] + ".jpg";
                image.src = imageSource;
                cover.appendChild(image);
                item.appendChild(cover);
                var title = document.createElement("h3");
                title.className = "columnTitle";
                title.innerHTML = series["seriesName"];
                item.appendChild(title);
                var summary = document.createElement("p");
                summary.className = "columnText";
                summary.innerHTML = series["seriesSummary"];
                item.appendChild(summary);
                var link = document.createElement("a");
                link.id = series["seriesID"];
                link.onclick = function () {
                    location.href = "serie.html#" + this.id;
                }
                var linkText = document.createElement("p");
                linkText.className = "columnLink";
                linkText.innerHTML = "Read more here";
                link.appendChild(linkText);
                item.appendChild(link);
                var src = document.getElementById("columnBackground");
                src.appendChild(item);
            }
        }
    }
}

xmlhttp.open("GET", url, true);
xmlhttp.send();

function sortBySeriesID(array, key) {
    return array.sort(function (a,b) {
        var x = a[key];
        var y = b[key];
        return ((x < y) ? -1: ((x > y) ? 1 : 0));
    });
}