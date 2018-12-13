package com.cskaoyan.controller.employee;



import com.cskaoyan.domain.employee.Department;
import com.cskaoyan.domain.employee.Employee;
import com.cskaoyan.service.employee.DepartmentService;
import com.cskaoyan.service.employee.EmployeeService;
import com.cskaoyan.util.CustomResult;
import com.cskaoyan.util.EUDataGridResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    /**
     * @return 右区域跳转到employee_list页面
     * 跳转到list页面之后，再调用list方法，到时候再查询员工信息并添加到session中
     */
    @RequestMapping("/find")
    public String find(HttpSession session){
        return "employee_list";
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Employee> getData(){
        return employeeService.findAllEmployees();
    }

    @RequestMapping("/get/{empId}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable String empId) {
        Employee employee= employeeService.getEmployeeById(empId);
        return employee;
    }

    /**
     *  借助PageHelper工具
     * @param page 第几页
     * @param rows 每一页有几行
     * @return
     * @throws IOException
     */

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getEmployeeList(@RequestParam("page") Integer page,
                                            @RequestParam("rows") Integer rows) throws IOException {
        System.out.println("page = " + page + ", rows = " + rows);
        EUDataGridResult result = employeeService.getEmployeeList(page, rows);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "{}";
    }

    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "{}";
    }

    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "{}";
    }

    @RequestMapping("/add")
    @RequiresPermissions(value = {"employee:add"})
    public String add(){
        return "employee_add";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "employee_edit";
    }

    /**
     *
     * @param employee
     * @param department    为了接受departmentId这个参数
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid Employee employee,
                                Department department, BindingResult bindingResult){
        CustomResult result;

        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }

        //这句话必须加上，不然就会出现bug
        department = departmentService.getDepartmentById(department.getDepartmentId());
        employee.setDepartment(department);

        //如果id重复，就添加信息员工编号已存在
        //否则就插入到数据库中
        if (employeeService.getEmployeeById(employee.getEmpId()) != null) {
            result = new CustomResult(0, "该员工编号已经存在，请更换员工编号！",null);
        } else {
            result = employeeService.insert(employee);
        }
        return result;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid Employee employee,
                                   Department department, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }

        department = departmentService.getDepartmentById(department.getDepartmentId());
        employee.setDepartment(department);

        return employeeService.updateAll(employee);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids){
        CustomResult result = employeeService.deleteBatch(ids);
        return result;
    }

    /**
     * 下面三个方法实现条件搜索功能
     * */

    //根据员工id查找
    @RequestMapping("/search_employee_by_employeeId")
    @ResponseBody
    public EUDataGridResult searchEmployeeByEmployeeId(Integer page, Integer rows, String searchValue){
        EUDataGridResult result = employeeService.searchEmployeeByEmployeeId(page, rows, searchValue);
        return result;
    }

    //根据员工名字查找
    @RequestMapping("/search_employee_by_employeeName")
    @ResponseBody
    public EUDataGridResult searchEmployeeByEmployeeName(Integer page, Integer rows, String searchValue){
        EUDataGridResult result = employeeService.searchEmployeeByEmployeeName(page, rows, searchValue);
        return result;
    }

    //根据部门名字查找
    @RequestMapping("/search_employee_by_departmentName")
    @ResponseBody
    public EUDataGridResult searchEmployeeByDepartmentName(Integer page, Integer rows, String searchValue){
        EUDataGridResult result = employeeService.searchEmployeeByDepartmentName(page, rows, searchValue);
        return result;
    }

}
