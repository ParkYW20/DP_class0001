// 20200207 박연우

package hw.ch02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// 어댑터 (상속 이용)
public class FileProperties extends Properties implements FileIO {
    // @Override
    // public void readFromFile(String filename) throws IOException {
        // property.load(new FileReader(filename));    // 어댑티에게 위임. property(properties 인스턴스)의 load() 메소드를 호출
    // }

    public FileProperties() {  // 생성자
        super();
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        load(new FileReader(filename));    
        // 어댑티(Properties)를 속성으로 가지지 않고, 상속 받았기 때문에
        // FileIO 구현 시 부모 클래스의 메소드를 호출
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        store(new FileWriter(filename), "written by FileProperties");
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }
    
    @Override
    public String getValue(String key) {
        return getProperty(key, "");
    }
    
} 