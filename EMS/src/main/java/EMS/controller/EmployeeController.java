package EMS.controller;

import EMS.entity.Employee;
import EMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @GetMapping("/get")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
    @PostMapping("/insert")
    public Employee InsertEmployee( @RequestBody Employee emp) {
        return service.SaveEmployee(emp);
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Employee> GetEmployee(@PathVariable int id) {
        return service.getEmployeeById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> DeleteEmployee(@PathVariable int id) {
        service.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }
@PutMapping("/update/{id}")
    public ResponseEntity<Employee> UpdateEmployee(@PathVariable int id,@RequestBody Employee emp) {
        return service.getEmployeeById(id)
                .map(existing->{
                    existing.setName(emp.getName());
                    existing.setDepartment(emp.getDepartment());
                    existing.setSalary(emp.getSalary());

                    return ResponseEntity.ok(service.SaveEmployee(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
