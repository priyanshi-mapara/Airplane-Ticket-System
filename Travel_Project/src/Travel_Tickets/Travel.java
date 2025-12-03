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
                frame.getContentPane().setBackground(new Color(232, 241, 250));
                frame.setBounds(0, 0, 1370, 750);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(null);

                Color primary = new Color(0, 82, 155);
                Color accent = new Color(244, 137, 37);
                Color surface = new Color(248, 252, 255);
                Color outline = new Color(202, 224, 244);

                JPanel panel = new JPanel();
                panel.setBackground(primary);
                panel.setBorder(null);
                panel.setBounds(320, 24, 680, 95);
                frame.getContentPane().add(panel);

                JLabel lblNewLabel = new JLabel("BOOK YOUR TICKET");
                panel.add(lblNewLabel);
                lblNewLabel.setForeground(Color.WHITE);
                lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));

                JLabel subheading = new JLabel("Seamless bookings with AeroFly");
                subheading.setForeground(Color.WHITE);
                subheading.setFont(new Font("Segoe UI", Font.PLAIN, 18));
                panel.add(subheading);

                JLabel lblNewLabel_1 = new JLabel("Ticket Type");
                lblNewLabel_1.setForeground(primary);
                lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 32));
                lblNewLabel_1.setBounds(202, 118, 207, 49);
                frame.getContentPane().add(lblNewLabel_1);

                JPanel bookingPanel = new JPanel();
                bookingPanel.setLayout(null);
                bookingPanel.setBackground(surface);
                bookingPanel.setBorder(new javax.swing.border.LineBorder(outline, 2, true));
                bookingPanel.setBounds(25, 165, 560, 385);
                frame.getContentPane().add(bookingPanel);

                JRadioButton rdbtnEconomyClass = new JRadioButton("Economy Class");
                rdbtnEconomyClass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                rdbtnEconomyClass.setBackground(surface);
                rdbtnEconomyClass.setBounds(22, 70, 173, 23);
                bookingPanel.add(rdbtnEconomyClass);

                JRadioButton rdbtnFirstClass = new JRadioButton("First Class");
                rdbtnFirstClass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                rdbtnFirstClass.setBackground(surface);
                rdbtnFirstClass.setBounds(22, 35, 173, 23);
                bookingPanel.add(rdbtnFirstClass);

                JRadioButton rdbtnBusinessClass = new JRadioButton("Business Class");
                rdbtnBusinessClass.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                rdbtnBusinessClass.setBackground(surface);
                rdbtnBusinessClass.setBounds(22, 105, 173, 23);
                bookingPanel.add(rdbtnBusinessClass);

                ButtonGroup G1 = new ButtonGroup();
                G1.add(rdbtnBusinessClass);
                G1.add(rdbtnFirstClass);
                G1.add(rdbtnEconomyClass);

                JRadioButton rdbtnSingleTicket = new JRadioButton("Single Ticket");
                rdbtnSingleTicket.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                rdbtnSingleTicket.setBackground(surface);
                rdbtnSingleTicket.setBounds(210, 35, 141, 23);
                bookingPanel.add(rdbtnSingleTicket);

                JRadioButton rdbtnReturnTicket = new JRadioButton("Return Ticket");
                rdbtnReturnTicket.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                rdbtnReturnTicket.setBackground(surface);
                rdbtnReturnTicket.setBounds(210, 70, 141, 23);
                bookingPanel.add(rdbtnReturnTicket);

                ButtonGroup G2 = new ButtonGroup();
                G2.add(rdbtnSingleTicket);
                G2.add(rdbtnReturnTicket);

                JRadioButton rdbtnAdult = new JRadioButton("Adult ");
                rdbtnAdult.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                rdbtnAdult.setBackground(surface);
                rdbtnAdult.setBounds(388, 35, 141, 23);
                bookingPanel.add(rdbtnAdult);

                JRadioButton rdbtnChild = new JRadioButton("Child");
                rdbtnChild.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                rdbtnChild.setBackground(surface);
                rdbtnChild.setBounds(388, 70, 141, 23);
                bookingPanel.add(rdbtnChild);

                ButtonGroup G3 = new ButtonGroup();
                G3.add(rdbtnChild);
                G3.add(rdbtnAdult);

                JComboBox<String> cmbDestinations = new JComboBox<>();
                cmbDestinations.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                cmbDestinations
                                .setModel(new DefaultComboBoxModel<>(new String[] { "Destination:", "London", "Paris",
                                                "New York", "Sydney", "Los Angeles" }));
                cmbDestinations.setBounds(210, 105, 231, 27);
                bookingPanel.add(cmbDestinations);

                JSeparator separator = new JSeparator();
                separator.setForeground(outline);
                separator.setBounds(15, 145, 530, 12);
                bookingPanel.add(separator);

                JLabel summaryLabel = new JLabel("Fare Breakdown");
                summaryLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
                summaryLabel.setForeground(primary);
                summaryLabel.setBounds(20, 160, 200, 20);
                bookingPanel.add(summaryLabel);

                JLabel Tax = new JLabel("Tax:");
                Tax.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                Tax.setBounds(40, 195, 61, 16);
                bookingPanel.add(Tax);

                JLabel lblSubTotal = new JLabel("Sub Total:");
                lblSubTotal.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblSubTotal.setBounds(40, 230, 89, 16);
                bookingPanel.add(lblSubTotal);

                JLabel Total = new JLabel("Total:");
                Total.setFont(new Font("Segoe UI", Font.BOLD, 14));
                Total.setBounds(40, 270, 61, 16);
                bookingPanel.add(Total);

                TxtTax = new JTextField();
                TxtTax.setBackground(Color.WHITE);
                TxtTax.setBounds(140, 190, 150, 26);
                bookingPanel.add(TxtTax);
                TxtTax.setEditable(false);

                TxtSubTotal = new JTextField();
                TxtSubTotal.setColumns(10);
                TxtSubTotal.setBounds(140, 225, 150, 26);
                TxtSubTotal.setEditable(false);
                bookingPanel.add(TxtSubTotal);

                TxtTotal = new JTextField();
                TxtTotal.setColumns(10);
                TxtTotal.setBounds(140, 265, 150, 26);
                TxtTotal.setEditable(false);
                bookingPanel.add(TxtTotal);

                JLabel lblextra = new JLabel("Class fare:");
                lblextra.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblextra.setBounds(40, 305, 89, 16);
                bookingPanel.add(lblextra);

                extra = new JTextField();
                extra.setColumns(10);
                extra.setBounds(140, 300, 150, 26);
                bookingPanel.add(extra);
                extra.setEditable(false);

                JButton btnNewButton = new JButton("Calculate");
                btnNewButton.setForeground(Color.WHITE);
                btnNewButton.setBackground(primary);
                btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
                btnNewButton.addActionListener((ActionEvent e) -> handleTotal(rdbtnFirstClass, rdbtnBusinessClass,
                                rdbtnEconomyClass, rdbtnSingleTicket, rdbtnReturnTicket, rdbtnAdult, rdbtnChild,
                                cmbDestinations));
                btnNewButton.setBounds(320, 190, 200, 35);
                bookingPanel.add(btnNewButton);

                JButton btnReset = new JButton("Reset");
                btnReset.setBackground(outline);
                btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
                btnReset.addActionListener(e -> resetForm(G1, G2, G3, cmbDestinations));
                btnReset.setBounds(320, 235, 95, 35);
                bookingPanel.add(btnReset);

                JButton btnExit = new JButton("Exit");
                btnExit.setBackground(new Color(230, 99, 99));
                btnExit.setForeground(Color.WHITE);
                btnExit.setFont(new Font("Segoe UI", Font.BOLD, 14));
                btnExit.addActionListener(e -> frame.dispose());
                btnExit.setBounds(425, 235, 95, 35);
                bookingPanel.add(btnExit);

                JPanel ticketPanel = new JPanel();
                ticketPanel.setBackground(Color.WHITE);
                ticketPanel.setBorder(new javax.swing.border.LineBorder(outline, 2, true));
                ticketPanel.setLayout(null);
                ticketPanel.setBounds(610, 140, 700, 430);
                frame.getContentPane().add(ticketPanel);

                JLabel ticketHeader = new JLabel("Passenger Ticket");
                ticketHeader.setFont(new Font("Segoe UI", Font.BOLD, 24));
                ticketHeader.setForeground(primary);
                ticketHeader.setBounds(24, 15, 260, 30);
                ticketPanel.add(ticketHeader);

                JLabel chip = new JLabel("AeroFly");
                chip.setOpaque(true);
                chip.setBackground(accent);
                chip.setForeground(Color.WHITE);
                chip.setHorizontalAlignment(SwingConstants.CENTER);
                chip.setFont(new Font("Segoe UI", Font.BOLD, 14));
                chip.setBounds(570, 18, 100, 26);
                ticketPanel.add(chip);

                JLabel lblClass = new JLabel("Class");
                lblClass.setFont(new Font("Segoe UI", Font.BOLD, 13));
                lblClass.setBounds(24, 64, 61, 16);
                ticketPanel.add(lblClass);

                JLabel lblTicket = new JLabel("Ticket");
                lblTicket.setFont(new Font("Segoe UI", Font.BOLD, 13));
                lblTicket.setBounds(214, 64, 61, 16);
                ticketPanel.add(lblTicket);

                JLabel lblAdult = new JLabel("Adult");
                lblAdult.setFont(new Font("Segoe UI", Font.BOLD, 13));
                lblAdult.setBounds(394, 64, 61, 16);
                ticketPanel.add(lblAdult);

                JLabel lblChild = new JLabel("Child");
                lblChild.setFont(new Font("Segoe UI", Font.BOLD, 13));
                lblChild.setBounds(544, 64, 61, 16);
                ticketPanel.add(lblChild);

                txtClass = new JTextField();
                txtClass.setColumns(10);
                txtClass.setBounds(24, 90, 150, 28);
                ticketPanel.add(txtClass);
                txtClass.setEditable(false);

                txtTicket = new JTextField();
                txtTicket.setColumns(10);
                txtTicket.setBounds(214, 90, 130, 28);
                ticketPanel.add(txtTicket);
                txtTicket.setEditable(false);

                txtAdult = new JTextField();
                txtAdult.setColumns(10);
                txtAdult.setBounds(394, 90, 130, 28);
                ticketPanel.add(txtAdult);
                txtAdult.setEditable(false);

                txtChild = new JTextField();
                txtChild.setColumns(10);
                txtChild.setBounds(544, 90, 130, 28);
                ticketPanel.add(txtChild);
                txtChild.setEditable(false);

                JSeparator separator_2 = new JSeparator();
                separator_2.setForeground(outline);
                separator_2.setBounds(24, 130, 650, 12);
                ticketPanel.add(separator_2);

                JLabel lblFrom = new JLabel("From:");
                lblFrom.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblFrom.setBounds(24, 160, 61, 16);
                ticketPanel.add(lblFrom);

                txtFrom = new JTextField();
                txtFrom.setColumns(10);
                txtFrom.setBounds(100, 155, 150, 26);
                ticketPanel.add(txtFrom);
                txtFrom.setEditable(false);

                JLabel lblTo = new JLabel("To:");
                lblTo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblTo.setBounds(24, 205, 61, 16);
                ticketPanel.add(lblTo);

                txtTo = new JTextField();
                txtTo.setColumns(10);
                txtTo.setBounds(100, 200, 150, 26);
                ticketPanel.add(txtTo);
                txtTo.setEditable(false);

                JLabel lblDate = new JLabel("Date:");
                lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblDate.setBounds(24, 250, 61, 16);
                ticketPanel.add(lblDate);

                txtDate = new JTextField();
                txtDate.setColumns(10);
                txtDate.setBounds(100, 245, 150, 26);
                ticketPanel.add(txtDate);
                txtDate.setEditable(false);

                JLabel lblTime = new JLabel("Time:");
                lblTime.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblTime.setBounds(24, 295, 61, 16);
                ticketPanel.add(lblTime);

                txtTime = new JTextField();
                txtTime.setColumns(10);
                txtTime.setBounds(100, 290, 150, 26);
                ticketPanel.add(txtTime);
                txtTime.setEditable(false);

                JLabel lblTicketNo = new JLabel("Ticket No:");
                lblTicketNo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblTicketNo.setBounds(310, 160, 97, 16);
                ticketPanel.add(lblTicketNo);

                txtTicketNo = new JTextField();
                txtTicketNo.setColumns(10);
                txtTicketNo.setBounds(400, 155, 150, 26);
                ticketPanel.add(txtTicketNo);
                txtTicketNo.setEditable(false);

                JLabel lblFrom_1_1 = new JLabel("Price:");
                lblFrom_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblFrom_1_1.setBounds(310, 205, 61, 16);
                ticketPanel.add(lblFrom_1_1);

                txtPrice = new JTextField();
                txtPrice.setColumns(10);
                txtPrice.setBounds(400, 200, 150, 26);
                ticketPanel.add(txtPrice);
                txtPrice.setEditable(false);

                JLabel lblFrom_1_2 = new JLabel("Route:");
                lblFrom_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                lblFrom_1_2.setBounds(310, 250, 61, 16);
                ticketPanel.add(lblFrom_1_2);

                txtroute = new JTextField();
                txtroute.setColumns(10);
                txtroute.setBounds(400, 245, 150, 26);
                ticketPanel.add(txtroute);
                txtroute.setEditable(false);
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
                txtroute.setText("Via: " + (destination.equals("London") ? "Dubai" : "Direct"));
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
