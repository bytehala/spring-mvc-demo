<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

First name: <form:input path="firstName" />
<br><br>
Last name: <form:input path="lastName" />
<br><br>
Country: 
	<form:select path="country">
		<form:options items="${student.countryOptions }" />
	</form:select>
<br><br>
Favorite language:
	Java <form:radiobutton path="favoriteLanguage" value="Java" />
	PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
	C# <form:radiobutton path="favoriteLanguage" value="C#" /> 
<br><br>
<button type="submit" > Submit </button>
</form:form>

</body>
</html>