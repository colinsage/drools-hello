package com.colinsage.drools;

/**
 * Created by colin on 2017-05-16.
 */
public class ConditionedDataPoint extends DataPoint {
    double WARN ;
    double CRITICAL;

    public double getWARN() {
        return WARN;
    }

    public void setWARN(double WARN) {
        this.WARN = WARN;
    }

    public double getCRITICAL() {
        return CRITICAL;
    }

    public void setCRITICAL(double CRITICAL) {
        this.CRITICAL = CRITICAL;
    }
}
