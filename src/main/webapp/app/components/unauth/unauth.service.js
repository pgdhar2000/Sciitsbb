(function() {
  'use strict';

  angular.
  module('bbApp').
  service('LoginSvc', LoginSvc);

  function LoginSvc($http, $location, UrlService){
    this.loginUser = function(user){
      return $http.post(UrlService.loginUrl(),user).then(function(response) {
        console.log(response);
        return response
      }, function(response){
        $location.path("/internalError");
      })
    };

    this.countriesList = function(auth){
      return $http.get(UrlService.countriesListUrl(), {params: {"authCode":auth}}).then(function(response){
        return response;
      }, function(response){
        return response;
      })
    };

    this.addressType = function(auth){
      return $http.get(UrlService.addressTypeListUrl(), {params:{"authCode":auth}}).then(function(response){
        return response;
      }, function(response){
        return response;
      })
    };

    this.roleType = function(auth){
      return $http.get(UrlService.roleTypeListUrl(), {params:{"authCode":auth}}).then(function(response){
        return response;
      }, function(response){
        return response;
      })
    };

    this.raSignUp = function(signUpDetails){
      return $http.post(UrlService.signUpUrl(), signUpDetails).then(function(response){
        console.log("success ", response);
        return response;
      }, function(response){
        console.log("failure ", response);
        return response;
      })
    };
  }
})();
