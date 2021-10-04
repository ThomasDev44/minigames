import java.time.temporal.ValueRange;
import java.util.Scanner;

public class batailleDeCarte {

    static int[][] tableau;
    static int coef = 0;
    static int valeurDeCarte = 1;
    static int pointJoueur1 = 0;
    static int pointJoueur2 = 0;
    static int STOP1 = 0;
    static Scanner scan = new Scanner(System.in);

    public static void pause(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void afficherTableau() {
        for (coef = 0; coef < 4; coef++) {
            for (int i = 0; i < 2; i++) {
                for (int j = coef * 13; j < 13 * (coef + 1); j++) {
                    System.out.print(tableau[i][j]);
                }
                System.out.println("");
            }
        }
    }
    public static int verification(){
       int verifier = 0;
       int calcultotal = 0;
       int calcul = 0;

            for (int i = 1; i <= 1 ; i++) {
                for (int j = 0 ; j < 52; j++) {
                    calcul = tableau [1][j];
                    calcultotal = calcultotal + calcul;   } 
                    if (calcultotal == 0){
                        verifier = 0;
                    }
            else
        {
            verifier = 1;
        }}
return verifier;
    }

    public static void initialisation() {

        for (coef = 0; coef < 4; coef++) {
            for (int i = 0; i < 2; i++) {
                valeurDeCarte = 1;
                for (int j = coef * 13; j < 13 * (coef + 1); j++) {
                    if (i == 0) {
                        tableau[i][j] = 1 * (coef + 1);
                    } else {
                        tableau[i][j] = valeurDeCarte;
                        valeurDeCarte = valeurDeCarte + 1;
                    }
                }
            }
        }
    }

    public static int carteRandom() {
        int uneCarte;
        do {
            uneCarte = 0 + (int) (Math.random() * 52);

        } while (tableau[1][uneCarte] == 0);
        return uneCarte;
    }

    public static String joueur1couleur(int carte) {
        int couleurCarteJoueur1;
        String couleurCarteJ1 = "";
        couleurCarteJoueur1 = tableau[0][carte];
        switch (couleurCarteJoueur1) {
            case 1:
                couleurCarteJ1 = "coeur";
                break;
            case 2:
                couleurCarteJ1 = "carreau";
                break;
            case 3:
                couleurCarteJ1 = "trèfle";
                break;
            case 4:
                couleurCarteJ1 = "pique";
                break;
        }
        return couleurCarteJ1;
    }

    public static int joueur1valeur(int carte) {
        int valeurCarteJoeur1 = 0;
        valeurCarteJoeur1 = tableau[1][carte];
        tableau[1][carte] = 0;
        return valeurCarteJoeur1;
    }

    public static String joueur2couleur(int carte) {
        int couleurCarteJoueur2;
        String couleurCarteJ2 = "";
        couleurCarteJoueur2 = tableau[0][carte];
        switch (couleurCarteJoueur2) {
            case 1:
                couleurCarteJ2 = "coeur";
                break;
            case 2:
                couleurCarteJ2 = "carreau";
                break;
            case 3:
                couleurCarteJ2 = "trèfle";
                break;
            case 4:
                couleurCarteJ2 = "pique";
                break;
        }
        return couleurCarteJ2;
    }

    public static int joueur2valeur(int carte) {
        int valeurCarteJoeur2 = 0;
        valeurCarteJoeur2 = tableau[1][carte];
        tableau[1][carte] = 0;
        return valeurCarteJoeur2;
    }

    public static void comparatif(int carte1, int carte2) {

        if (carte1 > carte2) {
            System.out.println("Le joueur numéro 1 gagne cette partie !");
            pointJoueur1 = pointJoueur1 + 1;
            pause();
            System.out.println("Le joueur numéro 1 à " + pointJoueur1 + " point(s)");
            pause();
        } else if (carte1 < carte2) {
            System.out.println("Le joueur numéro 2 gagne cette partie !");
            pointJoueur2 = pointJoueur2 + 1;
            pause();
            System.out.println("Le joueur numéro 2 à " + pointJoueur2 + " point(s)");
            pause();
        } else {
            System.out.println("Egalité !");
            pause();
        }
    }

    public static void main(String[] args) {
        int uneCarte;
        String couleurCarteJoueur1;
        String couleurCarteJoueur2;
        int valeurCarteJoueur1;
        int valeurCarteJoueur2;
        int STOP;
        int pioche = 0;
        tableau = new int[2][52];
        initialisation();
        do {
            STOP1 = verification();
            System.out.println(
                    "Si vous voulez arrêter la partie, appuyez sur 0, sinon appuyez sur n'importe quel chiffre");
            STOP = scan.nextInt();
            if (STOP != 0 && STOP1 !=0) {
                uneCarte = carteRandom();
                // MKeyListener keypress= new MKeyListener();
                // keypress.ev
                System.out.println("Joueur numéro 1, appuyez sur un chiffre pour piocher");
                pioche = scan.nextInt();
                couleurCarteJoueur1 = joueur1couleur(uneCarte);
                valeurCarteJoueur1 = joueur1valeur(uneCarte);
                System.out.println(
                        "La carte du joueur numéro 1 est un " + valeurCarteJoueur1 + " de " + couleurCarteJoueur1);
                        pause();
                System.out.println("Joueur numéro 2, appuyez sur un chiffre pour piocher");
                pioche = scan.nextInt();
                uneCarte = carteRandom();
                couleurCarteJoueur2 = joueur1couleur(uneCarte);
                valeurCarteJoueur2 = joueur1valeur(uneCarte);
                System.out.println(
                        "La carte du joueur numéro 2 est un " + valeurCarteJoueur2 + " de " + couleurCarteJoueur2);
                        pause();
                        System.out.println("Appuyez sur un chiffre pour comparer les cartes");
                        pioche = scan.nextInt();
                comparatif(valeurCarteJoueur1, valeurCarteJoueur2);
            }
        } while (STOP != 0 && STOP1 != 0);
        System.out.println("Merci d'avoir joué !");

    }

}