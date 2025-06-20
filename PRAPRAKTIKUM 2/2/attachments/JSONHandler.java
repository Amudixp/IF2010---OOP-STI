public class JSONHandler implements IHandler {
    @Override
    public void writeRequest(RequestData data) {
        System.out.println("Writing request in JSON format:");
        data.printInfo();
    }

    @Override
    public void readRequest(RequestData data) {
        System.out.println("Reading request in JSON format:");
        data.printInfo();
    }
}
