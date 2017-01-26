/**
 * 
 */

angular.module('hello', [])
  .controller('home', function($http) {
    var self = this;
    $http.get('resource').then(function(response) {
      self.greeting = response.data;
    })
    $http.get('doors').then(function(response) {
      self.doors = response.data;
    })
    $http.get('products').then(function(response) {
      console.log(response);
    })
	$http.get('dropdown/1/H').then(function(response) {
      console.log(response);
    })
  }
);