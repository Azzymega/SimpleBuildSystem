package org.sbs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class XMLLoader implements ILoadConflict<XMLLoader,BuildConfiguration> {
    @Override
    public XMLLoader Resolve(BuildConfiguration Object) {
        FileReader reader;
        try {
            reader = new FileReader(Object.getDiskLocation());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int c;
        while (true) {
            try {
                if ((c = reader.read()) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Object.getData().add(new Character((char) c));
        }
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
