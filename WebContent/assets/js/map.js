function initialize() {
	var map;
	var markersArray = [];

	//préparation de la carte
	//options de la carte
	var myOptions = {
		center: new google.maps.LatLng(48.833, 2.333),
		zoom: 10,
		mapTypeId: google.maps.MapTypeId.ROADMAP,
		zoomControl:true,
		streetViewControl:true
	};
				
	//création de la carte
	map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
				
	//préparation du texte de la bubulle
	//on écrit ce qu'il y aura dedans
	var contentString = 
	'<div id="content">'+
	'<div id="siteNotice">' + '</div>'+
	'<h2 id="firstHeading" class="firstHeading">Hello World</h2>'+
	'<div id="bodyContent">'+
	'<p><b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large ' +
	'sandstone rock formation in the southern part of the '+
	'Northern Territory, central Australia. It lies 335 km (208 mi) '+
	'sacred to the Pitjantjatjara and Yankunytjatjara, the '+
	'Aboriginal people of the area. It has many springs, waterholes, '+
	'rock caves and ancient paintings. Uluru is listed as a World '+
	'Heritage Site.</p>'+
	'<p>Attribution: Uluru, <a href="http://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194">'+
	'http://en.wikipedia.org/w/index.php?title=Uluru</a> (last visited June 22, 2009).</p>'+
	'</div>'+
	'</div>'
	; //fin texte bubulle
				
	//création de la bubulle
	var infowindow = new google.maps.InfoWindow({
		content: contentString,	
	});

	// boucler pour générer les markers
	// tant qu'il reste des markers à traiter
	// on boucle et on appelle addMarker
	var marker1 = addMarker( 48.833, 2.333, map, "Hello World" );
	var marker2 = addMarker( 48.800, 2.333, map, "Hello World 2" );
				
	google.maps.event.addListener( 
		marker1, 
		'click', 
		function() {
			 infowindow.open( map, marker1 );
		}
	);

	function addMarker( lattitude, longitude, carte, infobulle ) { //ajouter lattitude et longitude en paramètre
		var myLatlng = new google.maps.LatLng(lattitude, longitude);

		var marker = new google.maps.Marker({
			position: myLatlng,
			map: carte,
			title: infobulle
		});

		return marker;
	}	  
}