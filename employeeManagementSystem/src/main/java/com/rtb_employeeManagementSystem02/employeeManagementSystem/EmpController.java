// This is control layer
// The work of this layer is just handling request and 
// call service layer(Bussiness logic layer where bussiness
//  logic is written) for appropriate service and data 
// base interacts with service layer[bussiness layer]

// *** Here Control layer depends on service layer 
package com.rtb_employeeManagementSystem02.employeeManagementSystem;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("https://realtime-backend-project-fronted-production.up.railway.app/")
public class EmpController {

    // Object can be made from interface but the memory allocation
    // done will be according to the class that implements interface
    // EmployeeService employeeService = new EmployeeServiceImpl();

    @Autowired
    EmployeeService employeeService;

    // Get for reading
    // To map method to url this getmapping,putmapping or sevral mapping used
    @GetMapping(".app/")
    public List<Employee> getAllEmployees() {
        // service layer method used
        return employeeService.readEmployees();
    }

    @GetMapping(".app/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        // service layer method used
        return employeeService.readEmployee(id);
    }

    // Post for creating
    @PostMapping(".app/")
    // Here @RequestBody is denoted as HTML body. From body request
    // is sent
    public String createEmployee(@RequestBody Employee employee) {
        // employees.add(employee);
        return employeeService.creatEmployee(employee);
    }

    @DeleteMapping(".app/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id))
            return "Deleted Successfully";

        return "Not found";
    }

    /*
     * From url path Id is taken and from body of
     * web page updated employ entity will be taken
     */
    @PutMapping(".app/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

}
