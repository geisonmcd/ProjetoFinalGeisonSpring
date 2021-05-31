angular.module("institutions", ['ngRoute']).config(['$routeProvider', function($routeProvider){
   
    $routeProvider.when('/users', {
        name: "users",
        templateUrl: "view/users.html",
        controller: "usersController",
        resolve: {
            institutions: ["api", function (api) {
                return api.institutions.list();
            }]
        }
    });   
    
    $routeProvider.otherwise({ redirectTo: "/users" });
    
}]);
