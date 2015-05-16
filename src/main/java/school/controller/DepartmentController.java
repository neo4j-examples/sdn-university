package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import school.domain.Department;
import school.service.DepartmentService;
import school.service.Service;

@RestController
@RequestMapping(value = "/api/departments")
public class DepartmentController extends Controller<Department> {

    @Autowired
    private DepartmentService departmentService;

    @Override
    public Service<Department> getService() {
        return departmentService;
    }

}