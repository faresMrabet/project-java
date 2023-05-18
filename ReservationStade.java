package stad;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import stad.Reservation;
import stad.ReservationInterfaceImpl;
import stad.ReservationStade;

import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReservationStade extends JFrame implements ActionListener{
   private JLabel titleLabel, nameLabel, emailLabel, dateLabel, timeLabel;
   private JTextField nameField, emailField, dateField, timeField;
   private JButton reserveButton, cancelButton;
   private ArrayList<String[]> reservations;
   
ReservationInterface action =new ReservationInterfaceImpl();
   public ReservationStade() {
      setTitle("Réservation d'un stade privé");
      setLayout(new BorderLayout());
     
      JPanel northPanel = new JPanel(new GridLayout(6, 2));
      titleLabel = new JLabel("Réservation d'un stade privé");
      nameLabel = new JLabel("Nom  :");
      emailLabel = new JLabel("Email  :");
      dateLabel = new JLabel("Date  :");
      timeLabel = new JLabel("Heure  :");

      nameField = new JTextField(10);
      emailField = new JTextField(10);
      dateField = new JTextField(10);
      timeField = new JTextField(10);

      reserveButton = new JButton("Réserver");
      cancelButton = new JButton("Annuler");

      northPanel.add(titleLabel);
      northPanel.add(new JLabel(""));
      northPanel.add(nameLabel);
      northPanel.add(nameField);
      northPanel.add(emailLabel);
      northPanel.add(emailField);
      northPanel.add(dateLabel);
      northPanel.add(dateField);
      northPanel.add(timeLabel);
      northPanel.add(timeField);
      northPanel.add(reserveButton);
      northPanel.add(cancelButton);
      TableMOdele tm = new TableMOdele();
      JTable table = new JTable(tm);
      JScrollPane jsp = new JScrollPane(table);
      add(jsp, BorderLayout.CENTER);

      reservations = new ArrayList<String[]>();

      reserveButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String date = dateField.getText();
            String time = timeField.getText();

            if(name.equals("") || email.equals("") || date.equals("") || time.equals("")) {
               JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
            } else {
               Reservation res =new Reservation(name, email, date, time);
               action.ajouter(res);
               tm.charger(action.afficher());
               JOptionPane.showMessageDialog(null, "La réservation a été effectuée avec succès !");
 }
               
         }
      });

      cancelButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });

      add(northPanel, BorderLayout.NORTH);
      
      setLocationRelativeTo(null);
 	  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 	  setVisible(true);
       pack();

   }
   
   
   public static void main(String[] args) {
      ReservationStade reservation = new ReservationStade();
      reservation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}
