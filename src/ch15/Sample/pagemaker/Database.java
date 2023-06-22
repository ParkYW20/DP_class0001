package ch15.Sample.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Database {
    private Database() {
    }

    // 데이터베이스 이름에서 Properties를 얻는다 
    public static Properties getProperties(String dbname) throws IOException {
        // property file 이름
        String filename = dbname + ".txt";  // (dbname).txt file

        Properties prop = new Properties();   // empty Properties 파일을 만든다
        prop.load(new FileReader(filename));  // (인자로 들어온) file 이름을 FileReader로 읽어서 돌려준다 -> empty properties file 변수(prop)는 load()로 properties list를 읽어들인다
        return prop;
    }
}
