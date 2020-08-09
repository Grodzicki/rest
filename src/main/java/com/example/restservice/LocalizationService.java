package com.example.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;

public class LocalizationService {

    final static Logger LOGGER = LoggerFactory.getLogger(LocalizationService.class);
    private final static String comma = ",";

    public static Localization localizationGetting(Localization localization, SaveFileServices saveFileServices) throws IOException{
        LOGGER.info("localizationGetting", localization);
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
