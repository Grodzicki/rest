package com.example.restservice;

public class Localization {

    private final String deviceid;// = 12345;
    private final String latitiude;// = 505430;
    private final String longitude;// = 1423412;

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
