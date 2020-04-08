package backend;

public class Manager {
    Cooker c1 = new Cooker();
    ReadClientData read=new ReadClientData();
    private String[]  totalMoneyArray=new String[read.getLength("client","price")];    Customer customer=new Customer();

    public void orders() {
        for (int i = 0; i < read.finalLength("client","order");i++) {
            System.out.println(c1.mealsArray(i));
        }
    }
    Waiter w1 = new Waiter();

    public  int removeDuplicateElements(int arr[], int n){
        if (n==0 || n==1){
            return n;
        }
        int[] temp = new int[n];
        int j = 0;
        for (int i=0; i<n-1; i++){
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        // Changing original array
        for (int i=0; i<j; i++){
            arr[i] = temp[i];
        }
        return j;
    }
    public void tableReservation(){
        int [] stringToNumber=new int[read.finalLength("client","table")];
        int [] arr=new int[read.finalLength("client","table")];
        for(int i=0;i<read.finalLength("client","table");i++) {
            stringToNumber[i] = Integer.parseInt(w1.getclientTableNumberArray(i));
            arr[i] = stringToNumber[i];
        }
        int length = arr.length;
        length = removeDuplicateElements(arr, length);
        //printing array elements
        for (int i=0; i<length; i++)
            System.out.print("\nTable Number "+arr[i]+" is Reserved\n");
    }

    double appetizerTaxes=1.10;
    double mainCourseTaxes=1.15;
    double desertTaxes=1.20;

    public void clientNames() {
        Customer c1 = new Customer();
        for (int i = 0; i < read.getLength("client","name"); i++) {

            double price=Double.parseDouble(getTotalMoneyArray(i));
            if(customer.getClientDishTypeArray(i).equals("appetizer"))
                System.out.println(c1.getClientNameDataArray(i)+"\t\t paid: "+(price*appetizerTaxes));
            if(customer.getClientDishTypeArray(i).equals("main_course"))
                System.out.println(c1.getClientNameDataArray(i)+"\t\t paid: "+(price*mainCourseTaxes));
            if(customer.getClientDishTypeArray(i).equals("desert"))
                System.out.println(c1.getClientNameDataArray(i)+"\t\t paid: "+(price*desertTaxes));
        }
    }


    public String getTotalMoneyArray(int i) {
        totalMoneyArray=read.readClientData("client","price");
        return totalMoneyArray[i];
    }
    private double totalMoneyBeforeTaxes=0;
     private double totalMoney=0;



    public void totalMoney(){
        //double totalMoneyBeforeTaxes=0;
        //double totalMoney=0;
        for(int i=0;i< read.getLength("client","price");i++){

            totalMoneyBeforeTaxes+=Double.parseDouble(getTotalMoneyArray(i));
            if(customer.getClientDishTypeArray(i).equals("appetizer"))
                totalMoney+=(Double.parseDouble(getTotalMoneyArray(i)))*appetizerTaxes;
            if(customer.getClientDishTypeArray(i).equals("main_course"))
                totalMoney+=(Double.parseDouble(getTotalMoneyArray(i)))*mainCourseTaxes;
            if(customer.getClientDishTypeArray(i).equals("desert"))
                totalMoney+=(Double.parseDouble(getTotalMoneyArray(i)))*desertTaxes;
        }



    }
    public double getTotalMoneyBeforeTaxes() {
        return totalMoneyBeforeTaxes;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

}




