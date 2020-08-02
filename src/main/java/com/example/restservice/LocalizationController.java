package com.example.restservice;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LocalizationController {

    private final static String comma = ",";
    private final static String fileName = "C:\\Users\\jakub.grodzicki\\Desktop\\testy\\restgps.txt";
    SaveFileServices saveFileServices = new SaveFileServices(fileName);


    @GetMapping("/getGPS")
    @ResponseBody
    public Localization greeting(@RequestBody Localization localization) throws IOException {
        Localization actualGps = new Localization(localization.getDeviceid(),
                localization.getLatitiude(), localization.getLongitude());
        String logMsg = actualGps.getDeviceid()+comma
                +actualGps.getLatitiude()+comma
                +actualGps.getLongitude()+System.lineSeparator();
        saveFileServices.SaveGpsToFile(logMsg);

        return actualGps;
    }

}
