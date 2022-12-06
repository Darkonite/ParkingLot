<%--
  Created by IntelliJ IDEA.
  User: Cosmin
  Date: 06/12/2022
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Add Cars">
<form class="needs-validation" name="parking_spot" novalidate method="post" action="${pageContext.request.contextPath}/AddCar">
 <div> <label>License Plate</label>
  <input class="form-control" id="license_plate" type="text" name="license_plate" required><br>
<div class="invalid-feedback">License Plate is required.
</div>
 </div>

  <div>
  <label>Parking Spot</label>
  <input class="form-control" type="text" id="parking_spot" name="parking_spot" required><br>
   <div class="invalid-feedback">Parking Spot is required.
   </div>
  </div>

 <div>
  <label>Owner</label>
 <select class="form-control">
  <c:forEach var="user" items="${users}" varStatus="status">
  <option value="${user.id}"  name="owner_id">${user.username}</option>
  </c:forEach>
 </select>
  <div class="invalid-feedback">Owner is required.
  </div>
 </div>
 <input type="submit" name="Save">


</form>
</t:pageTemplate>
