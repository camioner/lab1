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
        input.close();

        this.key = new int[Skey.length()];
        for (int i = 0; i < Skey.length(); i++) {
            this.key[i] = Character.getNumericValue(Skey.charAt(i));
        }

// llenamois key[] con la clave por separado
// for (int i = 0; i < Skey.length(); i++) {
// this.key[i] = Character.getNumericValue(Skey.charAt(i));
// }
// esto llena alphabet con alphanumeric en forma de espiral , es una matrisz de 64x64
        for (int i = 0; i < alphanumeric.length(); i++) {
            for (int j = 0; j < alphanumeric.length(); j++) {
                alphabet[i][j] = alphanumeric.charAt((i + j) % alphanumeric.length());
            }
        }


    }

    public BigVigenere(String numericKey) {
// Constructor que recibe la clave en forma de String y
// luego la transforma a la clave númerica correspondiente para almacenarla en el atributo key. También
// genera la matriz del alfabeto para el algoritmo Vigenère

        //llenamois key[] con la clave por separado
        for (int i = 0; i < numericKey.length(); i++) {
            this.key[i] = Character.getNumericValue(numericKey.charAt(i));
        }
    }

    public String encrypt(String message) {
// Método que cifra un mensaje utilizando la clave numérica
// almacenada y la matriz del alfabeto usando el algoritmo de Vigenère
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

    }

    private int findPos(char target, int e) {
        for (int i = 0; i < 64; i++) {
            if (alphabet[e][i] == target) {
                return i;
            }
        }
        return 0;
    }

}


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        BigVigenere cifrado = new BigVigenere();

    }
}