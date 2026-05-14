package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddNewContactTest extends TestBase{

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login();
        }
    }


    @Test
    public void addNewContactWithAllFieldsSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .Name("Vera"+i)
                .LastName("Lastovenko")
                .TelephoneNumber("0505555555"+1)
                .Email("roma123@gmail.com")
                .Adress("Ashdod, Israel")
                .Description("student")
                .build();

        app.getHelperContact().openAddContactForm();
        app.getHelperContact().fillAddContactForm(contact);
        app.getHelperContact().submitSaveContact();
        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getTelephoneNumber()));

        //Assert.assertTrue(app.getHelperContact().isContactPresent("Vera"));

    }

    @Test
    public void AddNewContactWithNessecaryFields(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
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

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getTelephoneNumber()));
        //Assert.assertTrue(app.getHelperContact().isContactPresent("Marina"));


    }
}
