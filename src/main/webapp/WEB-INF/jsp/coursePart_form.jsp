<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>Dodaj termin zajęć</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="container">
  <spring:url value="/coursePart/addCoursePart" var="addURL" />
  <h2>Dodaj termin zajęć</h2>
  <form:form modelAttribute="coursePartForm" method="post" action="${addURL}" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>Przedmiot</label>
    <form:select path="course">
      <form:options items="${courseList}" itemLabel="codeWithName"></form:options>
    </form:select>
   </div>
   <div class="form-group">
    <label>Typ</label>
    <form:select path="type">
       <form:options items="${classTypes}"></form:options>
    </form:select>
   </div>
   <div class="form-group">
     <label>Prowadzący</label>
     <form:select path="teacher">
       <form:options items="${teacherList}" itemLabel="fullName"></form:options>
     </form:select>
   </div>
   <div class="form-group">
     <label>Czas rozpoczęcia</label>
     <form:input path="startTime" id="startTime" />
   </div>
   <div class="form-group">
     <label>Czas zakończenia</label>
     <form:input path="endTime" id="endTime" />
   </div>
   <div class="form-group">
     <label>Miejsce</label>
     <form:input path="place" id="place" />
   </div>
   <button type="submit" class="btn btn-success">Dodaj termin zajęć</button>
  </form:form>
 </div>
</body>
</html>