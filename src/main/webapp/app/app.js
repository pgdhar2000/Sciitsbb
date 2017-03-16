var app = angular.module("bbApp",
["ui.router",
"ngCookies",
"ngStorage",
"ngMessages"
]);

app.service('userService',[function(){

	return {

		isLogged:false
	}
}]);
