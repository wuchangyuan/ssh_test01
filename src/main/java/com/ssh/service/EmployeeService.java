package com.ssh.service;

import com.ssh.dao.EmployeeDao;
import com.ssh.pojo.Dept;
import com.ssh.pojo.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;


    public void addEmp(Employee employee, Integer id) {
        employeeDao.addEmployee(employee,id);
    }

    public List<Dept> queryDepts() {
        List<Dept> list = employeeDao.queryDepts();
        return list;
    }

    public List<Employee> queryEmps() {
        List<Employee> list = employeeDao.queryEmps();
        return  list;
    }

    public List<Employee> queryEmpByCriteria(DetachedCriteria criteria) {
        List<Employee> list = employeeDao.queryEmpsByCriteria(criteria);
        return list;
    }
}
