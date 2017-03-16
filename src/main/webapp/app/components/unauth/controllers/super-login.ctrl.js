// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("superLoginController",superLoginController);

		function superLoginController($scope, $state, $location, $cookies, $http, UrlService, SuccessStatusService, LoginSvc){

			/*back button disable start*/

			var backButtonLogin = false;

			$scope.$on('$locationChangeStart', function(event, next, current){

				console.log($cookies.getObject('signOutResult'));

				backButtonLogin = $cookies.getObject('signOutResult');

				if((backButtonLogin) && (current.indexOf("/super-login") !== -1)){

					if(next.indexOf("#/search") == -1){

						event.preventDefault();
					}

					backButtonLogin = false;
					/*$cookies.remove('signOutResult');*/
				}


			});


			/*back button disable end*/

			/*User logout msg start*/

			$scope.logoutMsg = false;

			if(SuccessStatusService.getUserLogoutStatus()){

				$scope.logoutMsg = true;
			}

			/*User logout msg end*/

			/*Session expire msg start*/

			$scope.sessionExpireMsg = false;

			if(SuccessStatusService.getSessionExpireStatus()){

				$scope.sessionExpireMsg = true;
			}

			/*Session expire msg end*/

			$scope.validCheck = false;
			$scope.passwordMsg = false;
			$scope.usernameMsg = false;

			$scope.login = function(){
				/*console.log($scope.user);*/

				if(angular.isUndefined($scope.user)){

					$scope.usernameMsg = true;
					$scope.passwordMsg = true;
				}

				/*console.log($scope.user.username);*/

				if(angular.isUndefined($scope.user.username)){

					$scope.passwordMsg = false;
					$scope.usernameMsg = true;
				}

				/*console.log($scope.user.password);*/

				if(angular.isUndefined($scope.user.password)){

					$scope.passwordMsg = true;
					$scope.usernameMsg = false;
				}


				if(($scope.user.username != null) && ($scope.user.password != null)){

					LoginSvc.loginUser($scope.user).then(function(response){
						if(response.status == "200"){
							if(response.data.responseCode == "200"){

									$scope.validCheck = false;
									$scope.activeCheck = false;
									$scope.logoutMsg = false;
									$scope.sessionExpireMsg = false;
									$scope.passwordMsg = false;
									$scope.usernameMsg = false;
									$cookies.putObject('signInResult',response.data);

									$cookies.remove('signOutResult');

									if(angular.equals(response.data.message, "User login is successful")){

										console.log("login success");
										if(response.data.responsePayload.roleId == 6){
											console.log("super");
											$state.go("super-user");
										}


									}else{
										$state.go("super-login");
										$scope.activeCheck = true;
										$scope.user = null;
									}

							}else if(response.data.responseCode == "400"){
								$state.go("super-login");
								$scope.activeCheck = false;
								$scope.validCheck = true;
								$scope.logoutMsg = false;
								$scope.sessionExpireMsg = false;
								$scope.passwordMsg = false;
								$scope.usernameMsg = false;
								$scope.user = null;
							}
						}
					});
				}
			};

			$scope.removeMsgs = function(){

				console.log("removing");

				$scope.activeCheck = false;
				$scope.validCheck = false;
				$scope.logoutMsg = false;
				$scope.sessionExpireMsg = false;
				$scope.passwordMsg = false;
				$scope.usernameMsg = false;
			}

		}

})()
