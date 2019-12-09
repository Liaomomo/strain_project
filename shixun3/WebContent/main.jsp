<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>实训一</title>
</head>
<body>
<h1>你好！实训一！</h1>
Hello ${object} !!!!!
<div>
      <div><span>显示用户表</span></div>
      <div>
      <table border="1">
      <tr><td>姓名</td><td>性别</td><td>年龄 </td></tr>
      <c:forEach items="${userlist}" var="s">
    	<tr >
        <td>${s.name }</td>
        <td>${s.num }</td>
        <td>${s.age }</td>
    	</tr>
     </c:forEach> 
</table> 
</div> 
</div>

<!– 导入jquery插件文件-->
<script src="../static/jquery.min.js"></script> 
<div>
	<input  type="text" id="searchid" name="searchid"/>
	
	<input  type="button" id="btnsubmit" onclick="searchUsers()" value="查询"/>
</div>
<div id="searchresult">
      
</div>

<script type="text/javascript">
function searchUsers()
{
		var username=$("#searchid").val();
		console.log(username);
		if(username==undefined||null==username||username=="")
		{
			alert("搜索内容不能为空！");
		}
		else
		{
				$.ajax({
					type: 'post',
					     url: '../qd/getusersparam.do',
					     data:JSON.stringify({"name":username},{"age":"18"}),
					     contentType:'application/json;charset=utf-8',
					     dataType: 'json',
					     success: function(dataObj) {
					     console.log(dataObj);
					     var restr="<table> <tr><td>姓名</td><td>性别</td><td>年龄 </td></tr>";
					     for(var i=0;i<dataObj.length;i++)
					     {
					        console.log(dataObj[i]); 	restr+="<tr><td>"+dataObj[i].name
					     		+"</td><td>"+dataObj[i].sex
					     		+"</td><td>"+dataObj[i].age
					     		+"</td></tr>";
					     }
					          restr+="</table>";
					     	$("#searchresult").html(restr);
							console.log(restr);
			
						},
					     error: function(text) {
					     console.log(text);
					 },
					});


}

}
</script>



</body>
</html>