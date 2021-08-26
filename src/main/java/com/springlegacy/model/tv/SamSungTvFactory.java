package com.springlegacy.model.tv;

public class SamSungTvFactory implements TvAbstractFactory{

    @Override
    public TV create() {
        return new SamSungTV();
    }
}
