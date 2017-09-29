var herzauto = 1; // Setze AUTO VIRTUAL DOMS für herzblatt anzeige
var herzanzahl = 6;// ANZAHL ANZEIGE FAVORITE CARS // MAXIMAL 10
var buffer; // Puffer für BIlder URL
var url = new Array(5).fill(0);// IMAGE FROM SERVER Bilder URL NEU
// var codeset = []; // CODESET OF CARS
// var modelId = []; // MODELID OF CARS
// var equipment_code = []; // EQUIPMENT CODE WITH CORRECT SYNTAX
var random_number = 0;
var values = new Array(19).fill(0);// BEWERTUNG EVALUTAD
var maxX = 0; // MAXIMALWERT NACH DEM AUSSUCHEN
var custum; // ZUFALLSZAHL

// var cararray2 = []; // second Car array
// var secondcarlist = [];
var bufferarray = [];
var data; // JSON TEXT
// var img = []; // ARRAY MIT LINKS VON BILDER ALT
var carlikedstring = "";
var cardislikedstring = "";
var carsearch; // List car dynamic
var counter; // Stop Signal
var mobile;// MobileDevice State
var cararray = []; // primary Car array
var cararray_series = [];
var cararray_series2 = [];// TYPENBEZEICHUNUFN
var textarray = [];// ARAY MIT LISTELEMENTEN
var carliked = []; // Array with liked cars
var cardisliked = [];// Array with disliked cars
var r = [];
var autos = [];
var herzautos = [];// ERGEBNISSAUTOS
var checkall = new Array(5).fill(0);
var eigenschaften = [ "conceptValueRatings.autonom",
		"conceptValueRatings.effizient", "conceptValueRatings.eleganz",
		"conceptValueRatings.extravaganz", "conceptValueRatings.gelaende",
		"conceptValueRatings.geraeumig", "conceptValueRatings.innenraumLuxus",
		"conceptValueRatings.innovativ", "conceptValueRatings.kompakt",
		"conceptValueRatings.luxus", "conceptValueRatings.manuell",
		"conceptValueRatings.offenFahren", "conceptValueRatings.puristisch",
		"conceptValueRatings.rundumSicht", "conceptValueRatings.sicherheit",
		"conceptValueRatings.sportlich",
		"conceptValueRatings.sportlichesDesign",
		"conceptValueRatings.stauraum", "conceptValueRatings.traditionell" ];

// StartFunktion
start();

function testResults(form) {

	document.getElementById("SubmitButton").value = ("Please wait....");
	form.getElementsByTagName('input').length;
	console.log(form.getElementsByTagName('input').length);
	var schleife = form.getElementsByTagName('input').length;
	var output = "";
	for (var i = 2; i < schleife; i++) {

		if ((i != 6) && (i != 11)) {
			// console.log("Aktuelles i ="+i);
			// console.log( form[i].attributes.name.nodeValue +"=");
			// console.log( form[i].attributes.value.value +" Checked status is
			// "+form[i].checked);
			if (form[i].checked == true) {
				output = output + form[i].attributes.name.nodeValue + "="
						+ form[i].attributes.value.value + "&";
			}
		}
	}
	output = output.slice(0, output.length - 1);
	console.log(output);

	var data = output;
	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function() {
		if (this.readyState === this.DONE) {

			cararray = JSON.parse(this.responseText);
			console.log(cararray);
			try {
				cararray = cararray.slice(0, 5);// Test
				counter = cararray.length; // set counter
				// for
				// stopsignal
				makeUL(cararray);
				document.getElementById("myModal").style.display = "none";
				document.getElementById("myModal").className = "modal fade";
				document.getElementById("SubmitButton").value = ("Submit");
				$("#myModal").modal("hide");
				

			} catch (e) {
				// TODO: handle exception
			}
		}
	});

	xhr.open("POST", "http://localhost:8080//customsearch");
	xhr.setRequestHeader("content-type", "application/json");

	xhr.send(data);
}
function start() {
	pagevisible(0);
	fillcararray1();
}

