package ui.pages;

import ui.modules.CatalogGridViewPanel;
import ui.modules.CatalogItemsGrid;

public class CatalogPage extends BasePage {

    public CatalogGridViewPanel catalogGridViewPanel = new CatalogGridViewPanel();
    public CatalogItemsGrid catalogItemsGrid = new CatalogItemsGrid();

    CatalogPage(CatalogCategory catalogCategory) {
        super(String.format("?id_category=%d&controller=category", catalogCategory.getId()));
    }

    public enum CatalogCategory {
        WOMEN(3), DRESSES(8), TSHIRTS(5);

        private int id;

        CatalogCategory(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
