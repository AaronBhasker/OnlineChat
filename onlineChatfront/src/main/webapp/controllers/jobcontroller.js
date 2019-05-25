app.controller('jobsCtrl', function($scope,$http,$location,$rootScope){
	
	 $scope.addJob=function(job)
	 {
		 
		 $http.post("http://localhost:8081/OnlineChatmiddleware/addJobs",job);
	 };
	 
	 $scope.listJob=function()
	 {
		 $http.get("http://localhost:8081/OnlineChatmiddleware/listJobs").then(
				 function(response){
					 console.log(response.data);
					 $scope.allJobs=response.data;
				 }, 
				 function(error){
					 console.log(error);
				 });
	 }
	 
	 $scope.deleteJobs=function(job)
	 {
		 $http.delete("http://localhost:8081/OnlineChatmiddleware/deleteJobs",job);
	 }
	 
	 $scope.listJob();

	 
	 $scope.addJobApplication=function(job)
	 {
		 $scope.jobApplication={"job":job};
	 $http.post("http://localhost:8081/OnlineChatmiddleware/addJobApplication",$scope.jobApplication).then(
			 function(response){
				 console.log(response.data);
				 alert("You have applied for this job");
				 
				 $location.path("/home");
			 }, 
			 function(error){
				 console.log(error);
			 });
		 
		 
	 };
	 
	 
	 $scope.listJobApplication=function(job)
	 {
		 $http.get("http://localhost:8081/OnlineChatmiddleware/listJobApplication/"+job.jobid).then(
				 function(response){
					 console.log(response.data);
					 $rootScope.allJobapps=response.data;
					 console.log($scope.allJobapps);
					 $location.path("/Listjobapps");
				 }, 
				 function(error){
					 console.log(error);
				 });
	 }
	 
});