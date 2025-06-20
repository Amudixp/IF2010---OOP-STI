import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mahasiswa {
    private String nim;
    private String nama;
    private HashMap<String, String> nilai;

    static public ArrayList<String> registeredNim = new ArrayList<>();

    /*
     * Konstruktor objek Mahasiswa
     */
    public Mahasiswa(String nim, String nama) throws NimAlreadyExistsException {
        if (registeredNim.contains(nim)) {
            throw new NimAlreadyExistsException();
        }
        this.nim = nim;
        this.nama = nama;
        this.nilai = new HashMap<>();
        registeredNim.add(nim);
    }

    /*
     * Menambahkan nilai matakuliah baru ke daftar nilai Mahasiswa
     */
    public void addGrade(String kodeMatkul, Double nilai) throws InvalidScoreException, DuplicateSubjectException {
        if (nilai < 0 || nilai > 100) {
            throw new InvalidScoreException();
        }

        if (this.nilai.containsKey(kodeMatkul)) {
            throw new DuplicateSubjectException(kodeMatkul + " already in grades!");
        }

        String indeks;
        if (nilai > 90) {
            indeks = "A";
        } else if (nilai > 70) {
            indeks = "B";
        } else if (nilai > 50) {
            indeks = "C";
        } else if (nilai > 40) {
            indeks = "D";
        } else {
            indeks = "E";
        }

        this.nilai.put(kodeMatkul, indeks);
    }

    public String getNim() {
        return this.nim;
    }

    public String getNama() {
        return this.nama;
    }

    public Map<String, String> getNilai() {
        return this.nilai;
    }
}

class NimAlreadyExistsException extends Exception {
    public String getMessage() {
        return "NIM is already registered!";
    }
}

class InvalidScoreException extends Exception {
    public String getMessage() {
        return "Score cannot be below 0 or above 100!";
    }
}

class DuplicateSubjectException extends Exception {
    public DuplicateSubjectException(String message) {
        super(message);
    }
}
