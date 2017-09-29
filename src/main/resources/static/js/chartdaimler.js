/**
 * 
 */

var staticars;
var label1= [];;
var data1= [];;
var label2= [];;
var data2= [];;
var label= [];;

sortbyliked();




function tabledraw(){
	var ctx = document.getElementById('myChart').getContext('2d');
	var myChart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : label,
			datasets : [ {
				label : 'liked',
				data : data1,
				backgroundColor : "rgba(153,255,51,0.6)"
			}, {
				label : 'disliked',
				data : data2,
				backgroundColor : "rgba(255,153,0,0.6)"
			} ]
		}
	});
}


function sortbyliked() {
	var data = null;
	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;
	xhr.addEventListener("readystatechange", function() {
		if (this.readyState === 4) {
			staticars = JSON.parse(this.responseText);
			staticars = staticars.slice(0, 7);// Test
			console.log(this.responseText);
			fillin(staticars);
		}
	});

	xhr.open("GET", "http://localhost:8080//statiLiked");
	xhr.setRequestHeader("cache-control", "no-cache");
	xhr.setRequestHeader("postman-token",
			"3b8dcf48-4f02-0817-5aec-3fd12ff366d9");

	xhr.send(data);
}

function sortbydisliked() {
	var liked = null;

	var xhr = new XMLHttpRequest();
	xhr.withCredentials = true;

	xhr.addEventListener("readystatechange", function() {
		if (this.readyState === 4) {
			console.log(this.responseText);
		}
	});

	xhr.open("GET", "http://localhost:8080//statiDisliked");
	xhr.setRequestHeader("cache-control", "no-cache");
	xhr.setRequestHeader("postman-token",
			"3b8dcf48-4f02-0817-5aec-3fd12ff366d9");

	xhr.send(data);

}

function fillin(input) {
	for (var i = 0; i < input.length; i++) {
		console.log(input[i]);
		label1[i] = input[i].id;
		data1[i] = input[i].liked;
		label2[i] = input[i].id;
		data2[i] = input[i].disliked;
		label[i] = input[i].id+"("+input[i].series+")";
	}
	tabledraw();

}