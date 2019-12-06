function validation() {
	var a = document.forms["form"]["txtName"].value;
	if(a== "") {
		alert("Title is Required");
		return false;
	}
	if ((a.length < 2) || (a.length > 30)) {
        alert("Title should have 2 to 30 characters.");
        return false;
    }
	var b = document.forms["form"]["txtPrice"].value;
    if(b== "") {
        alert("Price is required.");
		return false;
    }
	if(/[^0-9]/.test(b)) {
        alert("Price has to be a number.");
		return false;
    }
	var c = document.forms["form"]["txtDoB"].value;
	if(c== "") {
        alert("Date of Launch is required.");
		return false;
    }
	var d = document.forms["form"]["Category"].value;
    if(d== "") {
        alert("Category is required.");
        return false;
    }
	}
