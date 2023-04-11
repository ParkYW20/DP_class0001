package hw.ch05;

import hw.ch05.idcard.IDCardFactoryYeonWooPark2;

public class Main2 extends Thread {
    
    public static void main(String[] args) {

        System.out.println("20200207 박연우");

        System.out.println("Start.");

        new Main2("최승훈").start();
        new Main2("박연우").start();
        new Main2("한수경").start();
        
        System.out.println("End.");
    }

    @Override
    public void run() {
        IDCardFactoryYeonWooPark2 obj = IDCardFactoryYeonWooPark2.getInstance();
        System.out.println(getName() + ": " + obj);
    }

    public Main2(String name) {
        super(name);
    }
}