function pagevisible(i) {
	if (i == 0) {
		// document.getElementById("wrap").style.display = "none";
		// document.getElementById("action").style.display = "none";
		// document.getElementById("status").style.display = "none";
		document.getElementById("wrap").style.visibilty = "hidden";
		document.getElementById("action").style.visibilty = "hidden";
		document.getElementById("status").style.visibilty = "hidden";
		document.getElementById("action").style.visibilty = "block";
		document.getElementById("loader2").style.visibilty = "block";

	} else if (i == 1) {
		document.getElementById("loader").style.display = "none";
		document.getElementById("wrap").style.display = " -webkit-box";
		document.getElementById("action").style.display = "-webkit-box";
		document.getElementById("status").style.display = "-webkit-box";

	}
}

function fillcararray1() {

	if (detectmob() == false) {

		var data = null;

		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;

		xhr
				.addEventListener(
						"readystatechange",
						function() {
							if (this.readyState === 4) {
								// console.log(this.responseText);
								cararray = JSON.parse(this.responseText);

								try {
									cararray = cararray.slice(0, 5);// Test
									counter = cararray.length; // set counter
									// for
									// stopsignal
									makeUL(cararray);
								} catch (err) {
									console
											.log("DIDNT GET ANY CARS FROM SERVER!");
								}

							}
							if (this.status == 500 || this.status == 502) {// IF
								// SERVER
								// ERROR

								document.getElementById("loader").style.background = "#e0e230";
								document.getElementById("wrap").style.display = "none";
								document.getElementById("action").style.display = "none";
								document.getElementById("status").style.display = "none";
								document.getElementById("serverstatus").style.display = "-webkit-box";
								document.getElementById("serverstatus").innerHTML = ("SERVER ERROR ");
								console.log("---SERVER returns Error ---");

							}
						});

		xhr.open("GET", "http://localhost:8080//data2");
		xhr.setRequestHeader("cache-control", "no-cache");
		xhr.setRequestHeader("postman-token",
				"84901a89-0086-81d3-d822-dd081e6b0c5e");
		xhr.send(data);
	} else {

		document.getElementById("wrap").style.height = "400px"; // RESOLUTION
		document.getElementById("demo").style.paddingLeft="0%"; //HERZBLATTANZEIGE MOBILE GERÄTE
		// FOR MOBILE
		// DEVICES
		var data = null;

		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;

		xhr
				.addEventListener(
						"readystatechange",
						function() {
							if (this.readyState === 4) {
								// console.log(this.responseText);
								cararray = JSON.parse(this.responseText);
								cararray = cararray.slice(0, 5);// Test

								counter = cararray.length; // set counter for
								// stopsignal
								makeUL(cararray);
							}
							if (this.status == 500 || this.status == 502) {// IF
								// SERVER
								// ERROR

								document.getElementById("loader").style.background = "#e0e230";
								document.getElementById("wrap").style.display = "none";
								document.getElementById("action").style.display = "none";
								document.getElementById("status").style.display = "none";
								document.getElementById("serverstatus").style.display = "-webkit-box";
								document.getElementById("serverstatus").innerHTML = ("SERVER ERROR ");
								console.log("---SERVER returns Error ---");

							}
						});

		xhr.open("GET", "http://localhost:8080//data3");
		xhr.setRequestHeader("cache-control", "no-cache");
		xhr.setRequestHeader("postman-token",
				"84901a89-0086-81d3-d822-dd081e6b0c5e");
		xhr.send(data);

	}

}
/**
 * 
 * errechnen durch als positiv gestimmten Autos
 */
