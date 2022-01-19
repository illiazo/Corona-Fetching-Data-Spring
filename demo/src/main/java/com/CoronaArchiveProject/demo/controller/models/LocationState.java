package com.CoronaArchiveProject.demo.controller.models;

public class LocationState {
    private String country;
    private String state;
    private String latestUpdate;
    private String deaths;
    private String actives;
    private String recovered;

    @Override
    public String toString() {
        return "LocationState{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", latestUpdate=" + latestUpdate +
                ", deaths=" + deaths +
                ", actives=" + actives +
                ", recovered=" + recovered +
                '}';
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getActives() {
        return actives;
    }

    public void setActives(String actives) {
        this.actives = actives;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatestUpdate() {
        return latestUpdate;
    }

    public void setLatestUpdate(String latestUpdate) {
        this.latestUpdate = latestUpdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
