// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("rocaDashboardController",rocaDashboardController);

		function rocaDashboardController($scope, $cookies, $location){

			var res = $cookies.getObject('signInResult');

			/*back button disable start*/

			$scope.$on('$locationChangeSuccess', function(event, newUrl, oldUrl){

				/*console.log("Old url is "+oldUrl);
				console.log("New url is "+newUrl);*/

				if(newUrl.indexOf("/roca-login") !== -1){
					$location.path("/roca-dashboard");
				}

			});

			/*back button disable end*/

			$scope.changeFiling = function(){
				$location.path("/roca-mbc-details");
			}

			$scope.changeRegistration = function(){
				$location.path("/roca-bvi-registration");
			}

			$scope.changeTransformation = function(){
				$location.path("/roca-bvi-transformation");
			}
		}

})()
