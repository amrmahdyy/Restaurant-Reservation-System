package backend;

import GUI.Controller;

public class Customer extends Person {
    int l;
    ReadClientData read=new ReadClientData();
    private String[] dishNameArray=new String[getLength("dish","name")];
    private  String[] dishPriceArray=new String[getLength("dish","price")];
    private  String[] dishTypeArray=new String[getLength("dish","type")];
    private  String[] seatsAvaliableArray=new String[getLength("table","number_of_seats")];
    private  String[] tableTypeArray=new String[getLength("table","type")];
    public  String[] tableNumberArray=new String[getLength("table","number")];
    private String[]  clientNameDataArray=new String[read.getLength("client","name")];
    private String[]  clientTableDataArray=new String[read.getLength("client","table")];
    private String[]  ClientDishTypeArray=new String[read.getLength("client","table")];
    AddMeal add=new AddMeal();
    public String getClientDishTypeArray(int i) {
        ClientDishTypeArray=read.readClientData("client","type");
        return ClientDishTypeArray[i];
    }

    public String getDishNameArray(int i) {
        dishNameArray  =verification("dish","name");
        return dishNameArray[i];
    }

    public String getDishPriceArray(int i) {
        dishPriceArray=verification("dish","price");

        return dishPriceArray[i];
    }

    public String getDishTypeArray(int i) {
        dishTypeArray=verification("dish","type");

        return dishTypeArray[i];
    }


    public String getSeatsAvaliableArray(int i) {
        seatsAvaliableArray=verification("table","number_of_seats");
        return seatsAvaliableArray[i];
    }

    public String getTableNumberArray(int i) {
        tableNumberArray=verification("table","number");
        return tableNumberArray[i];
    }

    public String getTableTypeArray(int i) {
        tableTypeArray=verification("table","smoking");
        return tableTypeArray[i];
    }

    public String getClientTableDataArray(int i) {
        clientTableDataArray=read.readClientData("client","table");
        return clientTableDataArray[i];
    }
    public void printtableNumbers(){
        clientTableDataArray=read.readClientData("client","table");
        for(int i=0;i<clientTableDataArray.length;i++){
            System.out.println(clientTableDataArray
                    [i]);
        }
    }

    public String noAvaliabiltyStatus="true";
    String tableNumber;
    public void checkTableAvaliabilty(int choice){
        switch (choice){
            case 1:
                noAvaliabiltyStatus="false";
                tableNumber="1";
                avaliabiltyInClientData("1");
                break;
            case 2:
                noAvaliabiltyStatus="false";
                tableNumber="2";
                avaliabiltyInClientData("2");
                break;
            case 3:
                noAvaliabiltyStatus="false";
                tableNumber="3";
                avaliabiltyInClientData("3");
                break;
            case 4:
                noAvaliabiltyStatus="false";
                tableNumber="4";
                avaliabiltyInClientData("4");
                break;
            case 5:
                noAvaliabiltyStatus="false";
                tableNumber="5";
                avaliabiltyInClientData("5");
                break;
            case 6:
                noAvaliabiltyStatus="false";
                tableNumber="6";
                avaliabiltyInClientData("6");
                break;
            case 7:
                noAvaliabiltyStatus="false";
                tableNumber="7";
                avaliabiltyInClientData("7");
                break;


        }
    }
   private String confirmOrderCheck;
    public void avaliabiltyInClientData(String tableNumber){

  confirmOrderCheck="true";
        if(noAvaliabiltyStatus.equals("true")){

            System.out.println("There is no table avaliable with your speciaifcation please choose another type of table or number of seats");
            //System.exit(0);
        }
        if(noAvaliabiltyStatus.equals("false")){
            for(int i=0;i<clientTableDataArray.length;i++) {
                if (tableNumber.equals(getClientTableDataArray(i))) {
                    System.out.println("this is a reserved table sorry");
                    confirmOrderCheck="false";
                    break;
                }

            }
        }

    }

    public String getConfirmOrderCheck() {
        return confirmOrderCheck;
    }

    public String getNoAvaliabiltyStatus() {
        return noAvaliabiltyStatus;
    }


    public double totalAmount=0;
    int var=1;
    String[] dishNames=new String[100];
    int q=0;
    int a=0;

    String dishname="";

    public double printReceipt(int i){

        double appetizerTaxes=1.10;
        double mainCourseTaxes=1.15;
        double desertTaxes=1.20;

        dishname=dishname.concat("\t"+getDishNameArray(i));

        System.out.println(dishname);

        double dishPrice=Double.parseDouble(getDishPriceArray(i));
        if(getDishTypeArray(i).equals("appetizer")) {

            totalAmount+=(dishPrice * appetizerTaxes);
            System.out.println("total amount after taxes is\t"+totalAmount);
        }
        if(getDishTypeArray(i).equals("main_course")) {

            totalAmount+=(dishPrice * mainCourseTaxes);
            System.out.println("total amount after taxes is\t"+totalAmount);
        }
        if(getDishTypeArray(i).equals("desert")) {

            totalAmount+=(dishPrice * desertTaxes);
            System.out.println("total amount after taxes is\t"+totalAmount);
        }
        return totalAmount;
    }

    ClientData saveData=new ClientData();
    Main1 M=new Main1();
    public String getClientNameDataArray(int i) {
        clientNameDataArray=read.readClientData("client","name");
        return clientNameDataArray[i];
    }

    int j=0;
    String s="";
    public void confirmOrder(int choice,int menuChoice){
        Controller control=new Controller();
        checkTableAvaliabilty(choice);
        if(confirmOrderCheck.equals("true")) {
            String tableNumberInString = Integer.toString(choice);
            if (noAvaliabiltyStatus.equals("false")) {
                add.createNewOrder(getNameArray(control.getTemp2()), getDishNameArray(menuChoice), getDishPriceArray(menuChoice), tableNumberInString, getDishTypeArray(menuChoice));
            }
        }
        else{
            System.out.println("This table is reserved please choose another table");
        }
    }

}

