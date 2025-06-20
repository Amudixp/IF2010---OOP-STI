public class NumberSumIII {

    public Number[] numberSumIII(Number[] numbers) {
        Number[] result = new Number[numbers.length]; // array keluaran
        int index = 0;

        // buat sesuai dengan soal dan gunakan fungsi add, subtract, multiply untuk memudahkan
        for (int i= 0; i<numbers.length;){
            Class<?> tipe = numbers[i].getClass();
            Number temp = numbers[i];
            i++;
            int urutan = 0;

            while(i< numbers.length && numbers[i].getClass().equals(tipe)){
                if(urutan==0){
                    temp = add(temp, numbers[i]);
                }else if (urutan==1){
                    temp = subtract(temp, numbers[i]);
                }else {
                    temp = multiply(temp, numbers[i]);
                }
                urutan = (urutan+1)%3;
                i++;
            }
            result[index++] = temp;
        }   

        // mengisi array result yang tersisa dengan null
        while (index < numbers.length) {
            result[index++] = null;
        }
        
        return result;
    } 
    // lakukan operasi penjumlahan sesuai tipe data
    private static Number add(Number a, Number b) {
        if (a instanceof Integer){
            return a.intValue() + b.intValue();
        }if (a instanceof Long){
            return a.longValue() + b.longValue();
        }if (a instanceof Float){
            return a.floatValue() + b.floatValue();
        }if (a instanceof Double){
            return a.doubleValue() + b.doubleValue();
        }if (a instanceof Short){
            return (short)(a.shortValue() + b.shortValue());
        }if (a instanceof Byte){
            return (byte)(a.byteValue() + b.byteValue());
        } return null;

    } 
    // lakukan operasi pengurangan sesuai tipe data
    private static Number subtract(Number a, Number b) {
        if (a instanceof Integer){
            return a.intValue() - b.intValue();
        }if (a instanceof Long){
            return a.longValue() - b.longValue();
        }if (a instanceof Float){
            return a.floatValue() - b.floatValue();
        }if (a instanceof Double){
            return a.doubleValue() - b.doubleValue();
        }if (a instanceof Short){
            return (short)(a.shortValue() - b.shortValue());
        }if (a instanceof Byte){
            return (byte)(a.byteValue() - b.byteValue());
        } return null;

    } 
    // lakukan operasi perkalian sesuai tipe data
    private static Number multiply(Number a, Number b) {
        if (a instanceof Integer){
            return a.intValue() * b.intValue();
        }if (a instanceof Long){
            return a.longValue() * b.longValue();
        }if (a instanceof Float){
            return a.floatValue() * b.floatValue();
        }if (a instanceof Double){
            return a.doubleValue() * b.doubleValue();
        }if (a instanceof Short){
            return (short)(a.shortValue() * b.shortValue());
        }if (a instanceof Byte){
            return (byte)(a.byteValue() * b.byteValue());
        } return null;
    }
}