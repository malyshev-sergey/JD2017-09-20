<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="row">
    <div class=col-md-1>ID</div>
    <div class=col-md-2>Пользователь</div>
    <div class=col-md-3>Книга</div>
    <div class=col-md-4>Отзыв</div>
</div>

<c:forEach items="${messages}" var="message">
<form class="edit-message-${message.id}" action="do?command=editmessages" method=POST>
    <div class="form-row">
        <input id="id" name="id" value="${message.id}" class="form-control input-md col-md-1" title="ID"/>
        <c:forEach items="${users}" var="user">
            <c:if test="${user.id==message.users_Id}">
                <div class="col-md-2">${user.login}</div>
            </c:if>
        </c:forEach>
        <c:forEach items="${books}" var="book">
            <c:if test="${book.id==message.books_Id}">
                <div class="col-md-3">${book.title}</div>
            </c:if>
        </c:forEach>
        <input id="message" name="message" value="${message.message}" class="form-control input-md col-md-4"/>

        <button id="update" name="update" class="btn btn-success col-md-1">
            Update
        </button>

        <button id="delete" name="delete" class="btn btn-danger col-md-1">
            Удалить
        </button>
    </div>
</form>
<br>
</c:forEach>

<%@ include file="include/middle-html.jsp" %>
<%@ include file="include/end-html.jsp" %>


