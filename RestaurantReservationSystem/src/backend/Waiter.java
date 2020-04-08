package backend;

public class Waiter {
    ReadClientData read = new ReadClientData();
    private String[] clientTableNumberArray = new String[read.getLength("client","table")]; //////CHANGE THE SIZE DO NOT FORGET AMR!!!!!!!!!!!
    public void printReservationForWaiter() {
        int[] stringToNumber = new int[read.getLength("client", "table")];
        int[] arr = new int[read.getLength("client","table")];
        for (int i = 0; i < read.getLength("client","table"); i++) {
            stringToNumber[i] = Integer.parseInt(getclientTableNumberArray(i));
            arr[i] = stringToNumber[i];
        }
        int length = arr.length;
        Manager manager = new Manager();
        length = manager.removeDuplicateElements(arr, length);
        Customer c1 = new Customer();
        //printing array elements
        for (int i = 0; i < length; i++)
            System.out.print(i + 1 + "- Client " + c1.getClientNameDataArray(i) + "reserved table number" + arr[i] + "\n");
    }



    public String getclientTableNumberArray(int i) {
        clientTableNumberArray=read.readClientData("client","table");
        return clientTableNumberArray[i];
    }

}