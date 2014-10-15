<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	width: 100%;
	border-collapse: collapse;
}

table thead tr td {
	font-size: 1em;
	border: 1px solid #98bf21;
	padding: 3px 7px 2px 7px;
}

table thead tr th {
	font-size: 1.1em;
	text-align: left;
	padding-top: 5px;
	padding-bottom: 4px;
	background-color: #A7C942;
	color: #ffffff;
}

table thead tr {
	color: #000000;
	background-color: #EAF2D3;
}
</style>
</head>
<body>
	<s:form name="list" action="list" namespace="/">
		<s:textfield name="name" label="name" />
		<s:submit />
	</s:form>
	<s:if test="books.size()>0">
		<table cellspacing="0">
			<thead>
				<tr>
					<th>Title</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="books">
					<tr>
						<td><a
							href='<s:url action="lookup"><s:param name="isbn" value="isbn" /></s:url>'>
								<s:property value="title" />
						</a></td>
						<td><a
							href='<s:url action="delete"><s:param name="isbn" value="isbn" /></s:url>'>
								Delete</a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
	<s:else>

	</s:else>
</body>
</html>