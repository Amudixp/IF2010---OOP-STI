import java.util.*;

public class TorrentDriver {

    private static void printSeparator() {
        System.out.println("------------");
    }

    private static void printArrayElements(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        if (array.length > 0) {
            System.out.println(array[array.length - 1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        /*
        * Kalian bisa mencoba menggunakan pendekatan kalian sendiri, petunjuk di bawah
        merupakan salah satu pendekatan yang dapat kalian ikuti.
        
        * Tahap 1
         * Hal yang perlu dilakukan yaitu:
         * Mengambil input nama file dan jumlah peer
         * 
         * TIPS: disarankan menggunakan Integer.parseInt(myScanner.nextLine()) untuk mengambil nilai input Integer 
         * secara aman dan mengurangi error atau masalah yang terjadi saat pembacaan input.
         */
        String file = input.nextLine();
        int banyakPeer = Integer.parseInt(input.nextLine());

        /*
         *  Tahap 2
         *  Hal yang perlu dilakukan yaitu:
         *  - Mengambil input konten masing-masing peer
         *  - masing-masing peer memiliki atribut nama dengan format nama "PeerX" dengan X merupakan
         *  bilangan integer
         * 
         *  Contoh input jika kalian mengatur jumlah peer nya 4 adalah sebagai berikut:
         *  2 3 1 4
            5 9 6 7
            1 8
            7 5 2
         * 
         *  Masukkan input-input tersebut ke dalam array of TorrentPeer. untuk instansiasinya
         *  bisa mengikuti konstruktor yang telah disediakan
         * 
         *  TIPS: gunakan method split(separator) pada kelas String untuk men-split string menjadi array dengan
         *  pembagi elemen sesuai dengan input separator
         *  Contoh:
         *      String inputSaya = "1 2 3 4";
         *      String[] inputSplit = inputSaya.split(" ");  // inputSplit = ["1", "2", "3", "4"]
         * 
         *      // ubah semua elemennya menjadi integer
         *      int[] inputInteger = new int[inputSplit.length];
         *      for (int i = 0; i < inputSplit.length < i++) {
         *          inputInteger[i] = Integer.parseInt(inputSplit[i]);
         *      }
         */
        TorrentPeer[] peers = new TorrentPeer[banyakPeer];

        for (int i = 0; i < banyakPeer; i++) {
            String[] chunkStrings = input.nextLine().split(" ");
            int[] chunks = new int[chunkStrings.length];
            for (int j = 0; j < chunkStrings.length; j++) {
                chunks[j] = Integer.parseInt(chunkStrings[j]);
            }
            peers[i] = new TorrentPeer("Peer" + (i + 1), chunks);
        }

        for (TorrentPeer peer : peers) {
            System.out.print(peer.name + " memiliki chunk: ");
            printArrayElements(peer.chunks);
        }

        printSeparator();

         /*
          * Tahap 3
            Hal yang perlu diperhatikan yaitu:
            - Masukkan chunk-chunk ke dalam sebuah array yang berisi chunk-chunk unik. misalnya pada contoh yang diberikan,
            terdapat total 13 chunk yang dimiliki oleh 4 peer, namun total chunk unik keseluruhannya adalah 9
            - array chunk unik tersebut nantinya akan digunakan untuk mengunduh secara urut chunk-chunk tersebut sehingga
            menghasilkan hasil rekonstruksi file yang valid
            - Kalian juga perlu men-track jumlah chunk unik yang ada karena diperlukan juga pada salah satu print statement
            
            CATATAN:
            berdasarkan catatan dari deskripsi soal, maksimal jumlah chunk unik yang dimiliki oleh seluruh peer yaitu
            100. untuk itu, kalian bisa membuat set sederhana menggunakan array of boolean dengan indeks array sebagai key
            dari chunk kalian.

                boolean[] UniqueChunks = new boolean[100];
            
            TIPS:
            - Untuk mengecek duplikasi, kalian bisa mengecek apakah UniqueChunks[key] true atau false
          */ 
        boolean[] UniqueChunks = new boolean[100];
        List<Integer> ChunkList = new ArrayList<>();

        for (TorrentPeer peer : peers) {
            for (int chunk : peer.chunks) {
                if (!UniqueChunks[chunk]) {
                    UniqueChunks[chunk] = true;
                    ChunkList.add(chunk);
                }
            }
        }

        // Urutkan chunk untuk memastikan unduhan dilakukan secara berurutan
        Collections.sort(ChunkList);

         // Tahap 4
          // Buat sebuah StringBuilder yang berfungsi sebagai rekonstruktor file torrent yang diunduh
          // untuk setiap chunk yang diunduh, append string "[Chunk-i]" ke dalam rekonstruktor file dengan
          // memanfaatkan method append() pada StringBuilder di mana i merupakan indeks chunk yang diunduh pada saat itu
          // 
          // Contoh 1:
          //    StringBuilder sb = new StringBuilder("Hello");
          //    sb.append(" World!");
          //    System.out.println(sb); // output: "Hello World!"
          //
          // Contoh 2:
          //    StringBuilder builder = new StringBuilder();
          //    builder.append("Oke");
          //    System.out.println(builder); // Output: "Oke"
          //    builder.append(" Gas");
          //    System.out.println(builder); // Output: "Oke Gas"

          /*
           * Catatan tambahan:
           * - Pada contoh output yang diberikan pada deskripsi soal, terdapat
           *  output "------------" yang merupakan separator.
           * - Gunakan method static printSeparator() untuk mencetak separator tersebut pada output
           * - Kalian bebas menggunakan method helper yang telah disediakan dalam pengerjaan soal
           * - Jangan lupa close scannernya untuk mencegah resource/memory leak
           */
        StringBuilder ReconstructedFile = new StringBuilder();
        for (int chunk : ChunkList) {
            for (TorrentPeer peer : peers) {
                if (peer.hasChunk(chunk)) {
                    System.out.println("Mengunduh chunk " + chunk + " dari " + peer.name + "...");
                    ReconstructedFile.append("[Chunk-").append(chunk).append("]");
                    break;
                }
            }
        }

        printSeparator();
        System.out.println("Semua chunk berhasil diunduh!");
        System.out.println("Menyusun kembali file...");
        System.out.println("File " + file + " berhasil direkonstruksi dari " + ChunkList.size() + " chunk.");
        System.out.println("Isi rekontruksi file: " + ReconstructedFile);
        
        input.close();
    }
}
