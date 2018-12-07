

//定义全局变量
var index = 0;
var timer=null;
var pics=byId("banner").getElementsByTagName("div");
var len = pics.length;

console.log(pics[index]);
//封装函数getElementById
function byId(id){
   return (typeof(id)==="string"?document.getElementById(id):id);
   }

 //封装函数，清除定时器
 function stopAutoPlay(){
 	if (timer) {
 		clearInterval(timer);
 	}
 }
//封装函数，开始自动轮播
 function startAutoPlay(){
 	timer = setInterval(
 		function(){
          index++
          if (index>=len){
          index=0;}
          console.log(index);
          changeImg();
          }
          ,2000);
 }




	



//封装函数 改变图片
function changeImg(){
	for(var i=0;i<len;i++){
		pics[i].style.display="none";
	}

  
   pics[index].style.display = "block";
  
}


function slideImg(){
	var main=byId("main");
	//滑过清除定时器，离开继续
	main.onmouseover=function(){
           stopAutoPlay();
           console.log("鼠标悬停");
	}
	main.onmouseout=function(){
		   startAutoPlay();
		   console.log("鼠标离开");}
 }


 startAutoPlay();
 slideImg();