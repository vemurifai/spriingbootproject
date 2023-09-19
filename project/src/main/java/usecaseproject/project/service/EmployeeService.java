package usecaseproject.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usecaseproject.project.dao.EmployeeRepo;
import usecaseproject.project.dao.ProgressRepo;
import usecaseproject.project.entities.Employee;
import usecaseproject.project.entities.Progress;
import usecaseproject.project.entities.TrainingModule;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepo employeeRepo;
@Autowired
private TrainingModuleService trainingModuleService;
@Autowired
private ProgressRepo progressRepo;
public List<Employee> getEmployees(){
    List<Employee> emp=(List<Employee>) this.employeeRepo.findAll();
    return emp;
}
public Employee getEmployeeById(long id){
    Employee emp=null;
    emp=this.employeeRepo.findById(id);
    return emp;
}
public Progress getprogressById(long id){
    Progress progress=null;
    progress=this.progressRepo.findById(id);
    return progress;
}
public Employee addEmployee(Employee emp){
    this.employeeRepo.save(emp);
    Progress progress=new Progress();
    progress.setId(emp.getId());
    progress.setProgressPercent("0%");
    progress.setCompleted(false);
    progress.setNo_of_modulesassigned(0);
    this.progressRepo.save(progress);
    return emp;
}

public void deleteEmployee(long id){

    this.employeeRepo.deleteById(id);
}

public void updateEmployee(Employee e, long id){
      e.setId(id);
        employeeRepo.save(e);
    }

    public void changeProgress(Progress p,long id){
    p.setId(id);
    if(p.getProgressPercent()=="100%")
        p.setCompleted(true);
    progressRepo.save(p);
}


public List<String> assign(long mid,long eid){
    TrainingModule tm=trainingModuleService.getModuleById(mid);
    Employee emp=getEmployeeById(eid);
   Progress p=this.progressRepo.findById(eid);
    List<String>tt,ti;
    ti=new ArrayList<>();
    tt=emp.getModuleassigned();

    if(tt==null ){
      ti.add(tm.getName());
        emp.setModuleassigned(ti);
    } else {
        if(!tt.contains(tm.getName())){
            emp.assign(tm.getName());
        }
    }
    p.setNo_of_modulesassigned(emp.getModuleassigned().size());
    employeeRepo.save(emp);
    progressRepo.save(p);
  return   emp.getModuleassigned();

}


}




