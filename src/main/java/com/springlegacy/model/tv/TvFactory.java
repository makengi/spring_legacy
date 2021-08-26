package com.springlegacy.model.tv;

public class TvFactory {
    public static TV getTv(TvAbstractFactory factory){
        return factory.create();
    }
}
