'use strict';

shareit.controller('EditBookController',
    function EditBookController($scope, bookData) {
        $scope.createStatusMessage = function (msg) {
            $scope.status = msg.status;
            $scope.detail = msg.detail;
        };

        $scope.saveBook = function (book, newBookForm) {
            bookData.postBook(book)
                .then(function (response) {
                        $scope.message = "Created book: " + book.title;
                        $scope.createStatusMessage(response.data);
                        $('#status').addClass('alert-success').removeClass('alert-danger');
                        $scope.statusmsg = true;
                    },
                    function (response) {
                        $scope.message = "Failed to create book: " + book.title;
                        $scope.createStatusMessage(response.data);
                        $('#status').addClass('alert-danger').removeClass('alert-success');
                        $scope.statusmsg = true;
                    });
        };

        $scope.cancelEdit = function() {
            window.location = '/';
        };
    });
