<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
  <h2>Lista rankingowa</h2>
  <form method="post" action="/report/ranking" cssClass="form" >
   <div class="form-group">
    <label>Kierunek</label>
    <select name="fieldOfStudy">
      <option value="Informatyka">Informatyka</option>
      <option value="Elektrotechnika">Elektrotechnika</option>
    </select>
   </div>
   <div class="form-group">
    <label>Semestr</label>
    <input name="semester"/>
   </div>
   <button type="submit" class="btn btn-success">Zobacz listę</button>
  </form>
 </div>
</body>
</html>