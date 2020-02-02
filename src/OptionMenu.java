import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.Rectangle;

public class OptionMenu extends JFrame implements ActionListener{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Connection koneksi;
	private JLabel lName;
	private JButton btnInputPenulis, btnInputBuku;

	public OptionMenu(Connection koneksi){
		this.koneksi = koneksi;
		jendelaProgram();
	}


	private void jendelaProgram(){

		lName = new JLabel("Pilih Menu Berikut : ");
		lName.setBounds(25, 20, 200, 20);

		btnInputPenulis = new JButton("Input Penulis");
		btnInputPenulis.setBounds(25, 50, 180, 20);
		btnInputPenulis.addActionListener(this);

		btnInputBuku = new JButton("Input Buku");
		btnInputBuku.setBounds(25, 78,  180, 20);
		btnInputBuku.addActionListener(this);

		setTitle("Option Menu");
		setSize(250, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		add(lName);
		add(btnInputPenulis);
		add(btnInputBuku);
	}	


	@Override
	public void actionPerformed(ActionEvent e) {
        System.out.println("Command : " + e.getActionCommand());
        
        if(e.getActionCommand() == "Input Buku"){
            InputBuku input2 = new InputBuku(koneksi);
			input2.setVisible(true);
        }

        if(e.getActionCommand() == "Input Penulis"){
            InputPenulis input = new InputPenulis(koneksi);
			input.setVisible(true);
        }


	}

}