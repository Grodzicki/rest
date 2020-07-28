package com.example.restservice;

import java.io.IOException;

public interface SaveFileService {
    public void createFile();
    public void closeFile();
    public void SaveGpsToFile(String log);

}
