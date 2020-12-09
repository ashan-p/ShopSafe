package shopsafe;

import java.util.ArrayList;
import java.io.*;
/**
 * @author Daniel Bennett
 * @version 1.0 
 */
public class TransactionLog {
    

    ArrayList<Transaction> transactions;

    public static TransactionLog instance = new TransactionLog();
    private static final int DAY = 24 * 60 * 60;
    private static final int WEEK = DAY * 7;
    private static final int MONTH = DAY * 30;


    private TransactionLog(){
        try{
            FileInputStream fileIn = new FileInputStream("transactions.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            transactions = (ArrayList<Transaction>) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (Exception e){
            transactions = new ArrayList<Transaction>();
        }
    }
    public boolean save(){
        try {
            FileOutputStream fileOut =
            new FileOutputStream("transaction.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(transactions);
            out.close();
            fileOut.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    /**
     * Adds a transaction to the transaction log
     * @param Transaction to add to the log
     */
    public void add(Transaction t){
        transactions.add(t);
    }

    
    /**
     * Removes a transaction from the log(most likely never used)
     * @param Transaction to remove from the log
     */
    public void remove(Transaction t){
        transactions.remove(t);

    }

    
    /**
     * 
     * @return TransactionLog the singleton object
     */
    public static TransactionLog getInstance(){return instance;}



    

}
