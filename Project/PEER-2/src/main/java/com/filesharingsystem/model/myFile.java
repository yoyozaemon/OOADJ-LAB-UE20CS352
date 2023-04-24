package com.filesharingsystem.model;
//package com.demo.fileUpload.model;

public class myFile {

    private String filename;
    private String fileType;
    private String fileSize;
    private byte[] file;

    public myFile() {
    }
    
    public myFile(String f1, String f2, String f3)
    {
        filename = f1;
        fileType = f2;
        fileSize = f3;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
