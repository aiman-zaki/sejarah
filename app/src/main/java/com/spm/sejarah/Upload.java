package com.spm.sejarah;

public class Upload {

    private String fileName;
    private String fileUrl;

    public Upload() {
    }

    public Upload(String fileName, String fileUrl) {
        if(fileName.trim().equals(""))
        {
            fileName="No name";
        }
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName (String imgName) {
        this.fileName = imgName;
    }


    public String getFileUrl() { return fileUrl; }

    public void setfileUrl(String imgUrl) {
        this.fileUrl = imgUrl;
    }
}
