'use strict';

angular.module('registrarApp')
    .factory('Statistics', function ($resource) {

        var url = 'api/studyBuddies/popular';

        return $resource(url, {}, {
            'query': {
                method: 'GET', isArray: true,
                transformResponse: function (data) {
                    return JSOG.parse(data);
                }
            }
        });
    });
