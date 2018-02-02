package com.ssh.dao;

import com.ssh.pojo.Dept;
import com.ssh.pojo.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao extends HibernateDaoSupport{
    public void addEmployee(Employee employee, Integer id){
        Dept dept = getHibernateTemplate().get(Dept.class, id);
        dept.getEmployees().add(employee);
        employee.setDept(dept);
        getHibernateTemplate().persist(employee);
    }

    public List<Dept> queryDepts() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Dept.class);
        List<Dept> list = (List<Dept>) getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    public List<Employee> queryEmps() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        List<Employee> list = (List<Employee>) getHibernateTemplate().findByCriteria(criteria);
        return list;
    }

    public List<Employee> queryEmpsByCriteria(DetachedCriteria criteria) {
        List<Employee> list = (List<Employee>) getHibernateTemplate().findByCriteria(criteria);
        return list;
    }
}
