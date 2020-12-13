<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>Rejestracja na przedmiot</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="container">
  <spring:url value="/registration/addRegistration" var="addURL" />
  <h2>Rejestracja na przedmiot</h2>
  <form:form modelAttribute="registrationForm" method="post" action="${addURL}" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>Student</label>
    <form:select path="student">
           <form:options items="${studentList}" itemLabel="nameWithId"></form:options>
         </form:select>
   </div>
   <div class="form-group">
    <label>Przedmiot</label>
    <form:select path="course">
               <form:options items="${courseList}" itemLabel="codeWithName"></form:options>
             </form:select>
   </div>
   <div class="form-group">
     <label>Ocena</label>
     <form:input path="grade" id="grade" />
   </div>
   <button type="submit" class="btn btn-success">Zarejestruj</button>
  </form:form>
 </div>
</body>
</html>