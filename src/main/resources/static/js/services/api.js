angular.module('users').factory('api', [ '$http', function ($http) {
    return    {
        users: {
            list: function () {
                return $http.get(`/usuario/todos`);
            },
            post: function (usuario) {
                return $http.post(`/usuario/adicionar`, usuario)
            },
            put: function (idUsuario, usuario) {
                return $http.put(`/usuario/alterar/${idUsuario}`, usuario);
            },
            delete: function (idUsuario) {
                return $http.delete(`/usuario/${idUsuario}`)
            }
        }
    }
}]);
