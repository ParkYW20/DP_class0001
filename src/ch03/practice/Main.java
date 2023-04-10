package ch03.practice;

public class Main {
    public static void main(String[] args) {

        AbstractDisplay x;

        // AbstractDisplay c = new CharDisplay('a');
        // c.open();
        // c.print();
        // c.close();
        x = new CharDisplay('a');
        x.open();
        x.print();
        x.close();

        x.display();    // c.display();

        
        // AbstractDisplay s = new StringDisplay("박연우");
        // s.open();
        // s.print();
        // s.close();      
        x = new StringDisplay("박연우"); 
        x.open();
        x.print();
        x.close();

        x.display();    // s.display();

        
    }

}
