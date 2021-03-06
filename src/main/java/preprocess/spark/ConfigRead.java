package preprocess.spark;

import java.io.*;
import java.util.Date;
import java.util.Properties;

/**
 * Created by zahraiman on 8/18/15.
 */
public class ConfigRead {
    InputStream inputStream;
    private Properties prop;

    public ConfigRead() throws IOException {
        getPropValues();
    }

    public void getPropValues() throws IOException {
        prop = new Properties();
        //String propFileName = "src/main/resources/config/config.properties";
        String propFileName = "/zaracode/classes/resources/config/config.properties";
        try {
            FileReader fileReader = new FileReader(propFileName);
            BufferedReader inputStream = new BufferedReader(fileReader);
            //inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            prop.load(inputStream);
        } catch (Exception e) {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
    }

    public boolean isUniqueUserHashtagBirthday() {
        return Boolean.valueOf(prop.getProperty("uniqueUserHashtagBirthday"));
    }

    public boolean isDirectedUserNet() {
        return Boolean.valueOf(prop.getProperty("directedUserNet"));
    }

    public boolean isGroupedUserMention() {
        return Boolean.valueOf(prop.getProperty("groupedUserMention"));
    }

    public boolean isTweetUser() {
        return Boolean.valueOf(prop.getProperty("tweetUser"));
    }

    public boolean isTweetUserHashtag() {
        return Boolean.valueOf(prop.getProperty("tweetUserHashtag"));
    }

    public boolean isGroupedTweetHashtag() {
        return Boolean.valueOf(prop.getProperty("groupedTweetHashtag"));
    }

    public boolean isLocal() {
        return Boolean.valueOf(prop.getProperty("local"));
    }

    public boolean isTweetHashtagTime(){
        return Boolean.valueOf(prop.getProperty("tweetHashtagTime"));
    }

    public Properties getProp() {
        return prop;
    }

    public String getHdfsPath(){
        return prop.getProperty("hdfsPath");
    }

    public String getDataPath() {
        return prop.getProperty("dataPath");
    }
    public String getOutputPath() {
        return prop.getProperty("outputPath");
    }
    public int getNumPart() {
        return Integer.valueOf(prop.getProperty("numPart"));
    }

    public String getOutputCSVPath(){
        return prop.getProperty("outputCSVPath");
    }

    public int getSensorEvalHashtagNum(){
        return Integer.valueOf(prop.getProperty("sensorEvalHashtagNum"));
    }

    public int getSensorEvalItNum(){
        return Integer.valueOf(prop.getProperty("sensorEvalItNum"));
    }

    public int getTopUserNum(){
        return Integer.valueOf(prop.getProperty("topNumUsers"));
    }

    public String getTestDataPath(){
        return  prop.getProperty("testDataPath");
    }
}