function evaluate() {
	try {

		if (carliked.length > 0) {
			for (var i = 0; carliked.length; i++) {
				// values[0] =( values[0] +
				// carliked[i].conceptValueRatings.autonom)*2;
				// values[1] =( values[1]
				// + carliked[i].conceptValueRatings.effizient)*2;
				values[2] = (values[2] + carliked[i].conceptValueRatings.eleganz) * 1.05;
				values[3] = (values[3] + carliked[i].conceptValueRatings.extravaganz);
				values[4] = (values[4] + carliked[i].conceptValueRatings.gelaende) * 2;
				values[5] = (values[5] + carliked[i].conceptValueRatings.geraeumig) * 1.5;
				// values[6] =( values[6]
				// + carliked[i].conceptValueRatings.innenraumLuxus)*2;
				// values[7] = (values[7] +
				// carliked[i].conceptValueRatings.innovativ);
				values[8] = (values[8] + carliked[i].conceptValueRatings.kompakt);
				values[9] = (values[9] + carliked[i].conceptValueRatings.luxus) * 1.5;
						// values[10] =( values[10]
						// + carliked[i].conceptValueRatings.manuell)*2;
						values[11] = (values[11] + carliked[i].conceptValueRatings.offenFahren) * 2,
						3;
				// values[12] = (values[12]
				// + carliked[i].conceptValueRatings.puristisch)*2;
				values[13] = (values[13] + carliked[i].conceptValueRatings.rundumSicht) * 1.5;
				values[14] = (values[14] + carliked[i].conceptValueRatings.sicherheit);
				values[15] = (values[15] + carliked[i].conceptValueRatings.sportlich) * 2;
				values[16] = (values[16] + carliked[i].conceptValueRatings.sportlichesDesign) * 2;
				values[17] = (values[17] + carliked[i].conceptValueRatings.stauraum);
				// values[18] = values[18]
				// + carliked[i].conceptValueRatings.traditionell)*2;
				// console.log(values[0]);
				// console.log(values[1]);
				// console.log(values[2]);
			}
		}

		if (carliked.length > 0) {
			for (var i = 0; carliked.length; i++) {
				// values[0] = values[0]
				// -carliked[i].conceptValueRatings.autonom;
				// values[1] =
				// values[1]-carliked[i].conceptValueRatings.effizient;
				values[2] = values[2] - carliked[i].conceptValueRatings.eleganz;
				values[3] = values[3]
						- carliked[i].conceptValueRatings.extravaganz;
				values[4] = values[4]
						- carliked[i].conceptValueRatings.gelaende;
				values[5] = values[5]
						- carliked[i].conceptValueRatings.geraeumig;
				// values[6] = values[6]-
				// carliked[i].conceptValueRatings.innenraumLuxus;
				// values[7] = values[7]
				-carliked[i].conceptValueRatings.innovativ;
				values[8] = values[8] - carliked[i].conceptValueRatings.kompakt;
				values[9] = values[9] - carliked[i].conceptValueRatings.luxus;
				// values[10] = values[10]-
				// carliked[i].conceptValueRatings.manuell;
				values[11] = values[11]
						- carliked[i].conceptValueRatings.offenFahren;
				// values[12] = values[12]-
				// carliked[i].conceptValueRatings.puristisch;
				// values[13] =
				// values[13]-carliked[i].conceptValueRatings.rundumSicht;
				values[14] = values[14]
						- carliked[i].conceptValueRatings.sicherheit;
				values[15] = values[15]
						- carliked[i].conceptValueRatings.sportlich;
				values[16] = values[16]
						- carliked[i].conceptValueRatings.sportlichesDesign;
				values[17] = values[17]
						- carliked[i].conceptValueRatings.stauraum;
				// values[18] = values[18]-
				// carliked[i].conceptValueRatings.traditionell;
			}
		}
	} catch (err) {

	}
	getAuswertung();
}

/**
 * Statistik
 */

function setStatistik(c, state) {
	var data = JSON.stringify(c);
	if (state == 0) {

		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;

		xhr.addEventListener("readystatechange", function() {
			if (this.readyState === 4) {
				console.log(this.responseText);
			}
		});

		xhr.open("PUT", "http://localhost:8080//addnegative");
		xhr.setRequestHeader("content-type", "application/json");
		xhr.setRequestHeader("cache-control", "no-cache");
		xhr.setRequestHeader("postman-token",
				"0e3c4e57-318e-5a25-970c-a60ebe263930");
		xhr.send(data);
	}

	else {

		var xhr = new XMLHttpRequest();
		xhr.withCredentials = true;

		xhr.addEventListener("readystatechange", function() {
			if (this.readyState === 4) {
				console.log(this.responseText);
			}
		});
		xhr.open("PUT", "http://localhost:8080//addpositive");
		xhr.setRequestHeader("content-type", "application/json");
		xhr.setRequestHeader("cache-control", "no-cache");
		xhr.setRequestHeader("postman-token",
				"0e3c4e57-318e-5a25-970c-a60ebe263930");
		xhr.send(data);

	}

}

