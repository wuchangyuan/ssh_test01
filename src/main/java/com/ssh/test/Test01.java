package com.ssh.test;

import com.ssh.pojo.Dept;
import com.ssh.pojo.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

public class Test01 {
    @Test
    public void test01(){
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        try {
            Dept dept = new Dept();
            dept.setId(1);
            dept.setName("技术部");

            Employee employee = new Employee();
            employee.setId(1);
            employee.setDept(dept);
            employee.setName("张三");
            employee.setHireDate(new Date());
            dept.getEmployees().add(employee);
            session.persist(dept);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            if (transaction!=null){
                transaction.rollback();
            }
        }
    }
}
