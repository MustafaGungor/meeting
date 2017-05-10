package tr.com.mebitech.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.com.mebitech.entity.Department;
import tr.com.mebitech.entity.Employee;
import tr.com.mebitech.service.interfaces.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="get",method = RequestMethod.GET)
	public List<Employee> findAll(){
		return employeeService.getAllEmployee();
	}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public Employee insertEmployee(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@RequestMapping(value="delete", method=RequestMethod.POST)
	public boolean deleteEmployee(@RequestBody Employee employee) {
		return employeeService.deleteEmployee(employee);
	}

	@RequestMapping(value="getall", method=RequestMethod.POST)
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}
}
