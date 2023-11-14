/*
 *
 *  *
 *  *  * PROJECT:    Simple Build System
 *  *  * LICENSE:     GPL - See COPYING in the top level directory
 *  *  * PROGRAMMER:  Maltsev Daniil <brickexberiment@lenta.ru>
 *  *
 *
 */

package org.sbs;

import org.sbs.xml.XML;

import java.util.ArrayList;

public class BuildConfiguration {
    private String diskLocation;
    private ArrayList<Character> data;
    private ArrayList<Token> tokens;
    private ArrayList<String> words;
    private ArrayList<Token> tree;
    private XML xml;
    public BuildConfiguration(String diskLocation) {
        this.data = new ArrayList<>();
        this.words = new ArrayList<>();
        this.diskLocation = diskLocation;
        this.tokens = new ArrayList<>();
        this.tree = new ArrayList<>();
    }

    public String getDiskLocation() {
        return diskLocation;
    }

    public void setDiskLocation(String diskLocation) {
        this.diskLocation = diskLocation;
    }

    public ArrayList<Character> getData() {
        return data;
    }

    public void setData(ArrayList<Character> data) {
        this.data = data;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<Token> getTree() {
        return tree;
    }

    public void setTree(ArrayList<Token> tree) {
        this.tree = tree;
    }

    public XML getXml() {
        return xml;
    }

    public void setXml(XML xml) {
        this.xml = xml;
    }
}
