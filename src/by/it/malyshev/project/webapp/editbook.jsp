<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>


<!-- ****************Start Edit Author -->
<fieldset class="border border-info p-2 rounded">
    <legend class="w-auto">Select author</legend>
    <div class="search-container">
        <div class="ui-widget">
            <div class="form-group row">
                <input type="hidden" id="searchInstance1" name="searchInstance" value="author" />
                <input type="text" id="search1" name="search" class="search col-3 offset-1" />
                <a class="btn btn-primary offset-4" href="do?command=addBook" role="button">Add new author</a>
            </div>
        </div>
    </div>
    <form id="sendReportName1" action="do?" method="post">
        <input type="hidden" id="reportName1" name="reportName" />
        <input type="hidden" name="command" value="editBook" />
    </form>
</fieldset>

<br>

<c:if test="${author!=null}">
    <form action="do?command=editBook" method="post">
        <fieldset class="border p-2 rounded">
            <legend class="w-auto">Edit author</legend>
            <div class="form-group row">
                <div class="col-1">ID:</div>
                <div class="col-5">Автор:</div>
            </div>
            <div class="form-group row">
                <div class="col-1">${author.id}</div>
                <div class="col-5">
                    <input id="editAuthorName" name="editAuthorName" value="${author.authorname}" class="form-control input-md"/>
                </div>
                <div>
                    <button id="authorDelete" name="authorDelete" value="authorDelete" class="btn btn-danger">Удалить</button>
                </div>
                &nbsp;
                <div>
                    <button id="authorEdit" name="authorEdit" value="authorEdit" class="btn btn-primary">Edit</button>
                </div>
            </div>
        </fieldset>
    </form>
</c:if>
<!-- ****************End Edit Author -->

<br>

<!-- ****************Start Edit Book -->



<fieldset class="border border-info p-2 rounded">
    <legend class="w-auto">Select book</legend>
    <div class="search-container">
        <div class="ui-widget">
            <div class="form-group row">
                    <input type="hidden" id="searchInstance2" name="searchInstance" value="book" />
                    <input type="text" id="search2" name="search" class="search col-3 offset-1" />
                    <a class="btn btn-primary offset-4" href="do?command=addBook" role="button">Add new book</a>
            </div>
        </div>
    </div>
    <form id="sendReportName2" action="do?" method="post">
        <input type="hidden" id="reportName2" name="reportBook" />
        <input type="hidden" name="command" value="editBook" />
    </form>
</fieldset>

<br>

<c:if test="${bookId!=null}">




</c:if>



<c:if test="${bookId!=null}">


<form  action="do?command=editBook" method="post">
    <fieldset class="border p-2 rounded">
        <legend class="w-auto">Edit book</legend>
            <div class="form-group row">
                <div class="col-3 text-right">ID:</div>
                <div class="col-8">
                    ${fullBook.id}
                </div>
            </div>
            <div class="form-group row">
                <div class="col-3 text-right">Название:</div>
                <div class="col-8">
                    <input id="editBookTitle" name="editBookTitle" value="${fullBook.title}" class="form-control input-md" />
                </div>
            </div>
            <div class="form-group row">
                <div class="col-3 text-right">Год:</div>
                <div class="col-2">
                    <input type="text" id="editBookPubYear" name="editBookPubYear" value="${fullBook.pubyear}" class="form-control input-md" />
                </div>
            </div>
            <div class="form-group row">
                <div class="col-3 text-right">ISBN:</div>
                <div class="col-6">
                    <input id="editBookIsbn" name="editBookIsbn" value="${fullBook.isbn}" class="form-control input-md" />
                </div>
            </div>
            <div class="form-group row">
                <div class="col-3 text-right">Цена:</div>
                <div class="col-2">
                    <input type="number" min="0.00" max="10000.00" step="0.01" id="editBookPrice" name="editBookPrice" value="${fullBook.price}" class="form-control input-md" />
                </div>
            </div>
            <div class="form-group row">
                <div class="col-3 text-right">Количество:</div>
                <div class="col-2">
                    <input type="number" min="0" max="10000" step="1" id="editBookQuantity" name="editBookQuantity" value="${fullBook.quantity}" class="form-control input-md" />
                </div>
                <label class="control-label" for="updateBook"></label>
                <div class="col-4 offset-2">
                    <button id="deleteBook" name="deleteBook" value="deleteBook" class="btn btn-danger">Delete</button>
                    <button id="updateBook" name="updateBook" value="updateBook" class="btn btn-primary">Update</button>
                </div>
            </div>
    </fieldset>
</form>

<fieldset class="border p-2 rounded">
    <legend class="w-auto">Select author</legend>
    <div class="search-container">
        <div class="ui-widget">
            <div class="form-group row">
                <input type="hidden" id="searchInstance3" name="searchInstance" value="author" />
                <input type="text" id="search3" name="search" class="search col-3 offset-1" />
            </div>
        </div>
    </div>
    <form id="sendReportName3" action="do?" method="post">
        <input type="hidden" id="reportName3" name="reportAuBo" />
        <input type="hidden" name="command" value="editBook" />
    </form>
</fieldset>


