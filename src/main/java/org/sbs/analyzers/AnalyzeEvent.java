package org.sbs.analyzers;

public class AnalyzeEvent {
    private String textEvent;

    public AnalyzeEvent(String textEvent) {
        this.textEvent = textEvent;
    }

    public String getTextEvent() {
        return textEvent;
    }

    public void setTextEvent(String textEvent) {
        this.textEvent = textEvent;
    }
}
