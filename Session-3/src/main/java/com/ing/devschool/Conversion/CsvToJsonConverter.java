package com.ing.devschool.Conversion;
import com.ing.devschool.FormatPackage.CsvFormat;
import com.ing.devschool.FormatPackage.JsonFormat;
import com.ing.devschool.Model.Transaction;
import java.util.*;



public class CsvToJsonConverter{

    public void convert() {
        this.readToObject();
        this.WriteObjectToJson(this.readToObject());
    }

    private HashMap<Long, Transaction> readToObject(){
        CsvFormat csvFormat = new CsvFormat();
        List<String[]> records = csvFormat.read();

        HashMap<Long,Transaction> hashList = new HashMap<>();
        for(String[] record : records){
            Long l = Long.parseLong(record[2]);
            String date = record[0];
            String item = record[3];
            Transaction t = new Transaction(date,l);

            if(!hashList.containsKey(l)){
                hashList.put(l ,t);
                hashList.get(l ).addToitemsSummary(item);
            }else{
                hashList.get(l).addToitemsSummary(item);
            }
        }

        return hashList;
    }

    public void printHashList(HashMap<Long,Transaction> hashList){
        Set set = hashList.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print("Key :" + me.getKey()+" | ");
            System.out.println("Value :" + me.getValue());
        }
    }

    public void WriteObjectToJson(HashMap<Long,Transaction> hashlist){
        JsonFormat js = new JsonFormat();
//        List<Transaction> transactions = new ArrayList<>(hashlist.values());
        js.write(hashlist);
        System.out.println("Finished");
    }

}
