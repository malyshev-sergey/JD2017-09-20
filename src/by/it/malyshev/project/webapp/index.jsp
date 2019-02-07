<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
    <h1>Все книги</h1>
    <p class="lead">Пример макета для вывода данных в виде таблицы</p>
</div>

<div class="row">
    <div class="col-md-4">Автор</div>
    <div class="col-md-3">Название</div>
    <div class="col-md-1">Год</div>
    <div class="col-md-2">ISBN</div>
    <div class="col-md-1">Цена</div>
    <div class="col-md-1">Количество</div>
</div>

<br>

<c:forEach items="${fullBooks}" var="fullBook">
    <div class="row">
        <div class="col-md-4">
            <c:forEach items="${fullBook.authors}" var="fullBookAuthor" varStatus="loopStatus">
                    ${fullBookAuthor}
                    <c:if test="${!loopStatus.last}">,</c:if>
            </c:forEach>
        </div>
        <div class="col-md-3"><a href="do?command=book&bookId=${fullBook.id}">${fullBook.title}</a></div>
        <div class="col-md-1">${fullBook.pubyear}</div>
        <div class="col-md-2">${fullBook.isbn}</div>
        <div class="col-md-1">${fullBook.price}</div>
        <div class="col-md-1">${fullBook.quantity}</div>

    </div>
<br>
</c:forEach>


<p>INDEX: ${message}</p>



<t:paginator count="${indexCount}" step="${indexStep}" urlprefix="?start=" current="${indexCurrent}"/>



<%@ include file="include/middle-html.jsp" %>
<%@ include file="include/end-html.jsp" %>