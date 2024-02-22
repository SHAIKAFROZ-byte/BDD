package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Property {
    private static final String PROPERTIES_FILE = "src/test/resources/file.properties";
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final String PASSWORD = properties.getProperty("password");
    public static final String USERNAME = properties.getProperty("username");
    public static final String URL = properties.getProperty("url");
    public static final String Title = properties.getProperty("title");

    private Property() {

    }

    public static String random(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        return randomString;
    }
}
