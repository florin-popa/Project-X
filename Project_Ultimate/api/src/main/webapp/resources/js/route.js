var app = angular.module("myApp", ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("/");

    $stateProvider
        .state('upload', {
            url: "/upload",
            templateUrl: "/resources/partials/upload.jsp"

        })
        .state('inertial', {
            url: "/inertial",
            templateUrl: "/resources/partials/inertial.jsp"

        })
        .state('environmental', {
            url: "/environmental",
            templateUrl: "/resources/partials/environmental.jsp"

        })
        .state('home', {
            url: "/home",
            templateUrl: "/resources/WEB-INF/index.jsp"

        })
        .state('succes', {
            url: "/succes",
            templateUrl: "/resources/partials/succes.jsp"

        });


});