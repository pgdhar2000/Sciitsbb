angular.
module('bbApp').
config(function($urlRouterProvider, $stateProvider, $locationProvider){

// $locationProvider.html5Mode(true);
$urlRouterProvider.otherwise("/search");

$stateProvider

		.state("search",{

		url:"/search",
		templateUrl:"app/components/unauth/templates/search.html"})

		.state("ra-login",{

		url:"/ra-login",
		templateUrl:"app/components/unauth/templates/ra-login.html",
		controller:"raLoginController"})

		.state("roca-login",{

		url:"/roca-login",
		templateUrl:"app/components/unauth/templates/roca-login.html",
		controller:"rocaLoginController"})

		.state("ip-login",{

		url:"/ip-login",
		templateUrl:"app/components/unauth/templates/ip-login.html",
		controller:"ipLoginController"})

		.state("super-login",{

		url:"/super-login",
		templateUrl:"app/components/unauth/templates/super-login.html",
		controller:"superLoginController"})

		.state("registered-agent-dashboard",{

		url:"/registered-agent-dashboard",
		templateUrl:"app/components/dashboards/templates/registered-agent-dashboard.html",
		controller:"registeredAgentDashboardController",
		authenticate:true})

		.state("incorporation",{

		url:"/incorporation",
		templateUrl:"app/components/incorporation/templates/incorporation.html",
		controller:"incorporationController",
		authenticate:true})

		.state("confirmation",{

		url:"/confirmation",
		templateUrl:"app/components/incorporation/templates/confirmation.html",
		controller:"confirmationController",
		authenticate:true})

		.state("charter",{

		url:"/charter",
		templateUrl:"app/components/incorporation/templates/charter.html",
		controller:"charterController",
		authenticate:true})

		.state("confirmation-charter",{

		url:"/confirmation-charter",
		templateUrl:"app/components/incorporation/templates/confirmation-charter.html",
		authenticate:true})

		.state("mbc-names",{

		url:"/mbc-names",
		templateUrl:"app/components/incorporation/templates/mbc-names.html",
		authenticate:true})

		.state("mbc-names-confirmation",{

		url:"/mbc-names-confirmation",
		templateUrl:"app/components/incorporation/templates/mbc-names-confirmation.html",
		authenticate:true})

		.state("capacity-powers",{

		url:"/capacity-powers",
		templateUrl:"app/components/incorporation/templates/capacity-powers.html",
		controller:"capacityPowersController",
		authenticate:true})

		.state("shares",{

		url:"/shares",
		templateUrl:"app/components/shares/templates/shares.html",
		authenticate:true})

		.state("mbc-shares-confirmation",{

		url:"/mbc-shares-confirmation",
		templateUrl:"app/components/shares/templates/mbc-shares-confirmation.html",
		authenticate:true})

		.state("disposition-shares",{

		url:"/disposition-shares",
		templateUrl:"app/components/shares/templates/disposition-shares.html",
		authenticate:true})

		.state("mbc-disposition-shares-confirmation",{

		url:"/mbc-disposition-shares-confirmation",
		templateUrl:"app/components/shares/templates/mbc-disposition-shares-confirmation.html",
		authenticate:true})

		.state("distribution-of-shares",{

		url:"/distribution-of-shares",
		templateUrl:"app/components/shares/templates/distribution-of-shares.html",
		authenticate:true})

		.state("distribution-shares-confirmation",{

		url:"/distribution-shares-confirmation",
		templateUrl:"app/components/shares/templates/distribution-shares-confirmation.html",
		authenticate:true})

		.state("information-on-shareholders",{

		url:"/information-on-shareholders",
		templateUrl:"app/components/shares/templates/information-on-shareholders.html",
		authenticate:true})

		.state("reg-off-admin",{

		url:"/reg-off-admin",
		templateUrl:"app/components/mbcadministration/templates/reg-off-admin.html",
		authenticate:true})

		.state("mbc-reg-off-admin-confirmation",{

		url:"/mbc-reg-off-admin-confirmation",
		templateUrl:"app/components/mbcadministration/templates/mbc-reg-off-admin-confirmation.html",
		authenticate:true})

		.state("ra-annual-returns",{

		url:"/ra-annual-returns",
		templateUrl:"app/components/mbcmanagement/templates/ra-annual-returns.html",
		authenticate:true})

		.state("request-for-transformation",{

		url:"/request-for-transformation",
		templateUrl:"app/components/transformation/templates/request-for-transformation.html",
		authenticate:true})

		.state("ra-register-inspection",{

		url:"/ra-register-inspection",
		templateUrl:"app/components/certificates/templates/ra-register-inspection.html",
		authenticate:true})

		.state("ra-issuance-of-certificates",{

		url:"/ra-issuance-of-certificates",
		templateUrl:"app/components/certificates/templates/ra-issuance-of-certificates.html",
		authenticate:true})

		.state("ra-filing-transf-bvi-company",{

		url:"/ra-filing-transf-bvi-company",
		templateUrl:"app/components/transformation/templates/ra-filing-transf-bvi-company.html",
		authenticate:true})

		.state("ra-filing-transf-bvi-company-confirmation",{

		url:"/ra-filing-transf-bvi-company-confirmation",
		templateUrl:"app/components/transformation/templates/ra-filing-transf-bvi-company-confirmation.html",
		authenticate:true})

		.state("ra-request-for-registration-bvi-company",{

		url:"/ra-request-for-registration-bvi-company",
		templateUrl:"app/components/transformation/templates/ra-request-for-registration-bvi-company.html",
		authenticate:true})

		.state("ra-req-register-bvi-company-confirmation",{

		url:"/ra-req-register-bvi-company-confirmation",
		templateUrl:"app/components/transformation/templates/ra-req-register-bvi-company-confirmation.html",
		authenticate:true})

		.state("ra-transformation-bvi-business-company",{

		url:"/ra-transformation-bvi-business-company",
		templateUrl:"app/components/transformation/templates/ra-transformation-bvi-business-company.html",
		authenticate:true})

		.state("ra-officially-transform-confirmation",{

		url:"/ra-officially-transform-confirmation",
		templateUrl:"app/components/transformation/templates/ra-officially-transform-confirmation.html",
		authenticate:true})

		.state("ra-register-details",{

		url:"/ra-register-details",
		templateUrl:"app/components/incorporation/templates/ra-register-details.html",
		authenticate:true})

		.state("register-inspection-confirmation",{

		url:"/register-inspection-confirmation",
		templateUrl:"app/components/certificates/templates/register-inspection-confirmation.html",
		authenticate:true})

		.state("ra-volun-liquid-offi-and-volun-liquidator",{

		url:"/ra-volun-liquid-offi-and-volun-liquidator",
		templateUrl:"app/components/mbcadministration/templates/ra-volun-liquid-offi-and-volun-liquidator.html",
		authenticate:true})

		.state("ra-offl-recer-off-and-off-recer",{

		url:"/ra-offl-recer-off-and-off-recer",
		templateUrl:"app/components/mbcadministration/templates/ra-offl-recer-off-and-off-recer.html",
		authenticate:true})

		.state("ra-restoration-strike-off-mbc",{

		url:"/ra-restoration-strike-off-mbc",
		templateUrl:"app/components/restoration/templates/ra-restoration-strike-off-mbc.html",
		authenticate:true})

		.state("ra-restoration-success",{

		url:"/ra-restoration-success",
		templateUrl:"app/components/restoration/templates/ra-restoration-success.html",
		authenticate:true})

		.state("ra-restoration-certificate",{

		url:"/ra-restoration-certificate",
		templateUrl:"app/components/restoration/templates/ra-restoration-certificate.html",
		authenticate:true})

		.state("ra-restoration-certificate-success",{

		url:"/ra-restoration-certificate-success",
		templateUrl:"app/components/restoration/templates/ra-restoration-certificate-success.html",
		authenticate:true})

		.state("ra-restoration-dissolved-mbc",{

		url:"/ra-restoration-dissolved-mbc",
		templateUrl:"app/components/restoration/templates/ra-restoration-dissolved-mbc.html",
		authenticate:true})

		.state("ra-appeal-to-the-court",{

		url:"/ra-appeal-to-the-court",
		templateUrl:"app/components/restoration/templates/ra-appeal-to-the-court.html",
		authenticate:true})

		.state("ra-appeal-to-the-court-success",{

		url:"/ra-appeal-to-the-court-success",
		templateUrl:"app/components/restoration/templates/ra-appeal-to-the-court-success.html",
		authenticate:true})

		.state("roca-dashboard",{

		url:"/roca-dashboard",
		templateUrl:"app/components/dashboards/templates/roca-dashboard.html",
		controller:"rocaDashboardController",
		authenticate:true})

		.state("roca-business-charter",{

		url:"/roca-business-charter",
		templateUrl:"app/components/certificates/templates/roca-business-charter.html",
		authenticate:true})

		.state("roca-business-charter-details",{

		url:"/roca-business-charter-details",
		templateUrl:"app/components/certificates/templates/roca-business-charter-details.html",
		authenticate:true})

		.state("roca-mbc-success",{

		url:"/roca-mbc-success",
		templateUrl:"app/components/incorporation/templates/roca-mbc-success.html",
		authenticate:true})

		.state("roca-mbc-reject",{

		url:"/roca-mbc-reject",
		templateUrl:"app/components/incorporation/templates/roca-mbc-reject.html",
		authenticate:true})

		.state("roca-bvi-registration",{

		url:"/roca-bvi-registration",
		templateUrl:"app/components/certificates/templates/roca-bvi-registration.html",
		authenticate:true})

		.state("roca-bvi-transformation",{

		url:"/roca-bvi-transformation",
		templateUrl:"app/components/certificates/templates/roca-bvi-transformation.html",
		authenticate:true})

		.state("roca-certificate-of-restoration",{

		url:"/roca-certificate-of-restoration",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-restoration.html",
		authenticate:true})

		.state("roca-certificate-of-restoration-details",{

		url:"/roca-certificate-of-restoration-details",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-restoration-details.html",
		authenticate:true})


		.state("roca-certificate-of-dissolution",{

		url:"/roca-certificate-of-dissolution",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-dissolution.html",
		authenticate:true})

		.state("roca-certificate-of-dissolution-details",{

		url:"/roca-certificate-of-dissolution-details",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-dissolution-details.html",
		authenticate:true})

		.state("roca-certificate-of-restoration-of-dissolution",{

		url:"/roca-certificate-of-restoration-of-dissolution",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-restoration-of-dissolution.html",
		authenticate:true})

		.state("roca-certificate-of-restoration-of-dissolution-details",{

		url:"/roca-certificate-of-restoration-of-dissolution-details",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-restoration-of-dissolution-details.html",
		authenticate:true})

		.state("roca-certificate-of-good-standing",{

		url:"/roca-certificate-of-good-standing",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-good-standing.html",
		authenticate:true})

		.state("roca-certificate-of-good-standing-details",{

		url:"/roca-certificate-of-good-standing-details",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-good-standing-details.html",
		authenticate:true})

		.state("roca-certificate-of-mbc-status",{

		url:"/roca-certificate-of-mbc-status",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-mbc-status.html",
		authenticate:true})

		.state("roca-certificate-of-mbc-status-details",{

		url:"/roca-certificate-of-mbc-status-details",
		templateUrl:"app/components/certificates/templates/roca-certificate-of-mbc-status-details.html",
		authenticate:true})

		.state("roca-register-details",{

		url:"/roca-register-details",
		templateUrl:"app/components/certificates/templates/roca-register-details.html",
		authenticate:true})

		.state("roca-mbc-register-success",{

		url:"/roca-mbc-register-success",
		templateUrl:"app/components/certificates/templates/roca-mbc-register-success.html",
		authenticate:true})

		.state("roca-mbc-register-reject",{

		url:"/roca-mbc-register-reject",
		templateUrl:"app/components/certificates/templates/roca-mbc-register-reject.html",
		authenticate:true})

		.state("roca-registrar-list",{

		url:"/roca-registrar-list",
		templateUrl:"app/components/registrarmanagement/templates/roca-registrar-list.html",
		authenticate:true})

		.state("roca-registrar-of-corporate-affairs-new",{

		url:"/roca-registrar-of-corporate-affairs-new",
		templateUrl:"app/components/registrarmanagement/templates/roca-registrar-of-corporate-affairs-new.html",
		authenticate:true})

		.state("roca-registrar-success",{

		url:"/roca-registrar-success",
		templateUrl:"app/components/registrarmanagement/templates/roca-registrar-success.html",
		authenticate:true})

		.state("roca-registrar-of-corporate-affairs-edit",{

		url:"/roca-registrar-of-corporate-affairs-edit",
		templateUrl:"app/components/registrarmanagement/templates/roca-registrar-of-corporate-affairs-edit.html",
		authenticate:true})

		.state("roca-registrar-of-corporate-affairs-delete",{

		url:"/roca-registrar-of-corporate-affairs-delete",
		templateUrl:"app/components/registrarmanagement/templates/roca-registrar-of-corporate-affairs-delete.html",
		authenticate:true})

		.state("roca-strike-off",{

		url:"/roca-strike-off",
		templateUrl:"app/components/restoration/templates/roca-strike-off.html",
		authenticate:true})

		.state("roca-strike-off-submitted",{

		url:"/roca-strike-off-submitted",
		templateUrl:"app/components/restoration/templates/roca-strike-off-submitted.html",
		authenticate:true})

		.state("roca-remove-strike-off",{

		url:"/roca-remove-strike-off",
		templateUrl:"app/components/restoration/templates/roca-remove-strike-off.html",
		authenticate:true})

		.state("roca-remove-strike-off-submitted",{

		url:"/roca-remove-strike-off-submitted",
		templateUrl:"app/components/restoration/templates/roca-remove-strike-off-submitted.html",
		authenticate:true})

		.state("roca-restoration-details",{

		url:"/roca-restoration-details",
		templateUrl:"app/components/restoration/templates/roca-restoration-details.html",
		authenticate:true})

		.state("roca-restoration-success",{

		url:"/roca-restoration-success",
		templateUrl:"app/components/restoration/templates/roca-restoration-success.html",
		authenticate:true})

		.state("roca-restoration-reject",{

		url:"/roca-restoration-reject",
		templateUrl:"app/components/restoration/templates/roca-restoration-reject.html",
		authenticate:true})

		.state("roca-voluntary-liquidator-approval",{

		url:"/roca-voluntary-liquidator-approval",
		templateUrl:"app/components/liquidation/templates/roca-voluntary-liquidator-approval.html",
		authenticate:true})

		.state("roca-voluntary-liquidator-approval-success",{

		url:"/roca-voluntary-liquidator-approval-success",
		templateUrl:"app/components/liquidation/templates/roca-voluntary-liquidator-approval-success.html",
		authenticate:true})

		.state("roca-voluntary-liquidator-approval-reject",{

		url:"/roca-voluntary-liquidator-approval-reject",
		templateUrl:"app/components/liquidation/templates/roca-voluntary-liquidator-approval-reject.html",
		authenticate:true})

		.state("roca-completion-of-liquidation",{

		url:"/roca-completion-of-liquidation",
		templateUrl:"app/components/liquidation/templates/roca-completion-of-liquidation.html",
		authenticate:true})

		.state("roca-approval-of-court-resignation",{

		url:"/roca-approval-of-court-resignation",
		templateUrl:"app/components/liquidation/templates/roca-approval-of-court-resignation.html",
		authenticate:true})

		.state("roca-approval-of-liquidation-resignation",{

		url:"/roca-approval-of-liquidation-resignation",
		templateUrl:"app/components/liquidation/templates/roca-approval-of-liquidation-resignation.html",
		authenticate:true})

		.state("roca-completion-of-liquidation-success-msg",{

		url:"/roca-completion-of-liquidation-success-msg",
		templateUrl:"app/components/liquidation/templates/roca-completion-of-liquidation-success-msg.html",
		authenticate:true})

		.state("roca-completion-of-liquidation-reject-msg",{

		url:"/roca-completion-of-liquidation-reject-msg",
		templateUrl:"app/components/liquidation/templates/roca-completion-of-liquidation-reject-msg.html",
		authenticate:true})

		.state("roca-change-mbc-name",{

		url:"/roca-change-mbc-name",
		templateUrl:"app/components/certificates/templates/roca-change-mbc-name.html",
		authenticate:true})

		.state("roca-mbc-name-change-confirmation",{

		url:"/roca-mbc-name-change-confirmation",
		templateUrl:"app/components/certificates/templates/roca-mbc-name-change-confirmation.html",
		authenticate:true})

		.state("roca-mbc-details",{

		url:"/roca-mbc-details",
		templateUrl:"app/components/incorporation/templates/roca-mbc-details.html",
		controller: "rocaMbcDetails",
		authenticate:true})

		.state("roca-ra-details",{

		url:"/roca-ra-details",
		templateUrl:"app/components/certificates/templates/roca-ra-details.html",
		authenticate:true})

		.state("roca-registration-ra-success",{

		url:"/roca-registration-ra-success",
		templateUrl:"app/components/certificates/templates/roca-registration-ra-success.html",
		authenticate:true})

		.state("roca-registration-ra-reject",{

		url:"/roca-registration-ra-reject",
		templateUrl:"app/components/certificates/templates/roca-registration-ra-reject.html",
		authenticate:true})

		.state("roca-ip-details",{

		url:"/roca-ip-details",
		templateUrl:"app/components/certificates/templates/roca-ip-details.html",
		authenticate:true})

		.state("roca-mbc-insolveny-details",{

		url:"/roca-mbc-insolveny-details",
		templateUrl:"app/components/certificates/templates/roca-mbc-insolveny-details.html",
		authenticate:true})

		.state("roca-filing-notice-of-mbc-insolvency-approved",{

		url:"/roca-filing-notice-of-mbc-insolvency-approved",
		templateUrl:"app/components/certificates/templates/roca-filing-notice-of-mbc-insolvency-approved.html",
		authenticate:true})

		.state("roca-filing-notice-of-mbc-insolvency-rejected",{

		url:"/roca-filing-notice-of-mbc-insolvency-rejected",
		templateUrl:"app/components/certificates/templates/roca-filing-notice-of-mbc-insolvency-rejected.html",
		authenticate:true})

		.state("ip-dashboard",{

		url:"/ip-dashboard",
		templateUrl:"app/components/dashboards/templates/ip-dashboard.html",
		controller:"ipDashboardController",
		authenticate:true})

		.state("ip-declaration-of-solvency",{

		url:"/ip-declaration-of-solvency",
		templateUrl:"app/components/liquidation/templates/ip-declaration-of-solvency.html",
		authenticate:true})

		.state("ip-filing-notice-of-mbc-insolvency",{

		url:"/ip-filing-notice-of-mbc-insolvency",
		templateUrl:"app/components/liquidation/templates/ip-filing-notice-of-mbc-insolvency.html",
		authenticate:true})

		.state("ip-filing-notice-of-mbc-insolvency-sucess",{

		url:"/ip-filing-notice-of-mbc-insolvency-sucess",
		templateUrl:"app/components/liquidation/templates/ip-filing-notice-of-mbc-insolvency-sucess.html",
		authenticate:true})

		.state("ip-liq-application-of-resignation",{

		url:"/ip-liq-application-of-resignation",
		templateUrl:"app/components/liquidation/templates/ip-liq-application-of-resignation.html",
		authenticate:true})

		.state("ip-liq-application-of-resignation-success",{

		url:"/ip-liq-application-of-resignation-success",
		templateUrl:"app/components/liquidation/templates/ip-liq-application-of-resignation-success.html",
		authenticate:true})

		.state("ip-liq-completion-of-liquidation",{

		url:"/ip-liq-completion-of-liquidation",
		templateUrl:"app/components/liquidation/templates/ip-liq-completion-of-liquidation.html",
		authenticate:true})

		.state("ip-liq-completion-of-liquidation-paid",{

		url:"/ip-liq-completion-of-liquidation-paid",
		templateUrl:"app/components/liquidation/templates/ip-liq-completion-of-liquidation-paid.html",
		authenticate:true})

		.state("ip-liquidation",{

		url:"/ip-liquidation",
		templateUrl:"app/components/liquidation/templates/ip-liquidation.html",
		authenticate:true})

		.state("ip-voluntary-liquidator",{

		url:"/ip-voluntary-liquidator",
		templateUrl:"app/components/liquidation/templates/ip-voluntary-liquidator.html",
		authenticate:true})

		.state("ip-liquidation-confirmation",{

		url:"/ip-liquidation-confirmation",
		templateUrl:"app/components/liquidation/templates/ip-liquidation-confirmation.html",
		authenticate:true})

		.state("ip-liq-court-removal",{

		url:"/ip-liq-court-removal",
		templateUrl:"app/components/liquidation/templates/ip-liq-court-removal.html",
		authenticate:true})

		.state("ip-liq-filing-notice-of-resignation",{

		url:"/ip-liq-filing-notice-of-resignation",
		templateUrl:"app/components/liquidation/templates/ip-liq-filing-notice-of-resignation.html",
		authenticate:true})

		.state("ip-voluntary-liquidatory-approval",{

		url:"/ip-voluntary-liquidatory-approval",
		templateUrl:"app/components/liquidation/templates/ip-voluntary-liquidatory-approval.html",
		authenticate:true})

		.state("ip-voluntary-liquidatory-approval-confirmation",{

		url:"/ip-voluntary-liquidatory-approval-confirmation",
		templateUrl:"app/components/liquidation/templates/ip-voluntary-liquidatory-approval-confirmation.html",
		authenticate:true})

		.state("super-user",{

		url:"/super-user",
		templateUrl:"app/components/usermanagement/templates/super-user.html",
		controller:"superUserController",
		authenticate:true})

		.state("user-enable-status",{

		url:"/user-enable-status",
		templateUrl:"app/components/usermanagement/templates/user-enable-status.html",
		authenticate:true})

		.state("user-disable-status",{

		url:"/user-disable-status",
		templateUrl:"app/components/usermanagement/templates/user-disable-status.html",
		authenticate:true})

		.state("super-registrar-list",{

		url:"/super-registrar-list",
		templateUrl:"app/components/registrarmanagement/templates/super-registrar-list.html",
		authenticate:true})

		.state("super-registrar-of-corporate-affairs-new",{

		url:"/super-registrar-of-corporate-affairs-new",
		templateUrl:"app/components/registrarmanagement/templates/super-registrar-of-corporate-affairs-new.html",
		authenticate:true})

		.state("super-registrar-success",{

		url:"/super-registrar-success",
		templateUrl:"app/components/registrarmanagement/templates/super-registrar-success.html",
		authenticate:true})

		.state("super-registrar-of-corporate-affairs-edit",{

		url:"/super-registrar-of-corporate-affairs-edit",
		templateUrl:"app/components/registrarmanagement/templates/super-registrar-of-corporate-affairs-edit.html",
		authenticate:true})

		.state("super-registrar-of-corporate-affairs-delete",{

		url:"/super-registrar-of-corporate-affairs-delete",
		templateUrl:"app/components/registrarmanagement/templates/super-registrar-of-corporate-affairs-delete.html",
		authenticate:true})

		.state("ra-registration",{
		url:"/ra-registration",
		templateUrl:"app/components/unauth/templates/ra-registration.html",
		controller:"raRegistrationController"})


		.state("ip-registration",{

		url:"/ip-registration",
		templateUrl:"app/components/unauth/templates/ip-registration.html"})

		.state("listUsers",{

		url:"/listUsers",
		templateUrl:"app/components/usermanagement/templates/list-users.html",
		controller:"listUsersController",
		authenticate:true})

		.state("editProfile",{

		url:"/editProfile",
		templateUrl:"app/components/usermanagement/templates/edit-profile.html",
		authenticate:true})

		.state("editUser",{

		url:"/editUser",
		templateUrl:"app/components/usermanagement/templates/edit-user.html",
		controller:"editUserController",
		authenticate:true})

		.state("changePassword",{

		url:"/changePassword",
		templateUrl:"app/components/usermanagement/templates/change-password.html",
		controller:"changePasswordController",
		authenticate:true})

		.state("internalError",{

		url:"/internalError",
		templateUrl:"app/components/common/templates/internal-error.html",
		controller:"internalErrorController",
		authenticate:true})

		.state("changeDefaultPassword",{

		url:"/changeDefaultPassword",
		templateUrl:"app/components/usermanagement/templates/change-default-password.html",
		controller:"changeDefaultPasswordController",
		authenticate:true})

		.state("secondaryAuthorization",{

		url:"/secondaryAuthorization",
		templateUrl:"app/components/usermanagement/templates/secondary-authorization.html",
		controller:"secondaryAuthorizationController",
		authenticate:true})

		.state("updateSecondaryAuthorization",{

		url:"/updateSecondaryAuthorization",
		templateUrl:"app/components/usermanagement/templates/update-secondary-authorization.html",
		controller:"updateSecondaryAuthorizationController",
		authenticate:true})

		.state("authHeader",{

		url:"/authHeader",
		templateUrl:"app/components/unauth/templates/unauth-header.html",
		controller:"unauthHeaderController"
		})

});
