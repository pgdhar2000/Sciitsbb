// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("ipDashboardController",ipDashboardController);

		function ipDashboardController($scope, $cookies, $location){

			var res = $cookies.getObject('signInResult');

			/*back button disable start*/

			$scope.$on('$locationChangeSuccess', function(event, newUrl, oldUrl){

				/*console.log("Old url is "+oldUrl);
				console.log("New url is "+newUrl);*/

				if(newUrl.indexOf("/ip-login") !== -1){
					$location.path("/ip-dashboard");
				}

			});

			/*back button disable end*/

			$scope.changeFiling = function(){
				$location.path("/ip-voluntary-liquidator");
			}

			$scope.changeApprovedMbcs = function(){
				$location.path("/ip-voluntary-liquidatory-approval");
			}

			$scope.changeSolvency = function(){
				$location.path("/ip-declaration-of-solvency");
			}
		}
})()
