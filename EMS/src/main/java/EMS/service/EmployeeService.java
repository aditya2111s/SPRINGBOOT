package EMS.service;


import EMS.entity.Employee;
import EMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee SaveEmployee(Employee emp) {
        return repo.save(emp);
    }

    public Optional<Employee> getEmployeeById(int id){
        return repo.findById(id);
    }

    public void deleteEmployeeById(int id){
        repo.deleteById(id);
    }
}
