<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
    <h1>Профиль</h1>
</div>
<div class="row">
    <div class="col-md-4">
        <p><b> Login: ${user.login} </b></p>
        <p><b> Email: ${user.email} </b></p>
    </div>
    <form action="do?command=profile" method="post">
        <fieldset>
            <div class="form-group">
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-danger">Logout</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>

<center>
    <br><br>
</center>

<div class="container">
    <h3>Мои текущие заказы</h1>
</div>

<div class="row">
    <div class="col-md-5">Название</div>
    <div class="col-md-1">Количество</div>
    <div class="col-md-1">Стоимость</div>
</div>
<br>
<c:forEach items="${orders}" var="order">
    <div class="row">
        <div class="col-md-5">
            <c:forEach items="${books}" var="book">
                <c:if test="${order.books_Id==book.id}">
                    <a href="do?command=book&id=${book.id}">${book.title}</a>
                </c:if>
            </c:forEach>
        </div>
        <div class="col-md-1">${order.quantity}</div>
        <div class="col-md-1">
            <c:forEach items="${books}" var="book">
                <c:if test="${order.books_Id==book.id}">
                    ${book.price*order.quantity}
                </c:if>
            </c:forEach>
        </div>
    </div>
<br>
</c:forEach>

<br>

<div class="container">
    <h3>Мои отзывы</h1>
</div>

      <div class="row">
        <div class="col-4">Книга</div>
        <div class="col-8">Отзыв</div>
      </div>

    <c:forEach items="${messages}" var="message">

      <div class="row">
        <c:forEach items="${books}" var="book">
            <c:if test="${message.books_Id==book.id}">
                <div class="col-4"><a href="do?command=book&id=${book.id}">${book.title}</a></div>
            </c:if>
        </c:forEach>
        <div class="col-8">${message.message}</div>
      </div>

    </c:forEach>





<p>Cmd Logout: ${message}</p>

<%@ include file="include/middle-html.jsp" %>
<%@ include file="include/end-html.jsp" %>