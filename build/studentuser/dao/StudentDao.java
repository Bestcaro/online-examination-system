package edu.nenu.onlineExam.studentuser.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import edu.nenu.onlineExam.studentuser.entity.student;


public class studentUserDao extends HibernateDaoSupport{
	
	//����Ա��¼��֤
	public student login(student student) {
		String hql = "from student where tid = ? and password = ?";
		List<student> list = (List<student>) this.getHibernateTemplate().find(hql, student.getTid(),student.getPassword());
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	public void updatePW(Integer tid, String npw) {
		String hql = "from student where tid =? ";
		student student = null;
		List<student> list = (List<student>) this.getHibernateTemplate().find(hql, tid);
		if(list != null && list.size()>0){
			student = (student)list.get(0);
		}
		student.setPassword(npw);
		this.getHibernateTemplate().save(student);
	}
	
	public void addstudent(student student)
	{
		this.getHibernateTemplate().save(student);
	}
	public void deletestudent(Integer tid )
	{		
		String hql = "from student where tid =? ";
	    student student = null;
	   List<student> list = (List<student>) this.getHibernateTemplate().find(hql, tid);
	    if(list != null && list.size()>0){
		 this.getHibernateTemplate().delete(list.get(0));
     	}
		
	}
}
