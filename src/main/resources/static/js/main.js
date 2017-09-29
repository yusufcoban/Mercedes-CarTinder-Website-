var data = null;
var xhr = new XMLHttpRequest();
var img = []; // ARRAY MIT LINKS VON BILDER
var textarray = [];// ARAY MIT LISTELEMENTEN
var cars = [];
var options = [ 1, 2, 3, 4, 5, 6 ];

/*
 * ACTIVATE FOR OWN SPRING MVC
 *  // VON OBJEKTE URLs IN IMAGE-ARRAY SPEICHERN function getimage(array) { for
 * (var i = 0; i < array.length; i++) { img[i] = array[i].modelImageUrl;
 * //console.log(img[i]); } } // Load pics in css so that image shows on Page
 * function loadPic(array) { for (var i = 0; i < array.length; i++) {
 * document.getElementById("pane" + (i + 1)).style.background = 'url("' + img[i] +
 * '") no-repeat scroll center center'; } }
 *  // Add the contents to tinderslide function makeUL(array) { for (var i = 0;
 * i < array.length; i++) { textarray[i] = "pane" + (i + 1); }
 *  // Create the list element: for (var i = 0; i < array.length; i++) {
 * document.getElementById("pane" + (i + 1)).style.display = "block";
 * document.getElementById("pane"+(i+1)+"_img").style.background = 'url("' +
 * img[i] + '") no-repeat scroll center center'; document.getElementById("pane" +
 * (i + 1)+"_modellname").innerHTML = array[i].series;
 *  }
 *  // Finally, return the constructed list:
 *  }
 *  /* GET DATA FROM
 * SERVER-----LOCALHOST:8888/data------------------------------- save Objects in
 * Array separate Img from arrays
 */
/*
 * ACTIVATE FOR OWN SPRING MVC xhr.withCredentials = true; var obj;
 * xhr.addEventListener("readystatechange", function() { if (this.readyState ===
 * 4) { //console.log(this.responseText); obj = JSON.parse(this.responseText);
 * cars = obj; // console.log(obj); // OBJEKTE AUSSPUCKEN getimage(obj); //
 * BILDER ABSICHERN makeUL(obj);
 * //document.getElementById('tinderslide').appendChild(makeUL(obj));// Liste //
 * erneuern //loadPic(obj); } });
 * 
 * xhr.open("GET", "http://localhost:8888/data");
 * xhr.setRequestHeader("cache-control", "no-cache");
 * xhr.setRequestHeader("postman-token",
 * "f63f1e32-4633-2100-d74e-0159235048d4"); xhr.send(data);
 */
// -----------------------------------//
// -------------------------------------------------------------------------------------
// /**
// * jTinder initialization
// */
// $("#tinderslide").jTinder({
// // dislike callback
// onDislike : function(item) {
// // set the status text
// $('#status').html('Dislike Car ' + (item.index() + 1));
// },
// // like callback
// onLike : function(item) {
// // set the status text
// $('#status').html('Like Car ' + (item.index() + 1));
// },
// animationRevertSpeed : 200,
// animationSpeed : 400,
// threshold : 1,
// likeSelector : '.like',
// dislikeSelector : '.dislike'
// });
//
// /**
// * Set button action to trigger jTinder like & dislike.
// */
// $('.actions .like, .actions .dislike').click(function(e) {
// e.preventDefault();
// $("#tinderslide").jTinder($(this).attr('class'));
// });
