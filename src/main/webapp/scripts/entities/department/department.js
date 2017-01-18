'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('department', {
                parent: 'entity',
                url: '/departments',
                views: {
                    'content@': {
                        templateUrl: 'html/departments.html',
                        controller: 'DepartmentController'
                    }
                }
            })
            .state('departmentDetail', {
                parent: 'entity',
                url: '/departments/:id',
                views: {
                    'content@': {
                        templateUrl: 'html/department-detail.html',
                        controller: 'DepartmentDetailController'
                    }
                }
            });
    });
