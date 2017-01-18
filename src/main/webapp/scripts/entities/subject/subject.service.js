'use strict';

angular.module('registrarApp')
    .factory('Subject', function ($resource) {

        var url = 'api/subjects/:id';

        // should be done on server side
        var truncate = function (obj, depth) {
            for (var property in obj) {
                if (property == 'id' || property == 'name') {
                    continue;
                }
                if (depth == 0) {
                    var p = obj[property];
                    if (p && p.constructor === Array) {
                        obj[property] = [];
                    } else {
                        obj[property] = null;
                    }
                } else {
                    truncate(obj[property], depth - 1);
                }
            }
        };


        var prune = function (obj, depth) {
            for (var property in obj) {
                if (property == 'id' || property == 'name') {
                    continue;
                }
                if (depth == 0) {
                    delete obj[property];
                } else {
                    prune(obj[property], depth - 1);
                }
            }
        };

        return $resource(url, {}, {
            'query': {
                method: 'GET', isArray: true,
                transformResponse: function (data) {
                    var obj = JSOG.parse(data);
                    for (var i = 0; i < obj.length; i++) {
                        truncate(obj[i], 0);
                    }
                    return obj;
                }
            },
            'remove': {method: 'DELETE'},
            'delete': {method: 'DELETE'},
            'post': {method: 'POST'},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    var obj = JSOG.parse(data);
                    truncate(obj, 2);
                    return obj;
                }
            }
        });
    });
