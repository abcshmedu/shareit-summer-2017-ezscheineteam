'use strict';

shareit.controller('EditDiscController',
    function EditDiscController($scope, discData) {
        $scope.createStatusMessage = function(msg) {
            $scope.detail = msg.detail;
            $scope.status = msg.status;
        };

        $scope.saveDisc = function (disc) {
            discData.postDisc(disc)
                .then(function (response) {
                    $scope.message = 'Disc erstellt: ' + disc.title;
                    $scope.createStatusMessage(response.data);
                    $('#status').addClass('alert-success').removeClass('alert-danger');
                    $scope.statusmsg = true;
                }, function (response) {
                    $scope.message = "Fehler beim erstellen der Disc: " + disc.title;
                    $scope.createStatusMessage(response.data);
                    $('#status').addClass('alert-danger').removeClass('alert-success');
                    $scope.statusmsg = true;
                });
        };


        $scope.cancelEdit = function () {
            window.location = '/';
        };
    });