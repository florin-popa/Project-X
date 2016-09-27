<html>

<head>

    <title>Web app</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.18/angular.min.js"></script>
    <script src="https://code.highcharts.com/stock/highstock.js"></script>
    <script src="http://code.highcharts.com/highcharts-more.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment.js"></script>
    <script src="script.js"></script>

    <%--<script src="scripts/jquery-1.10.1.min.js"></script>--%>
    <%--<script src="scripts/highstock.js"></script>--%>
    <%--<script src="http://code.highcharts.com/stock/highstock.js"></script>--%>
    <%--<script src="http://code.highcharts.com/stock/modules/exporting.js"></script>--%>
    <%--<script src="https://code.highcharts.com/highcharts.js"></script>--%>
    <%--<script src="https://code.highcharts.com/modules/exporting.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>--%>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--<script src="http://code.highcharts.com/stock/highstock.js"></script>--%>
    <%--<script src="http://code.highcharts.com/stock/modules/exporting.js"></script>--%>
    <%--<script src="//cdnjs.cloudflare.com/ajax/libs/highcharts/2.3.5/highcharts.js"></script>--%>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <link href="../../resources/css/textarea.css" rel="stylesheet" type="text/css"/>
    <link href="../../resources/css/button.css" rel="stylesheet" type="text/css"/>


    <%--<link rel="stylesheet" type="text/css" href="styledel.css" />--%>


    <!-- UI-Router module -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.4.7/angular.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.js"></script>
    <%--<script src="https://code.highcharts.com/highcharts.js"></script>--%>
    <%--<script scrc="http://code.highcharts.com/stock/highstock.js"></script>--%>

    <%--<button id="button" class="autocompare">Add point</button>--%>

</head>

<style>
    body {
        /*background-image: url("../../resources/img/templ1.png");*/
        /*background-size: 100%;*/
        background-color: lightgrey;
    }
</style>


<body ng-app="myApp">
<%--style="background:bluelight url('/resources/partials/templ1.png') no-repeat;>--%>

<%--<div class="row">--%>
<%--<img src="../../resources/img/templ1.png" class="image">--%>
<%--</div>--%>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">WEB APPLICATION</a>
        </div>
        <ul class="nav navbar-nav">

            <li><a ui-sref="home">Home</a></li>
            <li><a ui-sref="upload">Upload file here!</a></li>
            <li><a ui-sref="inertial">INERTIAL</a></li>
            <li><a ui-sref="environmental">ENVIRONMENTAL</a></li>

        </ul>
    </div>
</nav>


<div class="container">
    <div class="jumbotron text-center">
        <h1>Welcome !</h1>
    </div>


    <div ui-view></div>

    <script type="text/javascript" src="/resources/js/route.js"></script>
    <script type="text/javascript" src="/resources/controllers/uploadCtrl.js"></script>
    <script type="text/javascript" src="/resources/controllers/inertialCtrl.js"></script>
    <script type="text/javascript" src="/resources/controllers/environmentalCtrl.js"></script>
    <script type="text/javascript" src="/resources/controllers/in2.js"></script>


    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</div>
</body>
</html>
