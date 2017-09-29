<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
</meta>
<title>Daimler Yusuf_Coban</title>
<meta name="description" content=""></meta>
<meta name="viewport" content="width=device-width, initial-scale=1"></meta>
<link rel="apple-touch-icon" href="apple-touch-icon.png">
</link>
<link rel="apple-touch-icon-precomposed"
	href="/img/apple-touch/apple-touch-icon-57x57.png">
</link>
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="img//apple-touch/apple-touch-icon-72x72.png">
</link>
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="img/apple-touch/apple-touch-icon-114x114.png">
</link>
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="img/apple-touch/apple-touch-icon-144x144.png">
</link>
<link rel="stylesheet" type="text/css" href="css/jTinder.css">
</link>





</head>



<body>

	<!-- 
	<header class="page-header">
      <div class="page-header__logo" ng-click="mainCtrl.restart()"> 
        <img class="page-header__image de desktop" src="images/logo/desktop_de.svg" alt="logo"></img>
        <img class="page-header__image de mobile" src="images/logo/mobile_de.svg" alt="logo"></img>
      </div>

      <div class="page-header__imprint" ng-click="mainCtrl.openImprint()">
        <span class="page-header__imprint-icon icon IconInfoborder"></span>
        <span class="page-header__imprint-label ng-binding">Anbieter / Datenschutz</span>
      </div>
    </header> -->

	<div class="serverstatus" id="serverstatus"></div>
	<div class="loader" id="loader"></div>

	<ul>
		<li><div class="responsive" style="display: none" id="herzblatt0">
				<div class="gallery">
					<a target="_blank" href="img_fjords.jpg"> <img src=""
						id="herzblatt0_img" width="600" height="400"></img>
					</a>
					<div class="desc" id="herzblatt0_modellname">Add a
						description of the image here</div>
				</div>
			</div></li>
		<li><div class="responsive" style="display: none" id="herzblatt1">
				<div class="gallery">
					<a target="_blank" href="img_forest.jpg"> <img src=""
						id="herzblatt1_img" width="600" height="400"></img>
					</a>
					<div class="desc" id="herzblatt1_modellname">Add a
						description of the image here</div>
				</div>
			</div></li>
	</ul>







	<!-- start padding container -->
	<div class="wrap" id="wrap">
		<!-- start jtinder container -->
		<div id="tinderslide">
			<ul>
				<li class="pane1" id="pane1">
					<div class="img" id="pane1_img">
						<span id="pane1_span"> </span>
					</div>
					<div id="pane1_modellname">Modelname</div>
					<div id="pane1_infos"></div>
					<div class="like"></div>
					<div class="dislike"></div>
				</li>
				<li class="pane2" id="pane2">
					<div class="img" id="pane2_img">
						<span id="pane2_span"> </span>
					</div>
					<div id="pane2_modellname">Modelname</div>
					<div id="pane2_infos"></div>
					<div class="like"></div>
					<div class="dislike"></div>
				</li>
				<li class="pane3" id="pane3">
					<div class="img" id="pane3_img">
						<span id="pane3_span"> </span>
					</div>
					<div id="pane3_modellname">Modelname</div>
					<div id="pane3_infos"></div>
					<div class="like"></div>
					<div class="dislike"></div>
				</li>
				<li class="pane4" id="pane4">
					<div class="img" id="pane4_img">
						<span id="pane4_span"> </span>
					</div>
					<div id="pane4_modellname">Modelname</div>
					<div id="pane4_infos"></div>
					<div class="like"></div>
					<div class="dislike"></div>
				</li>
				<li class="pane5" id="pane5">
					<div class="img" id="pane5_img">
						<span id="pane5_span"> </span>
					</div>
					<div id="pane5_modellname">Modelname</div>
					<div id="pane5_infos"></div>
					<div class="like"></div>
					<div class="dislike"></div>
				</li>



			</ul>
		</div>
	</div>



	<!-- end padding container -->

	<!-- jTinder trigger by buttons  -->
	<div class="actions" id="action">
		<a href="#" class="dislike"><i></i></a> <a href="#" class="like"><i></i></a>
	</div>

	<!-- jTinder status text  -->
	<div id="status"></div>

	<!-- jQuery lib -->
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- transform2d lib -->
	<script type="text/javascript" src="js/jquery.transform2d.js"></script>
	<!-- jTinder lib -->
	<script type="text/javascript" src="js/jquery.jTinder.js"></script>
	<!-- jTinder initialization script -->
	<script type="text/javascript" src="js/main.js"></script>
	<script type="text/javascript" src="js/check.js"></script>


</body>
</html>