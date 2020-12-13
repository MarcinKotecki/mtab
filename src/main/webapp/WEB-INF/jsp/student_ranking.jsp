<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>Lista rankingowa</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="container">
  <h4>Lista rankingowa ${fieldOfStudy} semestr ${semester}</h4>
  <table class="table table-striped">
   <thead class="thead-dark">
    <th scope="row">Numer albumu</th>
    <th scope="row">Student</th>
    <th scope="row">Średnia</th>
   </thead>
   <tbody>
    <c:forEach items="${objects}" var="ob" >
     <tr>
      <td>${ob[0]}</td>
      <td>${ob[1]} ${ob[2]}</td>
      <td>${ob[3]}</td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
 </div>
</body>
