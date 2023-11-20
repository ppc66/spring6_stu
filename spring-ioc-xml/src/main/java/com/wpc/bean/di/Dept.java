package com.wpc.bean.di;

import java.util.List;

/**
 * @author wpc
 * @date 2023/10/10 14:12
 */
public class Dept {
    private String dname;
    private List<Employee> empList;

    public String getDname() {
        return dname;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public void info(){
        System.out.println("dname = " + dname);
        for (Employee employee : empList){
            System.out.println("employee = " + employee);
        }
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                ", empList=" + empList +
                '}';
    }
}
