app.controller('blogsCtrl', function($scope,$http,$location,$rootScope){
	
	 $scope.addBlog=function(blog)
	 {
		 $scope.blog={};
		 $scope.blog=blog;
		 console.log($scope.blog);
		 $http.post("http://localhost:8081/OnlineChatmiddleware/addBlog",$scope.blog);
	 }
	 
	 $scope.listBlogs=function()
	 {
		 $http.get("http://localhost:8081/OnlineChatmiddleware/ListBlog").then(
				 function(response){
					 console.log(response.data);
					 $scope.allBlogs=response.data;
				 }, 
				 function(error){
					 console.log(error);
				 });
	 }
	 
	 $scope.blogdisplay=function(blogId)
	 {
		 console.log('display blog '+blogId);
		 $http.get("http://localhost:8081/OnlineChatmiddleware/GetBlog/"+blogId).then(
				 function(response){
					 console.log(response.data);
					 $rootScope.Blog=response.data;
					 $location.path("/blogdisplay");
				 }, 
				 function(error){
					 console.log(error);
				 });
	 }
	 
	 $scope.deleteBlogs=function(blog)
	 {
		 $http.delete("http://localhost:8081/OnlineChatmiddleware/deleteBlog",blog);
	 }
	 
	 $scope.listBlogs();
	// $scope.listBlogComments();
	 


	 
	 $scope.listBlogComments=function()
	 {
		 $http.get("http://localhost:8081/OnlineChatmiddleware/ListBlogComments").then(
				 function(response){
					 console.log(response.data);
					 $scope.allBlogComments=response.data;
					 
				 }, 
				 function(error){
					 console.log(error);
				 });
	 }
	 
	 
	 


});