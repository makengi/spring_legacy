package com.springlegacy.model.tv;

import com.springlegacy.model.speaker.SonySpeaker;

public class LgTvFactory implements TvAbstractFactory{
    @Override
    public TV create() {
        return new LgTV(new SonySpeaker());
    }
}
