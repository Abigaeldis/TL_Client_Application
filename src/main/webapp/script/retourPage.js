
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('backmenuForm').addEventListener('click', function(event) {
        event.preventDefault(); 
        window.history.back(); 
    });
});
