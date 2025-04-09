//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

class BigVigenere {
    private int key[];
    private char[][] alphabet = new char[64][64];
    String alphanumeric = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";

    public BigVigenere() {
        System.out.println(" ingrese la clave ");
        Scanner input = new Scanner(System.in);
        String Skey = input.nextLine();

        System.out.println(" ingrese el mensaje a cifrar ");
        input = new Scanner(System.in);
        String mnsj = input.nextLine();

        this.key = new int[Skey.length()];
        // Convertimos la clave String a arreglo de enteros
        for (int i = 0; i < Skey.length(); i++) {
            this.key[i] = Character.getNumericValue(Skey.charAt(i));
        }

        // llenamois la matriz con el aalfabeto
        for (int i = 0; i < alphanumeric.length(); i++) {
            for (int j = 0; j < alphanumeric.length(); j++) {
                alphabet[i][j] = alphanumeric.charAt((i + j) % alphanumeric.length());
            }
        }

        String cifrado = encrypt(mnsj);
        System.out.println("Mensaje cifrado: " + cifrado);

        String descifrado = decrypt(cifrado);
        System.out.println("Mensaje descifrado: " + descifrado);

        reEncrypt(cifrado);


        input.close();

    }

    public BigVigenere(String numericKey) {
        this.key = new int[numericKey.length()];
        //llenamois key[] con la clave por separado
        for (int i = 0; i < numericKey.length(); i++) {
            this.key[i] = Character.getNumericValue(numericKey.charAt(i));
        }

        //si no se inicializa otra vez el alphabeto , no logra cifrar dnvo
        for (int i = 0; i < alphanumeric.length(); i++) {
            for (int j = 0; j < alphanumeric.length(); j++) {
                alphabet[i][j] = alphanumeric.charAt((i + j) % alphanumeric.length());
            }
        }
    }

    public String encrypt(String message) {
        char[] encrypted = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            encrypted[i] = alphabet[findPos(message.charAt(i), 0)][key[i % key.length]];
        }

        return new String(encrypted);

    }

    public String decrypt(String encryptedMessage) {
        StringBuilder resultado = new StringBuilder();
        int largo = key.length;

        for (int i = 0; i < encryptedMessage.length(); i++) {
            int pos = key[i % largo];
            int basepos = findPos(encryptedMessage.charAt(i), pos);
            resultado.append(alphabet[0][basepos]);
        }

        return new String(resultado);

    }

    public void reEncrypt(String encryptedMessage) {
        System.out.println("introduzca una nueva clave :");

        Scanner input = new Scanner(System.in);
        String clave = input.nextLine();

        BigVigenere newkey = new BigVigenere(clave);

        String newmsj = this.decrypt(encryptedMessage);

        String encriptagain = newkey.encrypt(newmsj);

        System.out.println("nuevo cifrado: " + encriptagain);

        input.close();
    }

    public int findPos(char target, int e) {

        for (int i = 0; i < 64; i++) {
            if (alphabet[e][i] == target) {
                return i;
            }
        }

        return 0;
    }

    public char search(int position) {
        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (position == i * alphabet.length + j) {
                    return alphabet[i][j];
                }
            }
        }
        return 0;
    }


    public char optimalSearch(int position) {
        if (position < 0 || position >= 4096) { // 64*64 = 4096
            throw new IllegalArgumentException("Posición fuera de rango.");
        }

        int fila = position / 64;
        int columna = position % 64;

        return alphabet[fila][columna];
    }


}


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        BigVigenere cifrado = new BigVigenere();

        // Medir tiempo de ejecución de search
        int testPosition = 1000;

        long startSearch = System.nanoTime();
        char resultSearch = cifrado.search(testPosition);
        long endSearch = System.nanoTime();
        long durationSearch = endSearch - startSearch;

        System.out.println("search(" + testPosition + ") = '" + resultSearch + "' en " + durationSearch + " ns");

        // Medir tiempo de ejecución de optimalSearch
        long startOptimal = System.nanoTime();
        char resultOptimal = cifrado.optimalSearch(testPosition);
        long endOptimal = System.nanoTime();
        long durationOptimal = endOptimal - startOptimal;

        System.out.println("optimalSearch(" + testPosition + ") = '" + resultOptimal + "' en " + durationOptimal + " ns");


    }
}