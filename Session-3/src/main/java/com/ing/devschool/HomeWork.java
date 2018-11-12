package com.ing.devschool;


import com.ing.devschool.Conversion.CsvToJsonConverter;


import java.io.IOException;

public class HomeWork {


    public static void main(String[] args) throws IOException {

        CsvToJsonConverter cj = new CsvToJsonConverter();
        cj.convert();


    }
}
