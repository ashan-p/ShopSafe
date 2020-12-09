package shopsafe;

import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class TransactionLog {
    //TODO : CREATE A SECONDARY LOG OF TRANSACTIONS

    ArrayList<Transaction> transactions;

    public static TransactionLog instance = new TransactionLog();

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
    

    public void add(Transaction t){
        transactions.add(t);
    }

    
    
    public void remove(Transaction t){
        transactions.remove(t);

    }

    

    public static TransactionLog getInstance(){return instance;}

}
