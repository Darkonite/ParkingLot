<%--
  Created by IntelliJ IDEA.
  User: andra
  Date: 12/7/2022
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: andra
  Date: 12/6/2022
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="add" tagdir="/WEB-INF/tags" %>>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<add:pageTemplate pageTitle="Edit Car">
    <h1>Edit Car</h1>

    <form class="needs-validation"  action="${pageContext.request.contextPath}/EditCar" novalidate method="post">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="license_plate">License Plate</label>
                <input type="text" class="form-control"  name="license_plate" id="license_plate" placeholder="" value="${car.licensePlate}" required>
                <div class="invalid-feedback">
                    License Plate is required.
                </div>
            </div>
        </div>



        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="parking_spot">Parking Spot</label>
                <input class="form-control" type="text" name="parking_spot" id="parking_spot" placeholder="" value="${car.parkingSpot}" required>
                <div class="invalid-feedback">
                    Parking Spot is required.
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-md-4">
                <label for="owner_id" class="form-label">Owner</label>
                <select class="form-select" id="owner_id" name="owner_id" required>
                    <option value="" >Choose...</option>
                    <c:forEach var="user" items ="${users}" varStatus="status">
                        <option value="${user.id}"${car.ownerName eq user.username ? 'selected' : ''}>${user.username}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="invalid-feedback">
                Choose is required.
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <button class="w-100 btn btn-primary btn-lg" type="submit">Edit </button>
            </div>
            <div class="invalid-feedback">
                Submit is required.
            </div>
        </div>
        <hr class="mb-4">
        <input type="hidden" name="car_id" value="${car.id}"/>

    </form>
</add:pageTemplate>

