package com.ssh.dao;

import com.ssh.pojo.Dept;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DeptDao extends HibernateDaoSupport{
    public void addDept(Dept dept){
        getHibernateTemplate().save(dept);
    }

    public List<Dept> queryDeptByName(DetachedCriteria criteria) {

        List<Dept> list = (List<Dept>) getHibernateTemplate().findByCriteria(criteria);
        return list;
    }
}
