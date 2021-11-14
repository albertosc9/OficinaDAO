package es.iestetuan.dam2.Conectores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.iestetuan.dam2.DAO.IEmpleadoBBDD;
import es.iestetuan.dam2.vo.Empleado;

public class EmpleadoJDBC implements IEmpleadoBBDD{

	private static String driver = "org.mariadb.jdbc.Driver";
	private static  String url = "jdbc:mariadb://localhost:3306/oficina";
	
	
	
	private Connection conectar() {
		
		String user = "root";
		String pass = "";
		
		Connection conexion= null;
		
		
		try {
			Class.forName(driver);
			
			
			conexion = DriverManager.getConnection(url, user, pass);
			
			
			
			if (conexion!=null) {
				System.out.println("conexión establecida");
			}else {
				System.out.println("fallo conexión");
			}
			
			
	
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conexion;
	}
	
	
	
	
	
	
	public void crearEmpleado(Empleado empleado) {
		
		Connection conexion = conectar();
		
		
		try {
		
			PreparedStatement pstm = conexion.prepareStatement("insert into empleados values (?,?,?,?,?,?,?,?)");
		
		
			pstm.setInt(1,empleado.getEmp_no());
			pstm.setString(2,empleado.getApellido());
			pstm.setString(3, empleado.getOficio());
			pstm.setInt(4,empleado.getDir());
			pstm.setDate(5,(Date) empleado.getDate());
			pstm.setFloat(6, empleado.getSalario());
			pstm.setFloat(7,empleado.getComision());
			pstm.setInt(8,empleado.getDept_no());
		
		
		
		int x = pstm.executeUpdate();
		
		if (x>0) {
			System.out.println("inserción correcta");
		}else
			System.out.println("fallo en la inserción");
		
		
		
		conexion.close();
		
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

	public void modificarEmpleado(Empleado empleado) {
		
		Connection conexion = conectar();
		
		try {
			PreparedStatement pstm = conexion.prepareStatement("update empleados set apellido = ?, oficio = ?, dir = ?, fecha_alt = ?, salario = ?, comision = ?, "
					+ "dept_no = ? where emp_no = ?;" );
		
		
		pstm.setString(1, empleado.getApellido());
		pstm.setString(2, empleado.getOficio());
		pstm.setInt(3, empleado.getDir());
		pstm.setDate(4, (Date) empleado.getDate());
		pstm.setFloat(5,empleado.getSalario());
		pstm.setFloat(6,empleado.getComision());
		pstm.setInt(7,empleado.getDept_no());
		pstm.setInt(8,empleado.getEmp_no());
		
		if (empleado.getComision()==0) {
		
			pstm.setNull(6, (int) empleado.getComision());
		}
		int x = pstm.executeUpdate();
		
		if (x>0)
			System.out.println("modificación correcta");
		else 
			System.out.println("fallo en la modificación");
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void borrarEmpleado(int idEmpleado) {
	
		Connection conexion = conectar();
		
		
		try {
			PreparedStatement pstm = conexion.prepareStatement("delete from empleados where emp_no = ?");
			
			
			pstm.setInt(1, idEmpleado);
			
			
			int x = pstm.executeUpdate();
			
			if (x>0) {
				System.out.println("borrado realizado");
			}else 
				System.out.println("fallo en el borrado");
			
			
			
			
			conexion.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void consultarEmpleado(int idEmpleado) {
		
		Connection conexion = conectar();
		
		try {
			PreparedStatement pstm = conexion.prepareStatement("select * from empleados where emp_no = ?");
		
			pstm.setInt(1, idEmpleado);
		
		
			int x = pstm.executeUpdate();
			
			if (x==0)
				System.out.println("fallo en la consulta");
		
		
		
		conexion.close();
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void consultarApellidoSalario(String apellido, Float salario) {
		
		Connection conexion = conectar();
		
		
		try {
			CallableStatement call = conexion.prepareCall("{call consultarEmpleadosApellidoSalario(?,?)");
			
			call.setFloat(1,salario);
			call.setString(2, apellido);
			
			call.execute();
			
			ResultSet result = call.getResultSet();
			
			while (result.next()) {
				System.out.println("numero empleado "+result.getInt(1) );
				System.out.println("apellido empleado: "+apellido);
				System.out.println("oficio "+result.getString(3));
				System.out.println("dir "+result.getInt(4));
				System.out.println("fecha_alt "+result.getDate(5));
				System.out.println("salario "+salario);
				System.out.println("comision "+result.getFloat(7));
				System.out.println("numero departamento "+result.getInt(8));
			}
			
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