/**
 * 
 * Auswertung von Ergebnisse und Ausgabe über Einschätzung
 */
function getAuswertung() {
	maxX = Math.max.apply(null, values);// get Max Entriy
	if (maxX <= 0) {
		console.log("Dann kann ich dir nicht helfen");
		setStatistik(cardisliked, 0);
		window.location.reload();
	} else {
		var buffer = maxX;
		var index = values.indexOf(maxX);
		var wertschätzung = eigenschaften[index];
		values[index] = -Infinity; // replace max in the array with -infinity
		var secondMaxX = Math.max.apply(null, values); // get the new max
		values[index] = buffer;
		console.log(maxX);
		console.log(secondMaxX);
		var wertschätzung2 = eigenschaften[values.indexOf(secondMaxX)];

		console.log("-------------------------------");
		// console.log(maxX);
		// console.log(index);
		console.log(wertschätzung);
		console.log(wertschätzung2);

		// StatistikPflege
		setStatistik(cardisliked, 0);
		setStatistik(carliked, 1);
		// NEHME WERTSCHÄTZUNG UND SCHICKE AN DATA4
		getherzAutos(wertschätzung, wertschätzung2);

		// herzblatt(wertschätzung, wertschätzung2, maxX, secondMaxX);
	}
}

/**
 * 
 * @param Gut
 *            empfundene Werte
 * @param Gut
 *            empfundene Werte
 * @returns
 */
function getherzAutos(a, b) {
	console.log("Kriterium von Herzblatt : " + a);
	console.log("Kriterium von Herzblatt : " + b);
	var data = null;

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function() {
		if (this.readyState === 4) {
			// console.log(this.responseText);
			autos = JSON.parse(this.responseText);// Point+
			// Pon
			console.log(autos);
			herzautos = autos.slice(0, 2);// Test
			herzblatt_anzeige(herzautos);

		}
	});
	xhr.addEventListener("progress", function() {
		console.log("läuft...<3");
	});
	xhr.open("GET", "http://localhost:8080//data4?fav1=\"" + a + "\"&fav2=\""
			+ b + "\"");
	xhr.setRequestHeader("cache-control", "no-cache");
	xhr.setRequestHeader("postman-token",
			"12bfd89a-1816-32d2-cd91-ff77e66fc360");
	xhr.send(data);
}

/**
 * SPINNING CIRCLE TEST
 */

function spin(a) {

	if (a == true) {
		document.getElementById("loader2").style.visibility = "visible";
		var target = document.getElementById('loader2');
		var spinner = new Spinner().spin();
		target.appendChild(spinner.el);
	} else {
		document.getElementById("loader2").style.display = "none";
		document.getElementById("loader2").style.visibility = " hidden";
	}

}

/**
 * HERZBLATT ANZEIGE entweder manuell...oder automatsisch
 * 
 * @param a
 * @returns
 */
