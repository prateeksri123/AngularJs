var app = angular.module('toDoAssignment', ['ngRoute']);

//This configures the routes and associates each route with a view and a controller
app.config(function ($routeProvider) {
    $routeProvider
        .when('/taskHomePage',
            {
                controller: 'TaskControlloer',
                templateUrl: '/src/app/views/TaskHomePage.html'
            })
        .when('/addTask',
            {
                controller: 'TaskControlloer',
                templateUrl: '/src/app/views/AddTask.html'
            })
        //Define a route that has a route parameter in it (:TaskId)
        .when('/editTask/:TaskId',
            {
                controller: 'TaskEditController',
                templateUrl: '/src/app/views/AddTask.html'
            })
        .otherwise({ redirectTo: '/taskHomePage' });
});





