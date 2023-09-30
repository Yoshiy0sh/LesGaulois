package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom,int force) {
		super();
		assert force > 0;
		this.nom = nom;
		this.force  = force;
	}
	
// rule s4274 désactivée pour le donctionnement des assert
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole()+"<<"+texte+">>");
		
	}
	
	private String prendreParole() {
		return "Le romain "+ nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		int force_debut = getForce();
		assert force_debut >0;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne");
		}
		assert getForce() < force_debut;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",-6);
		System.out.println(minus.getForce());
	}
}
