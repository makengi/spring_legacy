package com.springlegacy.model.tv;

import com.springlegacy.model.speaker.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "tv")
public class LgTV implements TV{

    private Speaker speaker;
    @Autowired
    public LgTV(Speaker speaker){
        this.speaker = speaker;
    }

    @Override
    public void powerOn() {
        System.out.println("@ LG Tv On");
    }

    @Override
    public void powerOff() {
        System.out.println("@ LG Tv Off");
    }

    @Override
    public void volumeUp() {
        System.out.println("@ LG Tv VolumeUp");
    }

    @Override
    public void volumeDown() {
        System.out.println("@ LG Tv VolumeDown");
    }
}
