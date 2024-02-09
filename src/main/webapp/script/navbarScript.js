const nav = document.querySelector('.nav')
window.addEventListener('scroll', fixNav)

function fixNav() {
	if (window.scrollY > nav.offsetHeight + 10) {
		nav.classList.add('active')
	} else {
		nav.classList.remove('active')
	}
}



document.addEventListener("DOMContentLoaded", function() {

	var currentPageUrl = window.location.href;


	var currentPagePath = currentPageUrl.substr(currentPageUrl.lastIndexOf("/") + 1);
	console.log(currentPagePath);
	var navLinks = document.querySelectorAll(".nav-link");


	navLinks.forEach(function(link) {
		var linkUrl = link.getAttribute("href");
		console.log(linkUrl);


		if (linkUrl === currentPagePath) {
			console.log("matching")
			link.classList.add("active");
		}
		else {
			console.log("not matching")
		}
	});
});

