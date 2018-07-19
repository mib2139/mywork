<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1 style="font-style: bold">Hello world!</h1>
	<ul id="menu">
		<li>MVC
		<ul>
		<li>helloworld 출력 (리턴값-false) <a href="hello.do">Hello world!</a></li>
		<li>helloworld 출력  (리턴값 -ModulandView) <a href="hello2.do">Hello world!</a></li>
		<li>입력 폼 및 결과 출력(@ModulAttribute) <a href="person.do">Person Info Service</a>
		<li>입력 폼 및 결과 출력(@RequestParam) <a href="person2.do">Person Info Service2</a>
		<li>입력 폼 및 결과 출력(입력폼에 초기값을 가짐) <a href="person3.do">Person Info Service3</a>
		</ul>
	</ul>
</body>
</html>
