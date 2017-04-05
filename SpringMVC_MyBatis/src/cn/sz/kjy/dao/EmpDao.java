package cn.sz.kjy.dao;

import java.util.List;
import java.util.Map;

import cn.sz.kjy.pojo.Emp;

public interface EmpDao {
	public List<Emp> findEmpList();
	public Map<String,Integer> pageing(int cp,int ps);
	public int countEmp();
	public int countEname(String ename);
}
