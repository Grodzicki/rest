package com.example.restservice;

import java.util.*;

public class GreetingService {
    private List<Localization> localizations = new ArrayList<Localization>();

    public void setGps(Localization localization){
        // TODO dodanie logowania lokalizacji
        localizations.add(localization);
    }
}
