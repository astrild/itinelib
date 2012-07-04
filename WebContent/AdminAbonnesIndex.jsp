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
		<td><h1>Abonnés</h1></td>
		<td>
		<a4j:form>			
			<a4j:commandButton value="Créer Abonné" action="#{adminAbonnesFormBean.viewNew }" styleClass="btn btn-success btn-large right" />
		</a4j:form>
		</td>
	</tr>	
  </table>

	<div class="row-fluid">

		<!-- DEBUT LISTE UTILISATEUR -->
		<div id="listeUtilisateur" class="span10">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>N° Abonné</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Date de Naissance</th>
						<th>Code postal</th>
						<th>Email</th>
						<th>Téléphone</th>
						<th colspan=3></th>
					</tr>
				</thead>
				
				<tbody>

					<a4j:form> 
					 <a4j:repeat value="#{adminAbonnesIndexBean.abonneListView}" var="abonne">
					   <tr>
							<td><h:outputText value="#{abonne.idabonne }" /></td>
							<td><h:outputText value="#{abonne.nomabonne }" /></td>
							<td><h:outputText value="#{abonne.prenomabonne }" /></td>
							<td><h:outputText value="#{abonne.datenaissance }" /></td>
							<td><h:outputText value="#{abonne.codepostal }" /></td>
							<td><h:outputText value="#{abonne.email }" /></td>
							<td><h:outputText value="#{abonne.tel }" /></td>
							<td><h:outputText value="#{abonne.dhresiliation }" /></td>
							<td>
								<a4j:commandButton value="detail" action="#{adminAbonnesShowBean.viewDetail }" styleClass="btn" >
									<f:param name="idAbo" value="#{abonne.idabonne}" />
								</a4j:commandButton>
							</td>
							<td>	
								<a4j:commandButton value="Modifier" action="#{adminAbonnesUpdateBean.viewDetail }" styleClass="btn" >
									<f:param name="idAbo" value="#{abonne.idabonne}" />
								</a4j:commandButton>
							</td>
							<td>
								<a4j:commandButton value="Résilier" action="#{adminAbonnesIndexBean.resilier }" styleClass="btn">
									<f:param name="idAbo" value="#{abonne.idabonne}" />
								</a4j:commandButton>
							</td>
						</tr>
					  </a4j:repeat>
				    </a4j:form> 

				</tbody>
			</table>
		</div>
		<!-- FIN LISTE UTILISATEUR -->


		<!-- DEBUT SPAN3 RECHERCHE -->
		<div class ="span2">
			<!-- DEBUT DU FORMULAIRE DE RECHERCHE -->
			<h:form id="boxRechercher" styleClass="well form-search">
				<h3>Rechercher</h3>

				<div class="control-group">
					<label class="control-label" for="idabonne">N° Abonné:</label>
					<div class="controls">
						<h:inputText id="idinput" value="#{adminAbonnesIndexBean.id }" styleClass="input-medium" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="prenom">Prénom:</label>
					<div class="controls">
							<h:inputText id="prenominput" value="#{adminAbonnesIndexBean.prenom }" styleClass="input-medium" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="nom">Nom:</label>
					<div class="controls">
						<h:inputText id="nominput" value="#{adminAbonnesIndexBean.nom }" styleClass="input-medium" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="email">Email:</label>
					<div class="controls">
							<h:inputText id="emailinput" value="#{adminAbonnesIndexBean.email }" styleClass="input-medium" />
					</div>
				</div>

				<div class="control-group">
					<label class="control-label" for="telephone">Téléphone:</label>
					<div class="controls">
						<h:inputText id="telephoneinput" value="#{adminAbonnesIndexBean.telephone }" styleClass="input-medium" />
					</div>
				</div>
				
				<a4j:commandButton value="Rechercher" action="#{ adminAbonnesIndexBean.recherche}" styleClass="btn">
					<f:param name="id" value="#{adminAbonnesIndexBean.id}" />
					<f:param name="nom" value="#{adminAbonnesIndexBean.nom}" />
					<f:param name="prenom" value="#{adminAbonnesIndexBean.prenom}" />
					<f:param name="telephone" value="#{adminAbonnesIndexBean.telephone}" />
					<f:param name="email" value="#{adminAbonnesIndexBean.email}" />
				</a4j:commandButton>
				
			</h:form>
			<!-- FIN DU FORMULAIRE DE RECHERCHE -->
		</div>
		<!-- FIN SPAN3 RECHERCHE -->		
	</div>

</div>
<!-- FIN CONTAINER  -->
</f:view>
</body>
</html>