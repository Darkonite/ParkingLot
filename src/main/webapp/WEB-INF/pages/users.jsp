<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="u" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<t:pageTemplate pageTitle="Parking Lot">
  <h1>Welcome to the Users Page</h1>
  <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddUser",>Add User</a>
  </c:if>
  <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/Invoice",>Invoice</a>
  <div class="container text-center">
    <u:forEach var="user" items="${users}">
      <div class="row">
        <div class="col">
            ${user.email}
        </div>
        <div class="col">
            ${user.username}
        </div>
      </div>
    </u:forEach>
  </div>
<c:if test="${not empty invoices}">
  <h2>Invoices</h2>
  <c:forEach var="username" items="${invoices}" varStatus="status">
    ${status.index+1}.${username}
    <br/>
  </c:forEach>
</c:if>

</t:pageTemplate>
