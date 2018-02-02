package com.ssh.controller;

import com.ssh.pojo.Dept;
import com.ssh.pojo.Employee;
import com.ssh.service.EmployeeService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @RequestMapping("list.html")
    public String listJsp(){
        return "list";
    }

    @RequestMapping("addEmp.do")
    public String addEmp(Employee employee,Integer ID){
        if (ID!=null){
            service.addEmp(employee,ID);
        }

        return "redirect:/list.do";
    }

    @RequestMapping("list.do")
    public ModelAndView empList(){
        List<Employee> list =  service.queryEmps();
        return new ModelAndView("list","employeeList",list);
    }

    @RequestMapping("queryEmp.do")
    public String queryEmp(Employee employee, Map map){
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        if (employee!=null){
            if (null != employee.getName()&&employee.getName().trim().length()>0){
                criteria.add(Restrictions.like("name","%"+employee.getName()+"%"));
            }
            if (employee.getId()!=null){
                criteria.add(Restrictions.idEq(employee.getId()));
            }
        }
        List<Employee> list = service.queryEmpByCriteria(criteria);
        map.put("employeeList",list);
        return "list";
    }

    @RequestMapping("queryDepts.do")
    public String queryDepts(Model model){
        List<Dept> list =  service.queryDepts();
        model.addAttribute("deptList",list);
        return "addEmp";
    }
}
