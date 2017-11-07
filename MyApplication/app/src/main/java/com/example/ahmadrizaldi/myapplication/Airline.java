package com.example.ahmadrizaldi.myapplication;

/**
 * Created by ahmadrizaldi on 11/7/17.
 */

public class Airline {

    private int id_f;
    private String flight_id,dates, from_, to_;
    private int hargae, hargab, hargaf, kuotae, kuotab, kuotaf;
    private String jamberangkat, jamtiba, destinasike;

    public Airline() {
    }

    public Airline(String flight_id, String dates, String from_, String to_, int hargae, int hargab, int hargaf, int kuotae, int kuotab, int kuotaf, String jamberangkat, String jamtiba, String destinasike) {
        this.flight_id = flight_id;
        this.dates = dates;
        this.from_ = from_;
        this.to_ = to_;
        this.hargae = hargae;
        this.hargab = hargab;
        this.hargaf = hargaf;
        this.kuotae = kuotae;
        this.kuotab = kuotab;
        this.kuotaf = kuotaf;
        this.jamberangkat = jamberangkat;
        this.jamtiba = jamtiba;
        this.destinasike = destinasike;
    }

    public Airline(int id_f, String flight_id, String dates, String from_, String to_, int hargae, int hargab, int hargaf, int kuotae, int kuotab, int kuotaf, String jamberangkat, String jamtiba, String destinasike) {
        this.id_f = id_f;
        this.flight_id = flight_id;
        this.dates = dates;
        this.from_ = from_;
        this.to_ = to_;
        this.hargae = hargae;
        this.hargab = hargab;
        this.hargaf = hargaf;
        this.kuotae = kuotae;
        this.kuotab = kuotab;
        this.kuotaf = kuotaf;
        this.jamberangkat = jamberangkat;
        this.jamtiba = jamtiba;
        this.destinasike = destinasike;
    }

    public int getId_f() {
        return id_f;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(String flight_id) {
        this.flight_id = flight_id;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getFrom_() {
        return from_;
    }

    public void setFrom_(String from_) {
        this.from_ = from_;
    }

    public String getTo_() {
        return to_;
    }

    public void setTo_(String to_) {
        this.to_ = to_;
    }

    public int getHargae() {
        return hargae;
    }

    public void setHargae(int hargae) {
        this.hargae = hargae;
    }

    public int getHargab() {
        return hargab;
    }

    public void setHargab(int hargab) {
        this.hargab = hargab;
    }

    public int getHargaf() {
        return hargaf;
    }

    public void setHargaf(int hargaf) {
        this.hargaf = hargaf;
    }

    public int getKuotae() {
        return kuotae;
    }

    public void setKuotae(int kuotae) {
        this.kuotae = kuotae;
    }

    public int getKuotab() {
        return kuotab;
    }

    public void setKuotab(int kuotab) {
        this.kuotab = kuotab;
    }

    public int getKuotaf() {
        return kuotaf;
    }

    public void setKuotaf(int kuotaf) {
        this.kuotaf = kuotaf;
    }

    public String getJamberangkat() {
        return jamberangkat;
    }

    public void setJamberangkat(String jamberangkat) {
        this.jamberangkat = jamberangkat;
    }

    public String getJamtiba() {
        return jamtiba;
    }

    public void setJamtiba(String jamtiba) {
        this.jamtiba = jamtiba;
    }

    public String getDestinasike() {
        return destinasike;
    }

    public void setDestinasike(String destinasike) {
        this.destinasike = destinasike;
    }
}
