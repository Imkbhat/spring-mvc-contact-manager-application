<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>


<s:url var="url_logout" value="/logout"/>
<s:url var="url_register" value="/reg_form"/>

<c:if test="${sessionScope.userId == null }">
	<%-- User is not yet logged in: guest Menu --%>
	<a href="#">Home</a> | <a href="#">Login</a> | <a href="${url_register}">Register</a> | <a href="#">About</a> | <a href="#">Help</a> 
</c:if>

<c:if test="${sessionScope.userId != null && sessionScope.roleId == 1}">
	<%-- Admin logged in : Menu --%>
	<s:url var="url_ahome" value="/admin/dashboard"/>
	<a href="${url_ahome}">Home</a> | <a href="<s:url value="/admin/users"/>">User List</a> | <a href="${url_logout}">Log Out</a> 
</c:if>

<c:if test="${sessionScope.userId != null && sessionScope.roleId == 2}">
	<%-- General User logged in : Menu --%>
	<s:url var="url_uhome" value="/user/dashboard"/>
	<s:url var="url_cform" value="/user/contact_form"/>
	<s:url var="url_clist" value="/user/clist"/>
	<a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a> | <a href="${url_clist}">Contact List</a> | <a href="${url_logout}">Log Out</a> 
</c:if>