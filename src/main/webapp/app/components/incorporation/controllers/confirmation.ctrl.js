// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("confirmationController",confirmationController);

		function confirmationController($scope, $cookies){

			var res = $cookies.getObject('signInResult');
		}
})()
