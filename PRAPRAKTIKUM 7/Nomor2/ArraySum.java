/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class ArraySum {
    // nWorkers menyatakan jumlah maksimum threads yang tersedia
    private int nWorkers;
    // array untuk menampung array masukan
    private Integer[] arr;
    private int[] partialSum; //menyimpan penjumlahan dari setiap thread
    private int totalSum; // menyimpan total 
    /**
     * Tambahkan atribut kelas yang dibutuhkan
     */ 

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    ArraySum(int nWorkers, Integer[] arr) {
        this.nWorkers = Math.min(nWorkers, arr.length);
        this.arr = arr;
        this.partialSum = new int[this.nWorkers];
        this.totalSum = 0;
    }

    /**
     * Implementasi
     * method sum akan membuat sejumlah thread dan memetakan array masukan secara merata ke semua threads yang dapat dibuat
     */
    public int sum() throws InterruptedException {
        if(arr == null || arr.length == 0){
            return 0;
        }
        Thread[] threads = new Thread[nWorkers];
        int length = arr.length;
        int div = length / nWorkers;
        int sisa = length % nWorkers;

        
        for(int i = 0; i < nWorkers; i++){
            final int index = i;
            int awal, akhir;

            awal = index * div + Math.min(index, sisa);
            akhir = awal + div + (index < sisa ? 1 : 0);
            threads[i] = new Thread(new Runnable() {
                public void run(){
                    partialSum[index] = partialSum(awal, akhir);
                }
            });
            threads[i].start();
        }
        for(Thread t : threads ){
            t.join();
        }
        for(int i=0; i < nWorkers; i++){
            totalSum += partialSum[i]; 
        }
        return totalSum;
    }

    /**
     * Implementasi
     * method partialSum akan melakukan penjumlahan elemen-elemen array pada index `start` sampai `end-1`
     */
    protected int partialSum(int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}