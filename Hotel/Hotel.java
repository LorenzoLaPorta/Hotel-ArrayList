import java.util.ArrayList;
import java.util.Scanner;

public class Hotel{

    static ArrayList<Cliente> camere = new ArrayList<>(); //arrayList contenente le camere dell'hotel
    static final int MAX_CAMERE = 5; //costante che indica le camere dell'hotel
    static final int PREZZO_A_NOTTE = 50; //costante che indica il prezzo a notte delle camere

    static Scanner scanner = new Scanner(System.in); //scanner in grado di prendere input

    /**
     * funzione che gestisce l'inserimento di un cliente in camera
     * 
     * @param Cliente
     * @return boolean
     */
    public static boolean inserisciCliente(Cliente cliente){
        if (camere.size() < MAX_CAMERE){
            cliente.nome = Cliente.inserimentoString(scanner, "inserisci il nome del cliente");
            cliente.giornoEntrata = Cliente.inserimentoInt(scanner, "inserisci il giorno di ingresso del cliente");
            camere.add(cliente);
            return true;
        }
        return false;
    }

    /**
     * funzione che ricerca un cliente
     * 
     * @param Cliente
     * @param String
     * @return boolean
     */
    public static boolean cercaCliente(Cliente cliente, String nome){
        for (int i = 0; i < camere.size(); i++){
            if ((camere.get(i).nome).equals(nome)){
                pagamento(i);
                return true;
            }
        }
        return false;
    }

    /**
     * funzione che stampa il conto del cliente
     * 
     * @param int
     * @return void
     */
    public static void pagamento(int indice){
        int giornoEntrata = camere.get(indice).giornoEntrata;
        int giornoUscita = Cliente.inserimentoInt(scanner, "inserisci il giorno attuale");
        int prezzo = (giornoUscita - giornoEntrata) * PREZZO_A_NOTTE;
        eliminaCliente(indice);
        System.out.println("il conto da pagare e' di " + prezzo + " euro");
    }

    /**
     * funzione che elimina il cliente dalla camera
     * 
     * @param int
     * @return void
     */
    public static void eliminaCliente(int indice){
        camere.remove(camere.get(indice));
    }

    public static void stampaCamere(){
        for (int i = 0; i < camere.size(); i++) {
            System.out.println("Camera " + i + ": " + camere.get(i).toString());
        }
        for (int i = camere.size(); i < MAX_CAMERE; i++){
            System.out.println("Camera " + i + ": vuota");
        }
    }

    /**
     * funzione che stampa il menu
     * 
     * @param void
     * @return void
     */
    public static void stampamenu(){
        System.out.println("INSERISCI UNA DELLE SEGUENTI OPZIONI:");
        System.out.println("0) esci");
        System.out.println("1) checkin");
        System.out.println("2) checkout");
        System.out.println("3) stampa camere");
    }

    public static void main(String[] args){
        String opzione;
        do {
            Cliente cliente = new Cliente(null, 0); //oggetto cliente contenente tutti i dati dei clienti
            stampamenu();
            opzione = scanner.nextLine();
            switch (opzione){
                case "0":
                    break;
                case "1":
                    if (inserisciCliente(cliente)){
                        System.out.println("checkin avvenuto con successo");
                    }
                    else{
                        System.out.println("l'hotel e' pieno. Non puoi eseguire il checkin");
                    }
                    break;
                case "2":
                    String nome = Cliente.inserimentoString(scanner, "inserisci il nome del cliente che deve fare checkout");
                    if (cercaCliente(cliente, nome)){
                        
                    }
                    else{
                        System.out.println("il checkout non puo' avvenire, assicurati di aver inserito correttamente il nome da cercare");
                    }
                    break;
                case "3":
                    stampaCamere();
                    break;
                default:
                    System.out.println("L'inserimento e' errato. Riprova");
                    break;
            }
        } while (!(opzione.equals("0")));
    }
}