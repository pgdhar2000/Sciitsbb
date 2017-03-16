(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("raRegistrationController",raRegistrationController);

		function raRegistrationController($scope, LoginSvc){


      $scope.middleName;
      $scope.state;
      $scope.passMsgValid = false;

      $scope.raRegForm = true;
      $scope.raRegFormResult = false;

      $scope.passCheck = function(){
        if($scope.userDetails.password != $scope.confpass){
          $scope.passMsg = "Password not matched";
          $scope.passMsgValid = false;
        }else{
          $scope.passMsg = "";
          $scope.passMsgValid = true;
        }
      }
      $scope.userDetails = {};

      // $scope.userDetails = {"addressTypeTbl":{}};
      // $scope.userDetails = {"countryTbl":{}};
      console.log($scope.addrLine1);
      console.log($scope.addrLine2);

      $scope.userDetails.streetAddress;
      $scope.userDetails.userTbl = {"userId":1};

      var authCode = "sample";
      LoginSvc.countriesList(authCode).then(function(response){
        if(response.status == "200"){
          if(response.data.responseCode == "200" && response.data.message == "Countries"){
            $scope.countriesList = response.data.responsePayload;
          }
        }
      });

      LoginSvc.addressType(authCode).then(function(response){
        if(response.status == "200"){
          if(response.data.responseCode == "200" && response.data.message == "AddressTypeDetails"){
            $scope.addressTypeList = response.data.responsePayload;
          }
        }
      });

      LoginSvc.roleType(authCode).then(function(response){
        console.log("Roles list", response);
        if(response.status == "200"){
          if(response.data.responseCode == "200" && response.data.message == "Role Details"){
            $scope.roleTypeList = response.data.responsePayload;
          }
        }
      });

      $scope.saveData = function(){

        $scope.userDetails.streetAddress = $scope.addrLine1+" "+$scope.addrLine2;
        console.log($scope.userDetails);

        LoginSvc.raSignUp($scope.userDetails).then(function(response){
          if(response.status == "200"){
            $scope.raRegForm = false;
            $scope.raRegFormResult = true;
          }
        })
      };

      // $scope.addressTypeList = [
      //                           {
      //                             "addressTypeId": 1,
      //                             "addressTypeName": "Corporate",
      //                             "addressTypeDesc": "Corporate Headquarters"
      //                           },
      //                           {
      //                             "addressTypeId": 2,
      //                             "addressTypeName": "Registered",
      //                             "addressTypeDesc": "Registered address in BVI"
      //                           },
      //                           {
      //                             "addressTypeId": 3,
      //                             "addressTypeName": "Operational",
      //                             "addressTypeDesc": "Operational"
      //                           },
      //                           {
      //                             "addressTypeId": 4,
      //                             "addressTypeName": "Primary Business",
      //                             "addressTypeDesc": "Primary Place of Business"
      //                           },
      //                           {
      //                             "addressTypeId": 5,
      //                             "addressTypeName": "Records",
      //                             "addressTypeDesc": "Records"
      //                           },
      //                           {
      //                             "addressTypeId": 6,
      //                             "addressTypeName": "Residence",
      //                             "addressTypeDesc": "Residence"
      //                           }
      //                         ];

      // $scope.countriesList = [
      //                         {
      //                           "countryId": 1,
      //                           "countryCode": "AF",
      //                           "countryName": "Afghanistan"
      //                         },
      //                         {
      //                           "countryId": 2,
      //                           "countryCode": "AX",
      //                           "countryName": "Åland Islands"
      //                         },
      //                         {
      //                           "countryId": 3,
      //                           "countryCode": "AL",
      //                           "countryName": "Albania"
      //                         },
      //                         {
      //                           "countryId": 4,
      //                           "countryCode": "DZ",
      //                           "countryName": "Algeria"
      //                         },
      //                         {
      //                           "countryId": 5,
      //                           "countryCode": "AS",
      //                           "countryName": "American Samoa"
      //                         }
      //                       ];

    }
})()
