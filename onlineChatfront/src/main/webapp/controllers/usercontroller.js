
app.controller('userCtrl', function($scope,$cookieStore,$http,$rootScope,$location) {
	'use strict';
  $scope.register = function(user) {
	  $scope.user={};
	  $scope.user=user;
    console.log(user.emailId);
    console.log(user.name);
    $http.post("http://localhost:8081/OnlineChatmiddleware/registeruser",$scope.user);
  };
  
  $scope.login = function(user){
	  $scope.user={};
	  $scope.user={"emailId":user.emailid,"password":user.password};
	  console.log($scope.user.emailId);
	  console.log(user.password);
	  
	    $http.post("http://localhost:8081/OnlineChatmiddleware/login",$scope.user).then(
				 function(response){
					
					 $rootScope.loggedInUser=response.data;
					 $cookieStore.put("currentuser", response.data);
					 $location.path("/");
				 }, 
				 function(error){
					 console.log(error);
				 }); 
				 
  }
  
});