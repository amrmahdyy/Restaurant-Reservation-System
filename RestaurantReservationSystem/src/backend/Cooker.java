package backend;

public class Cooker {

    ReadClientData read= new ReadClientData();
    Waiter w= new Waiter();
    private String[]  mealsArray=new String[read.finalLength("client","order")];



    public void printMealsAndTables() {
        System.out.println("Meals  \t\t Table Number");

        for (int i = 0; i < mealsArray.length; i++) {
            System.out.println(mealsArray(i)+"\t\t\t"+w.getclientTableNumberArray(i));
        }
    }
    public String mealsArray(int i) {

        mealsArray=read.readClientData("client","order");
        return mealsArray[i];
    }
    public int getMealsArray() {
        return mealsArray.length;
    }
}
