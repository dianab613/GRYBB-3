function initMap() {
	var direction = new google.maps.DirectionsService;
	var display = new google.maps.DirectionsRenderer;
	var enschede = new google.maps.LatLng(52.221852, 6.893845);
	var map = new google.maps.Map(document.getElementById('map'), {
		zoom: 14,
		center: enschede
	});
	display.setMap(map);

	var Changeloc = function changeloc() {
		calculateAndDisplayRoute(direction, display);
	};
	document.getElementById('from').addEventListener('change', Changeloc);
	document.getElementById('to').addEventListener('change', Changeloc);



	function addMarker(coords, treeid) {
		var icon = [];
		index = 0;
		icon[0] = {
			url: "green tree.png", // url
			scaledSize: new google.maps.Size(30, 30), // scaled size

		};

		icon[1] = {
			url: "yellowtree.png", // url
			scaledSize: new google.maps.Size(35, 35), // scaled size

		};

		icon[2] = {
			url: "redtree.png", // url
			scaledSize: new google.maps.Size(40, 40), // scaled size

		};

		index = Math.floor(Math.random() * icon.length);
		var waterperc = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100];
		waterlevel = waterperc[Math.floor(Math.random() * waterperc.length)];
		var marker = new google.maps.Marker({
			position: coords,
			map: map,
			waterlvl: waterlevel,
			icon: waterlevel >= 0 && waterlevel < 30 ? icon[2] : waterlevel >= 30 && waterlevel < 60 ? icon[1] : icon[0],
			id:treeid,
			
		});
		
		/*google.maps.event.addListener(marker, "onload", function() {
			setTimeout(function(){marker.setIcon(marker.icon);}, 432000000);
			});*/
		
		 
	
		
		const infowindow = new google.maps.InfoWindow({
			content: "<p> I'm at "+ marker.waterlvl+ "% water level</p>",
			maxWidth: 300,
		}); 
		
		
		marker.addListener('click', function() {
			infowindow.open(map, marker);
		});
		
		

	}


	var GerritLochemsbleek = [
		addMarker({ lat: 52.227565, lng: 6.883402, treeid: 1 }),
		addMarker({ lat: 52.228948, lng: 6.881421, treeid: 2 }),
		addMarker({ lat: 52.230407, lng: 6.881755, treeid: 3 }),
		addMarker({ lat: 52.228439, lng: 6.876610, treeid: 4 }),
		addMarker({ lat: 52.228695, lng: 6.878563, treeid: 5 }),
		addMarker({ lat: 52.228110, lng: 6.879776, treeid: 6 })
	];

	var Boerenkerkhof = [
		addMarker({ lat: 52.224872, lng: 6.892314, treeid: 7 }),
		addMarker({ lat: 52.224821, lng: 6.894685, treeid: 8 }),
		addMarker({ lat: 52.224525, lng: 6.893263, treeid: 9 })
	]

	var Shreuer = [
		addMarker({ lat: 52.231697, lng: 6.906776, treeid: 10 }),
		addMarker({ lat: 52.232058, lng: 6.909233, treeid: 11 }),
		addMarker({ lat: 52.232617, lng: 6.911701, treeid: 12 }),
		addMarker({ lat: 52.233840, lng: 6.907889, treeid: 13 }),
		addMarker({ lat: 52.234530, lng: 6.912631, treeid: 14 }),
		addMarker({ lat: 52.235443, lng: 6.911065, treeid: 15 }),
		addMarker({ lat: 52.230985, lng: 6.909985, treeid: 16 }),
		addMarker({ lat: 52.234319, lng: 6.910185, treeid: 17 })
	]

	var Blijdensteinpark = [
		addMarker({ lat: 52.215882, lng: 6.908889, treeid: 18 }),
		addMarker({ lat: 52.216298, lng: 6.906589, treeid: 19 }),
		addMarker({ lat: 52.216144, lng: 6.908150, treeid: 20 }),
		addMarker({ lat: 52.216394, lng: 6.909947, treeid: 21 }),
		addMarker({ lat: 52.215378, lng: 6.909244, treeid: 22 })
	]

	var Wooldrikspark = [
		addMarker({ lat: 52.216887, lng: 6.912318, treeid: 23 }),
		addMarker({ lat: 52.217495, lng: 6.914153, treeid: 24 }),
		addMarker({ lat: 52.216502, lng: 6.912999, treeid: 25 }),
		addMarker({ lat: 52.216428, lng: 6.914425, treeid: 26 }),
		addMarker({ lat: 52.215541, lng: 6.914103, treeid: 27 }),
		addMarker({ lat: 52.215745, lng: 6.915659, treeid: 28 }),
		addMarker({ lat: 52.215265, lng: 6.915283, treeid: 29 })
	]

	var Phoenixpark = [
		addMarker({ lat: 52.217073, lng: 6.926688, treeid: 30 }),
		addMarker({ lat: 52.216363, lng: 6.928566, treeid: 31 }),
		addMarker({ lat: 52.216685, lng: 6.930572, treeid: 32 }),
	]

	var Oosterbegraafpark = [
		addMarker({ lat: 52.223212, lng: 6.930261, treeid: 33 }),
		addMarker({ lat: 52.222180, lng: 6.929800, treeid: 34 }),
		addMarker({ lat: 52.221891, lng: 6.931763, treeid: 35 }),
		addMarker({ lat: 52.221365, lng: 6.930111, treeid: 36 }),
		addMarker({ lat: 52.222752, lng: 6.933598, treeid: 37 }),
		addMarker({ lat: 52.221148, lng: 6.933974, treeid: 38 }),
		addMarker({ lat: 52.222758, lng: 6.935937, treeid: 39 }),
	]

	var Volksparksingel = [
		addMarker({ lat: 52.219525, lng: 6.873907, treeid: 40 }),
		addMarker({ lat: 52.219235, lng: 6.874389, treeid: 41 }),
		addMarker({ lat: 52.218864, lng: 6.873997, treeid: 42 }),
		addMarker({ lat: 52.218821, lng: 6.874678, treeid: 43 }),
		addMarker({ lat: 52.219531, lng: 6.874748, treeid: 44 }),
	]

	var Cromhofpark = [
		addMarker({ lat: 52.208644, lng: 6.884110, treeid: 45 }),
		addMarker({ lat: 52.207941, lng: 6.884078, treeid: 46 }),
		addMarker({ lat: 52.207310, lng: 6.885301, treeid: 47 }),
		addMarker({ lat: 52.206685, lng: 6.885580, treeid: 48 }),
		addMarker({ lat: 52.207842, lng: 6.886106, treeid: 49 }),
		addMarker({ lat: 52.208427, lng: 6.886825, treeid: 50 }),
		addMarker({ lat: 52.208710, lng: 6.887952, treeid: 51 }),
		addMarker({ lat: 52.208835, lng: 6.888875, treeid: 52 }),
	]

	var Varvik = [
		addMarker({ lat: 52.206655, lng: 6.896295, treeid: 53 }),
		addMarker({ lat: 52.205044, lng: 6.897507, treeid: 54 }),
		addMarker({ lat: 52.204465, lng: 6.896123, treeid: 55 }),
		addMarker({ lat: 52.203229, lng: 6.895286, treeid: 56 }),
		addMarker({ lat: 52.204925, lng: 6.898065, treeid: 57 }),
		addMarker({ lat: 52.203586, lng: 6.900414, treeid: 58 }),
		addMarker({ lat: 52.204741, lng: 6.899932, treeid: 59 }),
		addMarker({ lat: 52.204296, lng: 6.901937, treeid: 60 }),
	]

	var Zweringbeekpark = [
		addMarker({ lat: 52.203228, lng: 6.860793, treeid: 61 }),
		addMarker({ lat: 52.202242, lng: 6.861683, treeid: 62 }),
		addMarker({ lat: 52.202768, lng: 6.863979, treeid: 63 }),
		addMarker({ lat: 52.201907, lng: 6.865932, treeid: 64 }),
		addMarker({ lat: 52.202238, lng: 6.868754, treeid: 65 }),
		addMarker({ lat: 52.202981, lng: 6.870878, treeid: 66 }),
		addMarker({ lat: 52.201659, lng: 6.872906, treeid: 67 }),
		addMarker({ lat: 52.202415, lng: 6.875041, treeid: 68 }),
		addMarker({ lat: 52.201685, lng: 6.877391, treeid: 69 }),

	]


	var WesselerbrinkFC = [
		addMarker({ lat: 52.195189, lng: 6.867195, treeid: 70 }),
		addMarker({ lat: 52.193538, lng: 6.863901, treeid: 71 }),
		addMarker({ lat: 52.193926, lng: 6.866454, treeid: 72 }),
		addMarker({ lat: 52.192821, lng: 6.865016, treeid: 73 }),
		addMarker({ lat: 52.193222, lng: 6.867387, treeid: 74 }),
		addMarker({ lat: 52.194320, lng: 6.868835, treeid: 75 })
		
	];
	var WesselerbrinkTKV = [
		addMarker({ lat: 52.197713, lng: 6.867805, treeid: 76 }),
		addMarker({ lat: 52.197009, lng: 6.866872, treeid: 77 }),
		addMarker({ lat: 52.196457, lng: 6.867999, treeid: 78 }),
		addMarker({ lat: 52.197147, lng: 6.867763, treeid: 79 })
	];
	
	var WesselerbrinkTEZ = [
		addMarker({ lat: 52.195439, lng: 6.869104, treeid: 80 })
	];
	
	var Victoria = [
		addMarker({ lat: 52.191516, lng: 6.865405, treeid: 81 }),
		addMarker({ lat: 52.189152, lng: 6.864053, treeid: 82 }),
		addMarker({ lat: 52.190840, lng: 6.861434, treeid: 83 }),
		addMarker({ lat: 52.191965, lng: 6.861380, treeid: 84 })
	];
	
	
	var WesselerbrinkparkZO = [
		addMarker({ lat: 52.189937, lng: 6.874794, treeid: 85 }),
		addMarker({ lat: 52.188246, lng: 6.874975, treeid: 86 }),
		addMarker({ lat: 52.188331, lng: 6.872904, treeid: 87 }),
		addMarker({ lat: 52.186825, lng: 6.872968, treeid: 88 }),
		addMarker({ lat: 52.185595, lng: 6.874373, treeid: 89 }),
		addMarker({ lat: 52.187509, lng: 6.876540, treeid: 90 })
		
	];
	var Stroink =[
		addMarker({ lat: 52.188572, lng: 6.890927, treeid: 91 }),
		addMarker({ lat: 52.188019, lng: 6.892354, treeid: 92 }),
		addMarker({ lat: 52.187302, lng: 6.889715, treeid: 93 }),
		addMarker({ lat: 52.186901, lng: 6.891421, treeid: 94 }),
		addMarker({ lat: 52.186460, lng: 6.893213, treeid: 95 }),
		addMarker({ lat: 52.185592, lng: 6.890660, treeid: 96 }),
		addMarker({ lat: 52.185599, lng: 6.893299, treeid: 97 })
		
	];










	var locations = [
		
		GerritLochemsbleek,
		Boerenkerkhof,
		Shreuer,
		Blijdensteinpark,
		Wooldrikspark,
		Phoenixpark,
		Oosterbegraafpark,
		Volksparksingel,
		Cromhofpark,
		Varvik,
		Zweringbeekpark];
}




function calculateAndDisplayRoute(direction, display) {
	direction.route({
		origin: document.getElementById('from').value,
		destination: document.getElementById('to').value,
		travelMode: 'DRIVING'
	}, function(response, status) {
		if (status === 'OK') {
			display.setDirections(response);
		} else {
			window.alert('Failed due to ' + status);
		}

	});
}


/*Script for the input save button */

function disable() {
	
	if (document.getElementById("modalinput").value != '' && document.getElementById("waterdate") != '' ) {
		document.getElementById("modalinput").disabled = true;
		document.getElementById("waterdate").disabled = true;
	}
}


