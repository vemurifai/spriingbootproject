package usecaseproject.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usecaseproject.project.entities.Employee;
import usecaseproject.project.entities.Progress;
import usecaseproject.project.entities.TrainingModule;
import usecaseproject.project.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
private EmployeeService employeeService;
@GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.employeeService.getEmployees();
    }
@GetMapping("/employee/{id}")
    public  Employee getById(@PathVariable("id") Long id){
    return this.employeeService.getEmployeeById(id);
    }
  @GetMapping("/progress/{id}")
   public Progress getProgress(@PathVariable("id") long id){
    return this.employeeService.getprogressById(id);
   }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee){
    this.employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
    this.employeeService.deleteEmployee(id);
    }
@PutMapping("/employee/{id}")
      public void updateEmployee(@RequestBody Employee emp,@PathVariable("id") Long id){
    this.employeeService.updateEmployee(emp,id);
}
@PutMapping("/progress/{id}")
public  void changeProgress(@RequestBody Progress p,@PathVariable("id") long id){
this.employeeService.changeProgress(p,id);
}
    @GetMapping("/{mid}/assign/{eid}")
       public List<String> assign(@PathVariable("mid")long mid,@PathVariable("eid")long eid){
        return this.employeeService.assign(mid, eid);
    }


}
