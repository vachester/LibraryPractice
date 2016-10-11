<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>编辑书籍</title>
<!-- CSS -->
<!-- <link rel="stylesheet" href="http://fonts.useso.com//css?family=Roboto:400,100,300,500"> -->
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/form-elements.css">
	<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicon and touch icons -->
	<link rel="shortcut icon" href="assets/ico/favicon.png">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

</head>
<body>
    <div class="top-content">
    	<div class="inner-bg">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 col-sm-offset-2 text">
                        <h1><strong>编辑书籍</strong> </h1>
                        <div class="description">
                          	<p>
	                            注意：不能留空，且如果为新作家，则必须填写Age和Country
                            </p>
                            <p>
                            	编辑完后回到新作家的作品展示处,编辑出错需要再次编辑
                            </p>
                        </div>
                    </div>
                </div>
                <div>
                	<div class="col-sm-6 col-sm-offset-3 form-box">
                    	<form  action="Edit" method="post" > 
		                	<div class="form-top">
		                		<div class="form-top-left">
		                        	<h3>Edit</h3>
		                            <p>Please modify message following.</p>
		                        </div>
		                    	<div class="form-top-right">
		                        	<i class="fa fa-user"></i>
		                        </div>
		                    </div>
		                    <div class="form-bottom">
				               	<div class="form-group">
				                    Title:<input type="text" name="eTitle" value="<s:property value="Title"/>" readonly="readonly" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    AuthorName:<input type="text" name="eAuthorName" value="<s:property value="AuthorName"/>" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    Publisher:<input type="text" name="ePublisher" value="<s:property value="Publisher"/>" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    PublishDate:<input type="text" name="ePublishDate" value="<s:property value="PublishDate"/>" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    Price:<input type="text" name="ePrice" value="<s:property value="Price"/>" class="form-first-name form-control" id="form-first-name">
				                </div>
				                **若为新作者，则填写
				                <div class="form-group">
				                    Age:<input type="text" name="eAge" value="<s:property value="Age"/>" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    Country:<input type="text" name="eCountry" value="<s:property value="Country"/>" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <button type="submit" class="btn btn-next">confirm</button>
				            </div>
		                </form>
                    </div>
                </div>
            </div>
        </div>
	</div>

    <!-- Javascript -->
    <script src="assets/js/jquery-1.11.1.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery.backstretch.min.js"></script>
    <script src="assets/js/retina-1.1.0.min.js"></script>
    <script src="assets/js/scripts.js"></script>
        
    <!--[if lt IE 10]>
        <script src="assets/js/placeholder.js"></script>
    <![endif]-->
</body>
</html>