package Java_DataStructures.domaine;

public class Enumeration {

	private static class Etudiant0 {
		private String nom;
		private String filiere;
		public Etudiant0(String nom, String filiere) { this.nom=nom; this.filiere=filiere; }
	}
	// 1) Version standard : déclaration de constantes (dans une classe attitrée)
	// --------------------------------------------------------------------------
	private static class Filiere1 {
		static final int EE = 0, IG = 1, ID = 2, IBM = 3;
	}

	private static class Etudiant1 {
		private String nom;
		private int filiere;		// on conserve la valeur (mais n'importe quel int)
		public Etudiant1(String nom, int filiere) { this.nom=nom; this.filiere=filiere; }
	}

	// 2) Version Object : class Filiere, création d'instance pour chaque valeur
	// -------------------------------------------------------------------------
	private static class Filiere2 { 
		static final Filiere2 EE = new Filiere2(0), IG = new Filiere2(1), ID = new Filiere2(2), IBM = new Filiere2(3); 
		private int f;
		public Filiere2(int f) { this.f=f; }
	}
	private static class Etudiant2 {
		private String nom;
		private Filiere2 filiere;
		public Etudiant2(String nom, Filiere2 filiere) { this.nom=nom; this.filiere=filiere; }
	}

	// 3) Version Object : abstract class Const & class Filiere
	// --------------------------------------------------------
	abstract static class Const implements Comparable { 
		private String ident;               // Nom de la constante 
		private final int ord = baseOrd++;  // Ordinal de la constante 
		protected static int baseOrd = 0;   // Ordinal de base 

		protected Const(String ident) { this.ident = ident; }
		public final int ordinal() { return ord; }
		public final String toString() { return ident; }
		public final boolean equals(Object o) { return super.equals(o); }
		public final int compareTo(Object n) { return ord - ((Const)n).ordinal(); }
	}
	
	final static class Filiere3 extends Const { 
		static final Filiere3 EE = new Filiere3("EE"), IG = new Filiere3("IG"), ID = new Filiere3("ID"), IBM = new Filiere3("IBM");
		private Filiere3(String ident) { super(ident); }
		static { baseOrd = 0; }
	}

	private static class Etudiant3 {
		private String nom;
		private Filiere3 filiere;
		public Etudiant3(String nom, Filiere3 filiere) { this.nom=nom; this.filiere=filiere; }
	}

	// 4) Version enum
	// ---------------
	private static enum Filiere4 { EE, IG, ID, IBM }

	private static class Etudiant4 {
		private String nom;
		private Filiere4 filiere;
		public Etudiant4(String nom, Filiere4 filiere) { this.nom=nom; this.filiere=filiere; }
	}

	private static enum EnumAvecValeurEtConstructeur { 
		EE(123), IG(234), ID(345), IBM(456);
		private int valeur;
		EnumAvecValeurEtConstructeur(int valeur) { this.valeur=valeur; }
		int getValeur() { return valeur; }
	}

	// =========================================================================

	// Test des 5 versions ci-dessus
	// -----------------------------
	private static void testEnum() {
		Etudiant0 et0a = new Etudiant0("Stettler", "IG");
		Etudiant0 et0b = new Etudiant0("Stettler", "xyz");			// Problème: ceci est accepté !

//		-----------------------------------------------------------------

		Etudiant1 et1a = new Etudiant1("Stettler", Filiere1.IG);
		Etudiant1 et1b = new Etudiant1("Stettler", 55);				// Problème: ceci est accepté !

//		-----------------------------------------------------------------

		Etudiant2 et2a = new Etudiant2("Stettler", Filiere2.IG);
//		Etudiant2 et2b = new Etudiant2("Stettler", 55);				// OK: ceci est refusé
		System.out.println(et2a.filiere);                        // Problème: impossible d'afficher l'identifiant (uniquement la valeur)
		if (et2a.filiere == Filiere2.IG) { }                     // OK: on peut tester
//		switch (et2a.filiere) { case Filiere2.IG: }              // Problème: impossible de faire de switch (sur l'instance de filiere)

//		-----------------------------------------------------------------

		Etudiant3 et3a = new Etudiant3("Stettler", Filiere3.IG);
//		Etudiant3 et3b = new Etudiant3("Stettler", 55);				// OK: ceci est refusé
		System.out.println(et3a.filiere);                        // OK: on peut afficher l'identifiant
		if (et3a.filiere == Filiere3.IG) { }                     // OK: on peut tester
//		switch (et3a.filiere) { case Filiere3.IG: }              // Problème: impossible de faire de switch (sur l'instance de filiere)

//		-----------------------------------------------------------------

		Etudiant4 et4a = new Etudiant4("Stettler", Filiere4.IG);
//		Etudiant4 et4b = new Etudiant4("Stettler", 55);				// OK: ceci est refusé
		System.out.println(et4a.filiere);                        // OK: on peut afficher l'identifiant
		if (et4a.filiere == Filiere4.IG) { }                     // OK: on peut tester
		switch (et4a.filiere) { case IG: }                       // OK: on peut faire des switch
		for(Filiere4 f : Filiere4.values()){System.out.println(f);}//OK: possibilité d'avoir la liste de tous les identifiants: values()
		Filiere4 f = Filiere4.valueOf("IG");                     // OK: possibilité de trouver une instance d'après son nom: valueOf()
	}
	
	// =========================================================================

	public static void main (String[] args) {
		testEnum();
	}
}