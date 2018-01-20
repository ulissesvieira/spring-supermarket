package com.springsupermarket.mongo.entiry;

public class Counters {
    private String sequenceName;
    private Integer sequenceValue;

    public Counters() {}

    public Counters(String sequenceName, Integer sequenceValue) {
        this.sequenceName = sequenceName;
        this.sequenceValue = sequenceValue;
    }

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public Integer getSequenceValue() {
        return sequenceValue;
    }

    public void setSequenceValue(Integer sequenceValue) {
        this.sequenceValue = sequenceValue;
    }
}
