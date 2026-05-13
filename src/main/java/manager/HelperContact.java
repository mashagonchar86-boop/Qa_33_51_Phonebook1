package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm() {
        click(By.cssSelector("a[href='/add']"));
    }

    public void fillAddContactForm(Contact contact) {
        type(By.xpath("//input[@placeholder='Name']"), contact.getName());
        type(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"), contact.getTelephoneNumber());
        type(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        type(By.xpath("//input[@placeholder='Address']"), contact.getAdress());
        type(By.xpath("//input[@placeholder='description']"), contact.getDescription());


    }

    public void submitSaveContact() {
        click(By.xpath("//b[normalize-space()='Save']"));
    }

    public boolean isLogged() {

        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public boolean isContactPresent(String name) {
        return wd.findElements(By.xpath("//h2[text()='" + name + "']")).size() > 0;
    }
}