<fieldset class="border p-2 rounded">
    <legend class="w-auto">Assigned author(s)</legend>
    <div class="row">
        <div class="col-1">ID:</div>
        <div class="col-5">Автор:</div>
    </div>

    <br>

    <c:forEach items="${fullAuthorBooks}" var="fullAuthorBook" varStatus="loopStatus">
        <form action="do?command=editBook" method="post">
                <div class="form-group row">
                    <div class="col-1">${fullAuthorBook.id}</div>
                       <div class="col-5">
                           <div id="authorName">${fullAuthorBook.authorName}</div>
                       </div>
                       <input type="hidden" name="authorBookId" value="${fullAuthorBook.id}" />
                       <div>
                           <button id="authorBookDelete" name="authorBookDelete" class="btn btn-danger">Unassin</button>
                           <c:if test="${!loopStatus.last}">
                               <button id="authorBookUpdate" name="authorBookUpdate" class="btn btn-primary">&nbsp;<!-- &#x1f87b; -->&#x21e9;&nbsp;</button>
                           </c:if>
                       </div>
                </div>
        </form>
    </c:forEach>
</fieldset>


<fieldset class="border p-2 rounded">
    <legend class="w-auto">Upload image</legend>
    <div class="card mx-auto" style="width: 18rem;">
        <img class="card-img-top" src="${pageContext.request.contextPath}/images/book-cover-${fullBook.id}.jpg alt="" class="img-fluid">
<!--    <div class="card-body">
            <p class="card-text"></p>
        </div> -->
    </div>
    <br>
    <form action="upload" method="post" enctype="multipart/form-data">
        <div class="input-group col-8 offset-2">
            <div class="custom-file">
                <input type="hidden" name="bookId" value="${fullBook.id}" />
                <input type="file" class="custom-file-input" id="inputGroupFile02" name="file">
                <label class="custom-file-label" for="inputGroupFile02">Choose file</label>
            </div>
            <div class="input-group-append">
                <button id="upload" name="upload" class="btn btn-primary">Upload</button>
            </div>
        </div>
    <form>
</fieldset>






</c:if>







<%@ include file="include/middle-html.jsp" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>


<script type="text/javascript">

$("#search1").autocomplete({
      source : function(request, response) {
           $.ajax({
                url : "search",
                type : "GET",
                data : {
                       term : request.term,
                       searchInstance : $("#searchInstance1").val()
                },
                dataType : "json",
                success : function(json) {
                      response($.map(json, function (value, key) {
                                    return {
                                        label: value,
                                        value: key
                                    }
                      }));
                }
         });
      },
      focus: function(event, ui) {
           $('#search1').val(ui.item.label);
           return false;
      },
      select: function( event, ui ) {
        var origEvent = event;
        while (origEvent.originalEvent !== undefined){
            origEvent = origEvent.originalEvent;
        }
        if (origEvent.type == 'click'){
            document.getElementById('search1').value = ui.item.label;
            document.getElementById('reportName1').value = ui.item.value;

            document.getElementById('sendReportName1').submit();
        } else {
            document.getElementById('sendReportName1').submit();
        }
      }
});

$("#search3").autocomplete({
      source : function(request, response) {
           $.ajax({
                url : "search",
                type : "GET",
                data : {
                       term : request.term,
                       searchInstance : $("#searchInstance3").val()
                },
                dataType : "json",
                success : function(json) {
                      response($.map(json, function (value, key) {
                                    return {
                                        label: value,
                                        value: key
                                    }
                      }));
                }
         });
      },
      focus: function(event, ui) {
           $('#search3').val(ui.item.label);
           return false;
      },
      select: function( event, ui ) {
        var origEvent = event;
        while (origEvent.originalEvent !== undefined){
            origEvent = origEvent.originalEvent;
        }
        if (origEvent.type == 'click'){
            document.getElementById('search3').value = ui.item.label;
            document.getElementById('reportName3').value = ui.item.value;

            document.getElementById('sendReportName3').submit();
        } else {
            document.getElementById('sendReportName3').submit();
        }
      }
});


$("#search2").autocomplete({
      source : function(request, response) {
           $.ajax({
                url : "search",
                type : "GET",
                data : {
                       term : request.term,
                       searchInstance : $("#searchInstance2").val()
                },
                dataType : "json",
                success : function(json) {
                      response($.map(json, function (value, key) {
                                    return {
                                        label: value,
                                        value: key
                                    }
                      }));
                }
         });
      },
      focus: function(event, ui) {
           $('#search2').val(ui.item.label);
           return false;
      },
      select: function( event, ui ) {
        var origEvent = event;
        while (origEvent.originalEvent !== undefined){
            origEvent = origEvent.originalEvent;
        }
        if (origEvent.type == 'click'){
            document.getElementById('search2').value = ui.item.label;
            document.getElementById('reportName2').value = ui.item.value;

            document.getElementById('sendReportName2').submit();
        } else {
            document.getElementById('sendReportName2').submit();
        }
      }
});



$('#inputGroupFile02').on('change',function(){
    //get the file name
    var fileName = document.getElementById("inputGroupFile02").files[0].name;
    //var fileName = $(this).val;
    //replace the "Choose a file" label
    $(this).next('.custom-file-label').html(fileName);
});

         $(function() {
            $( "#editBookPubYear" ).datepicker({
                 minViewMode: 2,
                 format: 'yyyy',
                 'autoclose' : true
            });
         });



</script>

<%@ include file="include/end-html.jsp" %>


