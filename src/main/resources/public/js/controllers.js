angular.module('app.controllers', []).controller('QAAccountListController', function($scope, $state, popupService, $window, QAAccount) {
  $scope.qaaccounts = QAAccount.query(); 

  $scope.deleteQAAccount = function(qaaccount) { 
    if (popupService.showPopup('Really delete this?')) {
      qaaccount.$delete(function() {
        $scope.qaaccounts = QAAccount.query(); 
        $state.go('qaaccounts');
      });
    }
  };
}).controller('QAAccountViewController', function($scope, $stateParams, QAAccount) {
  $scope.qaaccount = QAAccount.get({ id: $stateParams.id }); 
}).controller('QAAccountCreateController', function($scope, $state, $stateParams, QAAccount) {
  $scope.qaaccount = new QAAccount();  

  $scope.addQAAccount = function() { 
    $scope.qaaccount.$save(function() {
      $state.go('qaaccounts'); 
    });
  };
}).controller('QAAccountEditController', function($scope, $state, $stateParams, QAAccount) {
  $scope.updateQAAccount = function() { 
    $scope.qaaccount.$update(function() {
      $state.go('qaaccounts'); 
    });
  };

  $scope.loadQAAccount = function() { 
    $scope.qaaccount = QAAccount.get({ id: $stateParams.id });
  };

  $scope.loadQAAccount(); 
});
