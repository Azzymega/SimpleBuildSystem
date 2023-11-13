package org.sbs;

import java.util.Objects;

public class WordParser implements ILoadConflict<WordParser,BuildConfiguration> {
    @Override
    public WordParser Resolve(BuildConfiguration Object) {
        String bufferString = "";
        for (Character c : Object.getData()) {
            if (Character.isISOControl(c)) {
                if (!bufferString.isEmpty()) {
                    Object.getWords().add(bufferString);
                    bufferString = "";
                }
            }
            else if (Character.isWhitespace(c)) {
                if (!bufferString.isEmpty()) {
                    Object.getWords().add(bufferString);
                    bufferString = "";
                }
            }
            else if (c == '/' || c == ',') {
                Object.getWords().add(bufferString);
                Object.getWords().add(c.toString());
                bufferString = "";
            }
            else if (c == '<' || c == '>') {
                Object.getWords().add(bufferString);
                Object.getWords().add(c.toString());
                bufferString = "";
            }
            else {
                bufferString+=(c);
            }
        }
        for (int x = 0; x < Object.getWords().size(); x++) {
            if (Object.getWords().get(x).isEmpty()) {
                Object.getWords().remove(x);
                x--;
            }
            else if (Objects.equals(Object.getWords().get(x), "/")) {
                Object.getWords().remove(x);
                x--;
                Object.getWords().set(x,"</");
            }
        }
        return null;
    }
}
