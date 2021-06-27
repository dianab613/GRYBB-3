function initMap() {
        var directionsService = new google.maps.DirectionsService;
        var directionsDisplay = new google.maps.DirectionsRenderer;
		var enschede = new google.maps.LatLng(52.221852, 6.893845);
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 14,
          center: enschede
        });
        directionsDisplay.setMap(map);

/*//Marker
	const marker = new google.maps.Marker({
		position: enschede,
		map:map
	})*/

        var Changeloc = function() {
          calculateAndDisplayRoute(directionsService, directionsDisplay);
        };
        document.getElementById('from').addEventListener('change', Changeloc);
        document.getElementById('to').addEventListener('change', Changeloc);
      }

      function calculateAndDisplayRoute(directionsService, directionsDisplay) {
        directionsService.route({
          origin: document.getElementById('from').value,
          destination: document.getElementById('to').value,
          travelMode: 'DRIVING'
        }, function(response, status) {
          if (status === 'OK') {
            directionsDisplay.setDirections(response);
          } else {
            window.alert('Directions request failed due to ' + status);
          }
        });
      }
