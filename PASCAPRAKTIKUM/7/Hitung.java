public class Hitung {
    static final int NUM_OF_THREAD = 10;

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Lengkapi method ini untuk mencari bilangan prima dari [0, N]. Wajib menggunakan conccurency!

    // Di dalam method run() dalam runnable sertakan pemanggilan ThreadTracker.mark();
    // Jika tidak, atau jika tidak menggunakan conccurency maka kode akan terus runtime error!

    public int countPrime(int x, int y){
        int count = 0;
        for(int i = x; i <= y; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    public int hitungPrima(int N) throws InterruptedException {
        int part = N / NUM_OF_THREAD;
        int remainder = N % NUM_OF_THREAD;
        int total = 0;
        for(int i = 0; i < remainder; i++){
            if(isPrime(i)){
                total++;
            }
        }
        Thread[] threads = new Thread[NUM_OF_THREAD];
        int[] prima = new int[NUM_OF_THREAD];
        for(int i = 0; i < NUM_OF_THREAD; i++){
            final int idx = i;
            final int x = remainder + (i * part);
            final int y = (i + 1) * part; 
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    prima[idx] = countPrime(x, y);
                    ThreadTracker.mark();
                }
            });
            threads[i].start();
        }
        for(int i = 0; i < NUM_OF_THREAD; i++){
            threads[i].join();
        }
        for(int i = 0; i < NUM_OF_THREAD; i++){
            total += prima[i];
        }
        return total;
    }
}
