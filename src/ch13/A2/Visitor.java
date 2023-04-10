package ch13.A2;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
