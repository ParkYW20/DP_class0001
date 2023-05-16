package ch17.practice2;

public class Main {
    public static void main(String[] args) {
        // 관찰 대상 생성
        NumberGenerator rnGenerator = new RandomNumberGenerator();

        // 관찰자 생성
        Observer digitObserver = new DigitObserver();  
        Observer graphObserver = new GraphObserver();      

        // 관찰 대상에 관찰자를 등록 
        /*
         * (왜? 관찰 대상을 관찰자에 등록하는 게 아니라, 관찰자를 관찰 대상에 등록하나?)
         * 그래야 관찰 대상으로부터 무엇을 관찰할지 (getNumber()) 얻어올 수 있으니까.
         * 관찰자들은 관찰 대상의 속성으로 들어감 (집약/집합 관계) 
         * => 관찰 대상인 객체에 속성으로 등록된 관찰자들은 관찰 대상으로부터 notify 받을 수 있음 (notifyObservers())
         * => notifyObservers()는 자신(generator)의 'list' field(컬렉션 객체)에 등록된 observer 원소들에게 각각 'update(Generator instance(this))'를 호출함
         * => 관찰자(observer)들은 인자로 들어온 관찰대상(generator)으로부터 현재 상태를 얻어와(getNumber())
         * => 그대로 출력하거나 (DigitObserver의 instance) 그 수만큼의 그래프를 표시함(GraphObserver의 instance)
         */
        rnGenerator.addObserver(digitObserver);
        rnGenerator.addObserver(graphObserver);

        // 관찰대상에게 숫자 생성 요청
        rnGenerator.execute();

        /* 
         * (pre) Main의 main()에서 관찰대상과 관찰자 생성 후, 관찰 대상에 관찰자를 등록
         * 1) 관찰자가 등록된(observer를 속성으로 가지는) 상태인 generator에게 숫자 생성 요청 (execute()) 
         *     (숫자를 생성하여 자신의 field인 number 변수에 저장해둠)
         * 2) 관찰 대상(Random ... Generator)의 excute() 동작하며 부모(NumberGenerator)에게 상속받은 notifyObservers()를 실행
         * 3) notifyObservers() 동작하며 자신(관찰대상)에게 등록되어 있는 (list 객체에 등록된) 관찰자들을 하나씩 불러와서 (관찰자).update((this))를 호출, 인자로 자기자신 전달
         * 4) 관찰자 원소마다 update() 동작되며 매개변수(인자)로 들어온 관찰 대상(Random ... generator)의 .getNumber() 호출하여 관찰 대상의 현재 상태를 얻어옴
         *    + 관찰자마다 update()가 다르게 overriding 되어 있으므로 관찰자마다 다르게 결과를 보여줌 (숫자 출력 or 그래프 표시)
         */
    }
}
