package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int forcePotion;
	private int effetPotionMin;
	private int effetPotionMax;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		this.forcePotion = 1;
		parler("Bonjour je suis le druide " + nom + "et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");

	}

	private String prendreParole() {
		return "Le druide" + nom + " : ";

	}
	public void preparerPotion() {
		Random random = new Random();
		forcePotion = random.nextInt(effetPotionMax);
		while((forcePotion < effetPotionMin)) {
			forcePotion += 1;
		}
		if (forcePotion > 7) {
			System.out.println("J'ai préparé une super potion de force "+forcePotion);
			
		} else {
			System.out.println("Je n'ai pas trouve tous les ingrédients, ma potion est seulement de force "+forcePotion);

		}
		
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
	}
}
