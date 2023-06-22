package ch17.Sample;

public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
    // public void update(int number) {
    // public void update(NumberGenerator generator, int number) {

        System.out.println("DigitObserver:" + generator.getNumber());
        // System.out.println("DigitObserver:" + number);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
