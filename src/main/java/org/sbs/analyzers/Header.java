package org.sbs.analyzers;

import java.util.ArrayList;

public class Header {
    private String headerName;
    private ArrayList<String> internals;

    public Header(String headerName) {
        this.headerName = headerName;
        this.internals = new ArrayList<>();
    }

    public ArrayList<String> getInternals() {
        return internals;
    }

    public void setInternals(ArrayList<String> internals) {
        this.internals = internals;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
}
