package shopsafe;

public class TransactionLog {
    //TODO : CREATE A SECONDARY LOG OF TRANSACTIONS

    public static TransactionLog instance = new TransactionLog();

    private TransactionLog(){
        //TODO : MAKE CONSTRUCTOR 
    }

    //TODO
    public void add(Transaction t){}
    
    //TODO
    public void remove(Transaction t){}

    public static TransactionLog getInstance(){return instance;}

}
