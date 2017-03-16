// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("unauthHeaderController",unauthHeaderController);

    function unauthHeaderController($scope, $location){
      $scope.sampleVariable = 'hi';
    }
})()
