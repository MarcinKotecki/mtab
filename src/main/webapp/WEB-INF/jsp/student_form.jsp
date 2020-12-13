<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>Dodaj studenta</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="container">
  <spring:url value="/student/addStudent" var="addURL" />
  <h2>Dodaj studenta</h2>
  <form:form modelAttribute="studentForm" method="post" action="${addURL}" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>Imię</label>
    <form:input path="firstname"  id="firstname" />
   </div>
   <div class="form-group">
    <label>Nazwisko</label>
    <form:input path="lastname"  id="lastname" />
   </div>
   <div class="form-group">
     <label>Semestr</label>
     <form:input path="semester"  id="semester" />
   </div>
   <div class="form-group">
     <label>Grupa dziekańska</label>
     <form:input path="dgroup"  id="dgroup" />
   </div>
   <div class="form-group">
     <label>Kierunek studiów</label>
     <form:input path="fieldofstudy"  id="fieldofstudy" />
   </div>
   <button type="submit" class="btn btn-success">Dodaj studenta</button>
  </form:form>
 </div>
</body>
</html>