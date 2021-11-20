package org.example.generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class XmlSerializer<T> {
    private static XmlMapper xmlMapper = new XmlMapper();

    public void serializeEntity(Object entity, String fileName) {
        try {
            xmlMapper.writeValue(new File("src/test/java/org/example/generator/data/" + fileName), entity);
        } catch (IOException ex) {
            System.out.println("f");
        }
    }

    public T deserializeEntity(Class entityClass, String fileName) {
        try {
            File file = new File("src/test/java/org/example/generator/data/" + fileName);
            String xml = inputStreamToString(new FileInputStream(file));
            return (T) xmlMapper.readValue(xml, Object.class);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
