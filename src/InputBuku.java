import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Rectangle;

public class InputBuku extends JFrame implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Connection koneksi;
	private JLabel linbn, ljudul, ljumlah_halaman, lthn_terbit, lpenerbit, lid_penulis;
	private JTextField tfinbn, tfjudul, tfjumlah_halaman, tfthn_terbit, tfpenerbit, tfid_penulis;
	private JButton tombol, btnClose;

	public InputBuku(Connection koneksi) {
		this.koneksi = koneksi;
		jendelaProgram();
	}

	private void jendelaProgram() {
		linbn = new JLabel("ISBN Buku : ");
		linbn.setBounds(10, 10, 100, 20);
		tfinbn = new JTextField();
		tfinbn.setBounds(110, 10, 200, 20);

		ljudul = new JLabel("Judul Buku : ");
		ljudul.setBounds(10, 40, 100, 20);
		tfjudul = new JTextField();
		tfjudul.setBounds(110, 40, 200, 20);

		ljumlah_halaman = new JLabel("Jumlah Halaman: ");
		ljumlah_halaman.setBounds(10, 70, 100, 20);
		tfjumlah_halaman = new JTextField();
		tfjumlah_halaman.setBounds(110, 70, 200, 20);

		lthn_terbit = new JLabel("Tahun Terbit: ");
		lthn_terbit.setBounds(10, 100, 100, 20);
		tfthn_terbit = new JTextField();
		tfthn_terbit.setBounds(110, 100, 200, 20);

		lpenerbit = new JLabel("Penerbit : ");
		lpenerbit.setBounds(10, 130, 100, 20);
		tfpenerbit = new JTextField();
		tfpenerbit.setBounds(110, 130, 200, 20);

		lid_penulis = new JLabel("Id Penulis : ");
		lid_penulis.setBounds(10, 160, 100, 20);
		tfid_penulis = new JTextField();
		tfid_penulis.setBounds(110, 160, 200, 20);

		tombol = new JButton("Tambah");
		tombol.addActionListener(this);
		tombol.setBounds(110, 210, 90, 25);

		btnClose = new JButton("Keluar");
		btnClose.addActionListener(this);
		btnClose.setBounds(220, 210, 90, 25);

		setTitle("Tambah Data Buku");
		setSize(350, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setLayout(null);
		add(linbn);
		add(tfinbn);
		add(ljudul);
		add(tfjudul);
		add(ljumlah_halaman);
		add(tfjumlah_halaman);
		add(lthn_terbit);
		add(tfthn_terbit);
		add(lpenerbit);
		add(tfpenerbit);
		add(lid_penulis);
		add(tfid_penulis);
		add(tombol);
		add(btnClose);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Tambah") {
			String inbn = tfinbn.getText();
			String judul = tfjudul.getText();
			String jml_halaman = tfjumlah_halaman.getText();
			String thn_terbit = tfthn_terbit.getText();
			String penerbit = tfpenerbit.getText();
			String id_penulis = tfid_penulis.getText();

			if ((!inbn.equals("")) || (!judul.equals("")) || (!jml_halaman.equals("")) || (!thn_terbit.equals(""))
					|| (!penerbit.equals("")) || (!id_penulis.equals(""))) {
				try {
					Statement stmt = koneksi.createStatement();
					String sql = "INSERT INTO buku VALUES ('" + inbn + "', '" + judul + "', '" + jml_halaman + "', '"
							+ thn_terbit + "', '" + penerbit + "', '" + id_penulis + "')";
					stmt.executeUpdate(sql);

					String fmt = "INBN : %s, Judul : %s, Jumlah Halaman : %s, Tahun Terbit : %s, Penerbit : %s, Id Penulis :%s  Berhasil Tersimpan!";
					String info = String.format(fmt, inbn, judul, jml_halaman, thn_terbit, penerbit, id_penulis);
					JOptionPane.showMessageDialog(this, info, "Info", JOptionPane.INFORMATION_MESSAGE);

					tfinbn.setText("");
					tfjudul.setText("");
					tfjumlah_halaman.setText("");
					tfthn_terbit.setText("");
					tfpenerbit.setText("");
					tfid_penulis.setText("");

				} catch (SQLException exc) {
					JOptionPane.showMessageDialog(this, exc.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Massukkan Data!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			setVisible(false);
		}
	}

}