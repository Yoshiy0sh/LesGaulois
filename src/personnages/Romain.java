package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	
	
	public Romain(String nom,int force) {
		super();
		assert force > 0;
		this.nom = nom;
		this.force  = force;
		this.equipements = new Equipement[2];
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
	
	private void equiperRomain(Equipement e,int i) {
		equipements[i] = e;
		System.out.println("Le soldat "+getNom()+" est équipé avec un " + e.getNom()+" .");
		nbEquipements += 1;
	}
	
	public void sEquiper(Equipement e) {
		switch(nbEquipements) {
		case 2:
			System.out.println("Le soldat "+getNom()+" est déjà bien protégé !");
			break;
		case 1: 
			if(e == equipements[0]) {
				System.out.println("Le soldat "+getNom()+ " possede déjà un "+e.getNom()+ " !");
			}
			else {
				equiperRomain(e,1);
			}
			break;
		default :
			equiperRomain(e,0);
			
		}
		
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",10);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
