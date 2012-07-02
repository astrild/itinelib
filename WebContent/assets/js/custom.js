!function($) {

	$(function() {

		$('#btnGoToAbo').click(function(e) {
			e.preventDefault();
			$('#inscriptionTab a[href="#tabAbo"]').tab('show');
		});

		$('#btnBackToAbo').click(function(e) {
			e.preventDefault();
			$('#inscriptionTab a[href="#tabAbo"]').tab('show');
		});

		$('#btnGoToInfoPerso').click(function(e) {
			e.preventDefault();
			$('#inscriptionTab a[href="#tabInfoPerso"]').tab('show');
		});

		$('#btnBackToInfoPerso').click(function(e) {
			e.preventDefault();
			$('#inscriptionTab a[href="#tabInfoPerso"]').tab('show');
		});

		$('#btnGoToPaiement').click(function(e) {
			e.preventDefault();
			$('#inscriptionTab a[href="#tabPaiement"]').tab('show');
		});

		$('#btnBackToPaiement').click(function(e) {
			e.preventDefault();
			$('#inscriptionTab a[href="#tabPaiement"]').tab('show');
		});

		$('#btnGoToConfirmation').click(function(e) {
			e.preventDefault();
			$('#inscriptionTab a[href="#tabConfirmation"]').tab('show');
		});

		$('#dp2').datepicker();

		$('#modalCGV').modal(options);

	});

}(window.jQuery);

var nbTrajets = 1;

function ajouterTrajet() {
	var oldId = document.getElementById("lastTrajet " + nbTrajets).id;
	// alert(oldId);
	// lasttrajet
	var premierePartieId = oldId.substr(0, 11);
	var secondePartieId = parseInt(oldId.substr(11));
	// alert(premierePartieId + "lolol");
	// alert(secondePartieId + "lolol");

	document.getElementById("lastTrajet " + nbTrajets).id = secondePartieId;

	nbTrajets++;
	secondePartieId = nbTrajets;
	var newId = premierePartieId + secondePartieId;
	// alert(newId);

	var toAppend = '';
	toAppend += '<div class="box_trajet" id="' + newId + '">';
	toAppend += ' <div class="box_trajet_header">';
	toAppend += ' <h4>Trajet ' + secondePartieId + '</h4>';
	toAppend += ' </div>';
	toAppend += ' <div class="box_trajet_body">';
	toAppend += ' <form class="form-horizontal">';
	toAppend += ' <div class="box_trajet_body">';
	toAppend += ' <div class="control-group">';
	toAppend += ' <label class="control-label">Mode de transport: </label>';
	toAppend += ' <div class="controls">';
	toAppend += ' <select class="input-xlarge">';
	toAppend += ' <option>V&eacute;lo</option>';
	toAppend += ' <option>Auto</option>';
	toAppend += ' </select>';
	toAppend += ' </div>';
	toAppend += ' </div>';
	toAppend += ' <div class="control-group">';
	toAppend += ' <label class="control-label">Date et heure de d&eacute;part: </label>';
	toAppend += ' <div class="controls">';
	toAppend += ' <select class="input-xlarge">';
	toAppend += ' <option>Aujourd\'hui, 15h45</option>';
	toAppend += ' <option>12/06/2012, 10h10</option>';
	toAppend += ' </select>';
	toAppend += ' </div>';
	toAppend += ' </div>';
	toAppend += ' <div class="control-group">';
	toAppend += ' <label class="control-label">Station de d&eacute;part: </label>';
	toAppend += ' <div class="controls">';
	toAppend += ' <select class="input-xlarge">';
	toAppend += ' <option>Malakoff</option>';
	toAppend += ' <option>Vanves</option>';
	toAppend += ' <option>Châtelet</option>';
	toAppend += ' </select>';
	toAppend += ' </div>';
	toAppend += ' </div>';
	toAppend += ' </div>';
	toAppend += ' <div class="form-actions">';
	toAppend += ' <div id="btnAjouterTrajet" class="btn btn-info" onclick="ajouterTrajet()">Ajouter un trajet</div>';
	toAppend += ' <div class="btn">Annuler le trajet</div>';
	toAppend += ' </div>';
	toAppend += ' </form>';
	toAppend += ' <div class="clearfix" />';
	toAppend += ' </div>';
	toAppend += '</div>';
	//alert(toAppend);

	document.getElementById('faireReservation').innerHTML += toAppend;
}