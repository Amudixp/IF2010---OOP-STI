/**
 * Toko.java
 * [Kelas ini digunakan untuk memodelkan toko cimol dengan 4 atribut: cimolBojotArray, kas, MAX_CIMOL, cimolCount]
 * 
 * @author [18223049] [Amudi Purba]
 */


 public class Toko {
    // Deklarasi atribut
    private CimolBojot[] cimolBojotArray;
    private int kas;
    private static final int MAX_CIMOL = 3;
    private int cimolCount;

    public Toko(int initialKas) {
       kas = initialKas;
       cimolBojotArray = new CimolBojot[MAX_CIMOL];
       cimolCount = 0;
    }

    public int getKas() {
        return kas;
    }

    public void addCimolBojot(CimolBojot cimolBojot) {
        if(cimolCount < MAX_CIMOL){
            cimolBojotArray[cimolCount++]=cimolBojot;
        }
    }

    public int findCimolBojotIndexByName(String namaMenu) {
        for (int i=0; i<cimolCount; i++){
            if(cimolBojotArray[i].getNamaMenu().equals(namaMenu)){
                return i;
            }
        }return -1;
    }

    public String sellCimolBojot(String namaMenu, int quantity) {
        int index = findCimolBojotIndexByName(namaMenu);

        if(index == -1){
            return "Kita gak jual itu kaka\n";
        }

        CimolBojot cimol = cimolBojotArray[index];

        if(!cimol.isHaveEnoughStok(quantity)){
            return "Waduh stoknya gak cukup\n";
        }
        cimol.reduceStok(quantity); //mengurangi stok
        kas += cimol.getHarga()*quantity;
        
        return "Berhasil menjual cimol "+ namaMenu + " sebanyak " + quantity +
               "\nSekarang sisa: " + cimol.getStok();
    }
}