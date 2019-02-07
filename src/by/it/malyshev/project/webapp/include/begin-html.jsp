<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="css/jquery-ui.css" rel="stylesheet">
 <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet"/>
     <style>
      .ui-autocomplete {
        max-height: 100px;
        overflow-y: auto;
        overflow-x: hidden;
      }
      </style>
    <title>Demo project</title>
  </head>
  <body class="py-5">
      <nav class="navbar fixed-top navbar-expand-md navbar-light bg-light">
        <a class="navbar-brand" href=".">Home</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
         aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">

          <ul class="navbar-nav mr-auto">
            <menu:li command="resetDb" text="ResetDB" />
            <menu:li command="addBook" text="AddBook" />
            <menu:li command="editBook" text="EditBook" />
            <menu:li command="editUsers" text="EditUsers" />
            <menu:li command="editOrders" text="EditOrders" />
            <menu:li command="editMessages" text="EditMessages" />
          </ul>

          <ul class="navbar-nav navbar-right">
          <c:choose>
            <c:when test="${user==null}">
                <menu:li command="login" text="Login" />
                <menu:li command="signup" text="Sign-Up" />
            </c:when>
            <c:otherwise>
                <menu:li command="profile" text="Profile" />
            </c:otherwise>
          </c:choose>
          </ul>

        </div>
      </nav>
  <div class="container py-3">







