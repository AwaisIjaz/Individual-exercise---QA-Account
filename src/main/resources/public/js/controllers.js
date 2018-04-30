angular.module('app.controllers', []).controller('QAAccountListController', function($scope, $state, popupService, $window, QAAccount) {
  $scope.accounts = QAAccount.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks

  $scope.deleteQAAccount = function(qaaccount) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
      qaaccount.$delete(function() {
        $scope.qaaccounts = QAAccount.query(); 
        $state.go('qaaccounts');
      });
    }
  };
}).controller('QAAccountViewController', function($scope, $stateParams, QAAccount) {
  $scope.qaaccount = QAAccount.get({ id: $stateParams.id }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('QAAccountCreateController', function($scope, $state, $stateParams, QAAccount) {
  $scope.qaaccount = new QAAccount();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addQAAccount = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
    $scope.qaaccount.$save(function() {
      $state.go('qaaccounts'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('QAAccountEditController', function($scope, $state, $stateParams, QAAccount) {
  $scope.updateQAAccount = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.qaaccount.$update(function() {
      $state.go('qaaccounts'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadQAAccount = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.qaaccount = QAAccount.get({ id: $stateParams.id });
  };

  $scope.loadQAAccount(); // Load a shipwreck which can be edited on UI
});