function herzblatt_anzeige(a) {

	while (herzautos.length == 0) {
		console.log("was");
	}

	// document.getElementById("herzblatt1").style.display = "-webkit-box";
	// pointer

	/**
	 * WErte in HTML EINFÜGEN HERZAUTOS
	 */
	// XXX
	document.body.style.overflow = "initial";
	console.log("maybe the right one...");

	if (herzauto == 1) {
		demo(autos.slice(0, herzanzahl)); // HERZANZEIGE AUTOMATISCH 5 stück
	} else {
		document.getElementById("mybox").style.display = "block";
		var leistungsgrenze;
		if (herzautos[0].technicalValues.ratedOutputKw > herzautos[1].technicalValues.ratedOutputKw) {
			leistungsgrenze = herzautos[0].technicalValues.ratedOutputKw + 50;
		} else {
			leistungsgrenze = herzautos[1].technicalValues.ratedOutputKw + 50;
		}
		var verbrauch1 = ((herzautos[0].technicalValues.fuelConsumptionCombinedMin + herzautos[0].technicalValues.fuelConsumptionCombinedMax) / 2)
				.toFixed(1);
		var verbrauch2 = ((herzautos[1].technicalValues.fuelConsumptionCombinedMin + herzautos[0].technicalValues.fuelConsumptionCombinedMax) / 2)
				.toFixed(1);
		var leistung1 = (herzautos[0].technicalValues.ratedOutputKw * 1.35962);
		var leistung2 = (herzautos[1].technicalValues.ratedOutputKw * 1.35962);

		console.log(herzautos[0].technicalValues.ratedOutputKw);
		console.log(herzautos[1].technicalValues.ratedOutputKw);
		console.log(leistung1);
		console.log(leistung2);
		console.log("Leistungsgrenze in KW= " + leistungsgrenze);
		console.log("Leistungsgrenze in PS= " + leistungsgrenze * 1.35962);

		document.getElementById("herzblatt0_modellname").innerHTML = (herzautos[0].label);
		document.getElementById("herzblatt1_modellname").innerHTML = (herzautos[1].label);
		document.getElementById("herzblatt0_img").src = herzautos[0].modelImageUrl;
		document.getElementById("herzblatt1_img").src = herzautos[1].modelImageUrl;
		document.getElementById("verbrauch1_wert").innerHTML = verbrauch1
				+ " L/100km";
		document.getElementById("verbrauch2_wert").innerHTML = verbrauch2
				+ " L/100km";
		document.getElementById("leistung1_wert").innerHTML = parseInt(leistung1)
				+ " PS";
		document.getElementById("leistung2_wert").innerHTML = parseInt(leistung2)
				+ " PS";
		document.getElementById("verbrauch1").style.width = (verbrauch1 * 5)
				+ "%";
		document.getElementById("verbrauch2").style.width = (verbrauch2 * 5)
				+ "%";
		document.getElementById("leistung1").style.width = parseInt((herzautos[0].technicalValues.ratedOutputKw / leistungsgrenze) * 100)
				+ "%";
		document.getElementById("leistung2").style.width = parseInt((herzautos[1].technicalValues.ratedOutputKw / leistungsgrenze) * 100)
				+ "%";

		// (((array[i].technicalValues.fuelConsumptionCombinedMin +
		// array[i].technicalValues.fuelConsumptionCombinedMax) / 2)
		// .toFixed(1))
		// document.getElementById("herzblatt0_img").style.background = 'url("'
		// + herzautos[0].modelImageUrl + '") no-repeat scroll center center';
		// document.getElementById("herzblatt0_img").style.width="600";
		// document.getElementById("herzblatt0_img").style.height="400";
		// document.getElementById("gallery0_id").href =
		// herzautos[0].modelImageUrl;
		// document.getElementById("gallery1_id").href =
		// herzautos[1].modelImageUrl;

	}
	spin(false);

}

/**
 * HERZBLATT AUTOMATIESIEREN
 */
