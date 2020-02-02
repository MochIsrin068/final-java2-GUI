import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Rectangle;

public class InputPenulis extends JFrame implements ActionListener{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Connection koneksi;
	private JLabel lid, lnama, lalamat, lno_telepon, lwebsite, lemail;
	private JTextField tfid, tfnama, tfalamat, tfno_telepon, tfwebsite, tfemail;
	private JButton tombol, btnClose;
	
	public InputPenulis (Connection koneksi){
		this.koneksi = koneksi;
		jendelaProgram();
	}
	
	private void jendelaProgram() {
		lid = new JLabel("Id : ");
		lid.setBounds(10, 10, 100, 20);
		tfid = new JTextField();
		tfid.setBounds(110, 10, 200, 20);
		
		lnama = new JLabel("Nama : ");
		lnama.setBounds(10, 40, 100, 20);
		tfnama = new JTextField();
		tfnama.setBounds(110, 40, 200, 20);
		
		lalamat = new JLabel("Alamat : ");
		lalamat.setBounds(10, 70, 100, 20);
		tfalamat = new JTextField();
		tfalamat.setBounds(110, 70, 200, 20);
		
		lno_telepon = new JLabel("No Telepon : ");
		lno_telepon.setBounds(10, 100, 100, 20);
		tfno_telepon = new JTextField();
		tfno_telepon.setBounds(110, 100, 200, 20);
		
		lwebsite = new JLabel("Website : ");
		lwebsite.setBounds(10, 130, 100, 20);
		tfwebsite = new JTextField();
		tfwebsite.setBounds(110, 130, 200, 20);
		
		lemail = new JLabel("Email : ");
		lemail.setBounds(10, 160, 100, 20);
		tfemail = new JTextField();
		tfemail.setBounds(110, 160, 200, 20);
		
		tombol = new JButton("Tambah");
		tombol.addActionListener(this);
		tombol.setBounds(110, 210, 90, 25);
		
		btnClose = new JButton("Keluar");
		btnClose.addActionListener(this);
		btnClose.setBounds(220, 210, 90, 25);
		
		setTitle("Tambah Penulis");
		setSize(350, 320);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		add(lid);
		add(tfid);
		add(lnama);
		add(tfnama);
		add(lalamat);
		add(tfalamat);
		add(lno_telepon);
		add(tfno_telepon);
		add(lwebsite);
		add(tfwebsite);
		add(lemail);
		add(tfemail);
		add(tombol);
		add(btnClose);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Tambah"){
			String id = tfid.getText();
			String nama = tfnama.getText();
			String alamat = tfalamat.getText();
			String no_telepon = tfno_telepon.getText();
			String website = tfwebsite.getText();
			String email = tfemail.getText();
			
			if((!id.equals("")) || (!nama.equals("")) || (!alamat.equals("")) || (!no_telepon.equals("")) || (!website.equals("")) || (!email.equals(""))){
				try{
					Statement stmt = koneksi.createStatement();
					String sql = "INSERT INTO penulis (id, nama, alamat, no_telepon, website, email) VALUES ('"+ id+"', '"+ nama+"', '"+ alamat+"', '"+ no_telepon+"', '"+ website+"', '"+ email+"')";
					stmt.executeUpdate(sql);

					String fmt = "Id : %s, Nama : %s, Alamat : %s, No Telepon : %s, Website : %s, Email :%s  Berhasil Tersimpan!";
					String info = String.format(fmt, id, nama, alamat, no_telepon, website, email);
					JOptionPane.showMessageDialog(this, info, "Info", JOptionPane.INFORMATION_MESSAGE);

					tfid.setText("");
					tfnama.setText("");
					tfalamat.setText("");
					tfno_telepon.setText("");
					tfwebsite.setText("");
					tfemail.setText("");
				}
				catch(SQLException exc){
					JOptionPane.showMessageDialog(this, exc.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Massukkan Data!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			setVisible(false);
		}
	}
			
}