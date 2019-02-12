package org.woehlke.javaee7.petclinic.web.pages;

import org.jboss.arquillian.graphene.Graphene;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
// Run test file with arquillian



// No ngoi no om bung no cuoi - hai vai chuong chu

public class EditOwnerPage {

    @FindBy(id="editOwnerForm")
    private WebElement editOwnerForm;

    @FindBy(id="editOwnerForm:firstName")
    private WebElement firstName;

    @FindBy(id="editOwnerForm:lastName")
    private WebElement lastName;

    @FindBy(id="editOwnerForm:address")
    private WebElement address;

    @FindBy(id="editOwnerForm:city")
    private WebElement city;

    @FindBy(id="editOwnerForm:telephone")
    private WebElement telephone;

    @FindBy(id="editOwnerForm:save")
    private WebElement save;


    // Edit Owner Page


    @FindBy(id="editOwnerForm:save")
    private WebElement edit;

    public void saveContent(String name, String city){

        // Clear the field

        this.firstName.clear();
        this.city.clear();
        // Send data
        this.city.sendKeys(city);
        Graphene.guardHttp(this.save).click();

    }



    public void assertPageIsLoaded() {
        Graphene.waitModel().until().element(editOwnerForm).is().visible();
        Assert.assertTrue(editOwnerForm.isDisplayed());
    }

    public void editContent(String firstName,
                            String lastName,
                            String address,
                            String city,
                            String telephone) {
        this.firstName.clear();
        this.lastName.clear();
        this.address.clear();
        this.city.clear();
        this.telephone.clear();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.telephone.sendKeys(telephone);
        Graphene.guardHttp(this.save).click();
    }
}
