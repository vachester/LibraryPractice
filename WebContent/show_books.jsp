<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>已有书籍</title>
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	/*****Buttons*****/
    	.right {
			float: right;	
		}
		
		.button {
			width: 4.5em;
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
		/********Light Background Colors********/
		/*Orange*/
		.lightbg-orange {
			background-color: #e65440;
			color: #ffdada;
			-webkit-box-shadow: 0px 0px 0px 1px #b24132 inset, 0px 0px 0px 2px #ea624a inset, 0px 4px 0px 0px #a53c2e, 0px 5px 0px 0px #7e2e23, 0px 8px 0px 0px rgba(0,0,0,.15);
			-moz-box-shadow: 0px 0px 0px 1px #b24132 inset, 0px 0px 0px 2px #ea624a inset, 0px 4px 0px 0px #a53c2e, 0px 5px 0px 0px #7e2e23, 0px 8px 0px 0px rgba(0,0,0,.15);
			-ie-box-shadow: 0px 0px 0px 1px #b24132 inset, 0px 0px 0px 2px #ea624a inset, 0px 4px 0px 0px #a53c2e, 0px 5px 0px 0px #7e2e23, 0px 8px 0px 0px rgba(0,0,0,.15);
			box-shadow: 0px 0px 0px 1px #b24132 inset, 0px 0px 0px 2px #ea624a inset, 0px 4px 0px 0px #a53c2e, 0px 5px 0px 0px #7e2e23, 0px 8px 0px 0px rgba(0,0,0,.15);
		}
		.lightbg-orange:hover {
			background-color: #f15843;
		}
		.lightbg-orange:active {
			background-color: #d54e3b;
			-webkit-box-shadow: 0px 0px 0px 1px #b24132 inset, 0px 0px 0px 2px #ea624a inset, 0px 1px 0px 0px #a53c2e, 0px 3px 0px 0px rgba(0,0,0,.15);
			-moz-box-shadow: 0px 0px 0px 1px #b24132 inset, 0px 0px 0px 2px #ea624a inset, 0px 1px 0px 0px #a53c2e, 0px 3px 0px 0px rgba(0,0,0,.15);
			-ie-box-shadow: 0px 0px 0px 1px #b24132 inset, 0px 0px 0px 2px #ea624a inset, 0px 1px 0px 0px #a53c2e, 0px 3px 0px 0px rgba(0,0,0,.15);
			box-shadow: 0px 0px 0px 1px #b24132 inset, 0px 0px 0px 2px #ea624a inset, 0px 1px 0px 0px #a53c2e, 0px 3px 0px 0px rgba(0,0,0,.15);
		}
		.lightbg-orange .arrow {
			border-color: transparent transparent transparent #ea624a;
		}
		
		
    	.panel-table .panel-body{
  			padding:0;
		}

		.panel-table .panel-body .table-bordered{
		  	border-style: none;
		  	margin:0;
		}

		.panel-table .panel-body .table-bordered > thead > tr > th:first-of-type {
		    text-align:center;
		    width: 100px;
		}

		.panel-table .panel-body .table-bordered > thead > tr > th:last-of-type,
		.panel-table .panel-body .table-bordered > tbody > tr > td:last-of-type {
		  	border-right: 0px;
		}

		.panel-table .panel-body .table-bordered > thead > tr > th:first-of-type,
		.panel-table .panel-body .table-bordered > tbody > tr > td:first-of-type {
			border-left: 0px;
		}

		.panel-table .panel-body .table-bordered > tbody > tr:first-of-type > td{
		  	border-bottom: 0px;
		}

		.panel-table .panel-body .table-bordered > thead > tr:first-of-type > th{
		  	border-top: 0px;
		}

		.panel-table .panel-footer .pagination{
		  	margin:0; 
		}

		.panel-table .panel-footer .col{
		 	line-height: 34px;
		 	height: 34px;
		}

		.panel-table .panel-heading .col h3{
		 	line-height: 30px;
		 	height: 30px;
		}

		.panel-table .panel-body .table-bordered > tbody > tr > td{
		  	line-height: 34px;
		}

    </style>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body background="showresult.jpg">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
	<div class="container">
    	<div class="row">
    		<p></p>
    		<h1 align="center"><strong>全部图书</strong></h1>   
	        <div class="col-md-10 col-md-offset-1">
	            <div class="panel panel-default panel-table">
	              	<div class="panel-body">
	                	<table class="table table-striped table-bordered table-list">
	                  	<thead>
	                    <tr>
	                        <th class="hidden-xs">AuthorName</th>
	                        <th>Title</th>
	                        <th>Publisher</th>
							<th>Price</th>
	                    </tr> 
	                 	</thead>
	                  	<tbody>
	                    <s:iterator value="ExistedBooks" var="single_book">
						<tr>
							<td>
								<s:iterator value="ExistedAuthors" var="single_author">
									<s:if test="#single_author.AuthorID == #single_book.AuthorID">
										<s:url var="authorurl"  value="result">
											<s:param name="AuthorName" value="%{#single_author.Name}"></s:param>
										</s:url>
										<s:a href="%{authorurl}"><s:property value="%{#single_author.Name}"/></s:a>
									</s:if>
								</s:iterator>
							</td>
							<s:url var="url"  value="ShowBook">
									<s:param name="SelectedISBN" value="%{#single_book.ISBN}"></s:param>
							</s:url>
							<td>
								<s:a href="%{url}">《<s:property value="#single_book.Title"/>》</s:a>
							</td>
							<td>
								<s:property value="%{#single_book.Publisher}"/>
							</td>
							<td>
								<s:property value="%{#single_book.Price}"/>
							</td>
						</tr>
						</s:iterator>
	                    </tbody>
	                	</table>
	            	</div>
	        	</div>
			</div>
		</div>
	</div>
	<div class="right">
		<s:url var="backhomeurl" value="index.html">
		</s:url>
		<s:a href="%{backhomeurl}" class="button lightbg-orange "><span>back</span></s:a>
	</div>
</body>
</html>