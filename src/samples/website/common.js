function getParameterByName(name) {
	name = name.replace(/[\[]/, '\\\[').replace(/[\]]/, '\\\]');
	var regex = new RegExp('[\\?&]' + name + '=([^&#]*)'),
	results = regex.exec(location.search);
	return results == null ? '' : results[1].replace(/\+/g, ' ');
}
