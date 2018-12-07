
	//创建全局变量接受AJAX获取的数据
	var deviceData=null;
	var AJAX_SUCCESS=0;	
	//每页显示的最大行数
	var MAX_LEN = 50;
	//接收次数
	var INSERT_TIMES =0;
	//异常次数
	var ERROR_DATA_TIMES = 0;
	//临界数据次数
	var WARN_DATA_TIMES=0;







//点击获取数据，依次执行改变页面结构，获取AJAX数据，1秒一次插入数据
function clickDataAccess(){
	dataTableDisplay();
   
    //如果不在函数内加var,就是隐式声明全局变量，出了函数依然有效
     insert = self.setInterval(function(){
     askForData();
     showData();


    $('#accessingTimes').text(INSERT_TIMES);
	$('#errorTimes').text(ERROR_DATA_TIMES);
	$('#warnTimes').text(WARN_DATA_TIMES);
	if (ERROR_DATA_TIMES||WARN_DATA_TIMES){


		var pic = document.getElementById("pic");
       //激活警报页面,显示警报
		var warn = document.getElementById("warn");
		//warn.classList.add('active');
		//warn.style.fontSize="14px";
		warn.style.color="#d5eef0";
		warn.style.fontWeight="550";
		//显示警报条数
		var warnCount=document.getElementById("warnCount");
		warnCount.style.display="block";
		warnCount.innerHTML=WARN_DATA_TIMES+ERROR_DATA_TIMES;
	}
                                          },1000);
    
   
}




$(document).ready(function(){
  $("#stopButton").click(function(){

      stopDataAccess();}
      );}
        );



//点击停止获取按钮后的逻辑，停止插入行，并显示统计数据
function stopDataAccess(){
	//停止插入的计时器
	
	window.clearInterval(insert);
	alert("共接收"+INSERT_TIMES+"次数据"+",其中有"+ERROR_DATA_TIMES+"次异常数据");
	$('#statistics').fadeIn(1500);
	$('#accessingTimes').text(INSERT_TIMES);
	$('#errorTimes').text(ERROR_DATA_TIMES);
	$('#warnTimes').text(WARN_DATA_TIMES);
    window.clearInterval(insert);
}


//显现datatable,隐藏预设结构
function dataTableDisplay(){
	if (state==0) {
		$('#preload').fadeOut(1200);
		$('#table').fadeIn(1500);
		
}}

//获取对象数组，储存在全局变量里面
function askForData(callback){
	$.ajax({
			type: "GET", //GET或POST,
			async:false, //同步请求，否则无法获取数据
			url: "/dev/test",
			dataType: "json", 
			success: function(data) {
				//console.log(data);
				deviceData = data;
                console.log(deviceData)
				AJAX_SUCCESS=1;
				
				},
			error:function(){console.log("出错了")},
			
		});
	//一定要在SUCCESS外RETURN
	if (AJAX_SUCCESS) {
	return(deviceData);}

}



//插入单条数据到表格的第一行
function insertRow(data){
	
	var dataTable = document.getElementById("dataTable");
	var rows = dataTable.rows;
	var len = rows.length;
	//var random = Math.round(Math.random()*14);
	//var data = deviceData[random];
	INSERT_TIMES=INSERT_TIMES+1;

 var row=dataTable.insertRow(1);

row.insertCell(0).innerHTML =data.Id;
row.insertCell(1).innerHTML =data.deviceName;
row.insertCell(2).innerHTML =data.temperatureF;
row.insertCell(3).innerHTML =data.temperatureC;
row.insertCell(4).innerHTML =data.humidity;
row.insertCell(5).innerHTML =data.time;
row.insertCell(6).innerHTML ="<span class='label label-success'>运转正常</span>";


//如果数据异常，则显示异常数据
if (data.code=="002") {
 row.style.color="red";
 ERROR_DATA_TIMES=ERROR_DATA_TIMES+1;

 row.deleteCell(6);
 row.insertCell(6).innerHTML ="<span class='label label-danger'>异常数据</span>";

 row.deleteCell(1);
 row.insertCell(1).innerHTML =data.deviceName+"<span class='label label-danger m-left-xs'>设备异常</span>";
  


}

//如果有临界警报数据，则显示数据警报
else if(data.code=="003") {
 row.style.color="#ea6f06";
 WARN_DATA_TIMES=WARN_DATA_TIMES+1;

 row.deleteCell(6);
 row.insertCell(6).innerHTML ="<span class='label label-danger'>危险数据</span>";

 row.deleteCell(1);
 row.insertCell(1).innerHTML =data.deviceName+"<span class='label label-danger m-left-xs'>状态警报</span>";
  


}

  }


 //插入一行，一页最多显示MAX_LEN行
function dataTable(data){
	var dataTable = document.getElementById("dataTable");
	var rows = dataTable.rows;
	var len = rows.length;


	if (len<=MAX_LEN) {
		insertRow(data);
	}
	else{
		dataTable.deleteRow(len-1);
		insertRow(data);
	}
}


function showData(){
    console.log(deviceData);
	var dataLength = deviceData.length;

    for (var i = 0; i < deviceData.length; i++) {

    	dataTable(deviceData[i]);
    	
    }	
}





