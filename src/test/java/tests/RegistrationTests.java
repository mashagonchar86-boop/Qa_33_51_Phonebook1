package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }


    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        //int i = random.nextInt(1000) + 1000;
        User user = new User()
                .setEmail("user" + i + "@gmail.com")
                .setPassword("m341339182G^");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());

    }


    @Test
    public void registrationWrongEmail(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        User user = new User()
                .setEmail("user" + i + "gmail.com")
                .setPassword("m341339182G^");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
//        app.getHelperUser().fillLoginRegistrationForm(user2);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void registrationWrongPassword(){
        User user = new User().setEmail("user3@gmail.com").setPassword("");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));


    }

    @Test
    public void registrationExistUser(){
        User user = new User().setEmail("roma123@gmail.com").setPassword("m341339182G^");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));


    }



}

