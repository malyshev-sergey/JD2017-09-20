<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=login" method="post">
<fieldset>

<!-- Form Name -->
<div class="row text-center">
<legend class=>Form Name</legend>
</div>

<!-- Text input-->
<div class="form-group row">
  <label class="col-md-4 text-right control-label" for="login">Login</label>
  <div class="col-md-4 text-left">
  <input id="login" name="login" type="text"
   placeholder="" class="form-control input-md" required="">
  <span class="help-block">Your login: min 5 char</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group row">
  <label class="col-md-4 text-right control-label" for="password">Password</label>
  <div class="col-md-4 text-left">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">min 8 symbols</span>
  </div>
</div>


<!-- Button -->
<div class="form-group row">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4 text-left">
    <button id="submit" name="submit" class="btn btn-success">Submit</button>
  </div>
</div>


</fieldset>
</form>




<p>Cmd Login: ${message}</p>

<%@ include file="include/middle-html.jsp" %>
<%@ include file="include/end-html.jsp" %>