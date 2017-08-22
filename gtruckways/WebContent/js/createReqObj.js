function createRequestObject(){
	var request = null;
	
	try{
		request = new XMLHttpRequest();
	}catch(e){
		try{
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				alert("Older browser! Please update your browser...!!");
			}
		}
	}

	return request;
}
/*uppercase for license number*/
$(document).ready(function()
{
    $('#license').keyup(function()
    {
        $(this).val($(this).val().toUpperCase());
    });
});


$(document).ready( function () {

    $(" #lfrom").change( function () {

        var str = $("#lfrom").val();

        if( /^\d{2}\/\d{2}\/\d{4}$/i.test( str ) ) {

            var parts = str.split("/");

            var day = parts[0] && parseInt( parts[0], 10 );
            var month = parts[1] && parseInt( parts[1], 10 );
            var year = parts[2] && parseInt( parts[2], 10 );
            var duration = 5;

            if( day <= 31 && day >= 1 && month <= 12 && month >= 1 ) {

                var expiryDate = new Date( year, month - 1, day-1 );
                expiryDate.setFullYear( expiryDate.getFullYear() + duration );

                var day = ( '0' + expiryDate.getDate() ).slice( -2 );
                var month = ( '0' + ( expiryDate.getMonth() + 1 ) ).slice( -2 );
                var year = expiryDate.getFullYear();

                $("#lto").val( day + "/" + month + "/" + year );

            } else {
                // display error message
            	
            }
        }
    });
});