function demo(array) {
	var leistungsmax = 0;
	for (var i = 0; i < array.length; i++) {
		if (array[i].technicalValues.ratedOutputKw > (leistungsmax - 50)) {

			try {
				leistungsmax = array[i].technicalValues.ratedOutputKw + 50;
				document.getElementById("demo").style.display = "block";
			} catch (err) {
				document.getElementById("demo").innerHTML = err.message;
			}

		}
	}

	for (var i = 0; i < array.length; i++) {
		var div = document.createElement("div");
		div.id = "gallery" + i;

		var a = document.createElement("a");
		a.id = "gallery" + i + "_id";
		a.alt = "";
		a.target = "_blank";
		a.href = array[i].codeSet;

		var img = document.createElement("img");
		img.src = array[i].modelImageUrl;
		img.id = "herzblatt" + i + "img";
		// img.style.width = "400px";
		img.style.height = "auto";

		var div2 = document.createElement("div");

		div2.id = "herzblatt" + i + "_modellname";
		if (array[i].label.length > 25) {
			div2.innerHTML = array[i].label.slice(0, 25) + "....";
		} else {
			div2.innerHTML = array[i].label;
		}

		var div3 = document.createElement("div");
		var verbrauch = (((array[i].technicalValues.fuelConsumptionCombinedMin + array[i].technicalValues.fuelConsumptionCombinedMax) / 2)
				.toFixed(1));
		var verbrauch_text = document.createTextNode("Verbrauch: " + verbrauch
				+ " L/100km: ");

		div3.id = "div3" + i;

		var a2 = document.createElement("a");
		a2.id = "verbrauch" + (i + 1) + "_wert";

		var div4 = document.createElement("div");
		div4.id = "div4" + i;

		var div5 = document.createElement("div");
		div5.id = "verbrauch" + (i + 1);

		var div6 = document.createElement("div");
		var leistung_text = document.createTextNode("Leistung: "
				+ parseInt(array[i].technicalValues.ratedOutputKw * 1.35962)
				+ " in PS");

		var a3 = document.createElement("a");
		a3.id = "leistung" + (i + 1) + "_wert";

		var div7 = document.createElement("div");
		div7.id = "div7" + i;

		var div8 = document.createElement("div");
		div8.id = "leistung" + (i + 1);
		div8.style.width = "88%";

		/**
		 * Set order of DOMs
		 */

		document.getElementById("demo").appendChild(div);
		document.getElementById(div.id).appendChild(a);
		document.getElementById(a.id).appendChild(img);
		document.getElementById(a.id).appendChild(div2);
		document.getElementById(div.id).appendChild(div3);
		document.getElementById(div3.id).appendChild(a2);
		document.getElementById(div.id).appendChild(div4);
		document.getElementById(div.id).appendChild(leistung_text);
		document.getElementById(div4.id).appendChild(div5);
		document.getElementById(div5.id).appendChild(a3);
		document.getElementById(div.id).appendChild(div7);
		document.getElementById(div.id).appendChild(div6);
		document.getElementById(div7.id).appendChild(div8);

		/**
		 * set width for Balken
		 */
		document.getElementById(div5.id).style.width = (verbrauch * 5) + "%";
		document.getElementById(div8.id).style.width = parseInt((array[i].technicalValues.ratedOutputKw / leistungsmax) * 100)
				+ "%";
		/**
		 * Werte laden
		 */
		div3.appendChild(verbrauch_text);

		/**
		 * SET CLASS OF DOMs
		 */
		document.getElementById(div.id).className = "gallery";
		document.getElementById(div2.id).className = "desc";
		document.getElementById(div4.id).className = "w3-light-grey w3-round-xlarge";
		document.getElementById(div5.id).className = "w3-container w3-blue w3-round-xlarge";
		document.getElementById(div7.id).className = "w3-light-grey w3-round-xlarge";
		document.getElementById(div8.id).className = "w3-container w3-blue w3-round-xlarge";

	}

}

function herzblatt(a, b, aa, bb) {
	var data;
	var myObj = {};
	// myObj["filter_type"] = "concept";
	// myObj["field"] = a;
	// myObj["value"] = aa;

	// var json = JSON.stringify(myObj);
	var json_othermethod = '[ {"filter_type" : "concept" ,"field" : "' + a
			+ '","value" :' + aa + '},{"filter_type" : "concept" ,"field" : "'
			+ b + '","value" :' + bb + '} ]';
	// return json_othermethod;
	data = json_othermethod;
	herzblattsuche(data);
	console.log(herzautos);

};

function getImageHTTP(http_url, i) {
	var data = null;
	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr
			.addEventListener(
					"readystatechange",
					function() {
						if (this.status == 500 || this.status == 502) {
							// IF SERVER ERROR Hide everything..yellow
							// Background

							document.getElementById("loader").style.background = "#e0e230";
							document.getElementById("wrap").style.display = "none";
							document.getElementById("action").style.display = "none";
							document.getElementById("status").style.display = "none";
							document.getElementById("serverstatus").style.display = "-webkit-box";
							document.getElementById("serverstatus").innerHTML = ("SERVER ERROR");
							console.log("---SERVER returns Error ---");
						}
						if (this.readyState === 4) {
							response = this.responseText;
							fillurlimage(i, response, cararray);
						}
					});

	xhr.open("GET", http_url);
	xhr.setRequestHeader("cache-control", "no-cache");

	xhr.send(data);
}

