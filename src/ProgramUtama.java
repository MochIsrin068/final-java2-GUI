import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Rectangle;

public class ProgramUtama {
	public static void main (String[] args) {
		String url = "jdbc:mysql://127.0.0.1:3306/dbuas_18157201013?serverTimezone=UTC";
		String user = "root";
		String password = "";
		Connection cnx = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			cnx = DriverManager.getConnection(url, user, password);
		}
		catch(SQLException exc) {
			System.err.println(exc.toString());
		}
		finally {
			if(cnx == null) {
				JOptionPane.showMessageDialog(null, " Tidak ada koneksi ke database", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				OptionMenu optionMenu = new OptionMenu(cnx);
				optionMenu.setVisible(true);
				
			}
		}
	}
}


