package face_bank.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import face_bank.domain.Department;

@Repository
public interface DepartmentRepository extends GraphRepository<Department> {

}
