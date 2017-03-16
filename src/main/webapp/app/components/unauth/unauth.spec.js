describe('RA Login', function() {

    beforeEach(angular.mock.module('bbApp'));

    var $controller, $scope;

    beforeEach(inject(function(_$controller_, _$rootScope_){
        $scope = _$rootScope_.$new();
        $controller = _$controller_('raLoginController', { $scope: $scope});
    }));

    it('variable should be false', function () {
        expect($scope.logoutMsg).toBe(false);
        // expect($scope.newUser).toBeDefined();
    });
    // it('isOpen must be initialized as an empty array', function(){
    //     expect($scope.isOpen).toEqual([]);
    // });
    // it('default user role should be Role', function () {
    //     expect($scope.newUser.role).toBe('Role');
    // });
    // it('current tab should be USER by default', function () {
    //     expect($scope.currentTab).toBe('USER');
    // });
    // it('first page should be in loadedPages array', function () {
    //     var loadedPages = [1];
    //     expect(loadedPages).toEqual([1]);
    // });
    // it('hide password should be true', function() {
    //     expect($scope.hidePassword).toBe(true);
    // });
});
