package service;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * @author xiejiedun on 2018/12/14
 */
public class ReadJsonTest {

    String content = null;

    @Before
    public void before(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src\\test\\java\\service\\1.json")));
            content = "";
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                content += line;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readJson() throws Exception {
        ReadJson readJson = new ReadJson();
        readJson.readJson(content,null);
    }
}