package ch08.Sample.listfactory;

import ch08.Sample.factory.Factory;
import ch08.Sample.factory.Link;
import ch08.Sample.factory.Page;
import ch08.Sample.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
