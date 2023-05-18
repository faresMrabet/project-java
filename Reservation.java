package stad;

public class Reservation {
	   private String nom;
	   private String email;
	   private String date;
	   private String heure;

	   public Reservation(String nom, String email, String date, String heure) {
	      this.nom = nom;
	      this.email = email;
	      this.date = date;
	      this.heure = heure;
	   }

	   public String getNom() {
	      return nom;
	   }

	   public void setNom(String nom) {
	      this.nom = nom;
	   }

	   public String getEmail() {
	      return email;
	   }

	   public void setEmail(String email) {
	      this.email = email;
	   }

	   public String getDate() {
	      return date;
	   }

	   public void setDate(String date) {
	      this.date = date;
	   }

	   public String getHeure() {
	      return heure;
	   }

	   public void setHeure(String heure) {
	      this.heure = heure;
	   }
	}
