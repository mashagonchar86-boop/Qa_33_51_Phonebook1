package tests;

import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddNewContactTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login();
        }
    }


    @Test
    public void addNewContactWithAllFieldsSuccess(){
        Contact contact = Contact.builder()
                .Name("Vera")
                .LastName("Lastovenko")
                .TelephoneNumber("0505555555")
                .Email("roma123@gmail.com")
                .Adress("Ashdod, Israel")
                .Description("student")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddContactForm(contact);
        app.getHelperContact().submitSaveContact();

        Assert.assertTrue(app.getHelperContact().isContactPresent("Vera"));

    }

    @Test
    public void AddNewContactWithNessecaryFields(){
        Contact contact = Contact.builder()
                .Name("Marina")
                .LastName("Pushkina")
                .TelephoneNumber("0505555555")
                .Email("roma123@gmail.com")
                .Adress("Ashdod, Israel")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddContactForm(contact);
        app.getHelperContact().submitSaveContact();

        Assert.assertTrue(app.getHelperContact().isContactPresent("Marina"));


    }
}