function getcarlist(data) { // FILL ARRAY WITH CARS
	// console.log("START GETCARLIST");
	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;
	// sofort

	xhr.addEventListener("loadend", function() {
		if (this.readyState === 4) {

			array = JSON.parse(this.responseText);
			cararray2 = array;
			bufferarray = cararray2;
			secondcarlist = bufferarray;
			// console.log("END GETCARLIST");
		}
	});
	xhr.addEventListener("progress", function() {
		console.log("läuft...");

	});

	xhr
			.open(
					"POST",
					"https://api-sre-int.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=4&maxBucket=7&divfield=highlight.equipmentCode");
	xhr.setRequestHeader("content-type", "application/json");
	xhr.setRequestHeader("cache-control", "no-cache");

	xhr.send(data);

}

function herzblattsuche(data) { // FILL ARRAY WITH CARS
	// UNNESSESARY
	// console.log("START GETCARLIST");
	// var xhr = new XMLHttpRequest();
	// xhr.withCredentials = true;
	// xhr.addEventListener("loadend", function() {
	// if (this.readyState === 4) {
	// array = JSON.parse(this.responseText);
	// herzautos = array;
	// herzblatt_anzeige();
	// }
	// });
	// xhr.addEventListener("progress", function() {
	// console.log("läuft...");
	// });
	// xhr
	// .open(
	// "POST",
	// "https://api-sre-int.corpinter.net/mofi/modelfinder-backend/api/markets/de_DE/model?count=2&maxBucket=7&divfield=highlight.equipmentCode");
	// xhr.setRequestHeader("content-type", "application/json");
	// xhr.setRequestHeader("cache-control", "no-cache");
	// xhr.send(data);
	// api-sre-int

}

/**
 * Funktion um mobile Geräte zu erkennen
 */
function detectmob() {
	if (navigator.userAgent.match(/Android/i)
			|| navigator.userAgent.match(/webOS/i)
			|| navigator.userAgent.match(/iPhone/i)
			|| navigator.userAgent.match(/iPad/i)
			|| navigator.userAgent.match(/iPod/i)
			|| navigator.userAgent.match(/BlackBerry/i)
			|| navigator.userAgent.match(/Windows Phone/i)) {
		mobile = 1;
		return true;
	} else {
		mobile = 0;
		return false;
	}
}

function savecars(text) {
	cararray[0] = JSON.parse(text);

}

function makeUL(array) {// Add the contents to tinderslide
	for (var i = 0; i < array.length; i++) {
		textarray[i] = "pane" + (i + 1);
	}
	// Create the list element:
	try {
		for (var i = 0; i < array.length; i++) {

			// if(mobile==1){
			// document.getElementById("pane" + (i + 1) + "_img").src =
			// array[i].modelImageUrl;
			// }
			// else{
			// document.getElementById("pane" + (i + 1) +
			// "_img").style.background = 'url("'
			// + array[i].modelImageUrl
			// + '") no-repeat scroll center center';
			// }
			//			

			document.getElementById("pane" + (i + 1) + "_span").innerHTML = "Kraftsoff : "
					+ array[i].technicalValues.fuelTypePrimary
					+ "<br />"
					+ "komb. Verbrauch in L/100km : "
					+ (((array[i].technicalValues.fuelConsumptionCombinedMin + array[i].technicalValues.fuelConsumptionCombinedMax) / 2)
							.toFixed(1))
					+ "<br />"
					+ "Leistung in PS : "
					+ parseInt(array[i].technicalValues.ratedOutputKw * 1.35962)

			document.getElementById("pane" + (i + 1) + "_span").style.fontSize = "0.5em";
			document.getElementById("pane" + (i + 1) + "_span").style.fontSize = "70%";
			document.getElementById("pane" + (i + 1) + "_span").style.float = "none";
			document.getElementById("pane" + (i + 1) + "_span").style.top = "52%";
			document.getElementById("pane" + (i + 1) + "_span").style.opacity = "0.5";

			if (mobile == 1) {
				document.getElementById("pane" + (i + 1) + "_span").style.position = "initial";

				// Postition von der Infobox abändern
			} else {
				document.getElementById("pane" + (i + 1) + "_img").style.maxWidth = "1000px";

			}

			if (array[i].label.length > 25) {
				// Moruk
				document.getElementById("pane" + (i + 1) + "_modellname").innerHTML = (array[i].label
						.slice(0, 25) + "....");
			} else {
				document.getElementById("pane" + (i + 1) + "_modellname").innerHTML = (array[i].label);
			}

			document.getElementById("pane" + (i + 1) + "_modellname").style.background = "lightsteelblue";
			document.getElementById("pane" + (i + 1)).style.display = "block";

			/*
			 * STYLE RESPONSIVE &MOBILE
			 */
			if (mobile == 1) {
				document.getElementById("pane" + (i + 1)).style.fontSize = "larger";
				console.log("was here...");
				document.getElementById("pane" + (i + 1) + "_img").src = array[i].modelImageUrl;

				/**
				 * Hide ActionsBar for mobile Devices:...:
				 */
				document.getElementById("action").style.display = "none";
				document.getElementById("action").style.visibility = " hidden";

				/**
				 * Gallery mobile Darstellung
				 */

				document.getElementById("action").style.visibility = " hidden";

				// /**
				// * Spacefiller for Mobile Devices
				// */
				// document.getElementById("pane1mobile").style.display = "
				// -webkit-box";
				// document.getElementById("pane2mobile").style.display = "
				// -webkit-box";
				// document.getElementById("pane3mobile").style.display = "
				// -webkit-box";
				// document.getElementById("pane4mobile").style.display = "
				// -webkit-box";
				// document.getElementById("pane5mobile").style.display = "
				// -webkit-box";

			} else {
				document.getElementById("pane" + (i + 1) + "_img").src = array[i].modelImageUrl;
			}

		}
	} catch (err) {

	}

	pagevisible(1);

}

