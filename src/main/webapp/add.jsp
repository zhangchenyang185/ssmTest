<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  <h1>新增页面</h1>
  <form action="${pageContext.request.contextPath}/student/add" method="post">
    学生姓名：<input type="text" name="name"><br/>
      学生性别：
      男<input type="radio" name="sex" value="0"<c:if test="${student.sex==0}"> checked</c:if>>
      女<input type="radio" name="sex" value="1"<c:if test="${student.sex==1}"> checked</c:if>>
      <br>
    学生年龄：<input type="text" name="age"><br/>
    学生地址：<input type="text" name="address"><br/>
    <button type="submit">新增</button>
  </form>
</body>
</html>
