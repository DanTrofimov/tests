package org.example.generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlSerializer<T> {
    private static final XmlMapper xmlMapper = new XmlMapper();

    public void serializeEntity(Object entity, String fileName) {
        try {
            xmlMapper.writeValue(new File("src/test/java/org/example/generator/data/" + fileName), entity);
        } catch (IOException ex) {
            System.out.println("f");
        }
    }

    public T deserializeEntity(String fileName) {
        try {
            String xml = new String(Files.readAllBytes(Paths.get("src/test/java/org/example/generator/data/" + fileName)));
            return (T) xmlMapper.readValue(xml, Object.class);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
