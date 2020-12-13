<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>Lista przedmiotów</title>
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
    <th scope="row">Kod</th>
    <th scope="row">Nazwa</th>
    <th scope="row">Kierownik</th>
    <th scope="row">ECTS</th>
    <th scope="row">Kierunek studiów</th>
    <th scope="row">Semestr</th>
    <th scope="row">Edytuj</th>
    <th scope="row">Usuń</th>
   </thead>
   <tbody>
    <c:forEach items="${courseList}" var="course" >
     <tr>
      <td>${course.id}</td>
      <td>${course.code}</td>
      <td>${course.name}</td>
      <td>${course.personincharge.title} ${course.personincharge.firstname} ${course.personincharge.lastname}</td>
      <td>${course.ects}</td>
      <td>${course.fieldofstudy}</td>
      <td>${course.semester}</td>
      <td>
       <spring:url value="/course/editCourse/${course.id}" var="editURL" />
       <a class="btn btn-info" href="${editURL}" role="button" >Edytuj</a>
      </td>
      <td>
       <spring:url value="/course/deleteCourse/${course.id}" var="deleteURL" />
       <a class="btn btn-danger" href="${deleteURL}" role="button" >Usuń</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/course/addCourse/" var="addURL" />
  <a class="btn btn-success" href="${addURL}" role="button" >Dodaj przedmiot</a>
 </div>
</body>
