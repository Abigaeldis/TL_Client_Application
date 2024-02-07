function confirmDelete() {
	let confirmation = confirm("Voulez-vous vraiment supprimer votre compte ?");
	if (confirmation) {
		document.getElementById("deleteForm").submit();
	}
}