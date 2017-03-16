// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("rocaMbcDetails",rocaMbcDetails);

		function rocaMbcDetails($scope,$state,$cookies,IncorporationService){

			// var res = $cookies.getObject('signInResult');

      $scope.acceptMbc = function(){
        console.log($scope.comment);
        IncorporationService.mbcData().then(function(response){
          console.log(response);
        })
        // $state.go('roca-mbc-success')
      }
      $scope.rejectMbc = function(){
        console.log($scope.comment);
        // call IncorporationService.mbcData
        // $state.go('roca-mbc-reject')
      }

      $scope.mbcDetails = {
        legalName: "Corporation name",
        totalShares: "2",
        addressDetails: {
          streetAddress: "sample street address",
          city: "city name"
        },
        countryName: "India",
        phone: 12344566,
        fax: 121324343,
        pocEmail: "sample@sam.com",
        website: "www.sample.com",
        businessDetails: "details",
        agentName: "Sample Name"
      }



		}
})()
