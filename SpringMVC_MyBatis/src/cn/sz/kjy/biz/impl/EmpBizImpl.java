package cn.sz.kjy.biz.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sz.kjy.biz.EmpBiz;
import cn.sz.kjy.dao.EmpDao;
import cn.sz.kjy.pojo.Emp;
@Service
public class EmpBizImpl implements EmpBiz{
	private EmpDao empDaoImpl;
	@Override
	public List<Emp> findEmpList() {
		return empDaoImpl.findEmpList();
	}
	
	@Override
	public int countEname(String ename) {
		if (ename==null) {
			return 0;
		}
		return empDaoImpl.countEname(ename);
	}
	public EmpDao getEmpDaoImpl() {
		return empDaoImpl;
	}
	public void setEmpDaoImpl(EmpDao empDaoImpl) {
		this.empDaoImpl = empDaoImpl;
	}

	

}
