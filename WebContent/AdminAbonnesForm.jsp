<!-- OK MANQUE JAVASCRIPT -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Itinélib - ajouter abonne</title>

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

	<!-- DEBUT ADMIN NAVBAR -->
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a href="../abonnes/index.html"> <img alt=""
					src="../assets/img/logo.png" id="logo"> </a>

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
		<f:view>
			<table class="row-fluid">
				<tr>
					<td><h1>Nouveau client</h1></td>
					<td><a4j:form>
							<a4j:commandButton value="Retour"
								action="#{adminAbonnesFormBean.retour }"
								styleClass="btn btn-primary btn-large right" />
						</a4j:form>
					</td>
				</tr>
			</table>

			<div class="row-fluid">

				<!-- DEBUT FORMULAIRE NEW ABONNE -->
				<div class="span9">

					<h:form styleClass="form-horizontal">

						<div class="well">
							<h3>Choix de l'abonnement</h3>
							<div class="control-group">
								<label class="control-label" for="choixAbonnement">Abonnement:</label>
								<div class="controls">
									<h:selectOneMenu value="#{adminAbonnesFormBean.idabonnement}">
										<f:selectItems
											value="#{adminAbonnesFormBean.listeTypeAboItems}" />
									</h:selectOneMenu>
								</div>
							</div>
						</div>

						<div class="well">
							<h3>Informations client</h3>
							<div class="control-group">
								<label class="control-label" for="sexe">Sexe :</label>
								<div class="controls">
									<h:selectOneMenu
										value="#{adminAbonnesFormBean.currentAbonne.sexe}">
										<f:selectItem itemValue="M" itemLabel="Homme" />
										<f:selectItem itemValue="F" itemLabel="Femme" />
									</h:selectOneMenu>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="nom">Nom:</label>
								<div class="controls">
									<h:inputText id="nom"
										value="#{adminAbonnesFormBean.currentAbonne.nomabonne}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testnom"
										value="#{adminAbonnesFormBean.erreurNomAbonne}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="prenom">Prénom:</label>
								<div class="controls">
									<h:inputText id="prenom"
										value="#{adminAbonnesFormBean.currentAbonne.prenomabonne}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testprenom"
										value="#{adminAbonnesFormBean.erreurPrenomAbonne}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="datenaissance">Date de
									Naissance :</label>
								<div class="controls">
									<h:inputText id="dp2"
										value="#{adminAbonnesFormBean.currentAbonne.datenaissance}"
										styleClass="span2">
										<f:convertDateTime pattern="dd/MM/yyyy"></f:convertDateTime>
									</h:inputText>
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="adresse">Adresse :</label>
								<div class="controls">
									<h:inputText id="adresse"
										value="#{adminAbonnesFormBean.currentAbonne.adresse}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testAdresse"
										value="#{adminAbonnesFormBean.erreurAdresse}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="codepostal">Code
									postal :</label>
								<div class="controls">
									<h:inputText id="codepostal"
										value="#{adminAbonnesFormBean.codepostal}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testcodePostal"
										value="#{adminAbonnesFormBean.erreurCodePostal}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="telephone">Téléphone:</label>
								<div class="controls">
									<h:inputText id="telephone"
										value="#{adminAbonnesFormBean.currentAbonne.tel}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testTelephone"
										value="#{adminAbonnesFormBean.erreurTelephone}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="email">Email:</label>
								<div class="controls">
									<h:inputText id="email"
										value="#{adminAbonnesFormBean.currentUtilisateur.email}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testEmail"
										value="#{adminAbonnesFormBean.erreurMail}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="password">Mot de
									passe:</label>
								<div class="controls">
									<h:inputText id="password"
										value="#{adminAbonnesFormBean.password}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testPassword"
										value="#{adminAbonnesFormBean.erreurPassword}"
										styleClass="error input-xxlarge" />
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
										value="#{adminAbonnesFormBean.currentAbonne.titulairecompte}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testTitulaire"
										value="#{adminAbonnesFormBean.erreurTitulaireCompte}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="codebanque">Code
									banque:</label>
								<div class="controls">
									<h:inputText id="codebanque"
										value="#{adminAbonnesFormBean.currentAbonne.codebanque}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testCodeBanque"
										value="#{adminAbonnesFormBean.erreurCodeBanque}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="codeagence">Code
									agence:</label>
								<div class="controls">
									<h:inputText id="codeagence"
										value="#{adminAbonnesFormBean.currentAbonne.codeagence}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testCodeAgence"
										value="#{adminAbonnesFormBean.erreurCodeAgence}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="numerocompte">Numéro
									de compte:</label>
								<div class="controls">
									<h:inputText id="numerocompte"
										value="#{adminAbonnesFormBean.currentAbonne.numerocompte}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testNumCompte"
										value="#{adminAbonnesFormBean.erreirNumeroCompte}"
										styleClass="error input-xxlarge" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="clefrib">Clé RIB:</label>
								<div class="controls">
									<h:inputText id="clefrib"
										value="#{adminAbonnesFormBean.currentAbonne.clefrib}"
										styleClass="input-xxlarge" />
									<h:outputLabel id="testCleRib"
										value="#{adminAbonnesFormBean.erreurCleRib}"
										styleClass="error input-xxlarge" />
								</div>
							</div>
						</div>

						<div class="well form-actions">
							<h:commandButton value="Valider"
								action="#{adminAbonnesFormBean.save }"
								styleClass="btn btn-large btn-success" />
							<input class="btn btn-large" type="button" value="Annuler">

						</div>

					</h:form>

					<!-- FIN FORMULAIRE NEW ABONNE -->
				</div>

			</div>

		</f:view>
	</div>
	<!-- FIN CONTAINER  -->

	<!-- DEBUT FOOTER -->
	<!-- TODO: ADD THE FOOTER PARTIAL HERE -->
	<!-- FIN FOOTER -->


</body>
</html>