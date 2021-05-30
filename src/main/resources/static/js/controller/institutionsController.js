angular.module('institutions').controller("institutionsController", ["$scope", "$route", "institutions", "api",  function ($scope, $route, institutions, api){
    
    const init = function () {
        $scope.editMode = false;
        console.log(institutions);
        $scope.institutions = institutions.data;
        $scope.usuario = {};
    };
    
    $scope.salvaUsuario = function (form) {
        if (form.$invalid)return;
        if (!$scope.usuario) return;
        if ($scope.usuario.id) {
            api.institutions.put($scope.usuario.id, $scope.usuario).then(function (response) {
                $route.reload();
            });
        } else {
            api.institutions.post($scope.usuario).then(function (response) {
                $route.reload();
            });
        }
    };

    $scope.deleteUser = function (user) {
        api.institutions.delete(user.id).then(function (response) {
            $route.reload();
        }, function (error){
        });
    };

    $scope.editInstitution = function (usuario) {
        $scope.editMode = true;
        $scope.usuario = angular.copy(usuario);
        $scope.usuario.dtNasc = new Date(usuario.dtNasc)
    }

    init();
}]);