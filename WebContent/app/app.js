var app = angular.module('toDoAssignment', ['ngRoute']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/taskHomePage',
            {
                controller: 'TaskControlloer',
                templateUrl: 'app/views/TaskHomePage.html'
            })
        .when('/addTask',
            {
                controller: 'TaskControlloer',
                templateUrl: 'app/views/AddTask.html'
            })
        //Define a route that has a route parameter in it (:TaskId)
        .when('/editTask/:TaskId',
            {
                controller: 'TaskEditController',
                templateUrl: 'app/views/AddTask.html'
            })
         .when('/editTask/:TaskId',
            {
                controller: 'TaskEditController',
                templateUrl: 'app/views/AddTask.html'
            })
         .when('/registrationPage',
            {
                controller: 'loginController',
                templateUrl: 'app/views/RegistrationPage.html'
            })

        .otherwise({ redirectTo: '/' });
});







