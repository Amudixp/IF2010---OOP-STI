/**
 * Deque.java
 * Nama: Amudi Purba
 * NIM: 18223049
 */

/**
 * Kelas Deque merupakan implementasi struktur data double-ended queue
 * menggunakan double linked list.
 * Mendukung operasi penambahan dan penghapusan elemen di kedua ujung.
 */
public class Deque<E> {

    /**
     * Kelas Node merepresentasikan satu elemen dalam Deque.
     * Menyimpan data serta reference ke node berikutnya dan sebelumnya.
     */
    private class Node {
        E data;
        Node next;
        Node prev;

        Node(E data) {
            // Lengkapi konstruktornya
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Menunjuk ke elemen pertama
    private Node tail; // Menunjuk ke elemen terakhir
    private int size;  // Menyimpan jumlah elemen dalam deque

    /**
     * Konstruktor untuk menginisialisasi deque kosong.
     */
    public Deque() {
        head = null;
        tail = null;
        size = 0;
        // Lengkapi konstruktornya
    }

    /**
     * Mengecek apakah deque kosong.
     * @return true jika kosong, false jika tidak
     */
    public boolean isEmpty() {
        return size == 0;
        // Silakan tulis kodenya di bawah ini
    }

    /**
     * Mengembalikan jumlah elemen dalam deque.
     * @return jumlah elemen
     */
    public int getSize() {
        return size;
        // Silakan tulis kodenya di bawah ini
    }

    /**
     * Menambahkan elemen ke depan deque.
     * @param element elemen yang ingin ditambahkan
     */
    public void addFirst(E element) {
        Node newNode = new Node(element);
        if(isEmpty()){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
        // Silakan tulis kodenya di bawah ini
    }

    /**
     * Menambahkan elemen ke belakang deque.
     * @param element elemen yang ingin ditambahkan
     */
    public void addLast(E element) {
        Node newNode = new Node(element);
        if(isEmpty()){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        // Silakan tulis kodenya di bawah ini
    }

    /**
     * Menghapus dan mengembalikan elemen dari depan deque.
     * Jika deque kosong, print "Deque kosong. Tidak bisa menghapus elemen".
     * @return elemen yang dihapus, atau null jika kosong
     */
    public E removeFirst() {
        if (isEmpty()){
            System.out.println("Deque kosong. Tidak bisa menghapus elemen.");
            return null;
        }
        E data = head.data;
        if (head == tail){
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
        // Silakan tulis kodenya di bawah ini
    }

    /**
     * Menghapus dan mengembalikan elemen dari belakang deque.
     * Jika deque kosong, print "Deque kosong. Tidak bisa menghapus elemen".
     * @return elemen yang dihapus, atau null jika kosong
     */
    public E removeLast() {
        if (isEmpty()) {
            System.out.println("Deque kosong. Tidak bisa menghapus elemen.");
            return null;
        }
        E data = tail.data;
        if (head == tail) { // Hanya satu elemen
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
        // Silakan tulis kodenya di bawah ini
    }

    /**
     * Mengambil elemen pertama tanpa menghapusnya.
     * @return elemen pertama, atau null jika kosong
     */
    public E getHead() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
        // Silakan tulis kodenya di bawah ini
    }

    /**
     * Mengambil elemen terakhir tanpa menghapusnya.
     * @return elemen terakhir, atau null jika kosong
     */
    public E getTail() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
        // Silakan tulis kodenya di bawah ini
    }

    /**
     * Menampilkan isi deque dalam format [elemen1, elemen2, ...]
     */
    public void display() {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
        // Silakan tulis kodenya di bawah ini
    }
}