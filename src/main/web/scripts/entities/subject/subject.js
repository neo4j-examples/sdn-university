'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('subject', {
                parent: 'entity',
                url: '/subjects',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'html/subjects.html',
                        controller: 'SubjectController'
                    }
                }
            })
            .state('subjectDetail', {
                parent: 'entity',
                url: '/subjects/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'html/subject-detail.html',
                        controller: 'SubjectDetailController'
                    }
                }
            });
    });
