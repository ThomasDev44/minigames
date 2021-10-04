import java.util.Scanner;

public class batailleNavale {

    public static void initialisation() {
        tableau = new char[TAILLE][TAILLE];

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                tableau[i][j] = '?';
            }
        }
        y = 0 + (int) (Math.random() * 4);
        x = 0 + (int) (Math.random() * 4);
    }

    public static void afficherTableau() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                System.out.print(tableau[i][j]);
            }
            System.out.println("");
        }

    }

    public static void essaie(int y, int x) {
        int colonne;
        int ligne;
        int nombreDeTentative = 0;
        String rejouer = "non";
        do {
            afficherTableau();

            System.out.println("Quelle colonne ?");
            colonne = scan.nextInt();
            colonne = colonne - 1;
            System.out.println("Quelle ligne ?");
            ligne = scan.nextInt();
            ligne = ligne - 1;
            nombreDeTentative = nombreDeTentative + 1;
            if (colonne != y || ligne != x) {
                System.out.println("Piouf ! à l'eau");
                tableau[colonne][ligne] = '~';
            } else {
                System.out.println("Boom ! touché coulé !");
                System.out.println("Bravo, vous avez gagné en " + nombreDeTentative + " essais");
                System.out.println("Voulez-vous rejouer ? Tapez oui si c'est le cas");
                Scanner scan2 = new Scanner(System.in);
                rejouer = scan2.nextLine();
                if (rejouer.equals("oui")) {
                    initialisation();
                    System.out.println("C'est repartit !");
                    y = 0 + (int) (Math.random() * 4);
                    x = 0 + (int) (Math.random() * 4);
                    essaie (y, x);
                }
            }
        } while (colonne != y || ligne != x || !rejouer.equals("non"));
    }

    static final int TAILLE = 4;
    static char[][] tableau;
    static Scanner scan = new Scanner(System.in);
    static int x;
    static int y;

    public static void main(String[] args) {
        initialisation();
        essaie(y, x);

    }

}
