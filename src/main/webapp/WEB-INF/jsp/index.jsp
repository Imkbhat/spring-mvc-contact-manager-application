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
<title>User Login- Contact Application</title>
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
				<h3>User Login</h3>
				<c:if test="${error != null }">
					<p style="color: red;">${error}</p>
				</c:if>
				<c:if test="${param.act eq 'lo' }">
					<p style="color: green;">Logout Successful.</p>
				</c:if>
				<c:if test="${param.act eq 'reg' }">
					<p style="color: green;">Registration Successful.</p>
				</c:if>
				<s:url var="url_login" value='/login'/>
				<s:url var="url_register" value="/reg_form"/>
				<f:form action="${url_login}" modelAttribute="loginCommand">
					<table border="1">
					<tr>
						<td>User Name:</td>
						<td><f:input path="loginName"/></td>		
					</tr>
					<tr>
						<td>Password:</td>
						<td><f:password path="password"/></td>		
					</tr>
					<tr>
						<td colspan="2" align="right"><button>Login</button> <br/>
						<a href="${url_register}">New User Registration</a>
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