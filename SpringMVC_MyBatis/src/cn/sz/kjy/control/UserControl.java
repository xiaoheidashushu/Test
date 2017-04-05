package cn.sz.kjy.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.sz.kjy.biz.UserBiz;
import cn.sz.kjy.pojo.User;

@Controller
@RequestMapping("uc")
public class UserControl {
	
	private UserBiz userBizImpl;
	
	@RequestMapping(value="islogin",method=RequestMethod.POST)
	public String checkLogin(User user,HttpSession session){
		System.out.println("进入checkLogin方法");
		System.out.println(user.getUsername()+"--"+user.getUserpassword());
		User u=userBizImpl.isLogin(user);
		if (u!=null) {
			session.setAttribute("u", u);
			return "main";
		}
		return "index";
	}
	public UserBiz getUserBizImpl() {
		return userBizImpl;
	}
	public void setUserBizImpl(UserBiz userBizImpl) {
		this.userBizImpl = userBizImpl;
	}
	
}	
