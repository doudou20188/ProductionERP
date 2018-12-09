package com.cskaoyan.controller.employee;



import com.cskaoyan.domain.employee.Department;
import com.cskaoyan.service.employee.DepartmentService;
import com.cskaoyan.util.CustomResult;
import com.cskaoyan.util.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    /**
     * 权限判断，具体代码需要补充
     * @return
     */
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



    @RequestMapping("/get_data")
    @ResponseBody
    public List<Department> getData() {
        return departmentService.selectAllDepartments();
    }

    @RequestMapping("/find")
    public String find(HttpSession session){
        String[] sysPermissionList = {"department:add","department:edit","department:delete"};
        session.setAttribute("sysPermissionList",sysPermissionList);
        return "department_list";
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
    public EUDataGridResult getDepartmentList(@RequestParam("page") Integer page,
                                              @RequestParam("rows") Integer rows) throws IOException {
        System.out.println("page = " + page + ", rows = " + rows);
        EUDataGridResult result = departmentService.getDepartmentList(page, rows);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/add")
    public String add(){
        return "department_add";
    }

    @RequestMapping("/edit")
    public String edit(){
        return "department_edit";
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
    private CustomResult insert(@Valid Department department,
                                BindingResult bindingResult){
        CustomResult result;

        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }

        System.out.println("department = " + department);

        //如果id重复，就添加信息员工编号已存在
        //否则就插入到数据库中
        if (departmentService.getDepartmentById(department.getDepartmentId()) != null) {
            result = new CustomResult(0, "该员工编号已经存在，请更换员工编号！",null);
        } else {
            result = departmentService.insert(department);
        }
        return result;
    }

    @RequestMapping("/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid Department department,
                                   BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }

        return departmentService.updateAll(department);
    }

    @RequestMapping("/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids){
        CustomResult result = departmentService.deleteBatch(ids);
        return result;
    }

    /**
     * 下两个方法实现部门搜索功能
     */

    //根据部门id查找
    @RequestMapping("/search_department_by_departmentId")
    @ResponseBody
    public EUDataGridResult searchDepartmentByDepartmentId(Integer page, Integer rows, String searchValue){
        EUDataGridResult result = departmentService.searchDepartmentByDepartmentId(page, rows, searchValue);
        return result;
    }


    //根据部门名字找
    @RequestMapping("/search_department_by_departmentName")
    @ResponseBody
    public EUDataGridResult searchDepartmentByDepartmentName(Integer page, Integer rows, String searchValue){
        EUDataGridResult result = departmentService.searchDepartmentByDepartmentName(page, rows, searchValue);
        return result;
    }


}
