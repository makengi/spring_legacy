package com.springlegacy.model.tv;

public class SamSungTV implements TV{
    public SamSungTV() {
        System.out.println("@ SamSungTv 객체 생성");
    }

    @Override
    public void powerOn() {
        System.out.println("SamSung Tv On");
    }

    @Override
    public void powerOff() {
        System.out.println("SamSung Tv Off");
    }

    @Override
    public void volumeUp() {
        System.out.println("SamSung Tv Volume Up");
    }

    @Override
    public void volumeDown() {
        System.out.println("SamSung Tv Volume Off");
    }
}
