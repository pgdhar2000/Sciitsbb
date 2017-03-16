// use the following syntax for all services
(function() {
  'use strict';

  angular.
  module('bbApp').
  service("LogoutService", LogoutService);

  function LogoutService($http, $cookies, $location, SuccessStatusService){

    this.userLogout = function(res, urlValue){

      // /*console.log(res.responsePayload.authCode);*/
      //
      // var logoutDetails = new FormData();
      //
      // logoutDetails.append('authCode', res.responsePayload.authCode);
      //
      // var url = urlValue;
      //
      // $http.post(url, logoutDetails, {
      //   withCredentials : false,
      //   headers : {
      //     'Content-Type' : undefined
      //   },
      //   transformRequest : angular.identity
      // })
      // .success(function(data){
      //
      //   console.log(data);
      //   if(data.responseCode == 200){
      //
      //     console.log($cookies.getObject('signInResult'));
      //     $cookies.remove('signInResult');
      //     $cookies.remove('userId');
      //     $cookies.remove('secondaryAuthorizationCompleted');
      //     console.log($cookies.getObject('signInResult'));
      //     console.log($cookies.getObject('userId'));
      //     console.log($cookies.getObject('secondaryAuthorizationCompleted'));
      //
      //     $cookies.putObject('signOutResult',true);
      //
      //     if(!SuccessStatusService.getSessionExpireStatus()){
      //
      //       SuccessStatusService.setUserLogoutStatus(true);
      //     }
      //
      //     if(res.responsePayload.roleId == 2){
      //       $location.path("/ra-login");
      //     }else if(res.responsePayload.roleId == 3){
      //       $location.path("/roca-login");
      //     }else if(res.responsePayload.roleId == 4){
      //       $location.path("/ip-login");
      //     }else if(res.responsePayload.roleId == 1){
      //       $location.path("/super-login");
      //     }
      //   }
      //
      // }).error(function(data){
      //
      //   console.log(data);
      // });

      // changes made because logout api is not there start

        $cookies.remove('signInResult');

        $cookies.putObject('signOutResult',true);

        if(!SuccessStatusService.getSessionExpireStatus()){

              SuccessStatusService.setUserLogoutStatus(true);
          }

          if(res.responsePayload.roleId == 3){
              $location.path("/ra-login");
            }else if(res.responsePayload.roleId == 2){
              $location.path("/roca-login");
            }else if(res.responsePayload.roleId == 5){
              $location.path("/ip-login");
            }else if(res.responsePayload.roleId == 6){
              $location.path("/super-login");
            }

      // changes made because logout api is not there end
    }


  }

})()
