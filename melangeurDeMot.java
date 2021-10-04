public class melangeurDeMot {

    public static String melanger(String phrase) {
        final int nbrMots = phrase.split(" ").length;
        String prochain = "";
        for (int mot = 0; mot < nbrMots; mot++) {
            char[] caractere = phrase.split(" ")[mot].toCharArray();
            for (int i = 1; i < caractere.length; i++) {
                int random1 = 1 + (int) (Math.random() * (caractere.length - 2));
                int random2 = 1 + (int) (Math.random() * (caractere.length - 2));
                char lettreRandom = caractere[random1];
                caractere[random1] = caractere[random2];
                caractere[random2] = lettreRandom;
            }

            for (int c = 0; c < caractere.length; c++) {                                     // for (char c : caractere)
                char carac = caractere[c];
                prochain = prochain + carac;                                                 // prochain = prochain + c;
            }
            if (mot < nbrMots - 1)
                prochain = prochain + " ";
        }
        return prochain;
    }

    public static void main(String[] args) {
        String phrase = "mélange les lettres (sauf la première et la dernière) de chaque mot d'une phrase et qui affiche la phrase avec les mots mélangés.";
        String laPhrase = melanger(phrase);
        System.out.println(laPhrase);
    }
}