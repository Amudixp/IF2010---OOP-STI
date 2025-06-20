import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kobopedia {
    public static class Barang {
        private int ID;
        private String nama;
        private int harga;
        Map<String, Integer> ratingPengguna; // Map yang berisi namaPengguna dan rating yang diberikan

        // Konstruktor untuk Barang. Meng-assign setiap argumen ke attribut objek.
        public Barang(int ID, String nama, int harga) {
            this.ID = ID;
            this.nama = nama;
            this.harga = harga;
            this.ratingPengguna = new HashMap<>();
        }

        // Getter untuk ID
        public int getId() {
            return ID;
        }

        // Getter untuk Nama barang
        public String getNama() {
            return nama;
        }

        // Getter untuk Harga barang
        public int getHarga() {
            return harga;
        }

        // Menambahkan rating baru dari pengguna ke dalam Map ratingPengguna
        // Rating hanya bisa berada dalam rentang 0-5, jika berada diluar rentang maka
        // tidak akan dimasukan ke Map
        public void addRatingPengguna(String namaPengguna, int rating) {
            if(rating >= 0 && rating < 6){
                ratingPengguna.put(namaPengguna, rating);
            }
        }

        // Mendapatkan rating pengguna dari 0-5 dari seluruh rating yang diberikan oleh
        // pengguna
        public double getRating() {
            if (ratingPengguna.isEmpty()){
                return 0.0;
            }
            double total = 0;
            for(int r : ratingPengguna.values()){
                total += r;
            }
            return total;
        }
    }

    public static class BarangSorter implements Comparator<Barang> {
        private String attribute; // Atribut apa yang akan disortir

        // Terdapat 3 atribut yang dapat disortir:
        // - "harga"
        // - "rating"
        // - "id"
        // Jika diberikan argumen selain 3 atribut tersebut, maka atribut akan berupa
        // "id"
        public BarangSorter(String attribute) {
            if(attribute.equals("harga") || attribute.equals("rating") || attribute.equals("id")){
                this.attribute = attribute;
            }else{
                this.attribute = "id";
            }
        }

        // Membandingkan barang1 dan barang2 berdasarkan atribut yang diberikan
        @Override
        public int compare(Barang barang1, Barang barang2) {
            switch(attribute){
                case "harga" :
                    return Integer.compare(barang1.getHarga(), barang2.getHarga());
                case "rating" :
                    return Double.compare(barang1.getRating(), barang2.getRating());
                case "id" :
                    return Integer.compare(barang1.getId(), barang1.getId());
                default : 
                    return Integer.compare(barang1.getId(), barang2.getId());
            }
        }
    }

    // Fungsi statik yang dapat menyortir list of barang berdasarkan atribut yang
    // dipilih
    public static List<Barang> sortBarang(List<Barang> barangs, String attribute) {
        Collections.sort(barangs, new BarangSorter(attribute));
        return barangs;
    }
}
