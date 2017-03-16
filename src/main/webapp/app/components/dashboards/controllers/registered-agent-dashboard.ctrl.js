// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("registeredAgentDashboardController",registeredAgentDashboardController);

		function registeredAgentDashboardController($scope, $cookies, $location){

			var res = $cookies.getObject('signInResult');

			/*back button disable start*/

			$scope.$on('$locationChangeSuccess', function(event, newUrl, oldUrl){

				/*console.log("Old url is "+oldUrl);
				console.log("New url is "+newUrl);*/

				if(newUrl.indexOf("/ra-login") !== -1){
					$location.path("/registered-agent-dashboard");
				}

			});

			/*back button disable end*/

			$scope.changeFiling = function(){
				$location.path("/ra-filing-transf-bvi-company");
			}

			$scope.changeRegistration = function(){
				$location.path("/ra-request-for-registration-bvi-company");
			}

			$scope.changeTransformation = function(){
				$location.path("/ra-transformation-bvi-business-company");
			}
		}

})()
