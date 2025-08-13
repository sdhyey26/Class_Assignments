package com.tss.model;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
    private int empNo;
    private String eName;
    private String job;
    private int mgr;
    private Date hireDate;
    private BigDecimal sal;
    private BigDecimal comm;
    private int deptNo;

    public int getEmpNo() { return empNo; }
    public void setEmpNo(int empNo) { this.empNo = empNo; }

    public String getEName() { return eName; }
    public void setEName(String eName) { this.eName = eName; }

    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }

    public int getMgr() { return mgr; }
    public void setMgr(int mgr) { this.mgr = mgr; }

    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }

    public BigDecimal getSal() { return sal; }
    public void setSal(BigDecimal sal) { this.sal = sal; }

    public BigDecimal getComm() { return comm; }
    public void setComm(BigDecimal comm) { this.comm = comm; }

    public int getDeptNo() { return deptNo; }
    public void setDeptNo(int deptNo) { this.deptNo = deptNo; }
}
