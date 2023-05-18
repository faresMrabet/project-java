package stad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ReservationInterfaceImpl implements ReservationInterface{
	
	private Connection cx=SingletonConnection.getInstance();

	@Override
	public void ajouter(Reservation reservation) {
		try {
			PreparedStatement ps=cx.prepareStatement("insert into Reservation(nom,email,date,heure) values(?,?,?,?)");
	        ps.setString(1, reservation.getNom());
	        ps.setString(2, reservation.getEmail());
	        ps.setString(3, reservation.getDate());
	        ps.setString(4, reservation.getHeure());
	        ps.executeUpdate();
	        
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public List<Reservation> afficher() {
		List<Reservation>liste=new ArrayList<>();
		try {
			PreparedStatement ps=cx.prepareStatement("select * from Reservation");
	        
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	Reservation reservation=new Reservation( rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
	            liste.add(reservation);
	        }
	        
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return liste;
	}

	

	@Override
	public void suppression(int index) {
		// TODO Auto-generated method stub
		
	}

}

