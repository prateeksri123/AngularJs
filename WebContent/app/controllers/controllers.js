/**
 * @author Prateek
 */
app.factory("task",function($resource){
	return $resource('/rest/task/:id',{id: '@id'},{update : {method:'PUT'}})
});

app.controller('loginController', function($scope,$location,$http,customersService){
    $scope.openRegistrationPage = function(){
    	$scope.go("/registrationPage");
    	document.getElementById('pageDiv').style.display = 'none';
    }

    $scope.login = function(){
    	$http.get('rest/user/' + $scope.user.userName + '/' + $scope.user.password).
        success(function(data) {
        	customersService.setLoggedInUser(data);
        	document.getElementById('pageDiv').style.display = 'none';
        	$scope.go("/taskHomePage");
            console.log(data);
        });
    }

    $scope.backToLogin = function(){
    	document.getElementById('pageDiv').style.display = 'block'
    	$scope.go("/");
    }

    $scope.addUser = function(){
    	$http.post('rest/user',$scope.user).success(function(data) {
            console.log(data);
            document.getElementById('pageDiv').style.display = 'block'
            $scope.go("/");
        });
    }

    $scope.go = function(url) {
        console.log(url);
        $location.path( url );
     };

});

app.controller('TaskControlloer', function($scope, customersService,$location,$http) {

	init();

	function init() {
		$scope.loggedInUser = customersService.getLoggedInUser();
		$http.get('rest/task/' + $scope.loggedInUser.id).
        success(function(data) {
        	$scope.tasks = data;
            console.log(data);
        });
		$scope.editMode = false;

	}

	$scope.go = function(url) {
      console.log(url);
      $location.path( url );
   };


	$scope.insertCustomer = function() {
        $scope.newCustomer.userId = $scope.loggedInUser.id
		$http.post('rest/task',$scope.newCustomer).success(function(data) {
            console.log(data);
            getUpdatedList();
            $scope.go("/taskHomePage");
        });

	};

	$scope.deleteTask = function(id) {
		$('task_'+id).hide();
		$http.delete('rest/task/'+id).success(function(data) {
            console.log(data);
            $scope.tasks = data;
            $scope.go("/taskHomePage");
        });
	};

	function getUpdatedList() {
	    $http.get('rest/task').
	        success(function(data) {
	        	$scope.tasks = data;
	            console.log(data);
	        });
	}
});
app.controller('NavbarController', function($scope, $location) {
	$scope.getClass = function(path) {
		if ($location.path().substr(0, path.length) == path) {
			return true
		} else {
			return false;
		}
	}
});

app.controller('TaskEditController', function ($scope, $routeParams, customersService, $location,$http) {
    $scope.tasks = {};
    $scope.ordersTotal = 0.00;

    init();

    function init() {
        //Grab customerID off of the route
    	$scope.loggedInUser = customersService.getLoggedInUser();
        var taskId = ($routeParams.TaskId) ? parseInt($routeParams.TaskId) : 0;
        console.log("Task ID " + taskId);
        if (taskId > 0) {
        	$http.get('rest/task/' + taskId + '/' + $scope.loggedInUser.id).
	        success(function(data) {
	        	$scope.newCustomer = data;
	            console.log(data);
	        });
        }
        $scope.editMode = true;
    };

    $scope.update = function(){
    	$http.post('rest/task',$scope.newCustomer).success(function(data) {
            console.log(data);
            $scope.go("/taskHomePage");
        });

    };

    $scope.go = function(url) {
        console.log(url);
        $location.path( url );
     };



});
