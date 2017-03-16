// use the following syntax for all directives
(function() {
    'use strict';

    angular.
    module('bbApp').
    directive("loading",loading);

    function loading(){
        return {
            restrict: 'E',
            replace:true,
            template: '<div class="loading"><img src="img/loader.gif"/></div>',
            link: function (scope, element, attr) {
                  scope.$watch('loading', function (val) {
                      if (val)
                          $(element).show();
                      else
                          $(element).hide();
                  });
            }
          };
    }

})()
