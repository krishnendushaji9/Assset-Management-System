var returnVal = true;
function validation() {
		// variables for input values from form RegForm
		var name = document.forms["RegForm"]["name"].value;
		var email = document.forms["RegForm"]["email"].value;
		var date = document.forms["RegForm"]["date"].value;
		var personNumber = document.forms["RegForm"]["personNumber"].value;
		var discount = document.forms["RegForm"]["discountcode"].value;
		
		
		// Regex variables
		var nameRegex = /^[a-zA-Z ]{3,30}$/;
		var emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		var dateRegex = /^([0-9]{4})-([0-9]{2})-([0-9]{2})$/;
		var numberRegex = /^[0-9 ]{1,2}$/;
		var discountRegex = /^[a-zA-Z0-9 ]{5,30}$/;
		
		// name check
		if (!nameRegex.test(name)) {
			document.getElementById("nameForm").style.display = "inline-block";
			returnVal = false;
		} else {
			document.getElementById("nameForm").style.display = "none";
		}
		
		// email check
		if (!emailRegex.test(email)) {
			document.getElementById("emailForm").style.display = "inline-block";
			returnVal = false;
		} else{
			document.getElementById("emailForm").style.display = "none";
		}
		
		// date check
		if (!dateRegex.test(date)) {
			document.getElementById("dateForm").style.display = "inline-block";
			returnVal = false;
		} else {
			returnVal = dateCheck();
			console.log("dateCheck " + dateCheck());
		}
		
		// person number check
		if (!numberRegex.test(personNumber)) {
			document.getElementById("personForm").style.display = "inline-block";
			returnVal = false;
		} else {
			if (personNumber < 1) {
				document.getElementById("personForm").style.display = "inline-block";
			} else {
				document.getElementById("personForm").style.display = "none";
			}
		}
		// discount Check
		if (!discountRegex.test(discount)) {
			document.getElementById("discountForm").style.display = "inline-block";
			returnVal = false;
		} else{
			document.getElementById("discountForm").style.display = "none";
		}
		
		// Check Selection
		if (checkSelect() == false) {
			document.getElementById("availForm").style.display = "inline-block";
			returnVal = false;
		} else{
			document.getElementById("availForm").style.display = "none";
		}
		//agreement
		if (agreement == null || agreement == "") {
			document.getElementById("termsForm").style.display = "inline-block";
			returnVal = false;
		} else {
			document.getElementById("termsForm").style.display = "none";

		}
		return returnVal;
}

function dateCheck() {
	// getting date
	var str = document.forms["RegForm"]["date"].value;
	// splitting date into array
	var res = str.split("-");

	// temp value astrue
	var returnVal = true;

	// checking date less than 2019 current year
	if (res[0] < 2019) {
		returnVal = false;
	}
	// checking if month input less than 12
	if (res[1] > 12) {
		returnVal = false;
	}
	// checking day input less than 31
	if (res[2] > 31) {
		returnVal = false;
	}
	// if all correct
	if (returnVal)
		document.getElementById("dateForm").style.display = "none";
	else
		document.getElementById("dateForm").style.display = "inline-block";

	return returnVal;
}
function finalVal() {
	// getting value of check box agreed or disagree
	var agreement = document.forms["RegForm"]["agree"].value;

	// if all the validation passed
	if (validation()) {
		// enters condition statement
		// checks if checkbox is agree
		if (agreement == "agree") {
			// redirect to thankyou page
			window.location.replace("thankyou.html");
			// checks if checkbox is disagree
		} else if (agreement == "disagree") {
			// redirect to index page
			window.location.replace("index.html");
		}
	} else
		return false;

}


function checkSelect() {
	var checkedOrNot = false;
	for (var i = 1; i <= 3; i++) {
		if (document.getElementById("check" + i).checked == true) {
			checkedOrNot = true;
		}
	}
	return checkedOrNot;
}

function todayDate() {

	// date variable
	var date = new Date();

	// initializing date, month and year
	var day = date.getDate();
	var month = date.getMonth() + 1;
	var year = date.getFullYear();

	// variable for full date which will be sent as min value to the input type
	var fullDate = "";

	// if and month less than 10, 0 will be concatinated in the following
	// conditions
	if (day < 10 && month < 10) {
		fullDate = year + "-0" + month + "-0" + day;
	} else if (day < 10) {
		fullDate = year + "-" + month + "-0" + day;
	} else if (month < 10) {
		fullDate = year + "-0" + month + "-" + day;
	} else {
		fullDate = year + "-" + month + "-" + day;
	}

	// inserting current date to the inputtag
	document.getElementById("date").min = fullDate;
}
	
