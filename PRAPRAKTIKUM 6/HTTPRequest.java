/*Amudi Purba
 * 18223049
 * K04
 */

public class HTTPRequest {
    private String request;

    /**
     * Constructor untuk request
     * 
     * @param request Request yang akan dikirimkan
     */
    public HTTPRequest(String request) {
        this.request=request;
    }

    public boolean validateRequest() throws InvalidRequestException, InvalidMethodException {
        /*
         * Implementasi dengan aturan:
         * aturan request
         * - Request tidak boleh kosong ("")
         * - Request harus memiliki 2 buah slash (/)
         * - Request hanya bisa mengirimkan HTTP request
         * - Request hanya bisa mengirimkan metode GET, POST, DELETE dan PUT
         * 
         * "GET /url HTTP/1.1" => request yang benar
         * "" => mengembalikkan pesan "Request cannot be empty"
         * "GET url HTTP1.1" => mengembalikan pesan "Request has to have 2 /", hal yang
         * sama berlaku untuk request yang punya 1 slash
         * "GET /url HTP/1.1" => "Can only send HTTP request"
         * "GWT /url HTTP/1.1" => "Method is invalid"
         * 
         * Apabila request mematuhi seluruh aturan, maka request akan mencetak :
         * "Sending <request method> method"
         * request method type disini adalah GET, POST, DELETE atau PUT yang ada pada
         * request
         * 
         * contoh : "GET /url HTTP/1.1" akan mencetak "Sending GET method"
         * 
         * terakhir, apabila request mematuhi seluruh aturan maka ia akan mengembalikkan
         * nilai true
         */
        if (request==null || request.isEmpty()){
            throw new InvalidRequestException("Request cannot be empty");
        }
        int indexslash1 = request.indexOf('/');
        int indexslash2 = request.lastIndexOf('/');
        if (indexslash1 == -1 || indexslash2==indexslash1){
            throw new InvalidRequestException("Request has to have 2 /");
        }
        if(!request.contains("HTTP")){
            throw new InvalidRequestException("Can only send HTTP request");
        }
        String[] kata = request.split(" ");
        if (kata.length < 3){
            throw new InvalidRequestException("Invalid requst format");
        }
        String method = kata[0];
        if (!(method.equals("GET") || method.equals("POST") || method.equals("DELETE") || method.equals("PUT"))){
            throw new InvalidMethodException();
        }

        System.out.println("Sending " + method + " method");
        return true;
    }
}

class InvalidRequestException extends Exception {
    public InvalidRequestException(String message) {
        // Implementasi InvalidRequestException
        super(message);
    }
}

class InvalidMethodException extends Exception {
    public String getMessage() {
        // Implementasi custom message InvalidMethodException
        // Return pesan multak berisi: "Method is invalid"
        return "Method is invalid";
    }
}