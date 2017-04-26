'use strict';

shareit.controller('MediumController',
    function MediumController($scope, $http) {
        $http({
            method: 'GET',
            url: 'shareit/media/books'
        }).then(function success(response) {
            $scope.books = response.data;
        }, function errorCb(response) {
        });

        $http({
            method: 'GET',
            url: 'shareit/media/discs'
        }).then(function success(response) {
            $scope.discs = response.data;
        }, function errorCb(response) {
        });
    });