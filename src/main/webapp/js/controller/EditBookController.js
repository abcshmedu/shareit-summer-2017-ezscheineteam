'use strict';

shareit.controller('EditBookController',
    function EditBookController($scope, $http, $location) {
        $http({
            method: 'GET',
            url: 'shareit/media/books/12345'
        }).then(function success(response) {
            $scope.book = response.data;
        }, function errorCb(response) {
        });

        $scope.saveBook = function(book) {
            console.log(book.name);
        };
    });
