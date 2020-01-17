<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page isELIgnored="false"%>

<c:set var="cpath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact List- Contact Application</title>
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
				<h3>Contact List</h3>
				<c:if test="${param.act eq 'sv' }">
					<p style="color: green;">Contact Saved Successfully.</p>
				</c:if>
				<c:if test="${param.act eq 'del' }">
					<p style="color: green;">Contact Deleted Successfully.</p>
				</c:if>
				
				<c:if test="${param.act eq 'ed' }">
					<p style="color: green;">Contact Updated Successfully.</p>
				</c:if>
				
				<s:url var="url_login" value='/login'/>
				<s:url var="url_register" value="/reg_form"/>
				
				<table width="100%">
					<tr>
						<td align="right">
							<form action="<s:url value="/user/contact_search"/>">
								<input type="text" name="freeText" title="Enter Text to Seacrh" value="${param.freeText}"/>
								<button>Find</button>
							</form>
						</td>
					</tr>
				</table>
				
				<form action="<s:url value="/user/bulk_contact_delete"/>">
					<button> Delete Selected Records</button> 
					<p></p>
					<table border="1" cellpadding="3">
						<tr>
							<th>Select</th>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Address</th>
							<th>Remark</th>
							<th>Action</th>
						</tr>
						
						<c:if test="${empty  contactList}">
							<tr>
								<td colspan="8" align="center" style="color:red;">
									No Records Found.
								</td>
							</tr>
						</c:if>
						
						<c:forEach var="contact" items="${contactList}" varStatus="st">
								<tr>
									<td align="center"><input type="checkbox" name="cid" value="${contact.user_contact_id}"/></td>
									<td>${contact.name}</td>
									<td>${contact.phone}</td>
									<td>${contact.email}</td>
									<td>${contact.address}</td>
									<td>${contact.remark}</td>
									<s:url var="url_del" value="/user/del_contact">
										<s:param name="cid" value="${contact.user_contact_id}"/>
									</s:url>
									<s:url var="url_edit" value="/user/edit_contact">
										<s:param name="cid" value="${contact.user_contact_id}"/>
									</s:url>
									<td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>
								</tr>
							</c:forEach>
						</table>
				</form>				
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