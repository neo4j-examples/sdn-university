'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('school', {
                parent: 'entity',
                url: '/school',
                views: {
                    'content@': {
                        templateUrl: 'html/schools.html',
                        controller: 'SchoolController'
                    }
                }
            })
            .state('schoolDetail', {
                parent: 'entity',
                url: '/school/:id',
                views: {
                    'content@': {
                        templateUrl: 'html/school-detail.html',
                        controller: 'SchoolDetailController'
                    }
                }
            });
    });
