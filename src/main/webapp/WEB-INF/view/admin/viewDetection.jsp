<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" >

function fn1()
	{
		var files= document.getElementById("fileName").files;
		//var filename=document.getElementById("fileName");
		
		//inputNode = filename.value.replace("C:\\fakepath\\", "");
		var inputNode= [];
		for(var i= 0;i< files.length; i++)
			{
			alert(files[i].name);
			inputNode.push(files[i].name);
			}
		
		alert(inputNode);
		
		var d=document.getElementById("d1");
		
		var htp=new XMLHttpRequest();
		
		htp.onreadystatechange=function(){
		
			if(htp.readyState==4){
				
				alert(htp.responseText);
				var jsn= JSON.parse(htp.responseText);
				//alert(jsn.stringify["name"])
				alert(jsn["date"])
				alert(jsn["pictures"][0])
				for(var i=0; i<jsn["pictures"].length;i++)
					{
					d.innerHTML= d.innerHTML+"<img src= '../../../document/"+jsn["date"]+"/"+
					jsn["pictures"][i]+"' alt= 'no image height= '142' width= '142'/>";
					}
				
			}
		}
	htp.open("get"," http://127.0.0.1:5000/?imageName="+inputNode,true);
	htp.send();
}
	

</script>
</head>
<body>
	
	
	<input type="file" id="fileName" value="Choose File" enctype= "multipart/form-data" multiple>
	<input type="button" value="Detection" onclick="fn1()">
	<div id="d1"></div>
	
</body>
</html>