package es.iestetuan.dam2.Conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.iestetuan.dam2.DAO.IDepartamentoBBDD;
import es.iestetuan.dam2.vo.Departamento;

public class DepartamentosJDBC implements IDepartamentoBBDD{

	
	private static String driver = "org.mariadb.jdbc.Driver";
	private static  String url = "jdbc:mariadb://localhost:3306/oficina";
	
	
	
	private static Connection conectar() {
		
		String user = "root";
		String pass = "";
		
		Connection conexion = null;
		
		try {
			Class.forName(driver);
			
			conexion = DriverManager.getConnection(url, user, pass);
			
			
			if (conexion!=null) 
				System.out.println("conexion establecida");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conexion;
		
		
		
		
	}
	public void crearDepartamento(Departamento departamento) {
		
		Connection conexion = conectar();
		
		try {
			
			PreparedStatement pstm = conexion.prepareStatement("insert into departamentos values (?,?,?)");
			
			pstm.setInt(1, departamento.getDept_no());
			pstm.setString(2,departamento.getDnombre());
			pstm.setString(3, departamento.getLoc());
			
			
			int x = pstm.executeUpdate();
			
			if (x>0) {
				System.out.println("insercion correcta");
			}else {
				System.out.println("insercion incorrecta");
			}
				
			
			
			conexion.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		

	}
	
	
}
	@Override
	public void modificarDepartamento(Departamento departamento) {
		
		Connection conexion = conectar();
		
		
		
		
		
		PreparedStatement pstm1;
		PreparedStatement pstm ;
		
		try {
			
			
			pstm1 = conexion.prepareStatement("select dept_no from departamentos where dnombre = ? and loc = ?");
			pstm1.setString(1, departamento.getDnombre());
			pstm1.setString(2, departamento.getLoc());
			
		
			
			ResultSet result = pstm1.executeQuery();
			
			
			
			
			
			pstm = conexion.prepareStatement("update departamentos set dept_no = ?, dnombre = ?, loc = ? where dept_no = ?");
			
			
			if (result.first()) {
				
				
				
				pstm.setInt(1, departamento.getDept_no());
				pstm.setString(2,departamento.getDnombre());
				pstm.setString(3, departamento.getLoc());
				pstm.setInt(4, result.getInt(1));
				int x = pstm.executeUpdate();
				
				
				if (x>0) {
					System.out.println("actualizado");
				}else {
					System.out.println("fallo actualizacion");
				}
				
				
				
			}else {
				
				pstm.setInt(1, departamento.getDept_no());
				pstm.setString(2,departamento.getDnombre());
				pstm.setString(3, departamento.getLoc());
				pstm.setInt(4, departamento.getDept_no());
				
				
				int x = pstm.executeUpdate();
				
				if (x>0) {
					System.out.println("actualizado");
				}else {
					System.out.println("fallo actualizacion");
				}
			}
			
			
			
			
			
			
			
			
			conexion.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		
//		
//		try {
//			PreparedStatement pstm1 = conexion.prepareStatement("select * from departamentos");
//			
//			
//			ResultSet result = pstm1.executeQuery();
//			
//			PreparedStatement pstm;
//			
//			while(result.next()) {
//				
//				int id = result.getInt(1);
//				String nombre;
//				String loca;
//				if (id==departamento.getDept_no()) {
//					
//					pstm = conexion.prepareStatement("update departamentos set dnombre = ?, loc = ? where dept_no = ?");
//					
//					pstm.setString(1,departamento.getDnombre());
//					pstm.setString(2, departamento.getLoc());
//					pstm.setInt(3,departamento.getDept_no());
//					
//					int x = pstm.executeUpdate();
//					
//					if (x>0)
//						System.out.println("actualizacion correcta");
//					else 
//						System.out.println("actualizacion incorrecta");
//				
//				}else if (result.getString(2)==(departamento.getDnombre())) {
//					
//					pstm = conexion.prepareStatement("update departamentos set dept_no = ?, loc = ? where dnombre like ?");
//					
//					pstm.setInt (1,departamento.getDept_no());
//					pstm.setString(2, departamento.getLoc());
//					pstm.setString(3,departamento.getDnombre());
//					
//					
//					int x = pstm.executeUpdate();
//					
//					if (x>0)
//						System.out.println("actualizacion correcta");
//					else 
//						System.out.println("actualizacion incorrecta");
//				
//				}else if (result.getString(3)==(departamento.getLoc())){
//					
//					pstm = conexion.prepareStatement("update departamentos set dept_no = ?, dnombre = ? where loc like ?");
//					
//					pstm.setInt(1,departamento.getDept_no());
//					pstm.setString(2,departamento.getDnombre());
//					pstm.setString(3,departamento.getLoc());
//
//
//					int x = pstm.executeUpdate();
//					
//					if (x>0)
//						System.out.println("actualizacion correcta");
//					else 
//						System.out.println("actualizacion incorrecta");
//				
//				}
//				
//			}
//			
//			
//
//			conexion.close();
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//			
//			
//			
//		
//		
		
	}
	@Override
	public void borrarDepartamento(int idDepartamento) {
		
		Connection conexion = conectar();
		
		
		try {
			PreparedStatement pstm = conexion.prepareStatement("delete from departamentos where dept_no = ?");
			
			
			pstm.setInt(1,idDepartamento);
			
			
			int x = pstm.executeUpdate();
			
			if (x>0) {
				System.out.println("borrado con éxito");
			}else {
				System.out.println("fallo");
			}
			
			
			
			
			
			
			conexion.close();
			
			
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	public void consultarDepartamento(int idDepartamento) {
	
		Connection conexion = conectar();
		
		
		try {
			PreparedStatement pstm = conexion.prepareStatement("select * from departamentos where dept_no = ?");
			
			
			pstm.setInt(1,idDepartamento);
			
			ResultSet result  = pstm.executeQuery();
			
			
			if (result.first()) {
				
				System.out.println("numero de departamento: "+idDepartamento);
				System.out.println("nombre de departamento: "+result.getString(2));
				System.out.println("localizacion: "+result.getString(3));
				
			}else {
				System.out.println("no hay departamentos con ese número");
			}
			
			
			
			conexion.close();
			
		
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	

}