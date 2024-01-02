package Employee.Management.System.controller;

import Employee.Management.System.model.Employee;
import Employee.Management.System.repository.EmployeersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeersController {

    @Autowired
    private EmployeersRepository employeersRepository;


    @PostMapping("/register")
    public ResponseEntity<Employee> registerEmployeer(@RequestBody Employee employee){

       Employee employeeObj = employeersRepository.save(employee);

       return new ResponseEntity<>(employeeObj, HttpStatus.OK);

    }

    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployeerById(@PathVariable Long id,
                                                        @RequestBody Employee newEmployeeData){

        Optional<Employee> oldEmployeeData = employeersRepository.findById(id);

        if(oldEmployeeData.isPresent()){

            Employee updateEmployeerData = oldEmployeeData.get();
            updateEmployeerData.setSalary(newEmployeeData.getSalary());

            Employee employeeObj = employeersRepository.save(updateEmployeerData);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @GetMapping("/getEmployeerById/{id}")
    public ResponseEntity<Employee> getEmployeerById(@PathVariable Long id){

      Optional<Employee>  employeeData = employeersRepository.findById(id);

        return employeeData.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/employeers")
    public ResponseEntity<List<Employee>> getEmployeersList(){

        try{

            List<Employee> employeeList = new ArrayList<>(employeersRepository.findAll());

            if(employeeList.isEmpty()){
                return new ResponseEntity<>(employeeList, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @DeleteMapping
    public void deleteEmployeer(){

    }

}
