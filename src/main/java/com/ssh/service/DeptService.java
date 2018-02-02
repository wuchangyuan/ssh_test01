package com.ssh.service;

import com.ssh.dao.DeptDao;
import com.ssh.pojo.Dept;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DeptService {
    @Autowired
    private DeptDao deptDao;

    public List<Dept> queryDeptByName(DetachedCriteria criteria) {
        List<Dept> list = deptDao.queryDeptByName(criteria);
        return list;
    }

    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }
}
