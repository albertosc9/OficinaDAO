package es.iestetuan.dam2.DAO;

import es.iestetuan.dam2.vo.Departamento;

public interface IDepartamentoBBDD {

	public  void crearDepartamento(Departamento departamento);
	public void modificarDepartamento(Departamento departamento);
	public void borrarDepartamento(int idDepartamento);
	public void consultarDepartamento(int idDepartamento);
	
	
}
