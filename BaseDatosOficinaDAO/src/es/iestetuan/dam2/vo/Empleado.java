package es.iestetuan.dam2.vo;

import java.util.Date;

public class Empleado {

	private int emp_no;
	private String apellido;
	private String oficio;
	private int dir;
	private Date date;
	private float salario;
	private float comision;
	private int dept_no;
	
	
	
	
	public Empleado(int emp_no, String apellido, String oficio, int dir, Date date, float salario, float comision,
			int dept_no) {
		this.emp_no = emp_no;
		this.apellido = apellido;
		this.oficio = oficio;
		this.dir = dir;
		this.date = date;
		this.salario = salario;
		this.comision = comision;
		this.dept_no = dept_no;
	}




	public int getEmp_no() {
		return emp_no;
	}




	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getOficio() {
		return oficio;
	}




	public void setOficio(String oficio) {
		this.oficio = oficio;
	}




	public int getDir() {
		return dir;
	}




	public void setDir(int dir) {
		this.dir = dir;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public float getSalario() {
		return salario;
	}




	public void setSalario(float salario) {
		this.salario = salario;
	}




	public float getComision() {
		return comision;
	}




	public void setComision(float comision) {
		this.comision = comision;
	}




	public int getDept_no() {
		return dept_no;
	}




	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}
	
}
