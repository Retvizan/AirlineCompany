package exceptions;

/*
Exception is used when Total range of airline is less then some value
 */
public class MyOwnException extends Exception{

    protected String message;

   public MyOwnException(String message){
        super(message);
    }


    public void getMess(){
        System.out.println("MyOwnException get triggered");

    }

}

