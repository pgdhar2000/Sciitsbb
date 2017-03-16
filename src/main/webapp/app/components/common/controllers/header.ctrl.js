// use the following syntax for all controllers
(function() {
    'use strict';

    angular.
    module('bbApp').
    controller("headerController",headerController);

		function headerController($scope, $cookies, $location, UrlService, LogoutService){

			var res = $cookies.getObject('signInResult');

			$scope.firstName = res.responsePayload.firstName;
			$scope.middleName = res.responsePayload.middleName;
			$scope.lastName = res.responsePayload.lastName;

			/*console.log(res);*/

			/*$scope.roleId = res.responsePayload.roleId;
			$scope.defaultPassword = res.responsePayload.isDefaultPasswordChanged;

			if($scope.secondaryAuthorization == 1){

				$scope.secondaryAuthorization = 1;
			}else{

				$scope.secondaryAuthorization = res.responsePayload.isSecondaryAuthorizationSaved;
			}


			if($scope.secondaryAuthorization == 0){

				if($cookies.getObject('secondaryAuthorizationCompleted')){

					console.log("Entered after completing secondary Authorization");

					$scope.defaultPassword = 1;
					$scope.secondaryAuthorization = 1;
				}
			}

			console.log("defaultPassword: "+$scope.defaultPassword);
			console.log("secondaryAuthorization: "+$scope.secondaryAuthorization);*/

			/*header based on role start*/

			$scope.roleId = res.responsePayload.roleId;

			/*header based on role end*/

			/*current Url start*/
			var presentUrl = $location.path();
			$scope.currentUrl = presentUrl.substring(1,presentUrl.length+1);
			/*current Url end*/

			$scope.incorporationDD = false;
			$scope.sharesDD = false;
			$scope.mbcAdministrationDD = false;
			$scope.mbcManagementDD = false;
			$scope.transformBVIDD = false;
			$scope.registerInspectionDD = false;
			/*$scope.liquidationDD = false;*/
			$scope.strikingOffDD = false;

			$scope.rocaOrdersDD = false;
			$scope.rocaRegisterDD = false;
			$scope.rocaRegistrarDD = false;
			$scope.rocaStrikingOffDD = false;
			$scope.rocaLiquidatorDD = false;

			$scope.ipLiquidatorDD = false;

			$scope.superUserDD = false;
			$scope.superRegistrarDD = false;

			if(($location.path() == "/registered-agent-dashboard") || ($location.path() == "/incorporation") ||
			   ($location.path() == "/charter") || ($location.path() == "/mbc-names") ||
			   ($location.path() == "/capacity-powers") || ($location.path() == "/mbc-names-confirmation") ||
			   ($location.path() == "/confirmation") || ($location.path() == "/confirmation-charter") ||
			   ($location.path() == "/ra-register-details")){
				$scope.incorporationDD = true;
			}else if(($location.path() == "/shares") || ($location.path() == "/disposition-shares") ||
					 ($location.path() == "/distribution-of-shares") || ($location.path() == "/information-on-shareholders") ||
					 ($location.path() == "/distribution-shares-confirmation") ||
					 ($location.path() == "/mbc-disposition-shares-confirmation") || ($location.path() == "/mbc-shares-confirmation")){
				$scope.sharesDD = true;
			}else if(($location.path() == "/reg-off-admin") || ($location.path() == "/mbc-reg-off-admin-confirmation") ||
					 ($location.path() == "/ra-volun-liquid-offi-and-volun-liquidator") ||
					 ($location.path() == "/ra-offl-recer-off-and-off-recer")){
				$scope.mbcAdministrationDD = true;
			}else if($location.path() == "/ra-annual-returns"){
				$scope.mbcManagementDD = true;
			}else if(($location.path() == "/request-for-transformation") || ($location.path() == "/ra-filing-transf-bvi-company") ||
					 ($location.path() == "/ra-filing-transf-bvi-company-confirmation") ||
					 ($location.path() == "/ra-request-for-registration-bvi-company") ||
					 ($location.path() == "/ra-req-register-bvi-company-confirmation") ||
					 ($location.path() == "/ra-transformation-bvi-business-company") ||
					 ($location.path() == "/ra-officially-transform-confirmation")){
				$scope.transformBVIDD = true;
			}else if(($location.path() == "/ra-register-inspection") || ($location.path() == "/ra-issuance-of-certificates") ||
					 ($location.path() == "/register-inspection-confirmation")){
				$scope.registerInspectionDD = true;
			}else if(($location.path() == "/ra-restoration-strike-off-mbc") || ($location.path() == "/ra-restoration-success") ||
					 ($location.path() == "/ra-restoration-dissolved-mbc") || ($location.path() == "/ra-restoration-certificate") ||
					 ($location.path() == "/ra-restoration-certificate-success") ||
					 ($location.path() == "/ra-appeal-to-the-court") || ($location.path() == "/ra-appeal-to-the-court-success")){
				$scope.strikingOffDD = true;
			}else if(($location.path() == "/roca-dashboard")){
				$scope.rocaOrdersDD = true;
			}else if(($location.path() == "/roca-business-charter") || ($location.path() == "/roca-certificate-of-restoration") ||
					 ($location.path() == "/roca-certificate-of-dissolution") || ($location.path() == "/roca-certificate-of-restoration-of-dissolution") ||
					 ($location.path() == "/roca-certificate-of-good-standing") || ($location.path() == "/roca-certificate-of-mbc-status") ||
					 ($location.path() == "/roca-business-charter-details") || ($location.path() == "/roca-mbc-success") ||
					 ($location.path() == "/roca-mbc-reject") || ($location.path() == "/roca-bvi-registration") ||
					 ($location.path() == "/roca-bvi-transformation") || ($location.path() == "/roca-certificate-of-dissolution-details") ||
					 ($location.path() == "/roca-certificate-of-good-standing-details") || ($location.path() == "/roca-certificate-of-mbc-status-details") ||
					 ($location.path() == "/roca-certificate-of-restoration-details") || ($location.path() == "/roca-certificate-of-restoration-of-dissolution-details") ||
					 ($location.path() == "/roca-change-mbc-name") || ($location.path() == "/roca-mbc-name-change-confirmation") ||
					 ($location.path() == "/roca-mbc-details") || ($location.path() == "/roca-ra-details") ||
					 ($location.path() == "/roca-registration-ra-success") || ($location.path() == "/roca-registration-ra-reject") ||
					 ($location.path() == "/roca-register-details") || ($location.path() == "/roca-mbc-register-success") ||
					 ($location.path() == "/roca-mbc-register-reject") || ($location.path() == "/roca-ip-details") ||
					 ($location.path() == "/roca-mbc-insolveny-details") || ($location.path() == "/roca-filing-notice-of-mbc-insolvency-approved") ||
					 ($location.path() == "/roca-filing-notice-of-mbc-insolvency-rejected")){
				$scope.rocaRegisterDD = true;
			}else if(($location.path() == "/roca-registrar-list") || ($location.path() == "/roca-registrar-of-corporate-affairs-new") ||
					 ($location.path() == "/roca-registrar-success") || ($location.path() == "/roca-registrar-of-corporate-affairs-edit") ||
					 ($location.path() == "/roca-registrar-of-corporate-affairs-delete")){
				$scope.rocaRegistrarDD = true;
			}else if(($location.path() == "/roca-strike-off") || ($location.path() == "/roca-remove-strike-off") ||
					 ($location.path() == "/roca-strike-off-submitted") || ($location.path() == "/roca-remove-strike-off-submitted") ||
					 ($location.path() == "/roca-restoration-details") || ($location.path() == "/roca-restoration-success") ||
					 ($location.path() == "/roca-restoration-reject")){
				$scope.rocaStrikingOffDD = true;
			}else if(($location.path() == "/roca-voluntary-liquidator-approval") || ($location.path() == "/roca-completion-of-liquidation") ||
					 ($location.path() == "/roca-approval-of-court-resignation") || ($location.path() == "/roca-approval-of-liquidation-resignation") ||
					 ($location.path() == "/roca-completion-of-liquidation-reject-msg") || ($location.path() == "/roca-completion-of-liquidation-success-msg") ||
					 ($location.path() == "/roca-approval-of-liquidation-resignation") || ($location.path() == "/roca-voluntary-liquidator-approval-success") ||
					 ($location.path() == "/roca-voluntary-liquidator-approval-reject")){
				$scope.rocaLiquidatorDD = true;
			}else if(($location.path() == "/ip-liquidation") || ($location.path() == "/ip-voluntary-liquidator") ||
					 ($location.path() == "/ip-voluntary-liquidatory-approval") || ($location.path() == "/ip-declaration-of-solvency") ||
					 ($location.path() == "/ip-liq-completion-of-liquidation") || ($location.path() == "/ip-liq-application-of-resignation") ||
					 ($location.path() == "/ip-liq-filing-notice-of-resignation") || ($location.path() == "/ip-filing-notice-of-mbc-insolvency") ||
					 ($location.path() == "/ip-filing-notice-of-mbc-insolvency") || ($location.path() == "/ip-filing-notice-of-mbc-insolvency-sucess") ||
					 ($location.path() == "/ip-liq-application-of-resignation") || ($location.path() == "/ip-liq-application-of-resignation-success") ||
					 ($location.path() == "/ip-liq-completion-of-liquidation-paid") || ($location.path() == "/ip-liquidation-confirmation") ||
					 ($location.path() == "/ip-liq-court-removal") || ($location.path() == "/ip-voluntary-liquidatory-approval-confirmation") ||
					 ($location.path() == "/ip-dashboard")){
				$scope.ipLiquidatorDD = true;
			}else if(($location.path() == "/super-user") || ($location.path() == "/user-enable-status") ||
					 ($location.path() == "/user-disable-status")){
				$scope.superUserDD = true;
			}else if(($location.path() == "/super-registrar-list") || ($location.path() == "/super-registrar-of-corporate-affairs-new") ||
					 ($location.path() == "/super-registrar-success") || ($location.path() == "/super-registrar-of-corporate-affairs-edit") ||
					 ($location.path() == "/super-registrar-of-corporate-affairs-delete")){
				$scope.superRegistrarDD = true;
			}

			$scope.logout = function(){

				var urlValue = UrlService.logoutUrl();

				LogoutService.userLogout(res, urlValue);
			}
		}

})()
