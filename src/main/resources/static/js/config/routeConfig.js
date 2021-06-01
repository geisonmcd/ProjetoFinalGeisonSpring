angular.module("users", ['ngRoute']).config(['$routeProvider', function($routeProvider){
   
    $routeProvider.when('/users', {
        name: "users",
        templateUrl: "view/users.html",
        controller: "usersController",
        resolve: {
            users: ["api", function (api) {
                return api.users.list();
            }]
        }
    });   
    
    $routeProvider.otherwise({ redirectTo: "/users" });
    
}]);
