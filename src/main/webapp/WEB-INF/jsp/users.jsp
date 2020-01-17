<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<c:url var ="url_jqlib" value="/static/js/jquery-3.4.1.min.js"/>
	<script src="${url_jqlib}"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List- Contact Application</title>
	<script>
	function changeStatus(userId, loginStatus) {
		$.ajax({
			url : 'change_status',
			data:{
				user_id : userId,
				login_status : loginStatus,		
				},
			success: function(data) {
				alert(data);
			}
		})
	}
	
	</script>
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
		<s:url value="/admin/update_login_status" var="login_status_change"></s:url>
			<td height="350px" valign="top">
				<h3>User List</h3>
				<table width="100%" border="1">
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Address</th>
						<th>Login Name</th>
						<th>Login Status</th> 
					</tr>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td>${user.name}</td>
							<td>${user.email}</td>
							<td>${user.phone}</td>
							<td>${user.address}</td>
							<td>${user.login_name}</td>
							<td>
								<select id="id_${user.user_id}" onchange="changeStatus(${user.user_id},$(this).val());">
									<option value="1">Active</option>
									<option value="2">Block</option>
								</select>
								<script>
									$('#id_${user.user_id}').val('${user.login_status}');
								</script>
							</td>
						</tr>					
					</c:forEach>
				</table>
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