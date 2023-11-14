package org.sbs.xml;

import java.util.ArrayList;

public class XMLArray {
    private String name;
    private ArrayList<XMLObject> objects;
    private ArrayList<XMLArray> arrays;
    public XMLArray() {
        this.objects = new ArrayList<>();
        this.arrays = new ArrayList<>();
    }

    public ArrayList<XMLObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<XMLObject> objects) {
        this.objects = objects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<XMLArray> getArrays() {
        return arrays;
    }

    public void setArrays(ArrayList<XMLArray> arrays) {
        this.arrays = arrays;
    }
}
