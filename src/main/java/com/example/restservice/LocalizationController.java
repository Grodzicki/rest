package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LocalizationController {

//    private final static String comma = ",";
    private final static String fileName = "C:\\Users\\Kuba\\Desktop\\testy\\restgps.txt";
    public List<Localization> listLocalizations = new ArrayList<>();
    SaveFileServices saveFileServices = new SaveFileServices(fileName);


    @GetMapping("/GPS")
    public Localization getLastGps() throws IOException {

        return LocalizationService.localizationGetting(listLocalizations.get(listLocalizations.size()-1),saveFileServices);
    }

    @GetMapping("/GPS/list")
    public List<Localization> getListGps() {

        return listLocalizations;
    }
    @GetMapping("/GPS/{id}")
    public Localization getGpsFromId(@PathVariable("id") String id) {

        return LocalizationService.findLocalizationFromId(listLocalizations, id);
    }

    @PostMapping("/GPS")
    @ResponseBody
    public ResponseEntity postGps(@RequestBody Localization localization)  {

        listLocalizations.add(localization);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @DeleteMapping("/GPS/{id}")
    public ResponseEntity deleteLocation(@PathVariable("id") String id) {

        listLocalizations.removeIf(l -> l.getDeviceid().equals(id));

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
