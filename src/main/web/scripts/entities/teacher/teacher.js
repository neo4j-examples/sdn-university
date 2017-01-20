'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('teacher', {
                parent: 'entity',
                url: '/teachers',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'html/teachers.html',
                        controller: 'TeacherController'
                    }
                }
            })
            .state('teacherDetail', {
                parent: 'entity',
                url: '/teachers/:id',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'html/teacher-detail.html',
                        controller: 'TeacherDetailController'
                    }
                }
            });
    });
