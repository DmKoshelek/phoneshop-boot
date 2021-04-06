<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<common:page pageTitle="Login" showMenu="false">
    <div class="row mb-3 offset-1">
        <common:back/>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <c:if test="${param.error eq 'form'}">
                        <div class="alert alert-danger" role="alert">
                            Wrong login or password
                        </div>
                    </c:if>
                    <c:if test="${param.error eq 'github'}">
                        <div class="alert alert-danger" role="alert">
                            Can't login with github
                        </div>
                    </c:if>
                    <form method="post">
                        <div class="form-group row">
                            <label for="username" class="col-sm-3 col-form-label">
                                Username:
                            </label>
                            <div class="col-sm-8">
                                <input type="text" id="username" name="username" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="password" class="col-sm-3 col-form-label">
                                Password:
                            </label>
                            <div class="col-sm-8">
                                <input type="password" id="password" name="password" class="form-control"/>
                            </div>
                        </div>
                        <div class="row justify-content-center">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                        <div class="row justify-content-center">
                            <a href="<c:url value="/oauth2/authorization/github"/>">Login via GitHub >></a>
                        </div>
                        <sec:csrfInput />
                    </form>
                </div>
            </div>
        </div>
    </div>
</common:page>