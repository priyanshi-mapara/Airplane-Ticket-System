package Travel_Tickets;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Travel {

        private static final DecimalFormat MONEY = new DecimalFormat("Rs 0.00");

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

        private final Map<String, Double> basePrices = new HashMap<>();

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(() -> {
                        try {
                                Travel window = new Travel();
                                window.frame.setVisible(true);
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                });
        }

        public Travel() {
                seedData();
                initialize();
        }

        private void seedData() {
                basePrices.put("London", 50000d);
                basePrices.put("Paris", 55000d);
                basePrices.put("New York", 60000d);
                basePrices.put("Sydney", 54000d);
                basePrices.put("Los Angeles", 65000d);
        }

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

                JComboBox<String> cmbDestinations = new JComboBox<>();
                cmbDestinations
                                .setModel(new DefaultComboBoxModel<>(new String[] { "Destination:", "London", "Paris",
                                                "New York", "Sydney", "Los Angeles" }));
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
                TxtTax.setEditable(false);

                TxtSubTotal = new JTextField();
                TxtSubTotal.setColumns(10);
                TxtSubTotal.setBounds(155, 380, 130, 26);
                TxtSubTotal.setEditable(false);
                frame.getContentPane().add(TxtSubTotal);

                TxtTotal = new JTextField();
                TxtTotal.setColumns(10);
                TxtTotal.setBounds(155, 444, 130, 26);
                TxtTotal.setEditable(false);
                frame.getContentPane().add(TxtTotal);

                JSeparator separator_1_1 = new JSeparator();
                separator_1_1.setBounds(25, 482, 546, 12);
                frame.getContentPane().add(separator_1_1);

                JButton btnNewButton = new JButton("Total");
                btnNewButton.addActionListener((ActionEvent e) -> handleTotal(rdbtnFirstClass, rdbtnBusinessClass,
                                rdbtnEconomyClass, rdbtnSingleTicket, rdbtnReturnTicket, rdbtnAdult, rdbtnChild,
                                cmbDestinations));
                btnNewButton.setBounds(25, 505, 130, 35);
                frame.getContentPane().add(btnNewButton);

                JButton btnReset = new JButton("Reset");
                btnReset.addActionListener(e -> resetForm(G1, G2, G3, cmbDestinations));
                btnReset.setBounds(205, 505, 130, 35);
                frame.getContentPane().add(btnReset);

                JButton btnExit = new JButton("Exit");
                btnExit.addActionListener(e -> frame.dispose());
                btnExit.setBounds(385, 505, 130, 35);
                frame.getContentPane().add(btnExit);

                JLabel lblClass = new JLabel("Class");
                lblClass.setBounds(649, 151, 61, 16);
                frame.getContentPane().add(lblClass);

                JLabel lblTicket = new JLabel("Ticket");
                lblTicket.setBounds(823, 151, 61, 16);
                frame.getContentPane().add(lblTicket);

                JLabel lblAdult = new JLabel("Adult");
                lblAdult.setBounds(978, 151, 61, 16);
                frame.getContentPane().add(lblAdult);

                JLabel lblChild = new JLabel("Child");
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
                extra.setEditable(false);
        }

        private void handleTotal(JRadioButton rdbtnFirstClass, JRadioButton rdbtnBusinessClass,
                        JRadioButton rdbtnEconomyClass, JRadioButton rdbtnSingleTicket, JRadioButton rdbtnReturnTicket,
                        JRadioButton rdbtnAdult, JRadioButton rdbtnChild, JComboBox<String> destinations) {
                if (!rdbtnFirstClass.isSelected() && !rdbtnBusinessClass.isSelected() && !rdbtnEconomyClass.isSelected()) {
                        JOptionPane.showMessageDialog(frame, "Please select a class option first.", "Missing selection",
                                        JOptionPane.WARNING_MESSAGE);
                        return;
                }

                if (!rdbtnSingleTicket.isSelected() && !rdbtnReturnTicket.isSelected()) {
                        JOptionPane.showMessageDialog(frame, "Please choose single or return ticket.", "Missing selection",
                                        JOptionPane.WARNING_MESSAGE);
                        return;
                }

                if (!rdbtnAdult.isSelected() && !rdbtnChild.isSelected()) {
                        JOptionPane.showMessageDialog(frame, "Please mark whether the traveler is an adult or child.",
                                        "Missing selection", JOptionPane.WARNING_MESSAGE);
                        return;
                }

                if (destinations.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(frame, "Please pick a destination to continue.", "Destination needed",
                                        JOptionPane.WARNING_MESSAGE);
                        return;
                }

                String destination = destinations.getSelectedItem().toString();
                double base = basePrices.get(destination);
                double multiplier = rdbtnReturnTicket.isSelected() ? 2d : 1d;
                double classExtra = rdbtnEconomyClass.isSelected() ? 5000 : rdbtnBusinessClass.isSelected() ? 7000 : 0;
                double passengerAdjustment = rdbtnChild.isSelected()
                                ? (rdbtnEconomyClass.isSelected() ? 3000 : rdbtnBusinessClass.isSelected() ? 5000 : -2000)
                                : 0;
                double subtotal = base * multiplier;
                double tax = subtotal * 0.05;
                double total = subtotal + tax + classExtra + passengerAdjustment;

                updateSummary(rdbtnFirstClass, rdbtnBusinessClass, rdbtnEconomyClass, rdbtnSingleTicket,
                                rdbtnReturnTicket, rdbtnAdult, rdbtnChild, destination, classExtra, subtotal, tax, total);
        }

        private void updateSummary(JRadioButton rdbtnFirstClass, JRadioButton rdbtnBusinessClass,
                        JRadioButton rdbtnEconomyClass, JRadioButton rdbtnSingleTicket, JRadioButton rdbtnReturnTicket,
                        JRadioButton rdbtnAdult, JRadioButton rdbtnChild, String destination, double classExtra,
                        double subtotal, double tax, double total) {
                Calendar timer = Calendar.getInstance();
                txtDate.setText(new SimpleDateFormat("dd-MMM-yyyy").format(timer.getTime()));
                txtTime.setText(new SimpleDateFormat("HH:mm:ss").format(timer.getTime()));

                TxtSubTotal.setText(MONEY.format(subtotal));
                TxtTax.setText(MONEY.format(tax));
                TxtTotal.setText(MONEY.format(total));
                txtPrice.setText(MONEY.format(total));
                extra.setText(classExtra == 0 ? "NIL" : MONEY.format(classExtra));

                txtClass.setText(rdbtnEconomyClass.isSelected() ? "ECONOMY CLASS"
                                : rdbtnBusinessClass.isSelected() ? "BUSINESS CLASS" : "FIRST CLASS");
                txtTicket.setText(rdbtnReturnTicket.isSelected() ? "RETURN" : "ONE WAY");
                txtAdult.setText(rdbtnAdult.isSelected() ? "ONE" : "NIL");
                txtChild.setText(rdbtnChild.isSelected() ? "ONE" : "NIL");

                txtFrom.setText("India");
                txtTo.setText(destination);
                txtroute.setText("Via: "+ (destination.equals("London") ? "Dubai" : "Direct"));
                txtTicketNo.setText("TK" + (new Random().nextInt(90000) + 10000));
        }

        private void resetForm(ButtonGroup g1, ButtonGroup g2, ButtonGroup g3, JComboBox<String> destinations) {
                g1.clearSelection();
                g2.clearSelection();
                g3.clearSelection();
                destinations.setSelectedIndex(0);

                TxtTax.setText("");
                TxtSubTotal.setText("");
                TxtTotal.setText("");
                txtClass.setText("");
                txtTicket.setText("");
                txtAdult.setText("");
                txtChild.setText("");
                txtFrom.setText("");
                txtTo.setText("");
                txtDate.setText("");
                txtTime.setText("");
                txtTicketNo.setText("");
                txtPrice.setText("");
                txtroute.setText("");
                extra.setText("");
        }
}
