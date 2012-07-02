<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j"  prefix="a4j" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Itin&eacute;lib - Liste Abonn&eacute;s</title>
	
	<!-- DEBUT STYLESHEETS -->
	<link href="../assets/css/bootstrap.css" rel="stylesheet">
	<link href="../assets/css/custom.css" rel="stylesheet">
	<link href="../assets/css/datepicker.css" rel="stylesheet">
	<!-- FIN STYLESHEETS -->
	
	<!-- DEBUT JAVASCRIPT -->
	<script src="../assets/js/jquery.js" ></script>
	<script src="../assets/js/bootstrap-dropdown.js"></script>
	<script src="../assets/js/bootstrap-datepicker.js"></script>
	<script src="assets/js/custom.js"></script>
	<!-- FIN JAVASCRIPT -->

</head>
<body>
	<f:view>
		<!-- DEBUT ADMIN NAVBAR -->
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a href="abonnes/index.html"> <img alt=""
						src="../assets/img/logo.png" id="logo"> </a>
	
					<ul class="nav">
						<li><h2>Administration</h2>
						</li>
						<li><a href="../abonnes/index.html">Abonn&eacute;s</a>
						</li>
						<li><a href="../locations/index.html">Points location</a>
						</li>
						<li><a href="../vehicules/index.html">V&eacute;hicules</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- FIN ADMIN NAVBAR -->
	
		<!-- DEBUT CONTAINER -->
		<div class="container-fluid">
	
			<table class="row-fluid">
				<td><h1>R&eacute;servations</h1>
				</td>
				<td><a class="btn btn-success btn-large" style="float: right;"
					href="./new.html">Cr&eacute;er r&eacute;servation</a>
				</td>
			</table>
	
			<div class="row-fluid">
	
				<!-- DEBUT LISTE UTILISATEUR -->
				<div id="listeUtilisateur" class="span9">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>Station de d&eacute;part</th>
								<th># Abonn&eacute;</th>
								<th>Nom abonn&eacute;</th>
								<th>Pr&eacute;nom abonn&eacute;</th>
								<th>Date et heure de d&eacute;part</th>
								<th colspan=3></th>
							</tr>
						</thead>
						<tbody>
							<a4j:form>
								<a4j:repeat value="#{adminResaGlobaleIndexBean.reservationsListView}" var="reservation" >
									<tr>
										<td><h:outputText value="#{reservation.idresaglobale }" /></td>
										<td><h:outputText value="#{reservation.nompointlocation }" /></td>
										<td><a href="#"><h:outputText value="#{reservation.idabonne }" /></a></td>
										<td><a href="#"><h:outputText value="#{reservation.nomabonne }" /></a></td>
										<td><a href="#"><h:outputText value="#{reservation.prenomabonne }" /></a></td>
										<td><h:outputText value="#{reservation.dhreservationprevue }" /></td>
										<td>
											Voir
										</td>
										<td><a href="update.html">Modifier</a></td>
										<td><a href="">Supprimer</a></td>
									</tr>
								</a4j:repeat>
							</a4j:form>
						</tbody>
					</table>
				</div>
				<!-- FIN LISTE UTILISATEUR -->
	
	
				<!-- DEBUT SPAN3 RECHERCHE -->
				<div class="span3">
					<!-- DEBUT DU FORMULAIRE DE RECHERCHE -->
					<form id="boxRechercher" class="well form-search">
						<h3>Rechercher</h3>
	
						<div class="control-group">
							<label class="control-label" for="numReservation">N°
								r&eacute;servation :</label>
							<div class="controls">
								<input type="text" class="input-large" id="numReservation">
							</div>
						</div>
	
						<div class="control-group">
							<label class="control-label" for="numAbonne">N°
								abonn&eacute; :</label>
							<div class="controls">
								<input type="text" class="input-large" id="numAbonne">
							</div>
						</div>
	
						<div class="control-group">
							<label class="control-label" for="nomAbonne">Nom
								abonn&eacute; :</label>
							<div class="controls">
								<input type="text" class="input-large" id="nomAbonne">
							</div>
						</div>
	
						<div class="control-group">
							<label class="control-label" for="prenomAbonne">Pr&eacute;nom
								abonn&eacute; :</label>
							<div class="controls">
								<input type="text" class="input-large" id="prenomAbonne">
							</div>
						</div>
	
						<div class="control-group">
							<label class="control-label" for="stationDepart">Station
								de d&eacute;part :</label>
							<div class="controls">
								<input type="text" class="input-large" id="stationDepart">
							</div>
						</div>
	
						<div class="control-group">
							<label class="control-label" for="dp2">Date :</label>
							<div class="controls">
								<input id="dp2" class="span10" type="text"
									data-date-format="mm/dd/yy" value="">
							</div>
						</div>
	
						<button class="btn" type="submit">Rechercher</button>
					</form>
					<!-- FIN DU FORMULAIRE DE RECHERCHE -->
				</div>
				<!-- FIN SPAN3 RECHERCHE -->
			</div>
	
		</div>
		<!-- FIN CONTAINER -->
	
		
	</f:view>
</body>
</html>