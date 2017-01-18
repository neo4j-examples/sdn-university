'use strict';

angular.module('registrarApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('studyBuddy', {
                parent: 'entity',
                url: '/studyBuddies',
                views: {
                    'content@': {
                        templateUrl: 'html/studyBuddies.html',
                        controller: 'StudyBuddyController'
                    }
                }
            })
            .state('studyBuddyDetail', {
                parent: 'entity',
                url: '/studyBuddies/:id',
                views: {
                    'content@': {
                        templateUrl: 'html/studyBuddy-detail.html',
                        controller: 'StudyBuddyDetailController'
                    }
                }
            });
    });
