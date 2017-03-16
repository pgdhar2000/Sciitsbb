(function() {
  'use strict';

  angular.
  module('bbApp').
  service('GlobalService', GlobalService);

  function GlobalService($scope){
    $scope.justGetUsers = function(params){
      return $http.get()
    }
  }
})();
