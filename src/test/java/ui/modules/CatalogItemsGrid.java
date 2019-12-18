package ui.modules;

import org.openqa.selenium.By;
import ui.controls.Link;
import ui.modules.dialogs.SuccessfullyAddedToCartDialog;

public class CatalogItemsGrid extends BaseModule {
    public CatalogItemsGrid() {
        super(By.xpath("//ul[starts-with(@class, 'product_list')]"));
    }

    public CatalogItem getCatalogItemByDescription(String itemDescriptionPartialText) {
        return new CatalogItem(itemDescriptionPartialText);
    }

    public class CatalogItem extends BaseModule {

        private Controllable<Link> addToCrtLink = () -> new Link(this, By.xpath("//a[@title='Add to cart']"));

        public CatalogItem(String descriptionPartialText) {
            super(By.xpath(String.format("//li[contains(@class, 'ajax_block_product') and .//p[@class='product-desc' and contains(string(), '%s')]]", descriptionPartialText)));
        }

        public SuccessfullyAddedToCartDialog addToCart() {
            addToCrtLink.get().click();
            return new SuccessfullyAddedToCartDialog();
        }
    }
}
