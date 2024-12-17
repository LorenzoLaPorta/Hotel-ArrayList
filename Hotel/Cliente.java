import java.util.Scanner;

public class Cliente{
    //ATTRIBUTI
    String nome;
    int giornoEntrata;
    //---------

    //costruttore
    public Cliente(String nome, int giornoEntrata){
        this.nome = nome;
        this.giornoEntrata = giornoEntrata;
    }

    /**
     * override del metodo toString che restituisce la stringa per la stampa della lista
     * 
     * @param void
     * @return String
     */
    @Override
    public String toString(){
        return "cliente ( Nome: " + this.nome + ", Giorno di ingresso: " + giornoEntrata + " )";
    }

    /**
     * funzione che gestisce l'inserimento di dati String
     * 
     * @param Scanner
     * @param String
     * @return String
     */
    public static String inserimentoString(Scanner scanner, String messaggio){
        System.out.println(messaggio);
        return scanner.nextLine();
    }  
    /**
     * funzione che gestisce l'inserimento di dati String
     * 
     * @param Scanner
     * @param String
     * @return String
     */  
    public static int inserimentoInt(Scanner scanner, String messaggio){
        System.out.println(messaggio);
        int intero = scanner.nextInt();
        scanner.nextLine();
        return intero;
    }
}