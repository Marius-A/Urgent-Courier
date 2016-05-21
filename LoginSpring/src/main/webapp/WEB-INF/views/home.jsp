<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>

<head>

<style type="text/css">
#parent {
	display: flex;
}

#narrow {
	width: 400px;
	background: lightblue;
	/* Just so it's visible */
}

#wide {
	margin-right: 20px;
	margin-left: 20px;
	flex: 1;
}

body {
	margin: 40px;
}
</style>

<link href='http://fonts.googleapis.com/css?family=Oswald:400,300'
	rel='stylesheet'>
<link href="resources/css/style.css" rel="stylesheet">
<script src="https://maps.googleapis.com/maps/api/js?v=3"
	type="text/javascript"></script>
<script type='text/javascript' src='resources/js/map.js'></script>
<script type='text/javascript'
	src='http://code.jquery.com/jquery-2.0.2.js'></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"
	type="text/javascript"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="login" style="width: 200px;">
				<c:choose>
					<c:when test="${empty loggedInUser.numeC }">
						<a href="login" class="btn btn-default btn-sm"> <span
							class="glyphicon glyphicon-log-in"></span> Log in
						</a>
					</c:when>

					<c:otherwise>
						<div>
							<b>Hello : </b> ${loggedInUser.numeC} <br /> <b>CUI:</b>
							${loggedInUser.cui}! &nbsp;
							<form action="logout">
								<a href="logout" class="btn btn-default btn-sm"> <span
									class="glyphicon glyphicon-log-out"></span> Log out
								</a>
							</form>
							<br />
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<a href="#" class="logo-icon"> <img
				src="https://peli-pod.com/media/1027/courier-icon-green.png?width=150px&amp;height=150px"
				alt="">
			</a>
			<ul class="menu">
				<li><a href="#">Descarca Aplicatia</a></li>
				<li><a href="#">Detalii de facturare</a></li>
				<li><a href="#">Lista sediilor</a></li>
				<li><a href="#">Call center</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle">Mai
						multe<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="#">Ceva</a></li>
						<li><a href="#">Altceva</a></li>
						<li><a href="#">Evenimente</a></li>
						<li><a href="#">Despre Noi</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<br />
	<br />
	<br />
	<div>
		<c:choose>
			<c:when test="${empty loggedInUser.numeC }" />



			<c:otherwise>
				<div id="parent">
					<div id="wide">
						<c:if test="${empty loggedInUser.listaFacturi}">
								You don't have any orders
							</c:if>
						<c:if test="${ not empty loggedInUser.listaFacturi}">
							<h2>Comenzile male</h2>
							<table id="myTable" class="table table-hover">
								<thead>
									<tr>
										<th>#Factura</th>
										<th>Valoare Totala</th>
										<th>Discount %</th>
										<th>Intemeietor</th>
										<td>Numar Produse</td>
										<th>Data preluare</th>
										<th>Data expediere</th>
										<th>Detalii Comanda</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="fact" items="${loggedInUser.listaFacturi}">
										<tr>
											<td>${fact.codFactura}</td>
											<td>${fact.valoareEfectiva}</td>
											<td>${fact.valoareDiscount*100}</td>
											<td><p>${fact.intemeietor.nume}   ${fact.intemeietor.prenume}</p></td>
											<td>${fact.comanda.numarProduse}</td>
											<td>${fact.comanda.dataPreluare}</td>
											<td>${fact.comanda.dataExpediere}</td>
											<td>
												<ol>
													<c:forEach var="pac" items="${fact.comanda.listaPachete}">
														<p>${pac}</p>
													</c:forEach>
												</ol>
											</td>
											<td><a href="#" class="btn btn-default btn-sm"
												data-toggle="modal" data-target="#myModal"> <span
													class="glyphicon glyphicon-duplicate"></span> Vezi factura
											</a></td>
										</tr>

									</c:forEach>
								</tbody>
							</table>

						</c:if>
					</div>
					<div id="narrow">
						<iframe
							src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Ffacebook&amp;tabs=timeline&amp;width=400&amp;height=700&amp;small_header=false&amp;adapt_container_width=true&amp;hide_cover=false&amp;show_facepile=true&amp;appId"
							width="400" height="700" style="border: none; overflow: hidden"
							scrolling="no" frameborder="0" allowTransparency="true"></iframe>
					</div>

				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div id="sliders">
		<div class="slider">

			<div class="slide active-slide">
				<div class="container">
					<div class="row">
						<div class="slide-copy col-xs-5">
							<h1>Descarca aplicatia UcExpress</h1>
							<p>UcExpress este o aplicatie care urmeaza a fi dezvoltata de
								catre Marius Iliescu , atunci cand va avea timp si mai ales
								chef.</p>

							<ul class="get-app">
								<li><a href="#"><img
										src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/ios.png"
										alt=""></a></li>
								<li><a href="#"><img
										src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/android.png"
										alt=""></a></li>
								<li><a href="#"><img
										src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/windows.png"
										alt=""></a></li>
								<li><a href="#"><img
										src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/blackberry.png"
										alt=""></a></li>
							</ul>
						</div>
						<div class="slide-img col-xs-7">
							<img
								src="https://7labs.heypub.com/wp-content/uploads/2015/03/Track-shipment-status-automatically-from-iPhone-Android.png"
								width="540px" alt="">
						</div>
					</div>
				</div>
			</div>

			<div class="slide slide-feature">
				<div class="container">
					<div class="row">
						<div class="col-xs-12">
							<a href="#">Citeste Acum</a>
						</div>

					</div>
				</div>
			</div>

			<div class="slide">
				<div class="container">
					<div class="row">
						<div class="slide-copy col-xs-5">
							<h1>Preturi avantajoase</h1>
							<h2>-cele mai mici-</h2>
							<p>Daca gasiti in alta parte mai ieftin ducetiva acolo.</p>

						</div>
						<div class="slide-img col-xs-7">
							<img
								src="https://paceaustralia.files.wordpress.com/2012/07/price-cut.jpg"
								alt="">
						</div>
					</div>
				</div>
			</div>

			<div class="slide">
				<div class="container">
					<div class="row">
						<div class="slide-copy col-xs-5">
							<h1>Suntem peste tot</h1>
							<p>Ne gasiti la urmatoarele locatii in fiecare zi de luni
								pana duminica intre orele 08:00-22:00</p>
						</div>
						<div class="slide-img col-xs-7">
							<div id ="googleMap" style="width:700px;height:420px;">
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="slide">
			<div class="container">
				<div class="row">
					<div class="slide-copy col-xs-5">
						<h1>Curierat simpu si rapid</h1>
						<p>Mi de oameni din toate colturile tarii au beneficiat de
							serviciile noastre.</p>

					</div>
					<div class="slide-img col-xs-7">
						<img
							src="http://blog.tjobs.ro/blog/wp-content/uploads/2014/03/c4736dc935c189544aebb6f51b9f219f-600x300.jpg"
							width="540px" alt="">
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="slider-nav">
		<a href="#" class="arrow-prev"><img
			src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/arrow-prev.png"
			alt=""></a>
		<ul class="slider-dots">
			<li class="dot active-dot">&bull;</li>
			<li class="dot">&bull;</li>
			<li class="dot">&bull;</li>
			<li class="dot">&bull;</li>
			<li class="dot">&bull;</li>
		</ul>
		<a href="#" id="slideb" class="arrow-next"><img
			src="http://s3.amazonaws.com/codecademy-content/courses/ltp2/img/flipboard/arrow-next.png"
			alt=""></a>
	</div>
	</div>



	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Factura</h4>
				</div>
				<div class="modal-body">
					<p>Factura ..... I don't know .... am pierdut-o . :)</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<script src="https://code.jquery.com/jquery-2.1.4.min.js"
		type="text/javascript"></script>
	<script src="resources/js/app.js" type="text/javascript"></script>
	<footer>
		<p>Made by Marius Iliescu</p>
		<p>
			Contact information: <a href="mailto:iliescu.marius.a@gmail.com">iliescu.marius.a@gmail.com</a>.
		</p>
	</footer>

	<script type="text/javascript">
		var timer = null;
		$('#sliders').hover(function(ev) {
			clearInterval(timer);
		}, function(ev) {
			timer = setInterval(function() {
				document.getElementById("slideb").click();
			}, 3000);
		});
	</script>
</body>
</html>