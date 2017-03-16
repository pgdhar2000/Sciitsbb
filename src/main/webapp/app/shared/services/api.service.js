(function() {
  'use strict';

  angular.
  module('bbApp').
  service('ApiService', ApiService);

  function ApiService($scope){
    $scope.justGetUsers = function(params){
      return $http.get()
    }
  }
})();
