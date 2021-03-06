package cn.sz.kjy.pojo;

// Generated 2017-3-20 11:07:05 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;


/**
 * Dept generated by hbm2java
 */
public class Dept implements java.io.Serializable {

	private Integer deptno;
	private String dname;
	private String loc;
	private Set<Emp> emps = new HashSet<Emp>(0);

	public Dept() {
		
	}

	public Dept(String dname, String loc, Set<Emp> emps) {
		this.dname = dname;
		this.loc = loc;
		this.emps = emps;
	}

	public Integer getDeptno() {
		return this.deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return this.dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Set<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}
