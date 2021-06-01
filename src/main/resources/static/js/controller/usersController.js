angular.module('users').controller("usersController", ["$scope", "$route", "users", "api",  function ($scope, $route, users, api){
    
    const init = function () {
        $scope.editMode = false;
        $scope.users = users.data;
        $scope.usuario = {};
    };
    
    $scope.salvaUsuario = function (form) {
        if (form.$invalid)return;
        if (!$scope.usuario) return;
        if ($scope.usuario.id) {
            api.users.put($scope.usuario.id, $scope.usuario).then(function (response) {
                $route.reload();
            });
        } else {
            api.users.post($scope.usuario).then(function (response) {
                $route.reload();
            });
        }
    };

    $scope.deleteUser = function (user) {
        api.users.delete(user.id).then(function (response) {
            $route.reload();
        }, function (error){
        });
    };

    $scope.editUser = function (usuario) {
        $scope.editMode = true;
        $scope.usuario = angular.copy(usuario);
        $scope.usuario.dtNasc = new Date(usuario.dtNasc)
    }

    init();
}]);