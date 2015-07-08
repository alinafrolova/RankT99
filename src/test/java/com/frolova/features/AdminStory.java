package com.frolova.features;

import com.frolova.steps.AdminSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Frolova.A on 4/28/15.
 */
@RunWith(SerenityRunner.class)
public class AdminStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;


    @Steps
    AdminSteps adminSteps;

   @Before
  // @WithDriver("chrome")
    public void a_work_with_admin(){

        adminSteps.openAdmin();
        adminSteps.loginAdmin();
        adminSteps.clearAdmin();

    }

     @Test
   //  @WithDriver("firefox")
     public void c_find_actiona_in_action_log(){
         adminSteps.openAdmin();
         adminSteps.loginAdmin();

        adminSteps.should_see_definition_action("Campaign- ","T99_Registration_AB");
        adminSteps.should_see_definition_action("Content- ","a_registr=Default");
         // adminSteps.should_see_definition("Content- ","a_page=a2_nossn_1step;");
         // adminSteps.should_see_definition("Content- ","a_page=a3_ssn_3step;");
       //  adminSteps.should_see_definition("Content- ","a_page=a4_nossn_3step;");

        adminSteps.should_see_definition_action("Action- ","t99_preregcomplete=1(Non-member)");
        adminSteps.should_see_definition_action("Action- ","t12a_steptwo=1,unique;");
        adminSteps.should_see_definition_action("Action- ","t12a_stepthree=1,unique;");
        adminSteps.should_see_definition_action("Action- ","t12a_registration=1,unique;");
        // adminSteps.should_see_definition("Action- ","t12a_firstdeposit=1,unique;");

        }



}
