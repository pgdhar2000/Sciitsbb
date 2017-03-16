// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("charterController",charterController);

		function charterController($scope, $cookies, $location, $http, UrlService, IncorporationService){

			var res = $cookies.getObject('signInResult');

			$scope.generateCharterButton = false;
			$scope.registrationBlock = false;
			$scope.charterDataBlock = false;
			$scope.editCharterDataBlock = false;
			$scope.ammendmentValue = false;

			IncorporationService.incorporationsList(res.responsePayload.authCode).then(function(response){
				if(response.status == "200"){
					if(response.data.responseCode == "200" && response.data.message == "Incorporations"){
						$scope.incorporations = response.data.responsePayload;
					}
				}
			});

				$scope.selectedIncorporation;

				$scope.changingIncorporations = function(data){

					console.log(data);
					console.log("Mbc Id: "+data.mbcId);

					$scope.generateCharterButton = true;
					$scope.registrationBlock = false;
					$scope.charterDataBlock = false;
					$scope.editCharterDataBlock = false;
					$scope.ammendmentValue = false;
					$scope.incorporationId = data.mbcId;
				}

				$scope.generateCharter = function(){

					$scope.registrationBlock = true;
				}

				$scope.regFeePaid = function(){

					console.log("Fee paid");
					$scope.generateCharterButton = false;
					$scope.registrationBlock = false;


					var mbcParamsData = {authCode:res.responsePayload.authCode,
															 mbcId:$scope.incorporationId};

					console.log(mbcParamsData);

					IncorporationService.mbcData(mbcParamsData).then(function(response){
						if(response.status == "200"){
							if(response.data.responseCode == "200" && response.data.message == "MBC details"){
								$scope.mbcData = response.data.responsePayload;
								$scope.charterDataBlock = true;
							}
						}
					});

				$scope.ammendment = function(){

					$scope.charterDataBlock = false;
					$scope.editCharterDataBlock = true;
				}

		}
		}

})()
