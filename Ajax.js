function getData(url) {
    console.log('comming here...');
    
    const ajax = new XMLHttpRequest();
    ajax.open("GET", url, true);
    ajax.onload = function () {
        if (this.status === 200) {
            console.log("success");
            let data = this.responseText;
            console.log(data);
        }
        else {
            console.log("The error status is =" + this.statusText);
        }
    };
    ajax.send();


}
getData("info.txt");
