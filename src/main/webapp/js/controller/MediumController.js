'use strict';

shareit.controller('MediumController',
    function MediumController($scope, $http) {
        $http.get({
            method: 'GET',
            url: 'shareit/media/books/12345'
        }).
            then(function (response) {
                $scope.book = response.data;
        }, function (response) {
            console.log('Error');
        })
    });
