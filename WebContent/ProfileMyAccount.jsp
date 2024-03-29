<!-- OK 20120621 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Itinélib - Mon Compte</title>

<!-- DEBUT STYLESHEETS -->
<link href="../assets/css/bootstrap.css" rel="stylesheet">
<link href="../assets/css/custom.css" rel="stylesheet">
<!-- FIN STYLESHEETS -->
<!-- DEBUT JAVASCRIPT -->
<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap-dropdown.js"></script>
<script src="../assets/js/bootstrap-tab.js"></script>
<script src="../assets/js/bootstrap-collapse.js"></script>
<script src="../assets/js/custom.js"></script>
<!-- FIN JAVASCRIPT -->
</head>
<body>
	<f:view>
		<!-- DEBUT NAVBAR LOGGUE -->
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a href="../pages/home.html"> <img alt=""
						src="../assets/img/logo.png" id="logo"> </a>

					<div class="pull-right">
						<ul class="nav">
							<li><span id="connecte">Bienvenue 
									<h:outputText
										value="#{userProfilMyAccountBean.currentAbonneView.nomabonne} " />
									<h:outputText
										value="#{userProfilMyAccountBean.currentAbonneView.prenomabonne} " />

							</span></li>
							<li>
							<h:form style="margin-top: 9px;" >
							<h:commandLink value="Deconnexion" action="#{authBean.logout}" />
							</h:form>
							</li>
						</ul>
					</div>

				</div>
			</div>
		</div>
		<!-- FIN NAVBAR LOGGUE -->

		<!-- DEBUT PAGE-CANVAS -->
		<div class="page-canvas">
			<!-- DEBUT CONTAINER -->
			<div class="container">

				<h1>Espace Personnel</h1>

				<!-- DEBUT ROW -->
				<div class="row">
					<div class="span11 spanOffset1">

						<!-- DEBUT MONESPACETAB -->
						<ul id="monEspaceTab" class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" href="#accueil"><i
									class="icon-home"></i> Accueil</a></li>
							<li><a data-toggle="tab" href="#monCompte"><i
									class="icon-user"></i> Gérer mon compte</a></li>
							<li><a data-toggle="tab" href="#mesReservations"><i
									class="icon-book"></i> Mes réservations</a></li>
						</ul>
						<!-- FIN MONESPACETAB -->
					</div>
				</div>
				<!-- FIN ROW -->

				<!-- DEBUT MONESPACETABCONTENT -->
				<div id="monEspaceTabContent" class="tab-content">

					<!--------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------->

					<!-- DEBUT ACCUEIL -->
					<div id="accueil" class="tab-pane fade active in">

						<!-- DEBUT ROW -->
						<div class="row">
							<div class="span11 spanOffset1">
								<table class="table table-bordered">
									<tr>
										<th>Mon Abonnement:</th>
										<td></td>
									</tr>
									<tr>
										<th>Mes Conso & Factures:</th>
										<td></td>
									</tr>
								</table>
							</div>
							<!-- FIN ACCUEIL -->
						</div>
						<!-- FIN ROW -->
					</div>
					<!-- FIN ACCUEIL -->

					<!--------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------->

					<!-- DEBUT MONCOMPTE -->
					<div id="monCompte" class="tab-pane fade">

						<!-- DEBUT ROW -->
						<div class="row">

							<!-- DEBUT SPAN3 -->
							<div class="span3 spanOffset1">

								<!-- DEBUT TABBABLE -->
								<div class="tabbable tabs-left">
									<ul class="nav nav-tabs">
										<li class="active"><a data-toggle="tab"
											href="#mesInformations">Mes Informations</a></li>
										<li><a data-toggle="tab" href="#monAbonnement">Mon
												Abonnement</a></li>
										<li><a data-toggle="tab" href="#mesConsos">Mes
												Consommations & Factures</a></li>
									</ul>
								</div>
								<!-- FIN TABBABLE -->
							</div>

							<!-- FIN SPAN3 -->

							<!-- DEBUT SPAN8 -->
							<div class="span8">
								<div class="tab-content">

									<!-------------------------------------------------------------------------------------------------------->

									<!-- DEBUT MESINFORMATIONS -->
									<div id="mesInformations" class="tab-pane active">

										<!-- DEBUT ACCORDIONMESCOORDONNEES -->
										<div id="accordionMesCoordonnees" class="accordion">
											<div class="accordion-group">
												<div class="accordion-heading">
													<a class="accordion-toggle"
														href="#collapseMesCoordonneesFormulaire"
														data-parent="accordionMesCoordonnees"
														data-toggle="collapse">
														<h4>
															<i class="icon-home"></i> Mes coordonnées
														</h4> <h:outputText
															value="#{userProfilMyAccountBean.currentAbonneView.nomabonne} " />
														<h:outputText
															value="#{userProfilMyAccountBean.currentAbonneView.prenomabonne} " />
														<h:outputText
															value="#{userProfilMyAccountBean.currentAbonneView.adresse} " />
														<h:outputText
															value="#{userProfilMyAccountBean.currentAbonneView.codepostal} " />
														<h:outputText
															value="#{userProfilMyAccountBean.currentAbonneView.nomville} " />
													</a>
												</div>
												<div id="collapseMesCoordonneesFormulaire"
													class="accordion-body collapse" style="height: 0px;">
													<div class="accordion-inner">

														<!-- DEBUT FORMULAIRE MESCOORDONNEES -->
														<form class="form-horizontal">

															<div class="control-group">
																<label class="control-label" for="prenom">Prénom:</label>
																<div class="controls">
																	<h:inputText id="prenom"
																		value="#{userProfilMyAccountBean.currentAbonneView.prenomabonne}"
																		styleClass="input-xxlarge" />

																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="nom">Nom:</label>
																<div class="controls">
																	<h:inputText id="nom"
																		value="#{userProfilMyAccountBean.currentAbonneView.nomabonne}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="adresse">Adresse:</label>
																<div class="controls">
																	<h:inputText id="adresse"
																		value="#{userProfilMyAccountBean.currentAbonneView.adresse}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="codePostal">Code
																	Postal:</label>
																<div class="controls">
																	<h:inputText id="codePostal"
																		value="#{userProfilMyAccountBean.currentAbonneView.codepostal}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="form-actions">
																<button id="btnValiderFormulaireMesCoordonnees"
																	class="btn btn-success" type="submit">Valider</button>
															</div>

														</form>
														<!-- FIN FORMULAIRE MESCOORDONNEES -->
													</div>
												</div>
											</div>
										</div>
										<!-- FIN ACCORDIONMESCOORDONNEES -->

										<!-- DEBUT ACCORDIONMONRIB -->
										<div id="accordionMonRib" class="accordion">
											<div class="accordion-group">
												<div class="accordion-heading">
													<a class="accordion-toggle"
														href="#collapseaccordionMonRibFormulaire"
														data-parent="accordionMonRib" data-toggle="collapse">
														<h4>
															<i class="icon-shopping-cart"></i> Mon RIB
														</h4> Mon RIB actuel: <br /> </a>
												</div>
												<div id="collapseaccordionMonRibFormulaire"
													class="accordion-body collapse" style="height: 0px;">
													<div class="accordion-inner">

														<!-- DEBUT FORMULAIRE MONRIB -->
														<form class="form-horizontal">

															<div class="control-group">
																<label class="control-label" for="titulaire">Titulaire:</label>
																<div class="controls">
																	<h:inputText id="titulaire"
																		value="#{userProfilMyAccountBean.currentAbonneView.titulairecompte}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="codeBanque">Code
																	Banque:</label>
																<div class="controls">
																	<h:inputText id="codeBanque"
																		value="#{userProfilMyAccountBean.currentAbonneView.codebanque}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="codeGuichet">Code
																	Agence:</label>
																<div class="controls">
																	<h:inputText id="codeAgence"
																		value="#{userProfilMyAccountBean.currentAbonneView.codeagence}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="numCompte">N°
																	de compte:</label>
																<div class="controls">
																	<h:inputText id="numCompte"
																		value="#{userProfilMyAccountBean.currentAbonneView.numerocompte}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="cleRib">Clé
																	RIB:</label>
																<div class="controls">
																	<h:inputText id="cleRib"
																		value="#{userProfilMyAccountBean.currentAbonneView.clefrib}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="form-actions">
																<button id="btnValiderFormulaireMonRib"
																	class="btn btn-success" type="submit">Valider</button>
															</div>

														</form>
														<!-- FIN FORMULAIRE MONRIB -->
													</div>
												</div>
											</div>
										</div>
										<!-- FIN ACCORDIONMONRIB -->

										<!-- DEBUT ACCORDIONMONEMAIL -->
										<div id="accordionMonEmail" class="accordion">
											<div class="accordion-group">
												<div class="accordion-heading">
													<a class="accordion-toggle"
														href="#collapseMonEmailFormulaire"
														data-parent="accordionMonEmail" data-toggle="collapse">
														<h4>
															<i class="icon-envelope"></i> Mon Email
														</h4> <h:outputText
															value="#{userProfilMyAccountBean.currentAbonneView.email} " />
													</a>
												</div>
												<div id="collapseMonEmailFormulaire"
													class="accordion-body collapse" style="height: 0px;">
													<div class="accordion-inner">

														<!-- DEBUT FORMULAIRE MONEMAIL -->
														<form class="form-horizontal">

															<div class="control-group">
																<label class="control-label" for="email">Email:</label>
																<div class="controls">
																	<h:inputText id="email"
																		value="#{userProfilMyAccountBean.currentAbonneView.email}"
																		styleClass="input-xxlarge" />
																</div>
															</div>

															<div class="form-actions">
																<button id="btnValiderFormulaireEmail"
																	class="btn btn-success" type="submit">Valider</button>
															</div>

														</form>
														<!-- FIN FORMULAIRE MONEMAIL -->
													</div>
												</div>
											</div>
										</div>
										<!-- FIN ACCORDIONMONEMAIL -->

										<!-- DEBUT ACCORDION MONMOTDEPASSE -->
										<div id="accordionMonMdp" class="accordion">
											<div class="accordion-group">
												<div class="accordion-heading">
													<a class="accordion-toggle"
														href="#collapseMonMdpFormulaire"
														data-parent="accordionMonMdp" data-toggle="collapse">
														<h4>
															<i class="icon-pencil"></i> Mon Mot de passe:
														</h4> ****** </a>
												</div>
												<div id="collapseMonMdpFormulaire"
													class="accordion-body collapse" style="height: 0px;">
													<div class="accordion-inner">

														<!-- DEBUT FORMULAIRE MONMOTDEPASSE -->
														<form class="form-horizontal">

															<div class="control-group">
																<label class="control-label" for="actuelMdp">Mot
																	de passe actuel:</label>
																<div class="controls">
																	<h:inputSecret id="password"
																		value="#{userProfilMyAccountBean.password}"
																		styleClass="input-xlarge" />
																</div>
															</div>

															<div class="control-group">
																<label class="control-label" for="nouveauMdp">Nouveau
																	mot de passe:</label>
																<div class="controls">
																	<input type="text" class="input-xlarge"
																		id="nouveauMdp">
																</div>
															</div>

															<div class="control-group">
																<label class="control-label"
																	for="nouveauMdpConfirmation">Confirmez mot de
																	passe:</label>
																<div class="controls">
																	<input type="text" class="input-xlarge"
																		id="nouveauMdpConfirmation">
																</div>
															</div>

															<div class="form-actions">
																<button id="btnValiderFormulaireMdp"
																	class="btn btn-success" type="submit">Valider</button>
															</div>

														</form>
														<!-- FIN FORMULAIRE MONMOTDEPASSE -->
													</div>
												</div>
											</div>
										</div>
										<!-- FIN ACCORDION MONMOTDEPASSE -->

									</div>
									<!-- FIN MESINFORMATIONS -->

									<!-------------------------------------------------------------------------------------------------------->

									<!-- DEBUT MONABONNEMENT -->
									<div id="monAbonnement" class="tab-pane">

										<!-- DEBUT FORMULAIREMODIFIER -->
										<form id="modifierAbonnement">

											<!--DEBUT TABLE MODIFIERABONNEMENT -->
											<table class="table">

												<tbody>
													<tr>
														<td rowspan="2"><input id="rbSelectAboVelo"
															type="radio" value="velo" name="rbgSelectAbonnement">
														</td>
														<td rowspan="2">[prix]</td>
														<td rowspan="2"><img alt=""
															src="http://placehold.it/260x180"></td>
														<td><h5>Lorem ipsum dolor sit amet, consectetur
																adipiscing elit.</h5></td>
													</tr>
													<tr>
														<td>nec consequat est. Morbi viverra fermentum
															sodales. Donec a ipsum lectus. Etiam sodales, lorem ac
															lacinia viverra, mi ante semper nisi, quis scelerisque
															sapien ligula sed metus.</td>
													</tr>

													<tr>
														<td rowspan="2"><input id="rbSelectAboVoiture"
															type="radio" value="voiture" name="rbgSelectAbonnement">
														</td>
														<td rowspan="2">[prix]</td>
														<td rowspan="2"><img alt=""
															src="http://placehold.it/260x180"></td>
														<td><h5>Lorem ipsum dolor sit amet, consectetur
																adipiscing elit.</h5></td>
													</tr>
													<tr>
														<td>nec consequat est. Morbi viverra fermentum
															sodales. Donec a ipsum lectus. Etiam sodales, lorem ac
															lacinia viverra, mi ante semper nisi, quis scelerisque
															sapien ligula sed metus.</td>
													</tr>

													<tr>
														<td rowspan="2"><input id="rbSelectAboVeloVoiture"
															type="radio" value="veloVoiture"
															name="rbgSelectAbonnement">
														</td>
														<td rowspan="2">[prix]</td>
														<td rowspan="2"><img alt=""
															src="http://placehold.it/260x180"></td>
														<td><h5>Lorem ipsum dolor sit amet, consectetur
																adipiscing elit.</h5></td>
													</tr>
													<tr>
														<td>nec consequat est. Morbi viverra fermentum
															sodales. Donec a ipsum lectus. Etiam sodales, lorem ac
															lacinia viverra, mi ante semper nisi, quis scelerisque
															sapien ligula sed metus.</td>
													</tr>
												</tbody>
											</table>
											<!--FIN TABLE MODIFIERABONNEMENT -->

											<button class="btn btn-success" type="submit">Modifier</button>

										</form>
										<!-- FIN FORMULAIREMODIFIER -->

									</div>
									<!-- FIN MONABONNEMENT -->

									<!-------------------------------------------------------------------------------------------------------->

									<!-- DEBUT MESCONSOMMATIONS -->
									<div id="mesConsos" class="tab-pane">

										<h3>Mes Consommations & Factures</h3>

										<!-- DEBUT TABLEAUTYPEDEFORFAIT -->
										<table class="table well" id="TableBottomBorder">
											<tr>
												<td><i class="icon-chevron-right"></i></td>
												<th>Forfait : <h:outputText
														value="#{userProfilMyAccountBean.currentAbonneView.typeAbo} " />
												</th>
												<th>50 €/mois</th>
											</tr>
										</table>
										<!-- FIN TABLEAUTYPEDEFORFAIT -->

										<!-- DEBUT TABLEAU CONSOMMATIONDUMOIS -->
										<table class="table well">
											<tr>
												<th>Consommation Au :</th>
												<th>14 Juin 2012</th>
												<th>Coût</th>
											</tr>
											<tr>
												<th>Voiture</th>
												<td>50 km</td>
												<td>25 €</td>
											</tr>
											<tr>
												<th>Vélo</th>
												<td>10 km</td>
												<td>5 €</td>
											</tr>
											<tr>
												<th colspan=2>Total Facture :</th>
												<td>80 €</td>
											</tr>
										</table>
										<!-- FIN TABLEAU CONSOMMATIONDUMOIS -->

										<!-- DEBUT TABLEAU LISTEDESFACTURES -->
										<table class="table well">
											<tr>
												<th>Facture du:</th>
												<td>10-05-2012</td>
												<td><i class="icon-eye-open"></i></td>
												<td><i class="icon-print"></i></td>
												<td>Montant :</td>
												<td>80 €</td>
											</tr>
											<tr>
												<th>Facture du:</th>
												<td>10-04-2012</td>
												<td><i class="icon-eye-open"></i></td>
												<td><i class="icon-print"></i></td>
												<td>Montant :</td>
												<td>90 €</td>
											</tr>
											<tr>
												<th>Facture du:</th>
												<td>10-03-2012</td>
												<td><i class="icon-eye-open"></i></td>
												<td><i class="icon-print"></i></td>
												<td>Montant :</td>
												<td>80 €</td>
											</tr>
										</table>
										<!-- FIN TABLEAU LISTEDESFACTURES -->

									</div>
									<!-- FIN MESCONSOMMATIONS -->

									<!-------------------------------------------------------------------------------------------------------->



								</div>
								<!-- FIN TABCONTENT -->
							</div>
							<!-- FIN SPAN8 -->
						</div>
						<!-- FIN ROW -->

					</div>
					<!-- FIN MONCOMPTE -->

					<!--------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------->

					<!-- DEBUT MESRESERVATIONS -->
					<div id="mesReservations" class="tab-pane fade">
						<!-- DEBUT ROW -->
						<div class="row">
							<!-- DEBUT SPAN3 -->
							<div class="span3 spanOffset1">
								<!-- DEBUT TABBABLE -->
								<div class="tabbable tabs-left">
									<ul class="nav nav-tabs">
										<li class="active"><a data-toggle="tab"
											href="#voirReservations">Voir mes réservations</a></li>
										<li><a data-toggle="tab" href="#faireReservation">Faire
												une réservation</a></li>
									</ul>
								</div>
								<!-- FIN TABBABLE -->
							</div>
							<!-- FIN SPAN3 -->


							<!-- DEBUT SPAN8 -->
							<div class="span8">
								<div class="tab-content">
									<div id="voirReservations" class="tab-pane active">
										<h3>Mes réservations</h3>
										<br />
										<h4>Réservations à  venir</h4>
										<table id="TableBottomBorder" class="table well">
											<tr>
												<th>#</th>
												<th>Station de départ</th>
												<th>Date</th>
												<th>Heure de départ</th>
												<th></th>
											</tr>
											<tr>
												<td><a href="#">1</a></td>
												<td>Tour Eiffel</td>
												<td>05/07/2012</td>
												<td>13:37</td>
												<td><a href="#">Modifier</a></td>
											</tr>
											<tr>
												<td><a href="#">2</a></td>
												<td>Les Halles</td>
												<td>05/07/2012</td>
												<td>15:43</td>
												<td><a href="#">Modifier</a></td>
											</tr>
										</table>

										<div id="accordionMesCoordonnees" class="accordion">
											<div class="accordion-group">
												<div class="accordion-heading">
													<a class="accordion-toggle" data-toggle="collapse"
														data-parent="accordionMesCoordonnees"
														href="#collapseReservationsPassees">Réservations
														passées</a>
												</div>
												<div id="collapseReservationsPassees"
													class="accordion-body collapse" style="height: 0px;">
													<div class="accordion-inner">
														<table id="TableBottomBorder" class="table well">
															<tr>
																<th>#</th>
																<th>Station de départ</th>
																<th>Date</th>
																<th>Heure de départ</th>
																<th></th>
															</tr>
															<tr>
																<td><a href="#">3</a></td>
																<td>Javel-André-Citroën</td>
																<td>27/06/2012</td>
																<td>19:12</td>
																<td><a href="#">Modifier</a></td>
															</tr>
															<tr>
																<td><a href="#">4</a></td>
																<td>Malakoff - Métro</td>
																<td>26/06/2012</td>
																<td>08:51</td>
																<td><a href="#">Modifier</a></td>
															</tr>
														</table>
													</div>
												</div>
											</div>
										</div>
									</div>

									<!-- DEBUT FAIRERESERVATION -->
									<div id="faireReservation" class="tab-pane">
										<h3>
											Ma réservation<a id="btnValiderReservation"
												class="btn btn-success btn-large right">Valider Trajet</a>
										</h3>

										<!-- DEBUT BOX_TRAJET -->
										<div class="box_trajet" id="lastTrajet 1">
											<div class="box_trajet_header">
												<h4>Trajet 1</h4>
											</div>
											<div class="box_trajet_body">
												<form class="form-horizontal">
													<div class="box_trajet_body">
														<div class="control-group">
															<label class="control-label">Mode de transport: </label>
															<div class="controls">
																<select class="input-xlarge">
																	<option>Vélo</option>
																	<option>Auto</option>
																</select>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">Date et heure de
																départ: </label>
															<div class="controls">
																<select class="input-xlarge">
																	<option>Aujourd'hui, 15h45</option>
																	<option>12/06/2012, 10h10</option>
																</select>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">Station de départ: </label>
															<div class="controls">
																<select class="input-xlarge">
																	<option>Malakoff</option>
																	<option>Vanves</option>
																	<option>ChÃ¢telet</option>
																</select>
															</div>
														</div>
													</div>
													<div class="form-actions">
														<div id="btnAjouterTrajet" class="btn btn-info"
															onclick="ajouterTrajet()">Ajouter un trajet</div>
														<div class="btn">Annuler le trajet</div>
													</div>
												</form>
												<div class="clearfix"></div>
											</div>
										</div>

										<!-- FIN BOX_TRAJET -->

									</div>
									<!-- FIN FAIRERESERVATION -->

								
							</div>
						</div>
						<!-- FIN SPAN8 -->
					</div>
					<!-- FIN ROW -->
				</div>
				<!-- FIN MESRESERVATIONS -->

			</div>
			<!-- FIN MONESPACETABCONTENT -->

		</div>
		<!-- FIN CONTAINER -->
		</div>
		<!-- FIN PAGE-CANVAS -->
	</f:view>
</body>
</html>