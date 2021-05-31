function search() {
	var artistSearch = document.getElementById('artistSearch').value;
	// console.log(artistSearch);
	window.location.href="http://localhost:8080/search/" + artistSearch;
}