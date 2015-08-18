package face_bank.service;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import face_bank.domain.Department;
import face_bank.repository.DepartmentRepository;

@Service("departmentService")
public class DepartmentServiceImpl extends GenericService<Department> implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public GraphRepository<Department> getRepository() {
        return departmentRepository;
    }
}
