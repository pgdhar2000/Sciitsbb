// use the following syntax for all services
(function() {
    'use strict';

    angular.
    module('bbApp').
    service("UrlService", UrlService);

		function UrlService($location){
			/*this.baseUrl = $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/BlockBuster';*/

		this.baseUrl = 'http://182.74.133.92:8080/BlockBuster';
    
			this.signUpUrl = function(){

				return this.baseUrl + '/api/user/signup';
			}

			this.isUserExistUrl = function(){

				return this.baseUrl + '/api/user/isexist';
			}

			this.changePasswordUrl = function(){

				return this.baseUrl + '/api/user/changepassword';
			}

			this.resetPasswordUrl = function(){

				return this.baseUrl + '/api/user/resetpassword';
			}

			this.changeDefaultPasswordUrl = function(){

				return this.baseUrl + '/api/user/firsttimelogin/changepassword';
			}

			this.loginUrl = function(){

				return this.baseUrl + '/api/user/login';
			}

			this.listUsersUrl = function(){

				return this.baseUrl + '/api/user/getall';
			}

			this.activateUserUrl = function(){

				return this.baseUrl + '/api/user/activate';
			}

			this.deactivateUserUrl = function(){

				return this.baseUrl + '/api/user/delete';
			}

			this.userByIdUrl = function(){

				return this.baseUrl + '/api/user/get';
			}

			this.profileUpdateUrl = function(){

				return this.baseUrl + '/api/user/update';
			}

			this.secondaryAuthQuestionsListUrl = function(){

				return this.baseUrl + '/api/user/secondaryauthorizationdetails/quesitions/get';
			}

			this.secondaryAuthSaveUrl = function(){

				return this.baseUrl + '/api/user/usersecondaryauthorizationdetails/save';
			}

			this.secondaryAuthUpdateUrl = function(){

				return this.baseUrl + '/api/user/usersecondaryauthorizationdetails/update';
			}

			this.countriesListUrl = function(){

				return this.baseUrl + '/api/core/get/countries';
			}

			this.businessPurposeListUrl = function(){

				return this.baseUrl + '/api/incorporation/get/businesspurposes';
			}

			this.registeredAgentsListUrl = function(){

				return this.baseUrl + '/api/incorporation/get/registredagents';
			}

			this.incorporationUrl = function(){

				return this.baseUrl + '/api/incorporation/add';
			}

			this.incorporationsListUrl = function(){

				return this.baseUrl + '/api/incorporation/get/incorporations';
			}

			this.mbcDataUrl = function(){

				return this.baseUrl + '/api/incorporation/get';
			}

      this.addressTypeListUrl = function(){

				return this.baseUrl + '/api/core/get/addressTypeDetails';
			}

      this.roleTypeListUrl = function(){

        return this.baseUrl + '/api/core/get/roles';
      }

			this.logoutUrl = function(){

				return this.baseUrl + '/api/user/logout';
			}
		}

})()
