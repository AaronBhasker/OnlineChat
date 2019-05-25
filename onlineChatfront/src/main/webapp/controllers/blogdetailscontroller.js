app.controller('BlogDetailsCtrl', function($scope, $location,$http,$rootScope, $sce, $routeParams) {
	console.log($routeParams.id);
	var id = $routeParams.id; // this is an id that we get in the url path i.e. lastpart of the url
	$scope.rejectionTxt = false;
	
	$http.get("http://localhost:8081/OnlineChatmiddleware/GetBlog/"+id).then(function(response) {
		console.log(response.data)
		$scope.Blog = response.data
		//$scope.content = $sce.trustAsHtml($scope.blog.blogContent)
	}, function(response) {
		$rootScope.error = response.data
		if (response.status == 401)
			$location.path('/login')

	})
	
	
	$http.get("http://localhost:8081/OnlineChatmiddleware/hasuserlikedblog/"+id).then(function(response) {

		if (response.data == "")
			$scope.isLiked = false
		else
			$scope.isLiked = true
			console.log($scope.isLiked);
	}, function(response) {
		$rootScope.error = response.data
		if (response.status == 401)
			$location.path('/login')
	});
	

//	$scope.approve = function(blog) {
//
//		BlogService.approve(blog).then(function(response) {
//			$location.path('/blogsnotapproved')
//		}, function(response) {
//			$rootScope.error = response.error
//			if (response.error == 401)
//				$location.path('/login')
//		})
//	}
//
//	$scope.reject = function(blog) {
//
//		BlogService.reject(blog, $scope.rejectionReason).then(
//				function(response) {
//					$location.path('/blogsnotapproved')
//				}, function(response) {
//					$rootScope.error = response.error
//					if (response.error == 401)
//						$location.path('/login')
//				});
//	}
//	$scope.showRejectionTxt = function(blog) {
//		console.log('Rejecting blog');
//		$scope.rejectionTxt = true;
//		$scope.reject(blog);
//	}

	

	/*$scope.addComment = function(blogid, commentTxt) {
		$scope.blogComment = {}

		$scope.blogComment.commentTxt = commentTxt;

		BlogService.addComment(blogid, $scope.blogComment).then(
				function(response) {
					$scope.commentTxt = ''
					getBlogComments(id)
				}, function(response) {
					$rootscope.error = resonse.data
					if (response.status == 401)
						$location.path('/login')
					else {
						$scope.exceptionMessage = response.data
					}
				});
	}*/
	
	
	$scope.addBlogComment=function(blogId,comment)
	{
		 //console.log('display blog '+blog +' '+comment);
		 $scope.blogComment={"commenttext":comment};
		 $http.post("http://localhost:8081/OnlineChatmiddleware/addblogComment/"+blogId,$scope.blogComment).then(
				 function(response){
					 console.log(response.data);
					 $rootScope.Blog=response.data;
					 getBlogComments(blogId);
					 $location.path("/getblog/"+id);
				 }, 
				 function(error){
					 console.log(error);
				 });
	}
	
	
	function getBlogComments(id) {
		 $http.get("http://localhost:8081/OnlineChatmiddleware/ListBlogComments/"+id).then(function(response) {
			$scope.blogcomments = response.data
			console.log($scope.blogcomments);
			$location.path("/getblog/"+id);
		}, function(response) {
			$rootScope.error = response.data
			if (response.status == 401)
				$location.path('/login')
		});
	}
	
	$scope.updateLikes = function(id) {
		console.log('updating likes for blog ' + id);
		$http.put("http://localhost:8081/OnlineChatmiddleware/updatelikes/"+id).then(function(response) {
			$scope.Blog = response.data; //update blogpost likes
			$scope.isLike | $scope.isLiked
		}, function(response) {
			$rootScope.error = response.data
			if (response.status == 401)
				$location.path('/login')

		});
	} 
	getBlogComments(id);
	//hasuserlikedblog(id);
})