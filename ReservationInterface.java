package stad;

import java.util.ArrayList;
import java.util.List;

public interface ReservationInterface {
	
   public void ajouter(Reservation reservation);
   public void suppression(int index);
	public List<Reservation> afficher();
}
