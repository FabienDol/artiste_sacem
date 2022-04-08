package com.cgi.model;

public enum InstrumentType {

    WIND(1), WOODWIND(2), BRASS(3), PRECUSSION(4), STRING(5);

    private int sound;

    InstrumentType(int sound) {
        this.sound = sound;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "InstrumentType{" +
                "sound=" + sound +
                '}';
    }
}
