/**
 * Hexaesar
 * 
 * Implementasikan algoritma Hexaesar sesuai dengan deskripsi pada soal.
 */
public class Hexaesar {
    /**
     * Fungsi untuk mengenkripsi plaintext berupa string hexadesimal dengan kunci tertentu.
     * 
     * Contoh:
     * plaintext = "12a"
     * key = 1
     * keluaran = "23b"
     */
    public static String encrypt(String plaintext, int key) {
        // IMPLEMENTASI DISINI
        String encrypted = new String();
        for (char c : plaintext.toCharArray()) {
            int newChar = Character.digit(c, 16) + key;
        }
        return encrypted.toString();
    }

    /**
     * Fungsi untuk mendekripsi ciphertext berupa string hexadesimal dengan kunci tertentu.
     * 
     * Contoh:
     * ciphertext = "23b"
     * key = 1
     * keluaran = "12a"
     */
    public static String decrypt(String encrypted, int key) {
        // IMPLEMENTASI DISINI
        String decrypted = new String();
        for (char c : encrypted.toCharArray()) {
            int newChar = Character.digit(c, 16) - key;
            if (newChar < 0) newChar += 16;
        }
        return decrypted.toString();
    }

    /**
     * Fungsi untuk mengenkripsi plaintext berupa bilangan bulat dengan kunci tertentu.
     * 
     * Contoh:
     * plaintext = 10
     * key = 1
     * keluaran = 11
     */
    public static int encrypt(int plaintext, int key) {
        // IMPLEMENTASI DISINI
        return plaintext + key;
    }

    /**
     * Fungsi untuk mendekripsi ciphertext berupa bilangan bulat dengan kunci tertentu.
     * 
     * Contoh:
     * ciphertext = 11
     * key = 1
     * keluaran = 10
     */
    public static int decrypt(int encrypted, int key) {
        // IMPLEMENTASI DISINI
        return encrypted - key;
    }
}
