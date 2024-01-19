package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {

        public static String readFromConfig(String key) {
        Properties properties = new Properties();

        String value;
        try {
            properties.load((new FileInputStream("config.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        value = properties.getProperty(key);
        return value;

    }


//    public static String configReader(String fileName, String key) {
//        Properties properties = new Properties();
//        String workingDirectory = System.getProperty("user.dir");
//        String value;
//        try {
//            properties.load(new FileInputStream(workingDirectory + File.separator + fileName));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        value = properties.getProperty(key);
//        return value;
//    }


}