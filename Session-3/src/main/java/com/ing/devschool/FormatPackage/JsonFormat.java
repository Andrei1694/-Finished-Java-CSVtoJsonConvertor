package com.ing.devschool.FormatPackage;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.devschool.Model.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JsonFormat{

    PrettyPrinter p = new DefaultPrettyPrinter();
    ObjectMapper om = new ObjectMapper().setDefaultPrettyPrinter(p);

    Object ob;

    public JsonFormat(){

    }

    public void write(HashMap<Long, Transaction> t) {
        String pathName = "C:\\Users\\Andrei\\Desktop\\asd.json";
        try {

            om.writeValue(new File(pathName), t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
