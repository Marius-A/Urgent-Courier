var myCenter=new google.maps.LatLng(44.321357, 23.801851);

var location1=new google.maps.LatLng(44.309296, 23.835370);//facultate
var location2=new google.maps.LatLng(43.781252, 23.945439);//acasa
var location3=new google.maps.LatLng(44.427036, 26.108476);
var location4=new google.maps.LatLng(45.659445, 25.596463);


var marker;var marker1;var marker2;var marker3;var marker4;

function initialize()
{
	var mapProp = {
	  center:myCenter,
	  zoom:3,
	  mapTypeId:google.maps.MapTypeId.ROADMAP
	  };

	var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);

	var marker=new google.maps.Marker({
	  position:myCenter,
	  animation:google.maps.Animation.BOUNCE
	  });
	  
	var marker1=new google.maps.Marker({
		  position:location1,
		  animation:google.maps.Animation.BOUNCE
	  });
	var marker2=new google.maps.Marker({
		  position:location2,
		  animation:google.maps.Animation.BOUNCE
	  });
	var marker3=new google.maps.Marker({
		  position:location3,
		  animation:google.maps.Animation.BOUNCE
	  });
	var marker4=new google.maps.Marker({
		  position:location4,
		  animation:google.maps.Animation.BOUNCE
	  });

	marker.setMap(map);
	marker1.setMap(map);
	marker2.setMap(map);marker3.setMap(map);marker4.setMap(map);
}


google.maps.event.addDomListener(window, 'load', initialize);