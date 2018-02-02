package com.ssh.controller;

import com.ssh.pojo.Dept;
import com.ssh.service.DeptService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class DeptController {

    @Autowired
    private DeptService service;
    @RequestMapping("addDept.html")
    public String addDeptJsp(){
        return "addDept";
    }
    @RequestMapping("addDept.do")
    public String addDept(@ModelAttribute("name") String name){
        Dept dept = new Dept();
        dept.setName(name);
        service.addDept(dept);
        return "success";
    }

    @RequestMapping("queryDept.do")
    public ModelAndView queryDept(String name, Model model){
        DetachedCriteria criteria = DetachedCriteria.forClass(Dept.class);
        criteria.add(Restrictions.eq("name",name));
        List<Dept> list = service.queryDeptByName(criteria);
        if (list!=null&&list.size()>0){
            model.addAttribute("msg","部门名称已经存在");
            //return new RedirectView("addDep", true, false, true);
            return new ModelAndView("addDept");
        }else{
            model.addAttribute("name",name);
            return new ModelAndView("forward:/addDept.do");
        }

    }
}
