<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=signup" method="post">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="Your login" class="form-control input-md" required="">
  <span class="help-block">Your login: min 5 symbols</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="Your email" class="form-control input-md" required="">
  <span class="help-block">Your email</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">min 8 symbols</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitbutton"></label>
  <div class="col-md-4">
    <button id="submitbutton" name="submitbutton" class="btn btn-success">Signup</button>
  </div>
</div>

</fieldset>
</form>


<p>Cmd SIGN-UP: ${message}</p>

<%@ include file="include/middle-html.jsp" %>
<%@ include file="include/end-html.jsp" %>


