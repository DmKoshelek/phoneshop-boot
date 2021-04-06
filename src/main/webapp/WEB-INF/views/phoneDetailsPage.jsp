<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="phone" type="com.expertsoft.phoneshop.persistence.model.Phone"--%>

<%@ page contentType="text/html;charset=UTF-8"%>
<common:page pageTitle="Phone details" showMenu="true">
    <div class="row mb-3">
        <common:back/>
    </div>
    <div class="row justify-content-center">
        <h2><c:out value="${phone.brand}"/> <c:out value="${phone.model}"/> details</h2>
    </div>
    <div class="row md-8 justify-content-center">
        <div class="col-md-4">
            <img src="<c:url value="https://raw.githubusercontent.com/andrewosipenko/phoneshop-ext-images/master/${phone.image}"/>" width="100%" height="auto" alt="Phone image">
        </div>
        <div class="col-md-4">
            <p><b>Brand:</b> <c:out value="${phone.brand}"/></p>
            <p><b>Model:</b> <c:out value="${phone.model}"/></p>
            <p><b>Price:</b> <c:out value="${phone.price}"/> $</p>
            <p><b>Description:</b> <c:out value="${phone.description}"/></p>
        </div>
    </div>
</common:page>
