package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(how = How.CSS, using = "input[placeholder='Pet Name']")
    private WebElement petNameField;

    @FindBy(how = How.CSS, using = "input[placeholder='Pet Status']")
    private WebElement petStatusField;

    @FindBy(how = How.ID, using = "btn-create")
    private WebElement createButton;

    @FindBy(how = How.CSS, using = "body")
    private WebElement pageBody;

    @FindBy(how = How.XPATH, using = "//div[@class='assignment-masthead']/div/nav/div/span[@class='banner-date']/div")
    private WebElement headerLabel;

    @FindBy(how = How.CLASS_NAME, using = "assignment-masthead")
    private WebElement headerBanner;

    @FindBy(how = How.CSS, using = "input[placeholder='Pet Name']")
    private WebElement petNameEdit;

    @FindBy(how = How.CSS, using = "input[placeholder='Pet Status']")
    private WebElement petStatusEdit;

    @FindBy(how = How.XPATH, using = "//table/tbody/tr[1]/td[3]/button")
    private WebElement deleteButton;

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public WebElement getPetNameEdit() {
        return petNameEdit;
    }

    public WebElement getPetStatusEdit() {
        return petStatusEdit;
    }

    public WebElement getCreateButton() {
        return createButton;
    }

    public WebElement getTableData(int row, int column) {
        return new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//table/tbody/tr[" + row + "]/td[" + column + "]")));
    }

    public WebElement getTableHeader(int column) {
        return new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//table/thead/tr/th[" + column + "]")));
    }

    public WebElement getPetListTable() {
        return driver.findElement(By.xpath("//table[@class='table table-hover']"));
    }

    public int getTableRowCount() {
        return getPetListTable().findElements(By.xpath(".//tbody/tr")).size();
    }

    public WebElement getHeaderLabel() {
        return headerLabel;
    }

    public WebElement getHeaderBanner() {
        return headerBanner;
    }

    public WebElement getFirstVisibleDelete() {
        String xpath = "//table/tbody/tr[1]/td[3]/button";
        return (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getFirstVisibleNameSpan() {
        String xpath = "//table/tbody/tr[1]/td[1]/span";
        return (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getFirstVisibleNameInput() {
        String xpath = "//table/tbody/tr[1]/td[1]/input";
        return (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getFirstVisibleStatusSpan() {
        String xpath = "//table/tbody/tr[1]/td[2]/span";
        return (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getFirstVisibleStatusInput() {
        String xpath = "//table/tbody/tr[1]/td[2]/input";
        return (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getVisibleCreate() {

        return (new WebDriverWait(driver, 3))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("btn-create")));
    }

    public int getVisibleTableRowCount() {
        int tableSize;
        try {
            tableSize = (new WebDriverWait(driver, 3))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//tbody/tr"))).size();
            return tableSize;
        } catch (org.openqa.selenium.TimeoutException e) {
            return 0;
        }

    }

    public WebElement getPetNameField() {
        return petNameField;
    }


    public WebElement getPetStatusField() {
        return petStatusField;
    }

    public WebElement getPageBody() {
        return pageBody;
    }

    public void clickCreateButton() {
        createButton.click();
    }


    public void clickAndClearPetNameField() {
        petNameField.click();
        petNameField.click();
    }

    public void clickPetNameField() {
        petNameField.click();
    }

    public void sendKeysNameField(String key) {
        petNameField.sendKeys(key);
    }

    public void clickAndClearPetStatusField() {
        petStatusField.click();
        petStatusField.clear();
    }

    public void clickPetStatusField() {
        petStatusField.click();
    }

    public void sendKeysStatusField(String key) {
        petStatusField.sendKeys(key);
    }


    public WebElement getPetTable() {
        return driver.findElement(By.xpath("//table[@class='table table-hover']"));
    }

    public int getPetTableRowCount() {
        return getPetTable().findElements(By.xpath(".//tbody/tr")).size();
    }

    public String getPetName(int row) {
        String addedPetName = getPetTableData(row, 1).getText();
        return addedPetName;
    }

    public String getPetStatus(int row) {
        String addedPetStatus = getPetTableData(row, 2).getText();
        return addedPetStatus;
    }


    public WebElement getPetTableData(int row, int column) {
        return new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//table/tbody/tr[" + row + "]/td[" + column + "]")));
    }


}
