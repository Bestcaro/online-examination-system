package edu.nenu.onlineExam.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import edu.nenu.onlineExam.studentuser.dao.studentDao;
import edu.nenu.onlineExam.studentuser.entity.student;

@Transactional
public class studentService {
	
	private studentDao studentUserDao;

	public void setstudentDao(studentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	//����Ա��¼��֤
	public student login(student student) {
		return studentDao.login(student);
	}

	public void updatePW(Integer tid, String npw) {
		studentDao.updatePW(tid,npw);
	}

	public void deletestudent(Integer tid)
	{
		studentDao.deletestudent(tid);
	}
	
	public void addstudent(student student)
	{
		studentDao.addstudent(student);
	}
}
