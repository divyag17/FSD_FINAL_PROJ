let x=document.getElementById("source");
function getLocation(){
    if (navigator.geolocation){
        navigator.geolocation.getCurrentPosition(showPosition,showError);
    }
    else{
        alert("Geolocation is not supported by this browser.");
    }
}

function showPosition(position){
    lat=position.coords.latitude;
    lon=position.coords.longitude;
    console.log(lat);
    displayLocation(lat,lon);
}

function showError(error){
    switch(error.code){
        case error.PERMISSION_DENIED:
            x.innerHTML="User denied the request for Geolocation."
        break;
        case error.POSITION_UNAVAILABLE:
            x.innerHTML="Location information is unavailable."
        break;
        case error.TIMEOUT:
            x.innerHTML="The request to get user location timed out."
        break;
        case error.UNKNOWN_ERROR:
            x.innerHTML="An unknown error occurred."
        break;
    }
}

function displayLocation(latitude,longitude){
    var geocoder;
    geocoder = new google.maps.Geocoder();
    var latlng = new google.maps.LatLng(latitude, longitude);

    geocoder.geocode(
        {'latLng': latlng}, 
        function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                if (results[0]) {
                    var add= results[0].formatted_address ;
                    var  value=add.split(",");
                    count=value.length;
                    country=value[count-1];
                    state=value[count-2];
                    city=value[count-3];
                    document.getElementById("source").value = value;
                }
                else  {
                    alert("address not found");
                }
            }
            else {
                alert( "Geocoder failed ");
            }
        }
    );
}
google.maps.event.addDomListener(window, 'load', function () {
    var sourceplaces = new google.maps.places.Autocomplete(document.getElementById('source'));
    google.maps.event.addListener(sourceplaces, 'place_changed', function () {
        var place = sourceplaces.getPlace();
        var address = place.formatted_address;
        var latitude = place.geometry.location.lat();
        var longitude = place.geometry.location.lng();
        var mesg = "Address: " + address;
        console.log(latitude);
        console.log(longitude);
        console.log(mesg);
    });
    var destinationplace = new google.maps.places.Autocomplete(document.getElementById('destination'));
    google.maps.event.addListener(destinationplace, 'place_changed', function () {
        var place = destinationplace.getPlace();
        var address = place.formatted_address;
        var latitude = place.geometry.location.lat();
        var lon=place.place.geometry.location.lng();
        // var mesg = "Address: " + address;
        // console.log(latitude);
        // console.log(lon)
        // console.log(mesg);
    });
});