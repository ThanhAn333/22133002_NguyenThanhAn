<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file ="/common/taglib.jsp" %>

<c:url value="/" var="URL"></c:url>
	
<!DOCTYPE html>

<head>
  <meta charset="utf-8">
  <title>Metronic Shop UI</title>

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <meta content="Metronic Shop UI description" name="description">
  <meta content="Metronic Shop UI keywords" name="keywords">
  <meta content="keenthemes" name="author">

  <meta property="og:site_name" content="-CUSTOMER VALUE-">
  <meta property="og:title" content="-CUSTOMER VALUE-">
  <meta property="og:description" content="-CUSTOMER VALUE-">
  <meta property="og:type" content="website">
  <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
  <meta property="og:url" content="-CUSTOMER VALUE-">

  <link rel="shortcut icon" href="favicon.ico">

  <!-- Fonts START -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css"><!--- fonts for slider on the index page -->  
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href="${URL}assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${URL}assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="${URL}assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="${URL}assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
  <link href="${URL}assets/global/plugins/slider-layer-slider/css/layerslider.css" rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="${URL}assets/global/css/components.css" rel="stylesheet">
  <link href="${URL}assets/frontend/layout/css/style.css" rel="stylesheet">
  <link href="${URL}assets/frontend/pages/css/style-shop.css" rel="stylesheet" type="text/css">
  <link href="${URL}assets/frontend/pages/css/style-layer-slider.css" rel="stylesheet">
  <link href="${URL}assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="${URL}assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="${URL}assets/frontend/layout/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
</head>
<!-- Head END -->

<body>
	<!-- Begin header -->
	<%@include file ="/common/web/header.jsp"  %>
	<!-- End header -->

    <div class="main">
      <div class="container">
      	<!-- BEGIN CONTENT -->
        <sitemesh:write property="body"/>
        <!-- END CONTENT -->
      </div>
    </div>

	<!--Begin Footer -->
	<%@include file ="/common/web/footer.jsp"  %>
	<!--End Footer -->
</body>
