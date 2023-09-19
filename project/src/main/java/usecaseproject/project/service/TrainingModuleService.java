package usecaseproject.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usecaseproject.project.dao.EmployeeRepo;
import usecaseproject.project.dao.TrainingModuleRepo;
import usecaseproject.project.entities.Employee;
import usecaseproject.project.entities.TrainingModule;

import java.util.ArrayList;
import java.util.List;
@Service
public class TrainingModuleService {

//   private static List<TrainingModule> moduleList=new ArrayList<>();
//static {
//    moduleList.add(new TrainingModule(1,"java","trying"));
//    moduleList.add(new TrainingModule(2,"java  oops","tried"));
//    moduleList.add(new TrainingModule(3,"java abc","done"));
//}
    @Autowired
private TrainingModuleRepo trainingModuleRepo;
   @Autowired
    private EmployeeService employeeService;
//   @Autowired
//   private EmployeeRepo employeeRepo;
public  List<TrainingModule> getAllModules(){
    List<TrainingModule> t=(List<TrainingModule>) this.trainingModuleRepo.findAll();
     return t;
}

public  TrainingModule getModuleById(long id){
    TrainingModule trainingModule=null;
    try {
//    trainingModule= moduleList.stream().filter(e->e.getId()==id).findFirst().get();
        trainingModule = this.trainingModuleRepo.findById(id);
    }
    catch (Exception e){
        e.printStackTrace();
    }

    return trainingModule;
}

public TrainingModule addTrainingModule(TrainingModule t){
 this.trainingModuleRepo.save(t);
 return t;
}

public void deleteModule(long id){
trainingModuleRepo.deleteById(id);
}
public void updateTrainingModule(TrainingModule trainingModule,long id){
    TrainingModule tm=trainingModuleRepo.findById(id);
    tm=trainingModule;
    tm.setId(id);
    trainingModuleRepo.save(tm);
}

//public List<String>getAssignedEmployees(Long id){
//    TrainingModule tm=getModuleById(id);
//    if(tm!=null)
//        return tm.getAssignedEmployees();
//    else
//        return null;
//}

//public void assignToEmployees(long mid, long eid){
//    TrainingModule tm=getModuleById(mid);
//Employee emp=employeeService.getEmployeeById(eid);
//    tm.assignToEmployees(emp.getName());
////    emp.assignModules(tm);
////    employeeRepo.save(emp);
//    trainingModuleRepo.save(tm);
//
//
//}
//    public void unassignFromEmployees(long mid, long eid){
//        TrainingModule tm=getModuleById(mid);
//        Employee emp=employeeService.getEmployeeById(eid);
//        tm.unassignFromEmployees(emp.getName());
////       emp.unassignModules(tm);
//        trainingModuleRepo.save(tm);
////         employeeRepo.save(emp);
//
//    }


}