var app = angular.module('toDoAssignment', ['ngRoute']);

//This configures the routes and associates each route with a view and a controller
app.config(function ($routeProvider) {
    $routeProvider
        .when('/taskHomePage',
            {
                controller: 'TaskControlloer',
                templateUrl: 'app/views/TaskHomePage.html'
            })
        //Define a route that has a route parameter in it (:customerID)
        .when('/addTask',
            {
                controller: 'TaskControlloer',
                templateUrl: 'app/views/AddTask.html'
            })
        //Define a route that has a route parameter in it (:customerID)
        .when('/editTask/:TaskId',
            {
                controller: 'TaskEditController',
                templateUrl: 'app/views/AddTask.html'
            })
        .otherwise({ redirectTo: '/taskHomePage' });
});





