package usecaseproject.project.dao;


import org.springframework.data.repository.CrudRepository;
import usecaseproject.project.entities.TrainingModule;

public interface TrainingModuleRepo extends CrudRepository<TrainingModule,Long> {
public TrainingModule findById(long id);

}