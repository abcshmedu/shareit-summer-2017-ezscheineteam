'use strict';

shareit.controller('LoginController',
function LoginController($scope, $http) {
    $scope.login = function(credentials) {
        console.log("In login function");
        var req = {
            method: 'POST',
            url: 'http://auth-server-ezschein.herokuapp.com/users/authenticate/',
            headers: {
                "Content-type": "application/json; charset=utf-8"
            },
            data: credentials
        };

        $http(req).then(function(req, resp) {
            Console.log(resp.data.tokenString);
        });
    }
});