<!-- OK MANQUE JAVASCRIPT -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j"  prefix="a4j" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Itinélib - Liste Abonnés</title>

<!-- DEBUT STYLESHEETS -->
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<link href="../assets/css/custom.css" rel="stylesheet">
<link href="../assets/css/datepicker.css" rel="stylesheet">
<!-- FIN STYLESHEETS -->
</head>
<body>
<f:view>
<h:panelGroup rendered="#{!authBean.admin}">
			<script type="text/javascript">
			window.location.href = "/itinelib/faces/AuthLogin.jsp";
			</script>
</h:panelGroup>
	<!-- DEBUT ADMIN NAVBAR -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a href="../abonnes/index.html">
					<img alt="" src="../assets/img/logo.png" id="logo">
				</a>

				<ul class="nav" style="float: right; margin-top: 8px;">
					<li><h:outputText value="#{authBean.current.email }" /></li>
					<li>
							<h:form >
							<h:commandLink value="Deconnexion" action="#{authBean.logout}" />
							</h:form>
					</li>
				</ul>
				
				<ul class="nav">
					<li><h2>Administration</h2></li>
					<li><a href="../abonnes/index.html">Abonnés</a></li>
					<li><a href="../locations/index.html">Points location</a></li>
					<li><a href="../vehicules/index.html">Véhicules</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- FIN ADMIN NAVBAR -->

	<!-- DEBUT CONTAINER  -->
	<div class="container-fluid">
	
		<table class="row-fluid">
		  <tr>
			<td><h1>#<h:outputText value="#{adminAbonnesShowBean.currentAbonneView.idabonne }" /> - 
			<h:outputText value="#{adminAbonnesShowBean.currentAbonneView.prenomabonne } " />
			<h:outputText value="#{adminAbonnesShowBean.currentAbonneView.nomabonne }" /> </h1></td>
			<td>
			<a4j:form>	
				<a4j:commandButton value="Retour" action="#{adminAbonnesShowBean.retour }" styleClass="btn btn-primary btn-large right" />
			</a4j:form>
			</td>	
		  </tr>
		</table>
			
		<div class="row-fluid">

			<!-- DEBUT SHOW ABONNE -->
			<div class="span9">
				<div class ="well">
					<h3> Informations Client</h3>

					<table class="table">
						<tbody>
							<tr>
								<th>Nom : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.nomabonne }" /></td>
							</tr>
							<tr>
								<th>Prénom : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.prenomabonne }" /></td>
							</tr>
							<tr>
								<th>Date de naissance : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.datenaissance }" /></td>
							</tr>
							<tr>
								<th>Code Postal : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.codepostal }" /></td>
							</tr>
							<tr>
								<th>Téléphone : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.tel }" /></td>
							</tr>
							<tr>
								<th>Email : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.email }" /></td>
							</tr>
							<tr>
								<th>Mot de passe : </th>
								<td>******</td>
							</tr>
							
						</tbody>
					</table>
					
				</div>
				
				<div class="well">
					<h3> Informations bancaires</h3>
					<table class="table">
						<tbody>
							<tr>
								<th>Titulaire du compte : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.titulairecompte }" /></td>
							</tr>
							<tr>
								<th>Code banque : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.codebanque }" /></td>
							</tr>
							<tr>
								<th>Code agence : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.codeagence }" /></td>
							</tr>
							<tr>
								<th>Numéro de compte : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.numerocompte }" /></td>
							</tr>
							<tr>
								<th>Clé RIB : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.clefrib }" /></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="well">
					<h3> Informations Abonnement</h3>
					<table class="table">
						<tbody>
							<tr>
								<th>Abonnement en cours  : </th>
								<td><h:outputText value="#{adminAbonnesShowBean.currentAbonneView.typeAbo }" /></td>
							</tr>
							<tr>
								<th>Consommation voiture : </th>
								<td></td>
							</tr>
							<tr>
								<th>Consommation vélo : </th>
								<td></td>
							</tr>
							<tr>
								<th>Total Facture  : </th>
								<td></td>
							</tr>
							
						</tbody>
					</table>

				</div>
			</div>
			<!-- FIN SHOW ABONNE -->
		</div>
	</div>
	<!-- FIN CONTAINER  -->

	<!-- DEBUT FOOTER -->
	<!-- TODO: ADD THE FOOTER PARTIAL HERE -->
	<!-- FIN FOOTER -->
</f:view>	
</body>
</html>