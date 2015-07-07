package com.frolova.steps;

import com.frolova.addition.Mmdriver;
import com.frolova.pages.AdminPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
/**
 * Created by Frolova.A on 5/12/15.
 */
public class AdminSteps extends ScenarioSteps {
    AdminPages adminPages;
    Mmdriver mmdriver;

    @Step
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void loginAdmin(){
        adminPages.enterLoginPass("");
        adminPages.logInSubmit();
//        adminPages.choose_configuration_action_log();
    }
    @Step
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void clearAdmin(){
        adminPages.clearActionLog();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    @Step
    //////////////////////////////////////////////////////////////////////////////////////////
    public void openAdmin(){
        getDriver().manage().window().maximize();
        adminPages.open();

        }
    @Step
    //////////////////////////////////////////////////////////////////////////////////////////
    public void openActionLog(){
        adminPages.openActionLog();
        mmdriver.trackAction("t12a_stepone=1");
        mmdriver.trackAction("t12a_steptwo=1,unique;");
        mmdriver.trackAction("t12a_stepthree=1,unique;");
        mmdriver.trackAction("t12a_registration=1");
        mmdriver.trackAction("t12a_firstdeposit");
       }

    @Step
    public void should_see_definition(String text,String definition) {
        assertThat(adminPages.getDefinitions(), hasItem(containsString(definition)));

    }
   /////////////////////////////////////////////////////////////////////////////////////////////
   @Step
   public void settings_weight_all(){
       adminPages.openWeights();
       adminPages.change_weigtsdef("100");
       adminPages.change_weigts_a2("100");
       adminPages.change_weigts_a3("100");
       adminPages.change_weigts_a4("100");

       adminPages.click_button_save_weight();
   }
   //////////////////////////////////////////////////////////////////////////////////////////
   @Step
   public void settings_weight_default(){
       adminPages.openWeights();
       adminPages.change_weigtsdef("100");
       adminPages.change_weigts_a2("0");
       adminPages.change_weigts_a3("0");
       adminPages.change_weigts_a4("0");
       adminPages.click_button_save_weight();
   }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void settings_weight_a2(){
        adminPages.openWeights();
        adminPages.change_weigtsdef("0");
        adminPages.change_weigts_a2("100");
        adminPages.change_weigts_a3("0");
        adminPages.change_weigts_a4("0");
        adminPages.click_button_save_weight();
    }
    //////////////////////////////////////////////////////////////////////////////////////////

}
