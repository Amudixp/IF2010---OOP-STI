/* Amudi Purba
 * 18223049
 * K04
 */

public class Robot {
    /**
     * Tambahkan atribut kelas disini
     */
    private int x;
    private int y;


    public Robot() {
        /**
         * Konstruktor
         * Jangan lupa inisialisasi atribut kelas
         */
        this.x=0;
        this.y=0;

    }

    public void walk(int x, int y) throws Exception {
        /**
         * Implementasi sesuai soal
         */
        if(this.x + x > 5 || this.y + y > 5){
            throw new Exception("Malas berjalan");
        }
        this.x += x;
        this.y += y;
        System.out.println("Yawes Otw aing (" + this.x + ", " +this.y + ")");
    }

    public void talk(String language) throws Exception {
        /**
         * Implementasi sesuai soal
         */
        if (!language.equals("Indonesia") && !language.equals("Inggris")){
            throw new Exception("Minimal belajar "+language+" dulu daripada nyuruh aing doang");
        }
        System.out.println("Jago aing bisa "+ language);
    }

    public void receiveCommand(String command) throws Exception {
        /**
         * Implementasi sesuai soal
         */
        if(!command.equals("walk") && !command.equals("talk")){
            throw new Exception("Nyuruh-nyuruh aing mulu ih. "+command+" tidak dikenal");
        }
    }
}