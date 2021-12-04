package org.example.config;
import org.example.generator.GenerateData;

import java.io.File;

public class Config {
    public static String baseUrl;
    public static String email;
    public static String password;

    public static void main(String[] args) {
        Config cfg = new Config();
    }

    public Config()  {
        File file = new File("src/test/java/org/example/config/settings.xml");
        try {
            GenerateData<Config> generateData = new GenerateData<>();
            System.out.println(generateData.getEntity(file));
        } catch (Exception ex) {
            System.out.println("Settings not found.");
        }
    }
}
