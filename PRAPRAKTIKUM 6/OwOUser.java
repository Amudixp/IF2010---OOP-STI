/*
 * Amudi Purba
 * 18223049
 * K04
 */

public class OwOUser {
    private String username;
    private double balance;

    /**
     * Constructor untuk OwOUser dengan username
     * Balance diinisialisasi dengan 0
     * 
     * @param username Username
     */
    public OwOUser(String username) {
        this.username = username;
        this.balance = 0; 
    }

    /**
     * Constructor untuk OwOUser dengan username dan balance
     * 
     * @param username Username
     * @param balance  Balance
     * @throws InvalidParameterException dengan pesan "Balance tidak boleh negatif"
     */
    public OwOUser(String username, double balance) throws InvalidParameterException {
        this.username = username;
        if(balance<0){
            throw new InvalidParameterException("Balance tidak boleh negatif");
        }
        this.balance = balance;
    }

    /**
     * Fungsi untuk melakukan top up balance
     * 
     * @param amount Jumlah yang akan ditambahkan ke balance
     * @throws InvalidTopUpAmountException dengan pesan "Top up minimal 1000"
     */
    public void topUp(double amount) throws InvalidTopUpAmountException {
        if(amount<1000){
            throw new InvalidTopUpAmountException("Top up minimal 1000");
        }
        this.balance +=amount;
    }

    /**
     * Fungsi untuk melakukan pembayaran
     * 
     * @param amount Jumlah yang akan dibayarkan
     * @throws InvalidParameterException dengan pesan "Pembayaran tidak boleh negatif"
     * @throws InsufficientBalanceException dengan pesan "Saldo tidak cukup"
     */
    public void pay(double amount) throws InvalidParameterException, InsufficientBalanceException, InvalidPaymentAmountException {
        if(amount<0){
            throw new InvalidParameterException("Pembayaran tidak boleh negatif");
        }
        if(amount<100){
            throw new InvalidPaymentAmountException("Pembayaran minimal 100");
        }
        if(this.balance<amount){
            throw new InsufficientBalanceException("Saldo tidak cukup");
        }
        this.balance -= amount;
    }

    /**
     * Fungsi untuk mengecek balance
     * 
     * Fungsi ini akan mencetak username dan balance dengan format:
     * Username: <username>
     * Balance: <balance>
     * 
     * Gunakan System.out.println untuk mencetak username dan balance
     */
    public void checkBalance() {
        System.out.println("Username: "+ this.username);
        System.out.println("Balance: " + this.balance);
    }
}

class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

class InvalidTopUpAmountException extends Exception{
    public InvalidTopUpAmountException(String message){
        super(message);
    }
}

class InvalidParameterException extends Exception{
    public InvalidParameterException(String message){
        super(message);
    }
}

class InvalidPaymentAmountException extends Exception{
    public InvalidPaymentAmountException(String message){
        super(message);
    }
}