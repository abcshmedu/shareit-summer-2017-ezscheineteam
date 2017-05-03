'use strict';

shareit.controller('EditBookController',
    function EditBookController($scope, $http, $location) {
        $scope.createBook = function (book) {
            $http({
                method: 'POST',
                url: 'shareit/media/books/',
                data: book
            })
                .then(function (response) {
                        console.log("Success posting book.");
                        $scope.message = "Created book: " + book.title;
                        $scope.createStatusMessage(response.data);
                        $('#status').addClass('alert-success');
                        $('#status').removeClass('alert-danger');
                        $scope.statusmsg = true;
                    },
                    function (response) {
                        console.log("Failed to post book.");
                        $scope.message = "Failed to create book: " + book.title;
                        $scope.createStatusMessage(response.data);
                        $('#status').addClass('alert-danger');
                        $('#status').removeClass('alert-success');
                        $scope.statusmsg = true;
                    });
        };

        $scope.createStatusMessage = function (msg) {
            $scope.status = msg.status;
            $scope.detail = msg.detail;
        };

        $scope.saveBook = function (book, newBookForm) {
            $scope.createBook(book);
        };

        $scope.cancelEdit = function() {
            window.location = '/';
        };
    });
