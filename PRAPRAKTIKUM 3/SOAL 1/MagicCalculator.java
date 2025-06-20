public class MagicCalculator {
    /**
     * Menjalankan metode calculate untuk MagicCalculator
     * lihat deskripsi soal untuk cara kerja metode calculate
     * 
     * @param array Number
     */
    public void calculate(Number[] arr) {
        System.out.println("=== MULAI KALKULASI ===");
    
        for(Number num:arr){
            if(num instanceof Integer){
                System.out.println(num + " adalah tipe integer");
                System.out.println(Integer.MAX_VALUE);
                System.out.println(Integer.MIN_VALUE);
            }else if(num instanceof Byte){
                System.out.println(num + " adalah tipe byte");
                System.out.println(Byte.MAX_VALUE);
                System.out.println(Byte.MIN_VALUE);
            }else if(num instanceof Double){
                System.out.println(num + " adalah tipe double");
                System.out.println(Double.MAX_VALUE);
                System.out.println(Double.MIN_VALUE);
                System.out.println(Double.isInfinite(num.doubleValue()));
            }else if(num instanceof Float){
                System.out.println(num + " adalah tipe float");
                System.out.println(Float.MAX_VALUE);
                System.out.println(Float.MIN_VALUE);
                System.out.println(Float.isInfinite(num.floatValue()));
            }else if(num instanceof Short){
                System.out.println(num + " adalah tipe short");
                System.out.println(Short.MAX_VALUE);
                System.out.println(Short.MIN_VALUE);
            }else if(num instanceof Long){
                System.out.println(num + " adalah tipe long");
                System.out.println(Long.MAX_VALUE);
                System.out.println(Long.MIN_VALUE);
            }
        }
        System.out.println("=== KALKULASI SELESAI ===");
    }
}