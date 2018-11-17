package com.ing.devschool.Model;



import java.util.HashMap;

public class Transaction {
    private String date;
    private long transactionId;
    HashMap<String,Integer> itemsSummary = new HashMap<>();

    public Transaction(String date, long transactionId) {
        this.transactionId = transactionId;
        this.date = date;
    }

    public void addToitemsSummary(String item){
        if(!itemsSummary.containsKey(item)){
            itemsSummary.put(item,1);
        }else{
            int count = itemsSummary.get(item);
            itemsSummary.put(item,count+1);
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public HashMap<String, Integer> getItemsSummary() {
        return itemsSummary;
    }

    public void setItemsSummary(HashMap<String, Integer> itemsSummary) {
        this.itemsSummary = itemsSummary;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", transactionId=" + transactionId +
                ", itemsSummary=" + itemsSummary +
                '}';
    }
}
