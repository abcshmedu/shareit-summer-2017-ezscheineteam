'use strict';

var shareit = angular.module('shareit',['ngRoute'])
    .config(function($routeProvider, $locationProvider) {
        $routeProvider.when('/newbook',
            {
                templateUrl:'/templates/NewBook.html',
                controller: 'EditBookController'
            })
            .when('/newdisc',
                {
                    templateUrl:'/templates/NewDisc.html',
                    controller: 'EditDiscController'
                })
            .when('/',
            {
                templateUrl:'/templates/MediaList.html',
                controller: 'MediumController'
            });
    });
