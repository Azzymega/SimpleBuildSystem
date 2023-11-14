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

import java.util.Objects;

public class WordParser implements ILoadConflict<WordParser,BuildConfiguration> {
    @Override
    public WordParser Resolve(BuildConfiguration Object) {
        StringBuilder bufferString = new StringBuilder();
        for (Character c : Object.getData()) {
            if (Character.isISOControl(c)) {
                if (bufferString.length() > 0) {
                    Object.getWords().add(bufferString.toString());
                    bufferString = new StringBuilder();
                }
            }
            else if (Character.isWhitespace(c)) {
                if (bufferString.length() > 0) {
                    Object.getWords().add(bufferString.toString());
                    bufferString = new StringBuilder();
                }
            }
            else if (c == '/' || c == ',') {
                Object.getWords().add(bufferString.toString());
                Object.getWords().add(c.toString());
                bufferString = new StringBuilder();
            }
            else if (c == '<' || c == '>') {
                Object.getWords().add(bufferString.toString());
                Object.getWords().add(c.toString());
                bufferString = new StringBuilder();
            }
            else {
                bufferString.append(c);
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
