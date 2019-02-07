<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

    <div class="container">

        <form action="do?command=addBook" method="post">
            <fieldset class="border p-2 rounded">
                <legend class="w-auto">Add author</legend>
                <div class="form-group row">
                    <div class="col-3 text-right">
                        <label for="newAuthorName">Aвтор:</label>
                    </div>
                    <div class="col-4" >
                        <input id="newAuthorName" name="newAuthorName" class="form-control input-md"/>
                    </div>
                    <div class="col-2">
                        <button id="createNewAuthor" name="createNewAuthor" class="btn btn-primary">Add</button>
                    </div>
                </div>
            </fieldset>
        </form>

        <br>

        <form  action="do?command=addBook" method="post">
            <fieldset class="border p-2 rounded">
                <legend class="w-auto">Add book</legend>
                  <div class="form-group row">
                      <div class="col-3 text-right">Название:</div>
                      <div class="col-8">
                        <input id="newBookTitle" name="newBookTitle" class="form-control input-md"/>
                      </div>
                  </div>
                  <div class="form-group row">
                      <div class="col-3 text-right">Год:</div>
                      <div class="col-2">
                        <input type="text" id="newBookPubYear" name="newBookPubYear" class="form-control input"/>
                     </div>
                  </div>
                  <div class="form-group row">
                      <div class="col-3 text-right">ISBN:</div>
                      <div class="col-6">
                        <input id="newBookIsbn" name="newBookIsbn" class="form-control input-md"/>
                      </div>
                  </div>
                  <div class="form-group row">
                      <div class="col-3 text-right">Цена:</div>
                      <div class="col-2">
                        <input type="number" min="0.00" max="10000.00" step="0.01" id="newBookPrice" name="newBookPrice" class="form-control input-md"/>
                      </div>
                      <div class="col-4 offset-2">
                        <button id="createNewBook" name="createNewBook" class="btn btn-primary">Add</button>
                      </div>
                   </div>
            </fieldset>
        </form>

    </div>


<%@ include file="include/middle-html.jsp" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>


      <script type="text/javascript">
         $(function() {
            $( "#newBookPubYear" ).datepicker({
                 minViewMode: 2,
                 format: 'yyyy',
                 'autoclose' : true
            });
         });
      </script>
<%@ include file="include/end-html.jsp" %>


