// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("capacityPowersController",capacityPowersController);

		function capacityPowersController($scope, $cookies, $location){

			var res = $cookies.getObject('signInResult');

			$scope.financialServices = false;
			$scope.grossAssets = false;
			$scope.noEmployees = false;

			$scope.submitButton = function(){

				if(($scope.financialServices == true) || ($scope.grossAssets == true) || ($scope.noEmployees == true)){

					$location.path("/request-for-transformation");
				}else{

					$location.path("/mbc-names-confirmation");
				}
			}


		}

})()
