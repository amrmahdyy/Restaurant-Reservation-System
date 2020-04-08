package backend;

public class Person extends Verification {
    public  String[] passwordArray=new String[100];
    public  String[] userNameArray=new String[100];
    public  String[] roleArray=new String[100];
    public  String[] nameArray=new String[100];

    public String getPasswordArray(int i) {
        passwordArray=verification("user","password");
        return passwordArray[i];
    }
    public String getuserNameArray(int i) {
        userNameArray  =verification("user","username");
        return userNameArray[i];
    }
    public String getRoleArray(int i) {
        roleArray  =verification("user","role");
        return roleArray[i];
    }

    public String getNameArray(int i) {
        nameArray  =verification("user","name");
        return nameArray[i];
    }
}
