package ch02.A2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// ! : 어댑터는 어댑티를 가지고 있다가 어댑티에게 위임한다
// 어댑터 (위임을 이용함)
public class FileProperties implements FileIO {
    Properties property = new Properties();    // 어댑티 (JDK에서 제공됨)

    @Override
    public void readFromFile(String filename) throws IOException {
        property.load(new FileReader(filename));    // 어댑티에게 위임
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        property.store(new FileWriter(filename), "written by FileProperties");
    }

    @Override
    public void setValue(String key, String value) {
        property.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return property.getProperty(key, "");
    }
}
