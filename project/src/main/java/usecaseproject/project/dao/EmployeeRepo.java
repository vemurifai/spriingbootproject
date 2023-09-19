package usecaseproject.project.dao;

import org.springframework.data.repository.CrudRepository;
import usecaseproject.project.entities.Employee;

public interface EmployeeRepo extends CrudRepository<Employee,Long> {
public Employee findById(long id);

}
