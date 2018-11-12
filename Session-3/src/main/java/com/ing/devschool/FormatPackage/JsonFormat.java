package com.ing.devschool.FormatPackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.devschool.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JsonFormat extends Format implements Writable {

    ObjectMapper om = new ObjectMapper();
    Object ob;

    public JsonFormat(){

    }

    @Override
    public void printFormatType() {

    }

    @Override
    public void printFormat() {

    }

    void setOm(Object o){
        this.ob = o;
    }

    @Override
    public void write(HashMap<Long, Transaction> t) {
        String pathName = "C:\\Users\\Andrei\\Desktop\\asd.json";
        try {
            om.writeValue(new File(pathName), t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
