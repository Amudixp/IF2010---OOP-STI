import java.util.ArrayList;

public class ComplexWordCountServer {

    private int nWorkers;
    // masukkan arraylist of string dipastikan berupa alfabet lowercase saja
    private ArrayList<String> array;
    // hasil pada method countSpecialString akan disimpan pada res
    private int[] res = new int[26];

    ComplexWordCountServer(int nWorkers, ArrayList<String> array) {
        // Inisialisasi attributes
        this.nWorkers = nWorkers;
        this.array = array;
    }

    public void countSpecialString() throws InterruptedException {
        if (array == null || array.isEmpty()) return;
        Thread[] threads = new Thread[nWorkers];
        int size = array.size();
        int chunk = (size + nWorkers - 1)/nWorkers;
        int[][] temp = new int[nWorkers][26];

        for(int i = 0; i < nWorkers; i++ ){
            final int index = i;
            threads[i] = new Thread(new Runnable() {
                public void run(){
                    int mulai = index * chunk;
                    int akhir = Math.min(mulai+ chunk, size);
                    for (int j = mulai; j<akhir; j++){
                        int[] count = characterCountHelper(array.get(j));
                        for(int k = 0; k < 26; k++){
                            temp[index][k] += count[k]; 
                        }
                    }
                }
            });
            threads[i].start();
        }

        for(Thread t : threads){
            if(t != null){
                t.join();
            }
        }
        for(int i=0; i<nWorkers; i++){
            for(int j = 0; j<26; j++){
                res[j]+= temp[i][j];
            }
        }
        // calculateSum akan membuat thread untuk setiap string
        // setiap thread kemudian akan memanggil metode characterCountHelper
        // lalu hasil dari Array Mapping yang dikembalikan oleh metode characterCountHelper akan digunakan
        // untuk ditambahkan ke attribut res

    }

    protected int[] characterCountHelper(String str) {
        // Menghitung berapa banyak occurence dari suatu karakter pada suatu string
        // lalu dipetakan pada suatu array of integer

        // HINT : untuk memetakan suatu karakter ke array of integer, anda bisa melakukan arr[c-'a']
        // sehingga apabila variable c merupakan karakter 'a', value dari c-'a' menjadi 0, begitupun
        // dengan karakter alfabet lainnya
        int[] freq = new int[26];
        for(char c : str.toCharArray()){
            freq[c - 'a']++;
        }
        return freq;
    }

    public String toString() {
        // menampilkan berapa banyak kata spesial "one", "two" dan "three"
        // format keluaran dari fungsi ini adalah "one : {one_occurence}, two : {two_occurence}, three : {three_occurence}"
        // lalu diakhiri dengan newline
        int[] copy = res.clone();
        int count1 = 0, count2 = 0, count3 = 0;

        while (copy['o' - 'a'] > 0 && copy['n' - 'a'] > 0 && copy['e' - 'a'] > 0){
            count1++;
            copy['o' - 'a']--;
            copy['n' - 'a']--;
            copy['e' - 'a']--;
        }
        while (copy['t' - 'a'] > 0 && copy['w' - 'a'] > 0 && copy['o' - 'a'] > 0){
            count2++;
            copy['t' - 'a']--;
            copy['w' - 'a']--;
            copy['o' - 'a']--;
        }
        while (copy['t' - 'a'] > 0 && copy['h' - 'a'] > 0 && copy['r' - 'a'] > 0 &&copy['e' - 'a'] >=2){
            count3++;
            copy['t' - 'a']--;
            copy['h' - 'a']--;
            copy['r' - 'a']--;
            copy['e' - 'a']-= 2;
        }
        return "one : " + count1 + ", two : " + count2 + ", three : " + count3 + "\n";
    }
}