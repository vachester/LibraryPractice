<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>添加书籍</title>
	<style type="text/css">
    	/*****Buttons*****/
    	.right {
			float: right;	
		}
		
		.button {
			width: 5.5em;
			display: block;
			-webkit-border-radius: 6px;
			-moz-border-radius: 6px;
			-ie-border-radius: 6px;
			border-radius: 6px;
			padding: .48em .8em;
			text-shadow: rgba(0,0,0,.5) 0px -1px 0px;
			font-size: 18px;
			font-weight: 700;
			-webkit-transition-property: background-color;
			-webkit-transition-duration: .15s;
			-webkit-transition-timing-function: ease-in-out;
			cursor: pointer;
			text-decoration: none;
			margin-bottom: 20px;
		}
		
		.button span {
			vertical-align: middle;
		}
		.icon {
			width: 26px;
			height: 26px;
			-webkit-border-radius: 13px;
			-moz-border-radius: 13px;
			-ie-border-radius: 13px;
			border-radius: 13px;
			background: rgba(0,0,0,.3);
			float: right;
			-webkit-box-shadow: 0px 3px 0px 0px rgba(0,0,0,.2) inset, 0px 0px 0px 1px rgba(255,255,255,.2);
			-moz-box-shadow: 0px 3px 0px 0px rgba(0,0,0,.2) inset, 0px 0px 0px 1px rgba(255,255,255,.2);
			-ie-box-shadow: 0px 3px 0px 0px rgba(0,0,0,.2) inset, 0px 0px 0px 1px rgba(255,255,255,.2);
			box-shadow: 0px 3px 0px 0px rgba(0,0,0,.2) inset, 0px 0px 0px 1px rgba(255,255,255,.2);
		}
		.arrow {
			margin: 7px 0px 0 8px;
			-webkit-border-style: solid;
			-moz-border-style: solid;
			-ie-border-style: solid;
			border-style: solid;
			border-width:6px 6px 6px 12px;
			width: 0;
			height: 0;
		}
		
		/*Blue*/
		.lightbg-blue {
			background-color: #64a8a6;
			color: #dafffe;
			-webkit-box-shadow: 0px 0px 0px 1px #4e8381 inset, 0px 0px 0px 2px #74b6b4 inset, 0px 4px 0px 0px #4a7c7b, 0px 5px 0px 0px #355655, 0px 8px 0px 0px rgba(0,0,0,.15);
			-moz-box-shadow: 0px 0px 0px 1px #4e8381 inset, 0px 0px 0px 2px #74b6b4 inset, 0px 4px 0px 0px #4a7c7b, 0px 5px 0px 0px #355655, 0px 8px 0px 0px rgba(0,0,0,.15);
			-ie-box-shadow: 0px 0px 0px 1px #4e8381 inset, 0px 0px 0px 2px #74b6b4 inset, 0px 4px 0px 0px #4a7c7b, 0px 5px 0px 0px #355655, 0px 8px 0px 0px rgba(0,0,0,.15);
			box-shadow: 0px 0px 0px 1px #4e8381 inset, 0px 0px 0px 2px #74b6b4 inset, 0px 4px 0px 0px #4a7c7b, 0px 5px 0px 0px #355655, 0px 8px 0px 0px rgba(0,0,0,.15);
		}
		.lightbg-blue:hover {
			background-color: #73c2c0;
		}
		.lightbg-blue:active {
			background-color: #5a9896;
			-webkit-box-shadow: 0px 0px 0px 1px #589391 inset, 0px 0px 0px 2px #65a9a7 inset, 0px 1px 0px 0px #355655, 0px 3px 0px 0px rgba(0,0,0,.15);
			-moz-box-shadow: 0px 0px 0px 1px #589391 inset, 0px 0px 0px 2px #65a9a7 inset, 0px 1px 0px 0px #355655, 0px 3px 0px 0px rgba(0,0,0,.15);
			-ie-box-shadow: 0px 0px 0px 1px #589391 inset, 0px 0px 0px 2px #65a9a7 inset, 0px 1px 0px 0px #355655, 0px 3px 0px 0px rgba(0,0,0,.15);
			box-shadow: 0px 0px 0px 1px #589391 inset, 0px 0px 0px 2px #65a9a7 inset, 0px 1px 0px 0px #355655, 0px 3px 0px 0px rgba(0,0,0,.15);
		}
		.lightbg-blue .arrow {
			border-color: transparent transparent transparent #74b6b4;
		}
		
	</style>

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
	<!-- Top content -->
    <div class="top-content">
    	<div class="inner-bg">
    		<div class="container">
            	<div class="row">
                	<div class="col-sm-8 col-sm-offset-2 text">
	                	<div class="right">
							<s:url var="burl" value="index.html">
							</s:url>
							<s:a href="%{burl}" class="button lightbg-blue "><span>cancel</span></s:a>
						</div>
                    	<h1><strong>添加书籍</strong> </h1>
                        <div class="description">
                        	<p>
	                        	注意：ISBN重复添加会出错!不同作家的名字必须不同！如果为新作家，则必须填写Age和Country
                            </p>
                            <p>
	                        	编辑成功后返回搜索界面，失败则重新编辑
                            </p>
                        </div>
                    </div>
                </div>
            	<div>
                	<div class="col-sm-6 col-sm-offset-3 form-box">
                        <form  action="Add" method="post" > 
		                    <div class="form-top">
		                        <div class="form-top-left">
		                        	<h3>Add</h3>
		                            <p>Here are some message you need to fill in.</p>
		                        </div>
		                        <div class="form-top-right">
		                        	<i class="fa fa-user"></i>
		                        </div>
		                    </div>
		                    <div class="form-bottom">
				               	<div class="form-group">
				                	<input type="text" name="AuthorName" placeholder="AuthorName" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    <input type="text" name="ISBN" placeholder="ISBN" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    <input type="text" name="Title" placeholder="Title" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    <input type="text" name="Publisher" placeholder="Publisher" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    <input type="text" name="PublishDate" placeholder="PublishDate" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    <input type="text" name="Price" placeholder="Price" class="form-first-name form-control" id="form-first-name">
				                </div>
				                **若为新作者，则填写
				                <div class="form-group">
				                    <input type="text" name="Age" placeholder="Age" class="form-first-name form-control" id="form-first-name">
				                </div>
				                <div class="form-group">
				                    <input type="text" name="Country" placeholder="Country" class="form-first-name form-control" id="form-first-name">
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