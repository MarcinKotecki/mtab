<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>Classes List</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="container">
  <table class="table table-striped">
   <thead class="thead-dark">
    <th scope="row">ID</th>
    <th scope="row">Przedmiot</th>
    <th scope="row">Typ</th>
    <th scope="row">Prowadzący</th>
    <th scope="row">Czas rozpoczęcia</th>
    <th scope="row">Czas zakończenia</th>
    <th scope="row">Miejsce</th>
    <th scope="row">Edytuj</th>
    <th scope="row">Usuń</th>
   </thead>
   <tbody>
    <c:forEach items="${coursePartList}" var="coursePart" >
     <tr>
      <td>${coursePart.id}</td>
      <td>${coursePart.course.code} ${coursePart.course.name}</td>
      <td>${coursePart.type}</td>
      <td>${coursePart.teacher.fullName}</td>
      <td>${coursePart.startTime}</td>
      <td>${coursePart.endTime}</td>
      <td>${coursePart.place}</td>
      <td>
       <spring:url value="/coursePart/editCoursePart/${coursePart.id}" var="editURL" />
       <a class="btn btn-info" href="${editURL}" role="button" >Edytuj</a>
      </td>
      <td>
       <spring:url value="/coursePart/deleteCoursePart/${coursePart.id}" var="deleteURL" />
       <a class="btn btn-danger" href="${deleteURL}" role="button" >Usuń</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/coursePart/addCoursePart/" var="addURL" />
  <a class="btn btn-success" href="${addURL}" role="button" >Dodaj termin zajęć</a>
 </div>
</body>
