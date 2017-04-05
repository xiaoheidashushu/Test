package cn.sz.kjy.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import cn.sz.kjy.dao.UserDao;
import cn.sz.kjy.pojo.User;

@Service
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User isLogin(User user) {
		return super.getSqlSession().selectOne("cn.sz.kjy.pojo.User.checklogin", user);
	}

}
