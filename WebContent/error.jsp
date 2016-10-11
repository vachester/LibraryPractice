<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>错误页面</title>
	<link href="css/pintuer.css" rel="stylesheet"/>
</head>
<body>
	<div class="container" style=" margin-top:8%;"> 
  		 <div class="panel margin-big-top">
      		<div class="text-center">
         	<br>
        	<h2 class="padding-top"> <stong>慌了吧，小样!</stong> </h2>
         		<div class=""> 
            		<div class="float-left">
                		<img src="ds-1.gif">
                		<div class="alert"> 卧槽！页面不见了！ </div>
            		</div>
           	 		<div class="float-right">
               			<img src="ds-2.png" width="260"> 
            		</div>
          		</div>
          		<div class="padding-big">
          			<s:url var="errorbackurl" value="index.html">
          			</s:url>
               		<s:a href="%{errorbackurl}" class="button bg-yellow">返回主页吧</s:a>
               		<button class="button">简直了，逗比</button>
          		</div> 
      		</div> 
   		</div> 
	</div>
</body>
</html>