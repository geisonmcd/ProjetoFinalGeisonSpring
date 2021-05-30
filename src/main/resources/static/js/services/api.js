angular.module('institutions').factory('api', [ '$http', function ($http) {
    return    {
        institutions: {
            list: function () {
                return $http.get(`/usuario/todos`);
            },
            post: function (usuario) {
                return $http.post(`/usuario/adicionar`, usuario)
            },
            put: function (idUsuario, usuario) {
                return $http.put(`/usuario/${idUsuario}`, usuario);
            },
            delete: function (idUsuario) {
                return $http.delete(`/usuario/${idUsuario}`)
            },
            users: {
                reviews: {
                    get: function (idInstitution, idUser) {
                        return $http.get(`institutions/${idInstitution}/users/${idUser}/reviews`);
                    },
                    post: function (idInstitution, idUser, review) {
                        return $http.post(`institutions/${idInstitution}/users/${idUser}/reviews/`, review);
                    },
                    put: function (idInstitutions, idUser, idReview, review) {
                        return $http.put(`institutions/${idInstitutions}/users/${idUser}/reviews/${idReview}`, review);
                    }
                }
            }
        }
    }
}]);
