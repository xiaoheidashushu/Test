package cn.sz.kjy.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import cn.sz.kjy.dao.EmpDao;
import cn.sz.kjy.pojo.Emp;
@Service
public class EmpDaoImpl extends SqlSessionDaoSupport implements EmpDao{

	@Override
	public List<Emp> findEmpList() {
		return super.getSqlSession().selectList("cn.sz.kjy.pojo.Emp.listEmp");
	}

	@Override
	public Map<String, Integer> pageing(int cp, int ps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmp() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int countEname(String ename) {
		return super.getSqlSession().selectOne("cn.sz.kjy.pojo.Emp.addEmp",ename);
	}

}
