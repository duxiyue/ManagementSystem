window.onload = function() {
	init();
}
function init(){

	var success = $("#success").val();
	if (success == "true") {
		parent.$.fancybox.close();
	}
}
