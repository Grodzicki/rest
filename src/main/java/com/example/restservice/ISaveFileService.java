package com.example.restservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ISaveFileService implements SaveFileService{

    private String fileName = new String();
    private FileWriter myLogWriter;
    private BufferedWriter myBuffer;

    public ISaveFileService(String fileName){
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void createFile() {
        try{
            File myLogFile = new File(fileName);
            if (myLogFile.createNewFile()) {
                System.out.println("File created: " + myLogFile.getName());
            } else {
                System.out.println("File already exists.");
            }
            myLogWriter = new FileWriter(fileName, true);
            myBuffer = new BufferedWriter(myLogWriter);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeFile() {
        try {
            myBuffer.close();
            myLogWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void SaveGpsToFile(String log) {
        createFile();
        try {
            myBuffer.write(log);
            closeFile();
        } catch (IOException e) {
            closeFile();
            e.printStackTrace();
        }
        System.out.println("Successfully wrote to the file: \n"+log);
    }
}
