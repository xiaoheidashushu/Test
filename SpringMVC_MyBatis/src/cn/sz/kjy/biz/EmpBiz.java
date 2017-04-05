package cn.sz.kjy.biz;

import java.util.List;

import cn.sz.kjy.pojo.Emp;

public interface EmpBiz {
	public List<Emp> findEmpList();
	public int countEname(String ename);
}
