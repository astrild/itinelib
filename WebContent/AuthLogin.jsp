<!-- OK 20120621 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j"  prefix="a4j" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Itinélib - Se connecter</title>

  <!-- DEBUT STYLESHEETS -->
  <link href="../assets/css/bootstrap.css" rel="stylesheet">
  <link href="../assets/css/custom.css" rel="stylesheet">
  <!-- FIN STYLESHEETS -->
  <!-- DEBUT JAVASCRIPT -->
  <script src="../assets/js/jquery.js"></script>
  <script src="../assets/js/bootstrap-dropdown.js"></script>
  <!-- FIN JAVASCRIPT -->
</head>
<body>

  <!-- DEBUT NAVBAR -->
  <div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container">
        <a href="../pages/home.html">
          <img alt="" src="../assets/img/logo.png" id="logo">
        </a>

        <div class="pull-right">
          <ul class="nav">
            <li><a href="login.html">Se connecter</a></li>
            <li>
              <form method="link" action="subscribe.html">
                <button class="btn btn-warning" onclick="">S'abonner</button>
              </form>
            </li>
          </ul>
        </div>

        <ul class="nav">
          <li><a href="../pages/howitworks.html">Comment ça marche</a></li>
          <li><a href="../pages/offers.html">Offres &amp; Tarifs</a></li>
          <li><a href="../pages/map.html">Trouver une station</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              Assistance <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
              <li><a href="../pages/contact.html">Nous contacter</a></li>
              <li><a href="../pages/faq.html">Voir toutes les FAQ</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <!-- FIN NAVBAR -->

  <!-- DEBUT PAGE-CANVAS  -->
  <div class="page-canvas">
    <!-- DEBUT CONTAINER  -->
    <div class="container">

      <h1>Se connecter</h1>
	<f:view>
      <h:form styleClass="form-horizontal">

        <div class="control-group">
          <label class="control-label" for="email">Email:</label>
          <div class="controls">
          	<h:inputText id="emailinput" value="#{authBean.email }" styleClass="input-xlarge" />
          </div>
        </div>
        <div class="control-group">
          <label class="control-label" for="password">Password:</label>
          <div class="controls">
          	<h:inputSecret id="passwordinput" value="#{authBean.password }" styleClass="input-xlarge" />
          </div>
        </div>
        <div class="form-actions">
        	<h:commandButton value="Se connecter" action="#{authBean.login }" styleClass="btn btn-success" >
        		<f:param name="id" value="#{authBean.email}" />
        		<f:param name="id" value="#{authBean.password}" />
        	</h:commandButton>
        </div>
      </h:form>			
	</f:view>
    </div>
    <!-- FIN CONTAINER  -->
  </div>
  <!-- FIN PAGE-CANVAS  -->

</body>
</html>