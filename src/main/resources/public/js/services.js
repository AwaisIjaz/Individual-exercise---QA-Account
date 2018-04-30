angular.module('app.services', []).factory('QAAccount', function($resource) {
  return $resource('/api/v1/qaaccounts/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
