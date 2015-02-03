/**
 * @author Prateek
 */
app.controller('TaskControlloer', function($scope, customersService,$location,$http) {

	init();

	function init() {
		$scope.tasks = customersService.getCustomers();
		console.log("xxxxxx");
		$scope.user = customersService.getUser();
		$scope.editMode = false;
	}

	$scope.go = function(url) {
      console.log(url);
      $location.path( url );
   };


	$scope.insertCustomer = function() {
		var firstName = $scope.newCustomer.firstName;
		var lastName = $scope.newCustomer.lastName;
		var city = $scope.newCustomer.city;
		var dueDate = $scope.newCustomer.dueDate;
		var priority = $scope.newCustomer.priority;
		console.log(priority);
		customersService.insertCustomer(firstName, lastName, city, dueDate,priority);
		$scope.newCustomer.firstName = '';
		$scope.newCustomer.lastName = '';
		$scope.newCustomer.city = '';
		$scope.newCustomer.dueDate = 12/12/2012;
		$scope.newCustomer.priority = 0;
		hello();
		$scope.go("/taskHomePage");
	};

	$scope.deleteCustomer = function(id) {
		customersService.deleteCustomer(id);
	};

	function hello() {
	    $http.get('rest/task').
	        success(function(data) {
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

app.controller('TaskEditController', function ($scope, $routeParams, customersService, $location) {
    $scope.customer = {};
    $scope.ordersTotal = 0.00;

    //I like to have an init() for controllers that need to perform some initialization. Keeps things in
    //one place...not required though especially in the simple example below
    init();

    function init() {
        //Grab customerID off of the route
        var taskId = ($routeParams.TaskId) ? parseInt($routeParams.TaskId) : 0;
        console.log("Task ID " + taskId);
        if (taskId > 0) {
            $scope.newCustomer = customersService.getCustomer(taskId);
        }
        $scope.editMode = true;
    };
    
    $scope.update = function(){
    	$scope.go("/taskHomePage");
    };
    
    $scope.go = function(url) {
        console.log(url);
        $location.path( url );
     };
    
	

});
