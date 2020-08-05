package com.example.restservice;

public class Localization {

    private final String deviceid;
    private final String latitiude;
    private final String longitude;

    public Localization(){
        this.deviceid = new String();
        this.latitiude = new String();
        this.longitude = new String();
    }
    public Localization(String deviceid, String latitiude, String longitude) {
        this.deviceid = deviceid;
        this.latitiude = latitiude;
        this.longitude = longitude;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public String getLatitiude() {
        return latitiude;
    }

    public String getLongitude() {
        return longitude;
    }
}
