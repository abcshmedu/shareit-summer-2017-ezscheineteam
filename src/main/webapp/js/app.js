'use strict';

var shareit = angular.module('shareit',['ngRoute'])
    .config(function($routeProvider) {
        $routeProvider.when('/newBook',
            {
                templateUrl:'templates/NewBook.html',
                controller: 'EditBookController'
            })
    });
