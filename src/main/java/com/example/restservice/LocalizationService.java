package com.example.restservice;

import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

public class LocalizationService {
    private final static String comma = ",";

    public static Localization localizationGetting(Localization localization, SaveFileServices saveFileServices) throws IOException{
        Localization actualGps = new Localization(localization.getDeviceid(),
                localization.getLatitiude(), localization.getLongitude());
        String logMsg = actualGps.getDeviceid()+comma
                +actualGps.getLatitiude()+comma
                +actualGps.getLongitude()+System.lineSeparator();
        saveFileServices.SaveGpsToFile(logMsg);

        return actualGps;
    }

    public static Localization findLocalizationFromId(List<Localization> listLocalizations, String id){

//        listLocalizations.stream()
//                .filter(l -> l.getDeviceid().equals(id))
//                .

System.out.println(id);
        for(Localization localization : listLocalizations){
            if(localization.getDeviceid().equals(id)) {
                return localization;
            }
        }

        return new Localization();

    }
}
