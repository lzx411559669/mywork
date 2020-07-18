let navLiList= document.getElementById('nav-list').children;
let mainList = document.getElementById('main-list').children;
let title =document.getElementsByClassName('title');
const para = document.querySelector('p');
let navListPara = document.querySelector('.nav-list').children;
// console.log(mainList);
for (let index = 0; index < navLiList.length; index++) {
    navLiList[index].onclick=function(){
        for (let j = 0; j< navLiList.length; j++) {
            navLiList[j].removeAttribute('class');
            mainList[j].removeAttribute('class')
        }

        this.className="current-li";
        mainList[index].className="show";
        para.textContent=navLiList[index].textContent;
    }

}