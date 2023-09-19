package usecaseproject.project.dao;

import org.springframework.data.repository.CrudRepository;
import usecaseproject.project.entities.Progress;

public interface ProgressRepo extends CrudRepository<Progress,Long> {
public Progress findById(long id);

}
