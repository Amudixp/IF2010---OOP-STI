public class MaskPII {
    private String maskEmail(String email) {
        String[] potongan = email.split("@");
        String nama = potongan[0].toLowerCase();
        String domain = potongan[1].toLowerCase();

        String disamarkan = nama.charAt(0) + "*****" + nama.charAt(nama.length() - 1);
        return disamarkan + "@" + domain;
    }

    private String maskPhoneNumber(String phoneNumber) {
        String clear = phoneNumber.replaceAll("[^0-9]", "");
        int panjang_nomor = clear.length();
        int country_number = panjang_nomor - 10;
        
        String empat_digit_akhir = clear.substring(panjang_nomor - 4);
        if(country_number==0){
            return "***-***-" + empat_digit_akhir;
        }else if(country_number == 1){
            return "+*-***-***-" + empat_digit_akhir;
        }else if(country_number == 2){
            return "+**-***-***-" + empat_digit_akhir;
        }else{
            return "+***-***-***-" + empat_digit_akhir;
        }

    }

    public String maskPII(String pii) {
        // dilakukan pengecekan String pii
        // jika pii merupakan email, panggil method maskEmail
        // jika pii merupakan phone number, panggil method maskPhoneNumber
        if(pii.contains("@")){
            return maskEmail(pii);
        }else{
            return maskPhoneNumber(pii);
        }

    }
}