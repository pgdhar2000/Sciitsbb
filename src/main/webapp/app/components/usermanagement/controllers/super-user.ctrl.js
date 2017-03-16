// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("superUserController",superUserController);

		function superUserController($scope, $cookies, $location){

			var res = $cookies.getObject('signInResult');

			/*back button disable start*/

			$scope.$on('$locationChangeSuccess', function(event, newUrl, oldUrl){

				/*console.log("Old url is "+oldUrl);
				console.log("New url is "+newUrl);*/

				if(newUrl.indexOf("/super-login") !== -1){
					$location.path("/super-user");
				}

			});

			/*back button disable end*/


		}

})()
