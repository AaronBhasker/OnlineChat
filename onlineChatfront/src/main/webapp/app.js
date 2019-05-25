
var app = angular.module("myApp", ["ngRoute",'ngCookies']);
app.config(function($routeProvider,$locationProvider) {
	'use strict';
	$locationProvider.hashPrefix('');
    $routeProvider
    .when("/", {
        templateUrl : "views/home.html"
   
    })
     .when("/register", {
       templateUrl : "views/register.html",
       controller:"userCtrl"
    })
   .when("/login", {
        templateUrl : "views/login.html",
        controller:"userCtrl"
    })
    

.when("/Jobs", {
     templateUrl : "views/Job.html",
    	 controller:"jobsCtrl"     		 
})
.when("/Listjobs",{
    	templateUrl : "views/listjobs.html",
    	controller:"jobsCtrl"
    })
    .when("/Listjobapps",{
    	templateUrl : "views/listjobapps.html",
    	controller:"jobsCtrl"	
    })
    .when("/addBlog",{
    	templateUrl : "views/blog.html",
    	controller:"blogsCtrl"
    })
   .when("/Listblogs",{
    	templateUrl : "views/listblogs.html",
    	controller:"blogsCtrl"	
    })
    .when("/blogdisplay",{
    	templateUrl : "views/blogdisplay.html",
    	controller:"blogsCtrl"
        
    })
    .when('/getblog/:id', {
		templateUrl : 'views/blogdisplay.html',
		controller : 'BlogDetailsCtrl' // single blog post object-queries
										// getBlog() update blog,add comment
	})
	  .when("/suggestedUser",{
    	templateUrl : "views/suggestedUsers.html",
    	controller:"friendCtrl"
	
})
.when("/pendingRequests",{
    	templateUrl : "views/pendingRequests.html",
    	controller:"friendCtrl"
    		
})
   .when("/listAllfriends",{
    	templateUrl : "views/listAllfriends.html",
    	controller:"friendCtrl"
   })
   
    .when("/chat",{
    	templateUrl : "views/chat.html",
    	controller:"ChatCtrl"
   })
   .when('/uploadprofilepic', {
		templateUrl : 'views/uploadprofilepic.html'

})
app.run(function($location, $rootScope, $cookieStore,$http) {
	'use strict';
	console.log($rootScope.loggedInUser)
	if ($rootScope.loggedInUser == undefined)
		$rootScope.loggedInUser = $cookieStore.get("currentuser")

	$rootScope.logout = function() {
		console.log('entering logout')
		JSON.parse($rootScope.loggedInUser);
		var config = {
	            headers: {'Content-Type': undefined},
	            transformRequest: [],
	            //IMPORTANT
	            transformResponse: angular.identity
	        }
		var promise=$http.get("http://localhost:8081/OnlineChatmiddleware/logout",config).then(
				
				function(response) {
					console.log(response);
					
					console.log($rootScope.loggedInUser);
			delete $rootScope.loggedInUser;
			$cookieStore.remove("currentuser");
			console.log('loggedout '+$rootScope.loggedInUser);
			//$rootScope.message = "Successfully loggedout.."
			$location.path("/login");
		}, function(error) {
			$rootScope.error = error.data
			console.log('error in logging out');
			if (error.status == 401)
				$location.path('/login')

		});
		return promise;
	};
	
})
})
	