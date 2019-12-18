package ui.modules;

import org.openqa.selenium.By;
import ui.controls.Link;

public class CatalogGridViewPanel extends BaseModule {
    private Controllable<Link> gridViewLink = () -> new Link(this, By.cssSelector("#grid>a"));
    private Controllable<Link> listViewLink = () -> new Link(this, By.cssSelector("#list>a"));

    public CatalogGridViewPanel() {
        super(By.cssSelector(".content_sortPagiBar.clearfix"));
    }

    public void openListView() {
        listViewLink.get().click();
    }
}
