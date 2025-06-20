public class Witch extends Penyihir {
    private String authority;

    /*
     * Konstruktor untuk kelas Witch
     * 
     * Mengisi nama, maksimal mana, dan authority karakter berdasarkan parameter yang
     * diberikan
     * Mana awal sama dengan maksimal mana
     * Profesi karakter adalah "Witch"
     * 
     * Jangan tambahkan parameter profesi, gunakan pengetahuan kalian untuk
     * mengubahnya
     */
    public Witch(String name, int maxMana, String authority) {
        super(name, maxMana);
        this.authority = authority;
        this.profesi = "Witch";
    }

    /*
     * Metode untuk menggunakan sihir
     * 
     * Mengurangi mana karakter berdasarkan parameter yang diberikan
     * Jika mana karakter tidak cukup, tampilkan pesan "Mana [nama] tidak cukup!"
     * Jika mana karakter cukup, tampilkan pesan dengan format
     * "[nama] menggunakan sihir otoritas [authority] dengan mana sejumlah [jumlah
     * mana]"
     * "Sisa mana: [sisa mana]"
     * 
     * Gunakan System.out.println() untuk menampilkan informasi
     */
    @Override
    public void gunakanSihir(int mana) {
        if (this.mana < mana){
            System.out.println("Mana " + nama + " tidak cukup!");
        }else {
            this.mana -= mana;
            System.out.println(nama + " menggunakan sihir otoritas " + authority + " dengan mana sejumlah " + mana);
            System.out.println("Sisa mana: "+ this.mana);
        }
    }
}
