package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager manager;
    private static final Properties prop = new Properties();

    private ConfigManager() throws IOException {

        InputStream inputstream = ConfigManager.class.getResourceAsStream("/config.properties");
        prop.load(inputstream);
    }

    public static ConfigManager getInstance() throws IOException {
        if (manager == null){
            synchronized (ConfigManager.class){
                try {
                manager = new ConfigManager();
            } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
        return manager;
}

//public String getString(String key){
  //      return System.getProperty(key,prop.getProperty(key));

//}
public String getAsString(String key){
    return System.getProperty(key,prop.getProperty(key));
}
}

