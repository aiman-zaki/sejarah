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

    public String getImgName() {
        return fileName;
    }

    public void setImgName(String imgName) {
        this.fileName = imgName;
    }

    public String getImgUrl() {
        return fileUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.fileUrl = imgUrl;
    }
}
