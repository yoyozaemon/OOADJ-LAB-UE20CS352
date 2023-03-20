import java.io.*;
import java.util.*;

class Config implements Serializable {
    private static final long serialVersionUID = 1L;
    private HashMap<String, String> configMap;

    public Config() {
        configMap = new HashMap<String, String>();
    }

    public void put(String key, String value) {
        configMap.put(key, value);
    }

    public String get(String key) {
        return configMap.get(key);
    }

    public void serialize(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Config object is serialized to " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Config deserialize(String filename) {
        Config config = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            config = (Config) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Config object is deserialized from " + filename);
        } catch (IOException i) {
            System.out.println("Config file not found. Creating new Config object.");
            config = new Config();
        } catch (ClassNotFoundException c) {
            System.out.println("Config class not found");
            c.printStackTrace();
        }
        return config;
    }

    public void printContents() {
        System.out.println("Config object contents:");
        for (String key : configMap.keySet()) {
            System.out.println(key + " = " + configMap.get(key));
        }
    }
}
public class PES2UG20CS815{
public static void main(String[] args) {
    String filename = "config.cfg";

    // Deserialize the config object from file
    Config  config = Config.deserialize(filename);

    // Print the initial contents of the config object
    config.printContents();

    // Update the config object
    config.put("Path", "/usr/local/bin");
    config.put("Version", "1.2.3");
    config.put("System_Name", "PES2UG20CS815");

    // Serialize the updated config object to file
    config.serialize(filename);

    // Print the updated contents of the config object
    config.printContents();
}
}
