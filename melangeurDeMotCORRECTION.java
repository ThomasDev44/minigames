
import java.util.Arrays;
import java.util.Random;

public class melangeurDeMotCORRECTION {

    private static String melangerMot(String mot){
        char[] tabMot = mot.toCharArray();
        char[] tabMotMelange = new char[tabMot.length];

        //premier et dernier caractères identiques 
        tabMotMelange[0] = tabMot[0];
        tabMotMelange[tabMot.length -1] = tabMot[tabMot.length -1];

        Random position = new Random();

        for (int i = 1; i < tabMot.length-1; i++) {
            int indexAleatoire = 0;

            do {
                indexAleatoire = position.nextInt(tabMot.length-1);
            } while (tabMotMelange[indexAleatoire] != '\u0000');

            tabMotMelange[indexAleatoire] = tabMot[i];
        }

        String motMelange = String.valueOf(tabMotMelange);

        return motMelange;
    }

    public static void main(String[] args) {
        String chaine = "Notre cerveau est formidable car il est capable "
        + "de lire un mot même si ses lettres sont mélangées";

        String[] motsPhrase = chaine.split("[ ]");

        String phraseMelange = "";

        for (String mot : motsPhrase) {

            String motMelange;
            
            if (mot.length() <= 3) {
                motMelange = mot;
            } else {
                motMelange = melangerMot(mot);
            }

            phraseMelange = phraseMelange + " " + motMelange;
        }

        System.out.println(phraseMelange);
    }
}
