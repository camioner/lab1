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
        //no recuerdo para q era esto xd
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
        System.out.println("Mensaje reencriptado: ");


        input.close();

    }

    public BigVigenere(String numericKey) {
        //llenamois key[] con la clave por separado
        for (int i = 0; i < numericKey.length(); i++) {
            this.key[i] = Character.getNumericValue(numericKey.charAt(i));
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

        String encriptagain = newkey.encrypt(encryptedMessage);
        System.out.println("nuevo cifrado: " + encriptagain);

        input.close();
    }

    private int findPos(char target, int e) {

        for (int i = 0; i < 64; i++) {
            if (alphabet[e][i] == target) {
                return i;
            }
        }

        return 0;
    }

    public char optimalSearch(int position) {
//        Método que realiza la búsqueda del carácter corres -
//       pondiente de acuerdo a la posición indicada.Se busca realizar una búsqueda más eficiente que el caso
//        anterior.

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