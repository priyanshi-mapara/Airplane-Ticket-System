package Travel_Tickets;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Travel {

	private JFrame frame;
	private JTextField TxtTax;
	private JTextField TxtSubTotal;
	private JTextField TxtTotal;
	private JTextField txtClass;
	private JTextField txtTicket;
	private JTextField txtAdult;
	private JTextField txtChild;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtTicketNo;
	private JTextField txtPrice;
	private JTextField txtroute;
	private JTextField extra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Travel window = new Travel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Travel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(0, 0, 1370, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBorder(null);
		panel.setBounds(360, 32, 606, 73);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("BOOK YOUR TICKET");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 44));
		
		JLabel lblNewLabel_1 = new JLabel("Ticket Type");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_1.setBounds(202, 118, 207, 49);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnEconomyClass = new JRadioButton("Economy Class");
		rdbtnEconomyClass.setBounds(62, 239, 141, 23);
		frame.getContentPane().add(rdbtnEconomyClass);
		
		JRadioButton rdbtnFirstClass = new JRadioButton("First Class");
		rdbtnFirstClass.setBounds(62, 204, 141, 23);
		frame.getContentPane().add(rdbtnFirstClass);
		
		JRadioButton rdbtnBusinessClass = new JRadioButton("Business Class");
		rdbtnBusinessClass.setBounds(62, 274, 141, 23);
		frame.getContentPane().add(rdbtnBusinessClass);
		
		ButtonGroup G1 = new ButtonGroup();
		G1.add(rdbtnBusinessClass);
		G1.add(rdbtnFirstClass);
		G1.add(rdbtnEconomyClass);
		
		JRadioButton rdbtnSingleTicket = new JRadioButton("Single Ticket");
		rdbtnSingleTicket.setBounds(215, 204, 141, 23);
		frame.getContentPane().add(rdbtnSingleTicket);
		
		JRadioButton rdbtnReturnTicket = new JRadioButton("Return Ticket");
		rdbtnReturnTicket.setBounds(215, 239, 141, 23);
		frame.getContentPane().add(rdbtnReturnTicket);
		
		ButtonGroup G2 = new ButtonGroup();
		G2.add(rdbtnSingleTicket);
		G2.add(rdbtnReturnTicket);
		
		JRadioButton rdbtnAdult = new JRadioButton("Adult ");
		rdbtnAdult.setBounds(383, 204, 141, 23);
		frame.getContentPane().add(rdbtnAdult);
		
		JRadioButton rdbtnChild = new JRadioButton("Child");
		rdbtnChild.setBounds(383, 239, 141, 23);
		frame.getContentPane().add(rdbtnChild);
		
		ButtonGroup G3 = new ButtonGroup();
		G3.add(rdbtnChild);
		G3.add(rdbtnAdult);
		
		JComboBox cmbDestinations = new JComboBox();
		cmbDestinations.setModel(new DefaultComboBoxModel(new String[] {"Destination:", "London", "Paris", "New York", "Sydney", "Los Angeles"}));
		cmbDestinations.setBounds(215, 274, 231, 27);
		frame.getContentPane().add(cmbDestinations);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 176, 546, 12);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 309, 546, 12);
		frame.getContentPane().add(separator_1);
		
		JLabel Tax = new JLabel("Tax:");
		Tax.setBounds(60, 347, 61, 16);
		frame.getContentPane().add(Tax);
		
		JLabel lblSubTotal = new JLabel("Sub Total:");
		lblSubTotal.setBounds(60, 385, 89, 16);
		frame.getContentPane().add(lblSubTotal);
		
		JLabel Total = new JLabel("Total:");
		Total.setBounds(60, 449, 61, 16);
		frame.getContentPane().add(Total);
		
		TxtTax = new JTextField();
		TxtTax.setBackground(new Color(255, 255, 255));
		TxtTax.setBounds(155, 342, 130, 26);
		frame.getContentPane().add(TxtTax);
		TxtTax.setColumns(10);
		
		TxtSubTotal = new JTextField();
		TxtSubTotal.setColumns(10);
		TxtSubTotal.setBounds(155, 380, 130, 26);
		frame.getContentPane().add(TxtSubTotal);
		
		TxtTotal = new JTextField();
		TxtTotal.setColumns(10);
		TxtTotal.setBounds(155, 444, 130, 26);
		frame.getContentPane().add(TxtTotal);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(25, 482, 546, 12);
		frame.getContentPane().add(separator_1_1);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				double tax = 5;
				double london = 50000;
				double paris = 55000;
				double ny = 60000;
				double lax = 65000;
				double syd = 54000;
				double tc, eco = 5000, busi = 7000;
				
				if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					tc = london+(tax*london)/100;
					String sTax = String.format("Rs %.2f",(tax*london)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					tc = london+(tax*(london*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(london*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f",tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					tc = london+(tax*london)/100;
					String sTax = String.format("Rs %.2f",(tax*london)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					tc = london+(tax*(london*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(london*2))/100);
					TxtTax.setText(sTax);
					extra.setText("NIL");
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					tc = london+(tax*london)/100;
					String sTax = String.format("Rs %.2f",(tax*london)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					String econ = "Rs 5000.00";
					extra.setText(econ);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = london+(tax*(london*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(london*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = london+(tax*london)/100;
					String sTax = String.format("Rs %.2f",(tax*london)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f",tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = london+(tax*(london*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(london*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = london+(tax*london)/100;
					String sTax = String.format("Rs %.2f",(tax*london)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = london+(tax*(london*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(london*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = london+(tax*london)/100;
					String sTax = String.format("Rs %.2f",(tax*london)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("London"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = london+(tax*(london*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(london*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", london);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					tc = paris+(tax*paris)/100;
					String sTax = String.format("Rs %.2f",(tax*paris)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					tc = paris+(tax*(paris*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(paris*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f",tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					tc = paris+(tax*paris)/100;
					String sTax = String.format("Rs %.2f",(tax*paris)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					tc = paris+(tax*(paris*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(paris*2))/100);
					TxtTax.setText(sTax);
					extra.setText("NIL");
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					tc = paris+(tax*paris)/100;
					String sTax = String.format("Rs %.2f",(tax*paris)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					String econ = "Rs 5000.00";
					extra.setText(econ);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = paris+(tax*(paris*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(paris*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
                                else if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
                                {
                                        String econ = "Rs 5000.00";
                                        extra.setText(econ);
                                        tc = paris+(tax*paris)/100;
                                        String sTax = String.format("Rs %.2f",(tax*paris)/100);
                                        TxtTax.setText(sTax);
                                        String sub = String.format("Rs %.2f", paris);
                                        TxtSubTotal.setText(sub);
                                        String total = String.format("Rs %.2f",tc+3000);
                                        TxtTotal.setText(total);
                                        txtPrice.setText(total);
                                        txtClass.setText("ECONOMY CLASS");
                                        txtTicket.setText("ONE WAY");
                                        txtAdult.setText("NIL");
                                        txtChild.setText("ONE");
                                }
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = paris+(tax*(paris*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(paris*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = paris+(tax*paris)/100;
					String sTax = String.format("Rs %.2f",(tax*paris)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = paris+(tax*(paris*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(paris*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = paris+(tax*paris)/100;
					String sTax = String.format("Rs %.2f",(tax*paris)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Paris"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = paris+(tax*(paris*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(paris*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", paris);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					tc = ny+(tax*ny)/100;
					String sTax = String.format("Rs %.2f",(tax*ny)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					tc = ny+(tax*(ny*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(ny*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f",tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					tc = ny+(tax*ny)/100;
					String sTax = String.format("Rs %.2f",(tax*ny)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					tc = ny+(tax*(ny*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(ny*2))/100);
					TxtTax.setText(sTax);
					extra.setText("NIL");
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					tc = ny+(tax*ny)/100;
					String sTax = String.format("Rs %.2f",(tax*ny)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					String econ = "Rs 5000.00";
					extra.setText(econ);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = ny+(tax*(ny*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(ny*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = ny+(tax*ny)/100;
					String sTax = String.format("Rs %.2f",(tax*ny)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f",tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = ny+(tax*(ny*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(ny*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = ny+(tax*ny)/100;
					String sTax = String.format("Rs %.2f",(tax*ny)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = ny+(tax*(ny*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(ny*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = ny+(tax*ny)/100;
					String sTax = String.format("Rs %.2f",(tax*ny)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("New York"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = ny+(tax*(ny*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(ny*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", ny);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					tc = syd+(tax*syd)/100;
					String sTax = String.format("Rs %.2f",(tax*syd)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					tc = syd+(tax*(syd*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(syd*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f",tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
                                else if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					tc = syd+(tax*syd)/100;
					String sTax = String.format("Rs %.2f",(tax*syd)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					tc = syd+(tax*(syd*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(syd*2))/100);
					TxtTax.setText(sTax);
					extra.setText("NIL");
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					tc = syd+(tax*syd)/100;
					String sTax = String.format("Rs %.2f",(tax*syd)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					String econ = "Rs 5000.00";
					extra.setText(econ);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = syd+(tax*(syd*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(syd*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = syd+(tax*syd)/100;
					String sTax = String.format("Rs %.2f",(tax*syd)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f",tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = syd+(tax*(syd*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(syd*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = syd+(tax*syd)/100;
					String sTax = String.format("Rs %.2f",(tax*syd)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = london+(tax*(syd*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(syd*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = syd+(tax*syd)/100;
					String sTax = String.format("Rs %.2f",(tax*syd)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Sydney"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = syd+(tax*(syd*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(syd*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", syd);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					tc = lax+(tax*lax)/100;
					String sTax = String.format("Rs %.2f",(tax*lax)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					tc = lax+(tax*(lax*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(lax*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f",tc);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnFirstClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					tc = lax+(tax*lax)/100;
					String sTax = String.format("Rs %.2f",(tax*lax)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					extra.setText("NIL");
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnFirstClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					tc = lax+(tax*(lax*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(lax*2))/100);
					TxtTax.setText(sTax);
					extra.setText("NIL");
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc-2000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("FIRST CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					tc = lax+(tax*lax)/100;
					String sTax = String.format("Rs %.2f",(tax*lax)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					String econ = "Rs 5000.00";
					extra.setText(econ);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = lax+(tax*(lax*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(lax*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+eco);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnEconomyClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = lax+(tax*lax)/100;
					String sTax = String.format("Rs %.2f",(tax*lax)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f",tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				else if ((rdbtnEconomyClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					String econ = "Rs 5000.00";
					extra.setText(econ);
					tc = lax+(tax*(lax*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(lax*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+3000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("ECONOMY CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("NIL");
					txtChild.setText("ONE");
				}
				if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = lax+(tax*lax)/100;
					String sTax = String.format("Rs %.2f",(tax*lax)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = lax+(tax*(lax*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(lax*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+busi);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if((rdbtnBusinessClass.isSelected()) &&  (rdbtnSingleTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = lax+(tax*lax)/100;
					String sTax = String.format("Rs %.2f",(tax*lax)/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("ONE WAY");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
				else if ((rdbtnBusinessClass.isSelected()) &&  (rdbtnReturnTicket.isSelected()) && (rdbtnChild.isSelected()) && cmbDestinations.getSelectedItem().equals("Los Angeles"))
				{
					String busin = "Rs 7000.00";
					extra.setText(busin);
					tc = lax+(tax*(lax*2))/100;
					String sTax = String.format("Rs %.2f",(tax*(lax*2))/100);
					TxtTax.setText(sTax);
					String sub = String.format("Rs %.2f ", lax);
					TxtSubTotal.setText(sub);
					String total = String.format("Rs %.2f", tc+5000);
					TxtTotal.setText(total);
					txtPrice.setText(total);
					txtClass.setText("BUSINESS CLASS");
					txtTicket.setText("RETURN");
					txtAdult.setText("ONE");
					txtChild.setText("NIL");
				}
						
				if((rdbtnFirstClass.isSelected() || rdbtnEconomyClass.isSelected() || rdbtnBusinessClass.isSelected()) && (rdbtnSingleTicket.isSelected() 
						|| rdbtnReturnTicket.isSelected()) && (rdbtnAdult.isSelected() || rdbtnChild.isSelected()) && !cmbDestinations.getSelectedItem().equals("Destination:")) {
					
				        Calendar timer = Calendar.getInstance();
						timer.getTime();
						SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
						txtTime.setText(tTime.format(timer.getTime()));
						
						SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-YYYY");
						txtDate.setText(Tdate.format(timer.getTime()));
						txtFrom.setText("Mumbai ");
						txtTo.setText((String) cmbDestinations.getSelectedItem());
						
						int n;
						String q1 = "";
						n = 1325 + (int) (Math.random()*4328);
						q1 += n+1325;
						txtTicketNo.setText(q1);
						
						txtroute.setText("Convinient");
				}
			}
		});
		
		
		btnNewButton.setBounds(62, 509, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TxtTax.setText(null);
				TxtSubTotal.setText(null);
				TxtTotal.setText(null);
				rdbtnAdult.setSelected(false);
				rdbtnChild.setSelected(false);
				rdbtnFirstClass.setSelected(false);
				rdbtnEconomyClass.setSelected(false);
				rdbtnBusinessClass.setSelected(false);
				cmbDestinations.setSelectedItem("Destination:");
				rdbtnSingleTicket.setSelected(false);
				rdbtnReturnTicket.setSelected(false);
				txtClass.setText(null);
				txtTicket.setText(null);
				txtAdult.setText(null);
				txtChild.setText(null);
				txtFrom.setText(null);
				txtTo.setText(null);
				txtDate.setText(null);
				txtTime.setText(null);
				txtTicketNo.setText(null);
				txtPrice.setText(null);
				txtroute.setText(null);
				extra.setText(null);
				G1.clearSelection();
				G2.clearSelection();
				G3.clearSelection();
				
			}
		});
		btnReset.setBounds(239, 509, 117, 29);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame,"Confirm Exit","Ticket System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(416, 509, 117, 29);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setOrientation(SwingConstants.VERTICAL);
		separator_1_2.setBounds(625, 118, 12, 404);
		frame.getContentPane().add(separator_1_2);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblClass.setBounds(649, 151, 61, 16);
		frame.getContentPane().add(lblClass);
		
		JLabel lblTicket = new JLabel("Ticket");
		lblTicket.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTicket.setBounds(823, 151, 61, 16);
		frame.getContentPane().add(lblTicket);
		
		JLabel lblAdult = new JLabel("Adult");
		lblAdult.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAdult.setBounds(978, 151, 61, 16);
		frame.getContentPane().add(lblAdult);
		
		JLabel lblChild = new JLabel("Child");
		lblChild.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblChild.setBounds(1128, 151, 61, 16);
		frame.getContentPane().add(lblChild);
		
		txtClass = new JTextField();
		txtClass.setColumns(10);
		txtClass.setBounds(649, 186, 150, 26);
		frame.getContentPane().add(txtClass);
		txtClass.setEditable(false);
		
		txtTicket = new JTextField();
		txtTicket.setColumns(10);
		txtTicket.setBounds(823, 186, 130, 26);
		frame.getContentPane().add(txtTicket);
		txtTicket.setEditable(false);
		
		txtAdult = new JTextField();
		txtAdult.setColumns(10);
		txtAdult.setBounds(978, 186, 130, 26);
		frame.getContentPane().add(txtAdult);
		txtAdult.setEditable(false);
		
		txtChild = new JTextField();
		txtChild.setColumns(10);
		txtChild.setBounds(1131, 186, 130, 26);
		frame.getContentPane().add(txtChild);
		txtChild.setEditable(false);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(649, 176, 666, 12);
		frame.getContentPane().add(separator_2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(649, 215, 666, 12);
		frame.getContentPane().add(separator_2_1);
		
		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_2_1.setBounds(976, 238, 12, 340);
		frame.getContentPane().add(separator_1_2_1);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(649, 263, 61, 16);
		frame.getContentPane().add(lblFrom);
		
		txtFrom = new JTextField();
		txtFrom.setColumns(10);
		txtFrom.setBounds(744, 258, 130, 26);
		frame.getContentPane().add(txtFrom);
		txtFrom.setEditable(false);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(649, 314, 61, 16);
		frame.getContentPane().add(lblTo);
		
		txtTo = new JTextField();
		txtTo.setColumns(10);
		txtTo.setBounds(744, 309, 130, 26);
		frame.getContentPane().add(txtTo);
		txtTo.setEditable(false);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(649, 366, 61, 16);
		frame.getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(744, 361, 130, 26);
		frame.getContentPane().add(txtDate);
		txtDate.setEditable(false);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(649, 419, 61, 16);
		frame.getContentPane().add(lblTime);
		
		txtTime = new JTextField();
		txtTime.setColumns(10);
		txtTime.setBounds(744, 414, 130, 26);
		frame.getContentPane().add(txtTime);
		txtTime.setEditable(false);
		
		JLabel lblTicketNo = new JLabel("Ticket No:");
		lblTicketNo.setBounds(1014, 263, 97, 16);
		frame.getContentPane().add(lblTicketNo);
		
		txtTicketNo = new JTextField();
		txtTicketNo.setColumns(10);
		txtTicketNo.setBounds(1014, 295, 130, 26);
		frame.getContentPane().add(txtTicketNo);
		txtTicketNo.setEditable(false);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(1014, 375, 130, 26);
		frame.getContentPane().add(txtPrice);
		txtPrice.setEditable(false);
		
		JLabel lblFrom_1_1 = new JLabel("Price:");
		lblFrom_1_1.setBounds(1014, 343, 61, 16);
		frame.getContentPane().add(lblFrom_1_1);
		
		txtroute = new JTextField();
		txtroute.setColumns(10);
		txtroute.setBounds(1014, 456, 130, 26);
		frame.getContentPane().add(txtroute);
		txtroute.setEditable(false);
		
		JLabel lblFrom_1_2 = new JLabel("Route:");
		lblFrom_1_2.setBounds(1014, 424, 61, 16);
		frame.getContentPane().add(lblFrom_1_2);
		
		JLabel lblextra = new JLabel("Class fare:");
		lblextra.setBounds(60, 416, 89, 16);
		frame.getContentPane().add(lblextra);
		
		extra = new JTextField();
		extra.setColumns(10);
		extra.setBounds(155, 411, 130, 26);
		frame.getContentPane().add(extra);
	}
}
