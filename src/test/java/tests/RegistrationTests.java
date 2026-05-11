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
        int i = random.nextInt(1000) + 1000;
        User user = new User()
                .setEmail("user" + i + "@gmail.com")
                .setPassword("m341339182G^");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());

    }


    @Test
    public void registrationWrongEmail(){
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
//        User user2 = new User()
//                .setEmail("user" + i + "gmail.com")
//                .setPassword("m341339182G^");
//        System.out.println(user2);
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("roma123@gmail.com", "1111");
//        app.getHelperUser().fillLoginRegistrationForm(user2);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }

    @Test
    public void registrationWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("user3@gmail.com", "");
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));


    }



}

