//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class BigVigenere {
    private int[] key;
    private char [][] alphabet;
    // private static final String code = "abcdefghijklmnñopqrstuvwxzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    // private static final int LargoCode = code.length();

    public BigVigenere(){
        static scanner = new scanner (system.in);
        system.out.print ("ingrese la key");
        setKey(scanner.nextline());
    }



    public BigVigenere(String numericKey){
        int largo = numericKey.length();
        //Constructor que recibe la clave
        key = new int[largo];

        for (int i=0; i<largo; i++ ){
            key[i] = numericKey.ParseInt() / 10^(largo-1);
            largo--;
        }
        //numérica como una cadena y la almacena en el arreglo key. Y también genera la
        //matriz del alfabeto para el algoritmo Vigenère.
    }

    public String encrypt(String message) {

        // Método que cifra un mensaje
        // utilizando la clave numérica almacenada y la matriz del alfabeto usando el algoritmo
        // de Vigenère.
    }



    public class Main {
        public static void main(String[] args) {
            //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
            // to see how IntelliJ IDEA suggests fixing it.
            System.out.printf("Hello and welcome!");


        }
    }
}