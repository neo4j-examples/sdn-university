'use strict';

angular.module('registrarApp')
    .controller('StudentDetailController', function ($scope, $stateParams, Student) {
        $scope.student = {};
        $scope.load = function (id) {
            Student.get({id: id}, function(result) {
              $scope.student = result;
              $scope.student.enrolledClasses = extractEnrolledClasses(result);
            });
        };
        $scope.load($stateParams.id);

         function extractEnrolledClasses(student) {
            var classes= new Array();
            jQuery.each(student.enrollments, function(index,value) {
                classes.push(value.course.id);
            });
            return classes;
        }
    });
