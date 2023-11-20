package com.wpc.bean.di;

/**
 * @author wpc
 * @date 2023/10/10 14:12
 */
public class Employee {
    private String ename;
    private Integer age;
    private String[] hobbies;

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    //员工属于每个部门
    private Dept dept;
    public void work(){
        System.out.println(ename + "员工正在工作" + age);
        dept.info();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ename='" + ename + '\'' +
                ", age=" + age +
                ", dept="  +
                '}';
    }
}
