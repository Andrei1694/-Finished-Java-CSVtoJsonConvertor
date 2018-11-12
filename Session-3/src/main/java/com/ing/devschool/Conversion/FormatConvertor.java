package com.ing.devschool.Conversion;




public abstract class FormatConvertor<T , V > {

    T inputFormat;
    V outputFormat;

    FormatConvertor(T in, V out){
        this.inputFormat = in;
        this.outputFormat = out;
    }

    public abstract void convert();
}
