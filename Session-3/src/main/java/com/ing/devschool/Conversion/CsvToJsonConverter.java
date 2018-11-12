package com.ing.devschool.Conversion;
import com.ing.devschool.FormatPackage.CsvFormat;
import com.ing.devschool.FormatPackage.JsonFormat;
import com.ing.devschool.Transaction;
import java.util.*;


//<T extends CsvFormat & Readable, V extends JsonFormat & Writable>  extends FormatConvertor<T,V>
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
                hashList.put(l,t);
                hashList.get(l).addToitemsSummary(item);
            }else{
                hashList.get(l).addToitemsSummary(item);
            }
        }
//        this.printHashList(hashList);
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
        List<Transaction> transactions = new ArrayList<>(hashlist.values());
//        for(Transaction t : transactions){
//            js.write(t);
//        }
        js.write(hashlist);
        System.out.println("Finished");
    }

}
