package es.iestetuan.dam2.app;


import java.sql.Date;

import es.iestetuan.dam2.Conectores.DepartamentosJDBC;
import es.iestetuan.dam2.Conectores.EmpleadoJDBC;
import es.iestetuan.dam2.vo.Departamento;
import es.iestetuan.dam2.vo.Empleado;

public class Aplicativo {

	public static void main(String[] args) {
		
		DepartamentosJDBC depJDBC = new DepartamentosJDBC();
		EmpleadoJDBC empJDBC = new EmpleadoJDBC();
		
		
		Departamento d1 = new Departamento(50,"Informatica","Madrid");
//		Departamento d2 = new Departamento(60,"Comunicaciones","Madrid");
//		Departamento d3 = new Departamento(60,"Informatica y Comunicaciones","Bilbao");
		Empleado e1 = new Empleado(8001,"Justo","Prog.MP",7782,new Date(2021-11-10),(float) 1570,0,50);
		
//		depJDBC.crearDepartamento(d1);
//		depJDBC.crearDepartamento(d2);
//		depJDBC.modificarDepartamento(d3);
//		depJDBC.modificarDepartamento(new Departamento(50,"TIC",null));
//		depJDBC.borrarDepartamento(60);
//		depJDBC.consultarDepartamento(50);
		
		empJDBC.consultarApellidoSalario("justo",(float) 1570);
	
	
//		empJDBC.crearEmpleado(new Empleado(8001,"Justo","Prog.MP",7782,new Date(2021-11-10),(float) 1570,0,50));
		empJDBC.consultarEmpleado(8001);
		empJDBC.borrarEmpleado(7499);
		empJDBC.modificarEmpleado(e1);
		
		
		
		
		
		
	}

}
