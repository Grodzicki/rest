package com.example.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    final static Logger LOGGER = LoggerFactory.getLogger(LocalizationService.class);


    @GetMapping("/GPS")
    public Localization getLastGps() throws IOException {

        return LocalizationService.localizationGetting(listLocalizations.get(listLocalizations.size()-1),saveFileServices);
    }

    @GetMapping("/GPS/list")
    public List<Localization> getListGps() throws IOException {

        return listLocalizations;
    }
    @GetMapping("/GPS/{id}")
    public Localization getGpsFromId(@PathVariable("id") String id) throws IOException {

        return LocalizationService.findLocalizationFromId(listLocalizations, id);
    }

    @PostMapping("/GPS")
    @ResponseBody
    public ResponseEntity postGps(@RequestBody Localization localization) throws  IOException {

        listLocalizations.add(localization);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @DeleteMapping("/GPS/{id}")
    public ResponseEntity deleteLocation(@PathVariable("id") String id) {

        listLocalizations.removeIf(l -> l.getDeviceid().equals(id));

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
