(function() {
  'use strict';

  angular.
  module('bbApp').
  service('IncorporationService', IncorporationService);

  function IncorporationService($http, UrlService){
    this.countriesNamesList = function(auth){
      return $http.get(UrlService.countriesListUrl(), {params: {"authCode":auth}}).then(function(response){
        return response;
      }, function(response){
        return response
      })
    };

    this.businessList = function(auth){
      return $http.get(UrlService.businessPurposeListUrl(),{params: {"authCode":auth}}).then(function(response){
        return response
      }, function(response){
        return response
      })
    };

    this.registeredAgentsList = function(auth){
      return $http.get(UrlService.registeredAgentsListUrl(),{params: {"authCode":auth}}).then(function(response){
        return response
      }, function(response){
        return response
      })
    }

    this.submitIncoporation = function(incData, parametersData){
      console.log("parameters: "+parametersData);
      return $http.post(UrlService.incorporationUrl(), incData, {params:parametersData}).then(function(response){
        console.log(response);
        return response;
      }, function(response){
        console.log(response);
        return response;
      })
    };

    this.incorporationsList = function(auth){
      return $http.get(UrlService.incorporationsListUrl(), {params: {"authCode":auth}}).then(function(response){
        return response
      }, function(response){
        return response
      })
    };

    this.mbcData = function(data){
      console.log("data in svc", data);
      return $http({
        method: 'POST',
        url: UrlService.mbcDataUrl(),
        params: data
      }).then(function(response){
        console.log("success: ", response);
        return response;
      }, function(response){
        console.log("failure: ", response);
        return response;
      })
    };
  }
})();
