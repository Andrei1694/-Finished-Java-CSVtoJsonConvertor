package com.ing.devschool.FormatPackage;


import com.ing.devschool.Model.Transaction;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvFormat{
    Path filePath;
    List<String[]> records;
    Reader reader;
    CSVReader csvReader;

    public CsvFormat(){
       filePath = Paths.get("C:\\Users\\Andrei\\IdeaProjects\\devs\\Session-3\\src\\main\\resources\\bakery-transactions.csv");
    }


    public List<String[]> read() {
        try {
            reader = Files.newBufferedReader(filePath);
            csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            records = csvReader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
        }

       return records;
    }

    public List<String[]> getRecords() {
        return records;
    }
}
