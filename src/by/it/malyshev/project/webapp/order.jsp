<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<br><br>


  <div class="row justify-content-center">
    <div class="col-md-4 text-right">Название:</div>
    <div class="col-md-4 text-left">${book.title}</div>
  </div>
  <div class="row justify-content-center">
    <div class="col-md-4 text-right">Цена:</div>
    <div class="col-md-4 text-left">${book.price}</div>
  </div>
  <div class="row justify-content-center">
<div class="container">
<form action="do?command=order" method="post">
    <div class="form-group row justify-content-center">
        <label class="col-md-4 text-right control-label" for="quantity">Количество:</label>
        <div class="col-md-1 text-left">
            <select id="quantity" name="quantity" class="form-control">
                <option selected value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
            </select>
        </div>
        <div id="total" class="col-md-3 text-left">
         </div>
    </div>

    <div class="form-group row justify-content-center">
        <input type="hidden" name="id" value="${book.id}" />
        <div class="col-md-4 text-right">
            <a class="btn btn-primary" href="do?command=book&id=${book.id}" role="button">Cancel</a>
        </div>
        <div class="col-md-4 text-left">
            <button id="ok" name="ok" class="btn btn-success">Ok</button>
        </div>
    </div>


    </form>
     </div>


 <br><br>


<%@ include file="include/middle-html.jsp" %>
<%@ include file="include/end-html.jsp" %>


