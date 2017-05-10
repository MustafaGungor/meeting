package tr.com.mebitech.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tr.com.mebitech.entity.Department;
import tr.com.mebitech.service.interfaces.DepartmentService;

@RestController
@RequestMapping("department")
public class DepartmentRestController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value="get",method = RequestMethod.GET)
	public List<Department> findAll(){
		return departmentService.getAllDepartment();
	}
	
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public Department insertDepartment(@RequestBody Department Department) {
		return departmentService.insertDepartment(Department);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public Department updateDepartment(@RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}

	@RequestMapping(value="delete", method=RequestMethod.POST)
	public boolean deleteDepartment(@RequestBody Department department) {
		return departmentService.deleteDepartment(department);
	}

	@RequestMapping(value="getall", method=RequestMethod.POST)
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartment();
	}
}
