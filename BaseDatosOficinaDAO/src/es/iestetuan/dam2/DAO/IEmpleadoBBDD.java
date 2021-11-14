package es.iestetuan.dam2.DAO;

import es.iestetuan.dam2.vo.Empleado;

public interface IEmpleadoBBDD {

	public void crearEmpleado(Empleado empleado);
	public void modificarEmpleado(Empleado empleado);
	public void borrarEmpleado(int idEmpleado);
	public void consultarEmpleado(int idEmpleado);
	public void consultarApellidoSalario(String apellido,Float salario);
}
