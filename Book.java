package bookrecommender;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * La classe Book rappresenta un libro e fornisce funzionalità per gestire le operazioni correlate ai libri.
 * Estende la classe Utente.
 */
public class Book extends Utente {
    private static String titolo;
    private static String autore;
    private static int anno;
    private static String descrizione;
    private static int valutazione;
    private static boolean isUserLoggedIn;

    /**
     * Costruttore della classe Book.
     * 
     * @param titolo il titolo del libro
     * @param autore l'autore del libro
     * @param anno l'anno di pubblicazione del libro
     * @param descrizione la descrizione del libro
     * @param valutazione la valutazione del libro
     */
    public Book(String titolo, String autore, int anno, String descrizione, int valutazione) {
        Book.titolo = titolo;
        Book.autore = autore;
        Book.anno = anno;
        Book.descrizione = descrizione;
        Book.valutazione = valutazione;
    }

    /**
     * Costruttore alternativo della classe Book.
     * 
     * @param autore l'autore del libro
     * @param anno l'anno di pubblicazione del libro
     * @param descrizione la descrizione del libro
     * @param valutazione la valutazione del libro
     * @param titolo il titolo del libro
     */
    public Book(String autore, int anno, String descrizione, int valutazione, String titolo) {
        // Implementazione mancante
    }

    /**
     * Restituisce il titolo del libro.
     * 
     * @return il titolo del libro
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Restituisce l'autore del libro.
     * 
     * @return l'autore del libro
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Restituisce l'anno di pubblicazione del libro.
     * 
     * @return l'anno di pubblicazione del libro
     */
    public int getAnno() {
        return anno;
    }

    /**
     * Restituisce la descrizione del libro.
     * 
     * @return la descrizione del libro
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Restituisce la valutazione del libro.
     * 
     * @return la valutazione del libro
     */
    public int getValutazione() {
        return valutazione;
    }

    /**
     * Mostra il menu per visualizzare il riassunto delle valutazioni o i libri consigliati.
     */
    public static void menuRiassuntoValutazioni() {
        Scanner in = new Scanner(System.in);
        System.out.print("Premi 1 per visualizzare le valutazioni, 2 per i libri consigliati: ");
        int scelta = in.nextInt();

        switch (scelta) {
            case 1:
                mostraRiassuntoValutazioni();
                break;
            case 2:
                mostraLibriConsigliati();
                break;
            case 3:
                mostraLibreria();
                break;
            default:
                System.out.println("Scelta non valida.");
        }
    }

    /**
     * Mostra un riassunto delle valutazioni dei libri.
     */
    public static void mostraRiassuntoValutazioni() {
        String line = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/hp/eclipse-workspace/BookRecommender/CSV/ValutazioniUtente.csv"));

            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra i libri consigliati all'utente.
     */
    public static void mostraLibriConsigliati() {
        String path = "C:/Users/hp/eclipse-workspace/BookRecommender/CSV/SuggerimentiUtente.csv";
        String line = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra la libreria dell'utente.
     */
    public static void mostraLibreria() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:/Users/hp/eclipse-workspace/BookRecommender/CSV/Librerie.dati.csv"));
            String line = ",";
            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mostra i commenti degli utenti sui libri.
     */
    public static void mostraCommentiUtenti() {
        String path = "C:/Users/hp/eclipse-workspace/BookRecommender/CSV/ValutazioniUtente.csv";
        String line = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Permette di cercare un libro in base a diversi criteri.
     */
    public static void cercaLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Funzionalità di ricerca di libri:");
        System.out.println("1. Ricerca per titolo");
        System.out.println("2. Ricerca per autore");
        System.out.println("3. Ricerca per autore e anno");
        System.out.println("Seleziona qualsiasi altro numero per tornare al menù principale");
        System.out.print("Seleziona una opzione (1/2/3): ");
        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1:
                System.out.print("Inserisci il titolo del libro: ");
                scanner.nextLine(); 
                String titolo = scanner.nextLine();
                ricercaPerTitolo(titolo);
                break;
            case 2:
                System.out.print("Inserisci il nome dell'autore: ");
                scanner.nextLine(); 
                String autore = scanner.nextLine();
                ricercaPerAutore(autore);
                break;
            case 3:
                System.out.print("Inserisci il nome dell'autore: ");
                scanner.nextLine(); 
                String autore1 = scanner.nextLine();
                System.out.print("Inserisci l'anno di pubblicazione: ");
                int anno1 = scanner.nextInt();
                cercaLibroAutoreEAnno(autore1, anno1);
                break;
            default:
                System.out.println("Opzione non valida. Ritorno al menù principale.");
        }
    }

    /**
     * Cerca un libro in base al titolo.
     * 
     * @param titolo il titolo del libro da cercare
     */
    public static void ricercaPerTitolo(String titolo) {
        List<String> libriTrovati = new ArrayList<>();
        String path = "/Users/hp/eclipse-workspace/BookRecommender/CSV/Libri.dati.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] libro = line.split(",");
                if (libro.length >= 1 && libro[0].toLowerCase().contains(titolo.toLowerCase())) {
                    libriTrovati.add(libro[0]);
                }
            }
            if (libriTrovati.isEmpty()) {
                System.out.println("Nessun libro trovato con il titolo '" + titolo + "'.");
            } else {
                System.out.println("Libri trovati con il titolo '" + titolo + "':");
                for (String libro : libriTrovati) {
                    System.out.println(libro);
                }
            }
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la ricerca dei libri per titolo.");
            e.printStackTrace();
        }
    }

    /**
     * Cerca un libro in base all'autore.
     * 
     * @param autore il nome dell'autore del libro da cercare
     */
    public static void ricercaPerAutore(String autore) {
        List<String> libriTrovati = new ArrayList<>();
        String path = "/Users/hp/eclipse-workspace/BookRecommender/CSV/Libri.dati.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] libro = line.split(",");
                if (libro.length >= 2 && libro[1].toLowerCase().contains(autore.toLowerCase())) {
                    libriTrovati.add(libro[0]);
                }
            }
            if (libriTrovati.isEmpty()) {
                System.out.println("Nessun libro trovato per l'autore '" + autore + "'.");
            } else {
                System.out.println("Libri trovati per l'autore '" + autore + "':");
                for (String libro : libriTrovati) {
                    System.out.println(libro);
                }
            }
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la ricerca dei libri per autore.");
            e.printStackTrace();
        }
    }

    /**
     * Cerca un libro in base all'autore e all'anno di pubblicazione.
     * 
     * @param autore l'autore del libro
     * @param anno l'anno di pubblicazione del libro
     */
    public static void cercaLibroAutoreEAnno(String autore, int anno) {
        List<String> libriTrovati = new ArrayList<>();
        String path = "/Users/hp/eclipse-workspace/BookRecommender/CSV/Libri.dati.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] libro = line.split(",");
                if (libro.length >= 3 && libro[1].toLowerCase().contains(autore.toLowerCase()) && Integer.parseInt(libro[2]) == anno) {
                    libriTrovati.add(libro[0]);
                }
            }
            if (libriTrovati.isEmpty()) {
                System.out.println("Nessun libro trovato per l'autore '" + autore + "' e l'anno '" + anno + "'.");
            } else {
                System.out.println("Libri trovati per l'autore '" + autore + "' e l'anno '" + anno + "':");
                for (String libro : libriTrovati) {
                    System.out.println(libro);
                }
            }
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante la ricerca dei libri per autore e anno.");
            e.printStackTrace();
        }
    }
}
