<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<html>
	<head>
		<c:url var ="url_jqlib" value="/static/js/jquery-3.4.1.min.js"/>
		<script src="${url_jqlib}"></script>
		<script>
			$(document).ready(function(){
				//alert("Jquery working.");
				$("#id_get_time").click(function(){
					//alert("Button Clicked.");
					$.ajax({
					       url : 'get_time',
					       success : function(data) {
							$("#id_time").html(data);					    	   
					       }});
				});
			});
		</script>
	</head>
	<body>
		<h1><a href="${url_jqlib}">Link</a></h1>
		<button id="id_get_time">Get Server Time</button>
		<br/>
		<p id="id_time"></p>
	</body>
</html>