package ch20.Sample;

import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {
    // 이미 만든 BigChar 인스턴스를 관리 
    // private Map<String,BigChar> pool : 인터페이스 선언
    private Map<String,BigChar> pool = new HashMap<>(); // hash : key와 value 쌍을 관리한다는 의미!
    // Singleton 패턴 
    private static BigCharFactory singleton = new BigCharFactory();

    // 생성자 
    private BigCharFactory() {
    }

    // 유일한 인스턴스를 얻는다
    public static BigCharFactory getInstance() {
        return singleton;
    }

    // BigChar 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) {  // 중요) ex. '1' 달라고 요청이 오면,
        
        // pool에서 먼저 '1'이 있는지 검색을 함 (pool = 해쉬맵)
        BigChar bc = pool.get(String.valueOf(charname));    // "1"로 바꿔서 넣어줘야 함 // 여기 들어가는 건 key (<- string type)
        
        if (bc == null) {   // 검색한 결과, 없으면 ....
            // 여기서 BigChar 인스턴스를 생성 
            bc = new BigChar(charname);
            pool.put(String.valueOf(charname), bc);
        }
        return bc;
    }
}