function customsearch(input) {

}

function fillString() {// FILL STRING FOR FINAL OUTPUT
	for (var i = 0; i < carliked.length; i++) {
		// console.log(carliked.length);
		// console.log(carliked[0].label);
		carlikedstring += carliked[i].series + " ";
	}
	for (var i = 0; i < cardisliked.length; i++) {
		// console.log(cardisliked[i].series);
		cardislikedstring += cardisliked[i].series + " ";
	}

}
/**
 * jTinder initialization
 */
$("#tinderslide")
		.jTinder(
				{
					// dislike callback
					onDislike : function(item) {

						if (counter == 1) {
							cardisliked.push(cararray[item.index()]);
							fillString();
							document.getElementById("action").style.display = "none";
							document.getElementById("status").style.display = "none";
							document.getElementById("tinderslide").style.visibility = " hidden";
							document.getElementById("filter").style.visibility = " hidden";
							console.log("Cars you liked: " + carlikedstring);
							console.log("Cars you disliked: "
									+ cardislikedstring);
							spin(true);
							evaluate();
						}
						// INFOTEXT SETZEN
						// $('#status').html('Dislike Car ' + (item.index() +
						// 1));
						else {
							counter = counter - 1;
							// console.log(counter);
							$('#status')
									.html(
											'Dislike '
													+ (cararray[item.index()].label));
							// einfärben vom INFOBEREICH
							document.getElementById("status").style.backgroundColor = "red";
							cardisliked.push(cararray[item.index()]);
						}
					},

					// like callback
					onLike : function(item) {
						// console.log(counter);
						if (counter == 1) {
							carliked.push(cararray[item.index()]);
							fillString();
							document.getElementById("action").style.display = "none";
							document.getElementById("status").style.display = "none";
							// document.getElementById("").style.background:
							// "dimgrey";
							document.getElementById("tinderslide").style.visibility = " hidden";
							document.getElementById("filter").style.display = "none";
							console.log("Cars you liked: " + carlikedstring);
							console.log("Cars you disliked: "
									+ cardislikedstring);
							spin(true);
							evaluate();
						}
						// set the status text
						// $('#status').html('Like Car ' + (item.index() + 1));
						else {
							counter = counter - 1;
							// console.log(counter);
							$('#status').html(
									'Like ' + (cararray[item.index()].label));
							carliked.push(cararray[item.index()]);
							// einfärben
							document.getElementById("status").style.backgroundColor = "green";
						}
					},
					animationRevertSpeed : 200,
					animationSpeed : 400,
					threshold : 1,
					likeSelector : '.like',
					dislikeSelector : '.dislike'
				});

/**
 * Set button action to trigger jTinder like & dislike.
 */
$('.actions .like, .actions .dislike').click(function(e) {
	e.preventDefault();
	$("#tinderslide").jTinder($(this).attr('class'));
});
