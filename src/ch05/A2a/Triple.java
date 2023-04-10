package ch05.A2a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Triple {
    private static Map<String,Triple> map = new HashMap<>();

    // 클래스 로드 시 실행할 코드 => 해시맵을 완성함 (key: 이름, value: Triple 객체)
    static {
        String[] names = { "ALPHA", "BETA", "GAMMA" };
        // 스트림을 생성 => 각 원소에 대해 => 해쉬 맵에 넣어라
        Arrays.stream(names).forEach(s -> map.put(s, new Triple(s)));
    }

    private String name;

    private Triple(String name) {
        System.out.println("The instance " + name + " is created.");
        this.name = name;
    }

    public static Triple getInstance(String name) {
        return map.get(name);   // 해시맵에서 해당 이름의 Triple 객체를 얻어와서 반환함
    }

    @Override
    public String toString() {
        return this.name;
    }
}
