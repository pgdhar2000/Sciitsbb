// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("incorporationController",incorporationController);

    function incorporationController($scope, $state, $cookies, $location, $http, UrlService, IncorporationService){

	var res = $cookies.getObject('signInResult');
  var auth = "sample";
  var userDetails = res.responsePayload;
  console.log(userDetails)

  $scope.mbcDetails = {};
	IncorporationService.countriesNamesList(auth).then(function(response){
		if(response.data.responseCode == "200" && response.data.message == "Countries"){
			console.log("countries", response)
			$scope.countries = response.data.responsePayload;
		}
	});

	IncorporationService.businessList(auth).then(function(response){
		if(response.status == "200"){
			if(response.data.responseCode == "200" && response.data.message == "Business Purposes"){
        console.log("business purpose", response);
				$scope.businessPurpose = response.data.responsePayload;
			}
		}
	});

	IncorporationService.registeredAgentsList(auth).then(function(response){
		if(response.status == "200"){
			if(response.data.responseCode == "200" && response.data.message == "Registred Agents Details"){
				$scope.registeredAgents = response.data.responsePayload;
			}
		}
	});

	$scope.changingRegisterAgentDetails = function(details){
		$scope.registerAgentName = details.registeredAgentName;
	};

	$scope.submit = function(){

   //TODO: change later
  $scope.mbcDetails.addressDetailsTbl.userTbl.userId = 2;
  $scope.mbcDetails.userTblByRegisteredAgentId.userId = 3;
  $scope.mbcDetails.businessPurposeTbl.businessPurposeId = 4;
  $scope.mbcDetails.addressDetailsTbl.userTbl.userId = 5;

  $scope.mbcDetails.applicationFeeAmt = 100;
  console.log($scope.mbcDetails);

  var paramsData = {authCode:res.responsePayload.authCode};

		IncorporationService.submitIncoporation($scope.mbcDetails, paramsData).then(function(response){
			console.log(response);
			if(response.status == "200"){
				if(response.data.responseCode == "200"){
					$state.go("confirmation")
				}else {
  				$state.go('internalError')
  			}
			}else {
				$state.go('internalError')
			}
		});
	}
}

})()
