'use strict';

angular.module('registrarApp')
    .controller('ClassDetailController', function ($scope, $stateParams, Class) {
        $scope.class = {};

        $scope.load = function (id) {
            Class.get({id: id}, function(result) {
              $scope.class = result;
              $scope.class.enrolledStudents = extractEnrolledStudents(result);
            });
        };

        $scope.load($stateParams.id);

        function extractEnrolledStudents(theClass) {
            var students = new Array();
            jQuery.each(theClass.enrollments, function(index,value) {
                students.push(value.student.id);
            });
            return students;
        }
    });
