import java.util.Arrays;
import java.util.Scanner;

public class pendue {
    static Scanner scan = new Scanner(System.in);
    static char[] tableauMotADevine;
    static char[] tableauMotPropose;
    static char[] tableauComparatif;
    static String mot;
    static int nbrLettres;
    static char[] vraiMot;

    public static int demanderMot() {

        System.out.println("Quel mot ?");
        mot = scan.nextLine();
        nbrLettres = mot.split("").length;
        vraiMot = mot.toCharArray();

        System.out.println(vraiMot[1]);

        return nbrLettres;
    }

    public static void initialiseTableau() {
        tableauMotADevine = new char[nbrLettres];
        tableauMotPropose = new char[nbrLettres];

        for (int j = 0; j < nbrLettres; j++) {
            if (vraiMot[j] != '-'){
            tableauMotADevine[j] = '_';
            }
            else tableauMotADevine[j] = '-';
        }
        for (int j = 0; j < nbrLettres; j++) {
            tableauMotPropose[j] = vraiMot[j];
            System.out.println(tableauMotPropose[j]);
        }
}
    

    public static void afficherTableau() {

        for (int j = 0; j < nbrLettres; j++) {
            System.out.print(tableauMotADevine[j]);
        }
        System.out.println("");
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) {
            System.out.println("");
        }

    }

    public static void proposition() {
        char devineLettre;
        int essaie = 0;
        boolean stop = false;
        boolean pasDessaie = false;

        do {
            if (essaie < 11 && stop == false) {
                pasDessaie = false;
                System.out.println("Quelle lettre ? Vous avez fait " +essaie + " essaie(s) sur 11");
                String str = scan.nextLine();
                devineLettre = str.charAt(0);
                for (int i = 0; i < nbrLettres; i++) {
                    if (tableauMotPropose[i] == devineLettre) {
                        tableauMotADevine[i] = devineLettre;
                        pasDessaie = true;
                   }
                }   
                afficherTableau();
                if (pasDessaie == false){
                    essaie = essaie + 1;
                }

                if (java.util.Arrays.equals(tableauMotADevine, tableauMotPropose)) {
                    stop = true;
                } else {
                    stop = false;
                }
            }
        } while (essaie < 11 && stop == false);
    }

    public static void main(String[] args) {

        nbrLettres = demanderMot();
        initialiseTableau();
        clearScreen();
        afficherTableau();
        proposition();
        if (java.util.Arrays.equals(tableauMotADevine, tableauMotPropose)) {
            System.out.println("Bravo vous avez gagné !");
        }
        else {
            System.out.println("Dommage vous avez perdu");
        }

    }
}
