package com.example.restservice;

import java.io.IOException;

public interface ISaveFileServices {
    public void createFile();
    public void closeFile();
    public void SaveGpsToFile(String log);

}
