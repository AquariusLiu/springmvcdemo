<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=GBK" %>
<%@page isELIgnored="false" %>

<html>
	<head>
		<title>HelloWorld</title>
		<style type="text/css">
			div.temp {display: none;}
		</style>
	</head>
	
	<body>
		url: <input type="text" id="url" value="api/dnsmap/" /><br/>
		method: <select id="method"><option>POST</option><option>GET</select><br/>
		
		param: <input type="text" id="param" /> value: <input type="text" id="value" /> <button id="addParam">+</button> <br/>
		<form id="form">
			
		</form>
		<div class="temp one_param">
			<span class="param"></span><input class="value" type="text" /><button class="deleteParam" type="button">-</button>
		</div>
		<button id="commit">commit</button>
		
		<br/>
		<textarea id="rlt"></textarea>
		
		<script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function() {
				$(document).ajaxError(function(event, request, ajaxOptions, thrownError) {
					$("#rlt").val(thrownError);
				});
				var render = function(data) {
					$("#rlt").val(data);
				}
				$("#commit").click(function() {
					var method = $("#method").val();
					var url = $("#url").val();
					var params = $("#form").serialize();
					if(method == "POST") {
						$.post(url, params, render, "html");
					} else if(method == "GET") {
						$.get(url, params, render, "html");
					}
				});
				
				$("#addParam").click(function() {
					var $div = $("div.temp").clone();
					$div.removeClass("temp");
					var $input = $div.find("input");
					$div.find("span").text($("#param").val());
					$input.attr("name", $("#param").val());
					$input.val($("#value").val());
					$("#form").append($div);
				});
				
				$(document).on("click", "button.deleteParam", (function() {
					$(this).parent().remove();
				}));
			});
		</script>
	</body>
</html>
