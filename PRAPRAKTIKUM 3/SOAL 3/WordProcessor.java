import java.util.ArrayList;  

public class WordProcessor {
    // Atribut statik untuk menyimpan daftar kata
    private static ArrayList<String> kata;

    /**
     * Konstruktor
     * Inisialisasi daftar kata
     */
    public WordProcessor() {
        kata = new ArrayList<String>();
    }

    /**
     * Menambahkan kata ke dalam daftar kata
     * @param word
     */
    public static void addWord(String word) {
        kata.add(word);
    }

    /**
     * Menghapus kata dari daftar kata
     * @param word
     */
    public static void removeWord(String word) {
        kata.remove(word);
    }

    /**
     * Mencetak daftar kata dengan format:
     * 1. kata1
     * 2. kata2
     * ...
     */
    public static void printWords() {
        for (int i = 0; i < kata.size(); i++) {
            System.out.println((i + 1) + ". " + kata.get(i));
        }
    }

    /**
     * Mengembalikan kata terbalik pada index tertentu
     * Index dimulai dari 0
     * @param indeks
     * @return
     */
    private static StringBuilder reverseWord(int indeks) {
        if (indeks >= 0 && indeks < kata.size()) {
            String word = kata.get(indeks);
            return new StringBuilder(word).reverse();
        }
        return new StringBuilder(); 
    }
    
    /**
     * Mengembalikan apakah suatu kata pada index tertentu merupakan palindrome
     * Clue: gunakan method reverseWord
     * @param indeks
     * @return  true jika kata pada index tertentu merupakan palindrome
     *          false jika kata pada index tertentu bukan palindrome atau index tidak valid
     */
    public static boolean isPalindrome(int indeks) {
        if (indeks >= 0 && indeks < kata.size()) {
            String original = kata.get(indeks);
            String reversed = reverseWord(indeks).toString();
            return original.equals(reversed);
        }
        return false; 
    }
}