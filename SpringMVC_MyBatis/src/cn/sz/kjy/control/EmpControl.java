package cn.sz.kjy.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sz.kjy.biz.EmpBiz;
import cn.sz.kjy.pojo.Emp;

@Controller
@RequestMapping("ec")
public class EmpControl {
	private EmpBiz empBizImpl;
	@RequestMapping(value="el")
	public String Emplist(HttpSession session){
		System.out.println("进入EmpList方法");
		List<Emp> emplist=empBizImpl.findEmpList();
		session.setAttribute("emplist", emplist);
		system.out.print("asdasdasd");
		return "EmpList";
	}
	
	@ResponseBody
	@RequestMapping(value="fe",method=RequestMethod.POST)
	public String findEmpName(String ename){
		System.out.println("获取页面的ename:"+ename);
		int num=empBizImpl.countEname(ename);
		System.out.println(num);
		boolean flag=num>0?true:false;
		System.out.println(flag+"");
		return flag+"";
	}
	@RequestMapping(value="ff")
	public String aaa(){
		return "add";
	}
	
	
	
	public EmpBiz getEmpBizImpl() {
		return empBizImpl;
	}
	public void setEmpBizImpl(EmpBiz empBizImpl) {
		this.empBizImpl = empBizImpl;
	}
	
}	
