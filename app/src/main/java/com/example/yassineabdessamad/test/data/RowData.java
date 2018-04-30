package com.example.yassineabdessamad.test.data;

import java.util.List;

import eu.davidea.flexibleadapter.items.IFlexible;

/**
 * Created by yessine on 26-02-18.
 */


public class RowData {
    private String name ;
    private String description ;
    private String  urlPicture ;

    public RowData(String name, String description, String urlPicture) {
        this.name = name;
        this.description = description;
        this.urlPicture = urlPicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }
}
