package face_bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import face_bank.domain.Department;
import face_bank.service.DepartmentService;
import face_bank.service.Service;

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