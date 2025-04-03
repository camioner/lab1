//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

//public class BigVigenere {
//    private int[] key;
//    private char [][] alphabet;
//    // private static final String code = "abcdefghijklmnñopqrstuvwxzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//    // private static final int LargoCode = code.length();
//
//    public BigVigenere(){
//        static scanner = new scanner (system.in);
//        system.out.print ("ingrese la key");
//        setKey(scanner.nextline());
//    }
//
//
//
//    public BigVigenere(String numericKey){
//        int largo = numericKey.length();
//        //Constructor que recibe la clave
//        key = new int[largo];
//
//        for (int i=0; i<largo; i++ ){
//            key[i] = numericKey.ParseInt() / 10^(largo-1);
//            largo--;
//        }
//        //numérica como una cadena y la almacena en el arreglo key. Y también genera la
//        //matriz del alfabeto para el algoritmo Vigenère.
//    }

class BigVigenere {
    private int key[];
    private char[][] alphabet= new char[64][64];
    String alphanumeric = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public BigVigenere() {
        System.out.println(" ingrese la clave ");
        Scanner input= new Scanner(System.in);
        String Skey=input.nextLine();
        input.close();
        this.key= new int[Skey.length()];
        //llenamois key[] con la clave por separado
        for (int i = 0; i < Skey.length(); i++) {
            this.key[i] = Character.getNumericValue(Skey.charAt(i));
        }
        //esto llena alphabet con alphanumeric en forma de espiral , es una matrisz de 64x64
        for (int i = 0; i < alphanumeric.length(); i++) {
            for (int j = 0; j < alphanumeric.length(); j++) {
                alphabet[i][j] = alphanumeric.charAt((i + j) % alphanumeric.length());
            }
        }
        input.close();


    }
    public BigVigenere(String numericKey){

        //llenamois key[] con la clave por separado
        for (int i = 0; i < Skey.length(); i++) {
            this.key[i] = Character.getNumericValue(Skey.charAt(i));
        }
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
