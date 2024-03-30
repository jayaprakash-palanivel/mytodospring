package com.jp.todo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jp.todo.bo.EmployeeBo;
import com.jp.todo.vo.EmployeeVo;
import com.jp.todo.vo.ProjectVo;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();

	}

	@Override
	public EmployeeVo createEmployee(EmployeeVo employeeVo) {
		Session session = getSession();
		int employeeid =  (int) session.save(employeeVo);
		if (0<employeeid) {
			return employeeVo;
		}
		return null;
	}

	@Override
	public List<EmployeeVo> retriveEmployeeList() {
		Session session=getSession();
		Criteria cr=session.createCriteria(EmployeeVo.class);
		cr.add(Restrictions.eq("isDelete", false));
		List<EmployeeVo> employeeList=cr.list();
		if(null!=employeeList) {
			return employeeList;
		}
		return null;
	}

	@Override
	public EmployeeVo retriveEmployeeBasedOnId(int employeeId) {
		Session session=getSession();
		EmployeeVo employeeVo=(EmployeeVo) session.get(EmployeeVo.class, employeeId);
		if(null!=employeeVo) {
			return employeeVo;
		}
		return null;
	}

	@Override
	public void updateEmployee(EmployeeVo employeeVo) {
		Session session=getSession();
		session.update(employeeVo);
		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Session session=sessionFactory.getCurrentSession();
		EmployeeVo employeeVo=(EmployeeVo) session.get(EmployeeVo.class, employeeId);
		if(null!=employeeVo) {
			employeeVo.setIsDelete(true);
			session.update(employeeVo);
		}
		
	}

	@Override
	public long retriveCount() {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(EmployeeVo.class);
		cr.setProjection(Projections.rowCount());
		long empId = (long) cr.uniqueResult();
		if(0<empId) {
			return empId;
		}
		return 0;
	}

	@Override
	public List<EmployeeVo> retriveEmployeeByPagination(EmployeeBo employeeBo) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(EmployeeVo.class);
		cr.add(Restrictions.eq("isDelete", false));
		cr.setFirstResult(employeeBo.getStartingRecordIndex());
		cr.setMaxResults(employeeBo.getMaxRecord());
		//cr.addOrder(Order.desc("id"));
		List employeeVOList = cr.list();
		return employeeVOList;
	}

}
