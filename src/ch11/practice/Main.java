package ch11.practice;

public class Main {
    public static void main(String[] args) {

        // Entry f1 = new File("vi", 100);
        // System.out.println(f1.getName());
        // System.out.println(f1.getSize());
        // System.out.println(f1);

        Directory root = new Directory("root");

        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        // root.add(bin); // Entry 에는 add가 없으므로 실행이 안 됨
        // ((Directory)root).add(bin);
        root.add(bin);
        root.add(tmp);
        root.add(usr);

        bin.add(new File("vi", 100));
        bin.add(new File("latex", 200));

        System.out.println(root.getSize());

        root.printList();
        root.printList("/");

    }
}
