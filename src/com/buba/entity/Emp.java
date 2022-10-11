package com.buba.entity;

public class Emp {
    private Integer empId;
    private Integer dept;
    private String empName;
    private String empIdNumber;
    private Integer empAge;
    private String empSex;
    private Integer lockOut;

    public Emp() {
    }

    public Emp(Integer empId, Integer dept, String empName, String empIdNumber, Integer empAge, String empSex, Integer lockOut) {
        this.empId = empId;
        this.dept = dept;
        this.empName = empName;
        this.empIdNumber = empIdNumber;
        this.empAge = empAge;
        this.empSex = empSex;
        this.lockOut = lockOut;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpIdNumber() {
        return empIdNumber;
    }

    public void setEmpIdNumber(String empIdNumber) {
        this.empIdNumber = empIdNumber;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public Integer getLockOut() {
        return lockOut;
    }

    public void setLockOut(Integer lockOut) {
        this.lockOut = lockOut;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", dept=" + dept +
                ", empName='" + empName + '\'' +
                ", empIdNumber='" + empIdNumber + '\'' +
                ", empAge=" + empAge +
                ", empSex='" + empSex + '\'' +
                ", lockOut=" + lockOut +
                '}';
    }
}
