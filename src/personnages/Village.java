package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
		
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;

	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		this.villageois[this.nbVillageois] = gaulois;
		this.nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int numVillageois) {
		return this.villageois[numVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+ chef + " vivent les légendaires gaulois :");
		int i = 0;
		while((i < nbVillageois) &&(trouverHabitant(i) != null) ){
			System.out.println("\n - "+trouverHabitant(i).getNom());
			i+=1;
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",2);
//		Gaulois gaulois = village.trouverHabitant(30);
//		 on obtient cette exception car le tableau va de l'indice 0 à l'indice 29
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		ça ne marche pas car il n'y a pas d'affectation à l'indice 1, seulement à l'indice 0
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}

}

