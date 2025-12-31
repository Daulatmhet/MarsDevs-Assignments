package Utils;

import Constants.FramworkConstants;
import com.marsdevs.Enums.ConfigProperies;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtil {

    private PropertyUtil() {
    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream(FramworkConstants.getConfigFilepath());
            property.load(file);

            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Two method fill compartable use those code

    public static String get(ConfigProperies key) throws Exception {

        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("Property name" + key + "is not found. Please check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

}

