app.controller('friendCtrl', function($scope,$http,$location){
	$scope.addFriend=function(friendemail)
	 {
		 console.log(friendemail);
		 $http.post("http://localhost:8081/OnlineChatmiddleware/addFriend",friendemail);
	 };
	 
	 $scope.listFiends=function()
	 {
		 $http.get("http://localhost:8081/OnlineChatmiddleware/listFriends").then(
				 function(response){
					 console.log(response.data);
					 $scope.allfriends=response.data;
					 console.log($scope.allfriends[0]);
					
				 }, 
				 function(error){
					 console.log(error);
				 });
	 
		 
      }
	 
	 $scope.pendingRequests=function()
		{
			$http.get("http://localhost:8081/OnlineChatmiddleware/pendingRequests").then(
					function(response){
						 console.log(response.data);
						 $scope.allrequests=response.data;
						 console.log($scope.allrequests);
					}, 
					 function(error){
						 console.log(error);
					});
		}
	 
	 $scope.acceptRequest=function(friend)
	 {
		 $http.put("http://localhost:8081/OnlineChatmiddleware/acceptRequest",friend).then(
				 function(response){
					 console.log(response.data);	 
				 })		 
	 }
	 
	 $scope.Friends=function(friend)
	 {
		 $http.get("http://localhost:8081/OnlineChatmiddleware/FriendsList",friend).then(
				 function(response){
					 console.log(response.data);
					 $scope.friendsList=response.data;
					 console.log($scope.friendsList);
				 },
				 function(error){
					 console.log(error);
				 });
	 }
	 
	 $scope.rejectRequest=function(friend)
	 {
		 $http.delete("http://localhost:8081/OnlineChatmiddleware/rejectRequest",friend);
		 //.then(
//				 function(response){
//					 console.log(response.data);	 
//				 })		 
	 }
	 
	 
	 $scope.listFiends();
	 $scope.pendingRequests();
	 $scope.Friends();
	
});
	
