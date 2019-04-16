package fr.lifen.technicaltest.level4.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DecimalFormat;

public class Commission {
    @JsonProperty("pdg_fee")
    private Double pdgFee = 0d;

    @JsonProperty("interim_shifts")
    private int interimShifts;

    public Commission() {
    }

    public Double getPdgFee() {
        return pdgFee;
    }

    public void setPdgFee(Double pdgFee) {
        this.pdgFee = pdgFee;
    }

    public int getInterimShifts() {
        return interimShifts;
    }

    public void setInterimShifts(int interimShifts) {
        this.interimShifts = interimShifts;
    }

    public void addFee(double fee) {
        this.pdgFee += fee;
    }
}
