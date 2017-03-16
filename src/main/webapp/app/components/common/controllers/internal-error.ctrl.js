// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("internalErrorController",internalErrorController);

		function internalErrorController($scope, $cookies, UrlService, LogoutService){

			var res = $cookies.getObject('signInResult');
			if(res.responsePayload.middleName == null){

				$scope.loginUserName = res.responsePayload.firstName+" "+res.responsePayload.lastName;
			}else{

				$scope.loginUserName = res.responsePayload.firstName+" "+res.responsePayload.middleName+" "+res.responsePayload.lastName;
			}

			$scope.logout = function(){

				var urlValue = UrlService.logoutUrl();

				LogoutService.userLogout(res, urlValue);
			}

		}

})()
