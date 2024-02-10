package com.example.demo.Utility.Email;

import java.io.File;

import lombok.Data;


@Data
public class InlineContent {

    private String cid;
    private File file;

    public InlineContent(String cid, File file)
    {
        this.cid = cid;
        this.file = file;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
