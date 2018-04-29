angular.module('app.controllers', []).controller('AccountListController', function($scope, $state, popupService, $window, Account) {
  $scope.accounts = Account.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks

  $scope.deleteAccount = function(account) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
      account.$delete(function() {
        $scope.accounts = Account.query(); 
        $state.go('accounts');
      });
    }
  };
}).controller('AccountViewController', function($scope, $stateParams, Account) {
  $scope.account = Account.get({ id: $stateParams.id }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('AccountCreateController', function($scope, $state, $stateParams, Account) {
  $scope.account = new Account();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addAccount = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
    $scope.account.$save(function() {
      $state.go('accounts'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('AccountEditController', function($scope, $state, $stateParams, Account) {
  $scope.updateAccount = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.account.$update(function() {
      $state.go('accounts'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadAccount = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.account = Account.get({ id: $stateParams.id });
  };

  $scope.loadAccount(); // Load a shipwreck which can be edited on UI
});
