<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>

<c:set var="cpath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url var ="url_jqlib" value="/static/js/jquery-3.4.1.min.js"/>
<script src="${url_jqlib}"></script>
<c:url var ="url_css" value="/static/css/style.css"/>
<link href="${url_css}" rel="stylesheet" type="text/css">
	<script>
		$(document).ready(function() {
			$("#id_check_avail").click(function(){
				$.ajax({
					url : 'check_avail',
					data : {username: $("#id_username").val() },
					success : function(data) {
						$("#id_res_div").html(data);
					}
				});
			});
		});
	
	</script>
<title>User Registration- Contact Application</title>
</head>
<body>
	<table border="1" width="80%" align="center">
		<tr>
			<td height="80px;">
				<jsp:include page="include/header.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="25px;">
				<jsp:include page="include/menu.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">
				<h3>User Registration</h3>
				<c:if test="${error != null }">
					<p style="color: red;">${error}</p>
				</c:if>
				<c:if test="${param.act eq 'lo' }">
					<p style="color: green;">Logout Successful.</p>
				</c:if>
				<s:url var="url_reg" value="/register"/>
				<f:form action="${url_reg}" modelAttribute="registerCommand">
					<table border="1">
					
					<tr>
						<td>Name</td>
						<td><f:input path="user.name"/></td>
					</tr>
					<tr>
						<td>Phone</td>
						<td><f:input path="user.phone"/></td>	
					</tr>
					<tr>
						<td>Email</td>
						<td><f:input path="user.email"/></td>	
					</tr>
					<tr>
						<td>Address</td>
						<td><f:textarea path="user.address"/></td>	
					</tr>
					
					<tr>
						<td>User Name:</td>
						<td><f:input id= "id_username" path="user.login_name"/>
							<button type="button" id="id_check_avail" >Check Availability</button>
							<div id="id_res_div" class="error"></div>
						</td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><f:password path="user.password"/></td>		
					</tr>
					<tr>
						<td colspan="2" align="right"><button>Register</button> <br/>
						</td>		
					</tr>
					</table>				
				</f:form>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<jsp:include page="include/footer.jsp"></jsp:include>
			</td>
		</tr>
		
	</table>
</body>
</html>