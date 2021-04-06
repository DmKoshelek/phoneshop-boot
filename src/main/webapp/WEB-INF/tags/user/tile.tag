<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="user" required="true" type="com.expertsoft.phoneshop.persistence.model.User" %>

<tr>
    <td><c:out value="${user.id}"/></td>
    <td><c:out value="${user.login}"/></td>
    <td><c:out value="${user.name}"/></td>
</tr>