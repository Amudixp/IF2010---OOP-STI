import java.util.ArrayList;
import java.util.List;

public class NumberSumIII {
    public Number[] numberSumIII(Number[] numbers) {
        int n = numbers.length;
        Number[] result = new Number[n]; // Secara default, semua elemen diinisialisasi sebagai null
        boolean[] processed = new boolean[n]; // Untuk melacak elemen yang sudah diproses

        for (int i = 0; i < n; i++) {
            // Lewati jika elemen ini null atau sudah menjadi bagian dari grup lain
            if (processed[i] || numbers[i] == null) {
                continue;
            }

            // Temukan grup baru. Kumpulkan semua angka dengan tipe yang sama.
            List<Number> group = new ArrayList<>();
            List<Integer> groupIndices = new ArrayList<>();
            Class<?> currentType = numbers[i].getClass();

            // Cari di seluruh array untuk elemen dengan tipe yang sama
            for (int j = i; j < n; j++) {
                if (!processed[j] && numbers[j] != null && numbers[j].getClass().equals(currentType)) {
                    group.add(numbers[j]);
                    groupIndices.add(j);
                    processed[j] = true; // Tandai sebagai sudah diproses
                }
            }

            // Lakukan kalkulasi pada grup yang sudah terkumpul
            if (group.size() == 1) {
                // Jika hanya ada satu elemen, langsung masukkan ke hasil
                result[groupIndices.get(0)] = group.get(0);
            } else if (group.size() > 1) {
                // Lakukan operasi berulang: +, -, *
                Number temp = group.get(0);
                int op = 0; // 0: +, 1: -, 2: *
                for (int k = 1; k < group.size(); k++) {
                    Number nextNumber = group.get(k);
                    if (op == 0) {
                        temp = add(temp, nextNumber);
                    } else if (op == 1) {
                        temp = subtract(temp, nextNumber);
                    } else { // op == 2
                        temp = multiply(temp, nextNumber);
                    }
                    op = (op + 1) % 3; // Siklus operasi: 0 -> 1 -> 2 -> 0 ...
                }
                // Simpan hasil akhir di posisi elemen pertama dari grup ini
                result[groupIndices.get(0)] = temp;
                // Posisi lain dari grup ini akan tetap null di array 'result' secara default
            }
        }
        return result;
    }

    private static Number add(Number a, Number b) {
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() + b.intValue();
        } else if (a instanceof Double && b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else if (a instanceof Float && b instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if (a instanceof Long && b instanceof Long) {
            return a.longValue() + b.longValue();
        } else if (a instanceof Short && b instanceof Short) {
            return (short) (a.shortValue() + b.shortValue());
        } else if (a instanceof Byte && b instanceof Byte) {
            return (byte) (a.byteValue() + b.byteValue());
        }
        return null; // jika tipe data tidak dikenali, kembalikan null

    } // lakukan operasi penjumlahan sesuai tipe data
    private static Number subtract(Number a, Number b) {
        if (a instanceof Integer && b instanceof Integer) {
            return a.intValue() - b.intValue();
        } else if (a instanceof Double && b instanceof Double) {
            return a.doubleValue() - b.doubleValue();
        } else if (a instanceof Float && b instanceof Float) {
            return a.floatValue() - b.floatValue();
        } else if (a instanceof Long && b instanceof Long) {
            return a.longValue() - b.longValue();
        } else if (a instanceof Short && b instanceof Short) {
            return (short) (a.shortValue() - b.shortValue());
        } else if (a instanceof Byte && b instanceof Byte) {
            return (byte) (a.byteValue() - b.byteValue());
        }
        return null; // jika tipe data tidak dikenali, kembalikan null

    } // lakukan operasi pengurangan sesuai tipe data
    private static Number multiply(Number a, Number b) {
        if (a instanceof Integer && b instanceof Integer) {
                return a.intValue() * b.intValue();
            } else if (a instanceof Double && b instanceof Double) {
                return a.doubleValue() * b.doubleValue();
            } else if (a instanceof Float && b instanceof Float) {
                return a.floatValue() * b.floatValue();
            } else if (a instanceof Long && b instanceof Long) {
                return a.longValue() * b.longValue();
            } else if (a instanceof Short && b instanceof Short) {
                return (short) (a.shortValue() * b.shortValue());
            } else if (a instanceof Byte && b instanceof Byte) {
                return (byte) (a.byteValue() * b.byteValue());
        }
        return null; // jika tipe data tidak dikenali, kembalikan null
    } // lakukan operasi perkalian sesuai tipe data
}