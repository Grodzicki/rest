package com.example.restservice;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocalizationController {

    private final static String comma = ",";
    private final static String fileName = "C:\\Users\\Kuba\\Desktop\\testy\\restgps.txt";
    public List<Localization> listLocalizations = new ArrayList<Localization>();
    SaveFileServices saveFileServices = new SaveFileServices(fileName);


    @GetMapping("/getGPS")
    public Localization getLastGps() throws IOException {

        return LocalizationService.localizationGetting(listLocalizations.get(listLocalizations.size()-1),saveFileServices);
    }

    @GetMapping("/getGPS/list")
    public List<Localization> getListGps() throws IOException {

        return listLocalizations;
    }

//    @GetMapping("/getGPS/{id}")
    @RequestMapping(value = "/getGPS/{id}", method = RequestMethod.GET)
    public Localization getGpsFromId(@PathParam("id") int id) throws IOException {

        return LocalizationService.findLocalizationFromId(listLocalizations, id);
    }

    @PostMapping("/postGPS")
    @ResponseBody
    public boolean postGps(@RequestBody Localization localization) throws  IOException {

        return listLocalizations.add(localization);

    }

}
