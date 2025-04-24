package bbdd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import main.TasteOfBlood;
import player.Player;

public class BD_Taste extends BD_Conector {
	//Attributes
	private static Statement s;
	private static ResultSet reg;
	
	public BD_Taste(String bbdd) {
		super(bbdd);
	}
	//Añadir Player
	public boolean addPlayer(Player player) {
		String cadena = "INSERT INTO PLAYER VALUES('"+player.getName()+ "','" +player.getSoul()+"')";
		try {
			this.abrir();
			s = c.createStatement();
			s.executeUpdate(cadena);
			s.close();
			this.cerrar();
			return true;
		} catch (SQLException e) {
			this.cerrar();
			return false;
		}
	}
	
	//Borrar Player
	public boolean deletePlayer(String name) {
		String cadena = "DELETE FROM PLAYER WHERE NAME='"+name+"'";
		try {
			this.abrir();
			s = c.createStatement();
			s.executeUpdate(cadena);
			s.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		} finally {
			this.cerrar();
		}
	}
	
	//Hacer Select
	public String searchPlayer(String name) {
		String search = "";
		String line = "SELECT NAME,SOUL FROM PLAYER WHERE NAME='"+name+"'";
		
		
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(line);
			
			//Si encuentra algo habrá siguiente
			if(reg.next()) {
				search = reg.getString(1)+","+reg.getString(2);
			}
			else {
				throw new SQLException("No se ha encontrado la información");
			}
			//Flush
			s.close();
			return search;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "";
		} finally {
			this.cerrar();
		}
	}
	
	public String searchAllPlayers() {
		String search = "";
		String line = "SELECT NAME,SOUL FROM PLAYER";
		
		
		try {
			this.abrir();
			s = c.createStatement();
			reg = s.executeQuery(line);
			
			//Si encuentra algo habrá siguiente
			while(reg.next()) {
				search += reg.getString(1)+","+reg.getString(2)+"\n";
			}

			//Flush
			s.close();
			return search;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "";
		} finally {
			this.cerrar();
		}
	}
}
