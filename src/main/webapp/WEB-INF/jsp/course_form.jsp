<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>Dodaj przedmiot</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="container">
  <spring:url value="/course/addCourse" var="addURL" />
  <h2>Dodaj przedmiot</h2>
  <form:form modelAttribute="courseForm" method="post" action="${addURL}" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>Kod</label>
    <form:input path="code" id="code" />
   </div>
   <div class="form-group">
    <label>Nazwa</label>
    <form:input path="name" id="name" />
   </div>
   <div class="form-group">
     <label>Kierownik</label>
     <form:select path="personincharge">
       <form:options items="${teacherList}" itemLabel="fullName"></form:options>
     </form:select>
   </div>
   <div class="form-group">
     <label>ECTS</label>
     <form:input path="ects" id="ects" />
   </div>
   <div class="form-group">
     <label>Kierunek studiów</label>
     <form:input path="fieldofstudy" id="fieldofstudy" />
   </div>
   <div class="form-group">
     <label>Semestr</label>
     <form:input path="semester" id="semester" />
   </div>
   <button type="submit" class="btn btn-success">Dodaj przedmiot</button>
  </form:form>
 </div>
</body>
</html>