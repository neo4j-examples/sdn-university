'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('error', {
                parent: 'site',
                url: '/error',
                views: {
                    'content@': {
                        templateUrl: 'html/error.html'
                    }
                }
            });
    });
