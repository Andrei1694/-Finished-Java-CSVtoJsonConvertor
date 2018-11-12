package com.ing.devschool.FormatPackage;


import com.ing.devschool.Transaction;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CsvFormat extends Format implements Readable{

    List<String[]> records;
    List<Transaction> transactions = new ArrayList<>();
    String[] headers;
    Reader reader;
    CSVReader csvReader;

    public CsvFormat(){
        this.setFilePath("C:\\Users\\Andrei\\IdeaProjects\\devs\\Session-3\\src\\main\\resources\\bakery-transactions.csv");
    }

    @Override
    public List<String[]> read() {
        try {
            reader = Files.newBufferedReader(this.getFilePath());
            csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            records = csvReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return records;
    }



    @Override
    public void printFormatType() {

    }

    @Override
    public void printFormat() {
        for (int i = 0; i < records.size(); i++) {
            for (int j = 0; j < headers.length ; j++) {
                System.out.println(headers[j]+ " : " + records.get(i)[j]);
            }
            System.out.println("--------------------------------------");
        }
    }

    public List<String[]> getRecords() {
        return records;
    }
}
