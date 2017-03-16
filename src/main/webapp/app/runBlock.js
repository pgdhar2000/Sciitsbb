angular.
module('bbApp').
run(function ($cookies, $rootScope, $state, $localStorage, $location, $window,
  $timeout, $interval, userService, UrlService, LogoutService, SuccessStatusService) {

    $rootScope.$on("$stateChangeStart", function (event, toState, toParams, fromState, fromParams) {

      var value = $cookies.get('signInResult');

      if (value != undefined)
      userService.isLogged = value;
      if (toState.authenticate && !userService.isLogged) {
        // User isnâ€™t authenticated
        $state.transitionTo("search");
        event.preventDefault();
      }

    });

    var idleTime = 0;
    var stopLooping;

    $rootScope.mouseMoving = function(){

      idleTime = 0;
    }

    $rootScope.keyPressed = function(){

      idleTime = 0;
    }

    $(document).keypress(function(e){

      idleTime = 0;
    });

    stopLooping = $interval(function(){

      idleTime = idleTime + 1;

      console.log(idleTime);
      /* Session will be expired if the page is not an unauth page*/
      if ((idleTime == 15) && ($location.path() != "/search") && ($location.path() != "/ra-login") &&
      ($location.path() != "/roca-login") && ($location.path() != "/ip-login") &&
      ($location.path() != "/super-login")&& ($location.path() != "/ra-registration") &&
      ($location.path() != "/ip-registration")) { // 15 minutes

        //$state.go('logout');

        console.log("session time out logout");

        $timeout(function(){

          var urlValue = UrlService.logoutUrl();

          var res = $cookies.getObject('signInResult');

          //console.log($cookies.getObject('signInResult'));

          //console.log(res);

          SuccessStatusService.setSessionExpireStatus(true);

          LogoutService.userLogout(res, urlValue);

        },750);  // 50*15 = 750

      }

    },59950);  //59950 - considered as 1 minute, remaining 50 is covered in closing the modal
  });
