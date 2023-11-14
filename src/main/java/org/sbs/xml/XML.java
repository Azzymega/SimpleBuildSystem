package org.sbs.xml;

public class XML {
    private XMLMetadata header;
    private XMLArray array;

    public XML(XMLMetadata metadata) {
        this.header = metadata;
        this.array = new XMLArray();
    }
    public XMLMetadata getHeader() {
        return header;
    }

    public void setHeader(XMLMetadata header) {
        this.header = header;
    }

    public XMLArray getArray() {
        return array;
    }

    public void setArray(XMLArray array) {
        this.array = array;
    }
}
