<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>Lista studentów</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="container">
  <table class="table table-striped">
   <thead class="thead-dark">
    <th scope="row">Numer albumu</th>
    <th scope="row">Imię</th>
    <th scope="row">Nazwisko</th>
    <th scope="row">Semestr</th>
    <th scope="row">Grupa dziekańska</th>
    <th scope="row">Kierunek studiów</th>
    <th scope="row">Lista zaliczeń</th>
    <th scope="row">Edytuj</th>
    <th scope="row">Usuń</th>
   </thead>
   <tbody>
    <c:forEach items="${studentList}" var="student" >
     <tr>
      <td>${student.id}</td>
      <td>${student.firstname}</td>
      <td>${student.lastname}</td>
      <td>${student.semester}</td>
      <td>${student.dgroup}</td>
      <td>${student.fieldofstudy}</td>
      <td>
             <spring:url value="/report/studentCourseList/${student.id}" var="courseListURL" />
             <a class="btn btn-info" href="${courseListURL}" role="button" >Lista zaliczeń</a>
            </td>
      <td>
       <spring:url value="/student/editStudent/${student.id}" var="editURL" />
       <a class="btn btn-info" href="${editURL}" role="button" >Edytuj</a>
      </td>
      <td>
       <spring:url value="/student/deleteStudent/${student.id}" var="deleteURL" />
       <a class="btn btn-danger" href="${deleteURL}" role="button" >Usuń</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/student/addStudent/" var="addURL" />
  <a class="btn btn-success" href="${addURL}" role="button" >Dodaj studenta</a>
 </div>
</body>
