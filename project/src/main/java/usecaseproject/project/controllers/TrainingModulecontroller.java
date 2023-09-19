package usecaseproject.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usecaseproject.project.entities.Employee;
import usecaseproject.project.entities.TrainingModule;
import usecaseproject.project.service.TrainingModuleService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TrainingModulecontroller {
@Autowired
   private TrainingModuleService trainingModuleService;
    @GetMapping("/modules")
    public List<TrainingModule> getModules(){
     try {
         return this.trainingModuleService.getAllModules();
     }
     catch (Exception e){
         e.printStackTrace();
         return this.trainingModuleService.getAllModules();
     }


     }
@GetMapping("/module/{id}")
    public TrainingModule getModule(@PathVariable("id") long id){
try {
    return trainingModuleService.getModuleById(id);
}
        catch (Exception e){
    e.printStackTrace();
            return trainingModuleService.getModuleById(id);
        }
    }

    @PostMapping("/module")
    public TrainingModule  addTrainingModule(@RequestBody TrainingModule trainingModule){
        this.trainingModuleService.addTrainingModule(trainingModule);
       try {
           return trainingModule;
       }
catch (Exception e){
           e.printStackTrace();
    return trainingModule;
}
    }

    @DeleteMapping("/module/{id}")
    public void deleteModule(@PathVariable("id") long id){
        try {
            this.trainingModuleService.deleteModule(id);
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
    @PutMapping("/module/{id}")
public void updateModule(@RequestBody TrainingModule trainingModule,@PathVariable("id") long id) {
        try {
            this.trainingModuleService.updateTrainingModule(trainingModule, id);

        } catch (Exception e) {
            e.printStackTrace();
            this.trainingModuleService.updateTrainingModule(trainingModule, id);
        }
    }

//    @GetMapping("/{id}/assignedemployees")
//public List<String>getAssignedEmployee(@PathVariable("id") long id){
//        return trainingModuleService.getAssignedEmployees(id);
//    }
//
//    @PostMapping("/{mid}/assign/{eid}")
//    public void assign(@PathVariable long mid,@PathVariable long eid){
//        trainingModuleService.assignToEmployees(mid,eid);
//    }
//
//    @PostMapping("/{mid}/unassign/{eid}")
//    public void unassign(@PathVariable long mid,@PathVariable long eid){
//        trainingModuleService.unassignFromEmployees(mid,eid);
//    }


}