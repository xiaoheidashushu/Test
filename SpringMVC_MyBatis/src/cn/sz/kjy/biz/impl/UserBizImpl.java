package cn.sz.kjy.biz.impl;

import org.springframework.stereotype.Service;

import cn.sz.kjy.biz.UserBiz;
import cn.sz.kjy.dao.UserDao;
import cn.sz.kjy.pojo.User;
@Service
public class UserBizImpl implements UserBiz{
	private UserDao userDaoImpl;
	@Override
	public User isLogin(User user) {
		if (user==null||user.getUsername()==null||user.getUserpassword()==null) {
			return null;
		}
		return userDaoImpl.isLogin(user);
	}
	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

}
