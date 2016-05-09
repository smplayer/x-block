<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>test</title>
  </head>
  <body>
    <form action="<c:url value="/test/cal"/>" method="POST">
      <input type="text" name="a" />
      <input type="text" name="type" />
      <input type="text" name="b" />
      <br>
      <input type="submit" value="提交" />
    </form>
  </body>
</html>
