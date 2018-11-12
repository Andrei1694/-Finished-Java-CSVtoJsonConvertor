package com.ing.devschool.FormatPackage;

import com.ing.devschool.Transaction;

import java.util.HashMap;

public interface Writable{
    public void write(HashMap<Long, Transaction> t);
}
