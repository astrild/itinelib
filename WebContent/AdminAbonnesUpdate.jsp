<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
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

<!-- Javascript -->
<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap-dropdown.js"></script>
<script src="../assets/js/bootstrap-datepicker.js"></script>
<script src="../assets/js/custom.js"></script>

</head>
<body>
	<f:view>



		<!-- DEBUT ADMIN NAVBAR -->
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a href="../abonnes/index.html"> <img alt=""
						src="../../../assets/img/logo.png" id="logo"> </a>

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
					<td><h1>
							#
							<h:outputText
								value="#{adminAbonnesUpdateBean.currentAbonneView.idabonne }" />
							-
							<h:outputText
								value="#{adminAbonnesUpdateBean.currentAbonneView.prenomabonne } " />
							<h:outputText
								value="#{adminAbonnesUpdateBean.currentAbonneView.nomabonne }" />
						</h1></td>
					<td><a4j:form>
							<a4j:commandButton value="Retour"
								action="#{adminAbonnesUpdateBean.retour }"
								styleClass="btn btn-primary btn-large right" />
						</a4j:form></td>
				</tr>
			</table>

			<div class="row-fluid">


				<!-- DEBUT FORMULAIRE UPDATE ABONNE -->
				<div class="span9">

					<h:form styleClass="form-horizontal">

						<div class="well">
							<h3>Modifier abonnement</h3>
							<div class="control-group">
								<label class="control-label" for="choixAbonnement">Abonnement:</label>
								<div class="controls">
									<h:selectOneMenu value="#{adminAbonnesUpdateBean.idabonnement}">
										<f:selectItems
											value="#{adminAbonnesUpdateBean.listeTypeAboItems}" />
									</h:selectOneMenu>
								</div>
							</div>
						</div>
			

				<div class="well">
					<h3>Informations client</h3>
					<div class="control-group">
						<label class="control-label" for="sexe">Sexe :</label>
						<div class="controls">
							<h:selectOneMenu value="#{adminAbonnesUpdateBean.currentAbonneView.sexe}">
								<f:selectItem itemValue="M" itemLabel="Homme" />
								<f:selectItem itemValue="F" itemLabel="Femme" />
							</h:selectOneMenu>
						</div>
					</div>


					<div class="control-group">
						<label class="control-label" for="nom">Nom:</label>
						<div class="controls">
							<h:inputText id="nom"
								value="#{adminAbonnesUpdateBean.currentAbonneView.nomabonne}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="prenom">Prénom:</label>
						<div class="controls">
							<h:inputText id="prenom"
								value="#{adminAbonnesUpdateBean.currentAbonneView.prenomabonne}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="datenaissance">Date de
							Naissance :</label>
						<div class="controls">
							<h:inputText id="dp2"
								value="#{adminAbonnesUpdateBean.currentAbonneView.datenaissance}"
								styleClass="span2">
								<f:convertDateTime pattern="dd/MM/yyyy"></f:convertDateTime>
							</h:inputText>
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="adresse">Adresse :</label>
						<div class="controls">
							<h:inputText id="adresse"
								value="#{adminAbonnesUpdateBean.currentAbonneView.adresse}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="codepostal">Code postal
							:</label>
						<div class="controls">
							<h:inputText id="codepostal"
								value="#{adminAbonnesUpdateBean.currentAbonneView.codepostal}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="telephone">Téléphone:</label>
						<div class="controls">
							<h:inputText id="telephone"
								value="#{adminAbonnesUpdateBean.currentAbonneView.tel}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="email">Email:</label>
						<div class="controls">
							<h:inputText id="email"
								value="#{adminAbonnesUpdateBean.currentAbonneView.email}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="password">Mot de passe:</label>
						<div class="controls">
							<h:inputText id="password"
								value="#{adminAbonnesUpdateBean.password}"
								styleClass="input-xxlarge" />
						</div>
					</div>
				</div>

				<div class="well">
					<h3>Informations bancaires</h3>
					<div class="control-group">
						<label class="control-label" for="titulairecompte">Titulaire
							:</label>
						<div class="controls">
							<h:inputText id="titulairecompte"
								value="#{adminAbonnesUpdateBean.currentAbonneView.titulairecompte}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="codebanque">Code banque:</label>
						<div class="controls">
							<h:inputText id="codebanque"
								value="#{adminAbonnesUpdateBean.currentAbonneView.codebanque}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="codeagence">Code agence:</label>
						<div class="controls">
							<h:inputText id="codeagence"
								value="#{adminAbonnesUpdateBean.currentAbonneView.codeagence}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="numerocompte">Numéro de
							compte:</label>
						<div class="controls">
							<h:inputText id="numerocompte"
								value="#{adminAbonnesUpdateBean.currentAbonneView.numerocompte}"
								styleClass="input-xxlarge" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label" for="clefrib">Clé RIB:</label>
						<div class="controls">
							<h:inputText id="clefrib"
								value="#{adminAbonnesUpdateBean.currentAbonneView.clefrib}"
								styleClass="input-xxlarge" />
						</div>
					</div>
				</div>

				<div class="well form-actions">
					<a4j:commandButton value="Valider"
						action="#{adminAbonnesUpdateBean.update }"
						styleClass="btn btn-large btn-success">
						<f:param name="idAbo"
							value="#{adminAbonnesUpdateBean.currentAbonneView.idabonne}" />
						<f:param name="prenomAbo"
							value="#{adminAbonnesUpdateBean.currentAbonneView.prenomabonne}" />
					</a4j:commandButton>
					<input class="btn btn-large" type="button" value="Annuler">

				</div>
				</h:form>


			</div>
			<!-- DEBUT FORMULAIRE UPDATE ABONNE -->
		</div>

		</div>
		<!-- FIN CONTAINER  -->

		<!-- DEBUT FOOTER -->
		<!-- TODO: ADD THE FOOTER PARTIAL HERE -->
		<!-- FIN FOOTER -->
	</f:view>
</body>
</html>