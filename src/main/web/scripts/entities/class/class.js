'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('class', {
                parent: 'entity',
                url: '/classes',
                views: {
                    'content@': {
                        templateUrl: 'html/classes.html',
                        controller: 'ClassController'
                    }
                }
            })
            .state('classDetail', {
                parent: 'entity',
                url: '/classes/:id',
                views: {
                    'content@': {
                        templateUrl: 'html/class-detail.html',
                        controller: 'ClassDetailController'
                    }
                }
            });
    });
