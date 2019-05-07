package edu.nenu.onlineExam.student.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import edu.nenu.onlineExam.studentuser.entity.student;
import edu.nenu.onlineExam.studentuser.service.studentUserService;
 

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class studentAction extends ActionSupport implements ModelDriven<student> ,SessionAware{
	private student student = new student();
	private studentService studentService;
	
	public void sestudentService(studentService studentService) {
		this.studentService = studentService;
	}

	public student getModel() {
		return student;
	}
	
	private String npw;
	public void setNpw(String npw) {
		this.npw = npw;
	}

	
	public String alogin(){
		return "alogin";
	}
	
	
	public String login(){
		
		student existstudent = studentService.login(student);
		
		if(existAdmin == null){
			this.addActionError("����Ա��Ż��������");
			return "loginFailadmin";
		}else{
			
			ServletActionContext.getRequest().getSession().setAttribute("existstudent", existstudent);
			return "loginSuccessadmin";	
		}		
	}
	//�鿴����Ա��Ϣ
	public String ckxx(){
		return "ckxxstudent";
	}
	//�޸�����
	public String upw(){
		return "upwstudent";
	}
	public String updatePW(){
		studentService.updatePW(student.getUid(),npw);
		return "updatestudentPW";
	}
	
	public String addstudent()  {
		
		studentService.addstudent(student);
	}
	
	public string deletestudent(Integer tid)
	{
		studentService.deletestudent(tid)；
	}
	
	//��ȫ�˳����session
	public String sessionDestory(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "sessionDestorystudent";
	}

	public void setSession(Map<String, Object> arg0) {
	}
}
