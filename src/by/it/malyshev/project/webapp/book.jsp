<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>


<fieldset class="border p-2 rounded">
    <legend class="w-auto">Selected book</legend>

<div class="row">
<div class="col-4">

                <div class="card mx-auto" style="width: 8rem;">
                    <img class="card-img-top" src="${pageContext.request.contextPath}/images/book-cover-${fullBook.id}.jpg alt="Card image cap" class="img-fluid">
<!--                    <div class="card-body">
                        <p class="card-text"></p>
                    </div> -->
                </div>

</div>

<div class="col-8">


 <div class="container">
  <div class="row">
    <div class="col-2 text-right">Автор(ы):</div>
    <div class="col-10 text-left">
        <c:forEach items="${fullBook.authors}" var="fullBookAuthor" varStatus="loopStatus">
            ${fullBookAuthor}
            <c:if test="${!loopStatus.last}">,</c:if>
        </c:forEach>
    </div>
  </div>
  <div class="row">
    <div class="col-2 text-right">Название:</div>
    <div class="col-10 text-left"><b>${fullBook.title}</b></div>
  </div>
  <div class="row">
    <div class="col-2 text-right">Год:</div>
    <div class="col-10 text-left">${fullBook.pubyear}</div>
  </div>
  <div class="row">
    <div class="col-2 text-right">ISBN:</div>
    <div class="col-10 text-left">${fullBook.isbn}</div>
  </div>
  <div class="row">
    <div class="col-2 text-right">Цена:</div>
    <div class="col-10 text-left">${fullBook.price}</div>
  </div>
  <div class="row">
    <div class="col-2 text-right">Количество:</div>
    <div class="col-10 text-left">${fullBook.quantity}</div>
  </div>
 </div>

<form  action="do" method="get">
       <div class="form-group row">
         <input type="hidden" name="bookId" value="${fullBook.id}" />
         <label class="col-2 control-label" for="submit"></label>
         <div class="col-10 text-left">
           <button id="submit" name="command" value="order" class="btn btn-success">Order</button>
         </div>
       </div>
</form>

</div>
</div>

</fieldset>

 <br>

<fieldset class="border p-2 rounded">
    <legend class="w-auto">Comments</legend>

<div class="container">
    <div class="row">
        <div class="col-2">Пользователь:</div>
        <div class="col-6">Комментарий:</div>
        <div class="col-2"></div>
        <div class="col-2"></div>
    </div>

    <c:forEach items="${fullMessages}" var="fullMessage">
        <div class="row">
            <div class="col-2">${fullMessage.username}</div>
            <div class="col-6">${fullMessage.message}</div>

            <c:choose>
                <c:when test="${fullMessage.users_Id==user.id}">

                     <form class="form-inline" action="do?command=book" method="post">
                        <input type="hidden" name="bookId" value="${fullBook.id}" />
                            <input type="hidden" name="deleteMessageId" value="${fullMessage.id}" />
                            <button id="delete" name="delete" class="btn btn-outline-danger">Удалить</button>
                     </form>

                     &nbsp;
                     <button type="button" id ="editModalButton-${fullMessage.id}" class="btn btn-primary" name="update" data-toggle="modal" data-target="#editModal-${fullMessage.id}">Edit</button>

                     <div class="modal fade" id="editModal-${fullMessage.id}" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
                       <div class="modal-dialog" role="document">
                         <div class="modal-content">
                           <div class="modal-header">
                             <h5 class="modal-title" id="editModalLabel-${fullMessage.id}">Edit message</h5>
                             <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                               <span aria-hidden="true">&times;</span>
                             </button>
                           </div>
                           <div class="modal-body">
                             <form id="editForm-${fullMessage.id}" action="do?command=book" method="post">
                               <div class="form-group">
                                 <input type="hidden" name="BookId" value="${fullBook.id}" />
                                 <input type="hidden" name="updateMessageId" value="${fullMessage.id}" />
                                 <label for="message-text" class="col-form-label">Message:</label>
                                 <textarea class="form-control" id="message-text" name="editMessage">${fullMessage.message}</textarea>
                               </div>
                             </form>
                           </div>
                           <div class="modal-footer">
                             <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                              <button type="button" id="supdate" class="btn btn-primary odom-submit" >Update</button>
                           </div>
                         </div>
                       </div>
                     </div>
                </c:when>
                <c:otherwise>
                    <div class="col-2"></div>
                    <div class="col-2"></div>
                </c:otherwise>
            </c:choose>
        </div>
    </c:forEach>
</div>



 <div class="container">
    <form action="do?command=book" method="post">
            <input type="hidden" name="bookId" value="${fullBook.id}" />
            <label for="newMessage">Добавить комментарий:</label>
        <div class="form-group row">
            <textarea class="form-control col-10" id="newMessage" name="newMessage" rows="2"></textarea>
            <br>
            <div class="col-2">
                <button id="submit" name="createMessage" class="btn btn-primary">Add</button>
            </div>
       </div>
    </form>
 </div>

 </fieldset>


<%@ include file="include/middle-html.jsp" %>

<c:forEach items="${fullMessages}" var="fullMessage">
    <c:choose>
        <c:when test="${fullMessage.users_Id==user.id}">

            <script type="text/javascript">
            $(function () {
                $('body').on('click', '.odom-submit', function (e) {
                    $('#editForm-${fullMessage.id}').submit();
                    $('#editModal-${fullMessage.id}').modal('hide');
                });
            });
            </script>

        </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>

</c:forEach>

<%@ include file="include/end-html.jsp" %>


