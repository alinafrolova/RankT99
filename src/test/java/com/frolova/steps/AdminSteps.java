package com.frolova.steps;

import com.frolova.pages.AdminPages;
import com.frolova.addition.*;
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
    MMDriver mmdriver;

    @Step
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void loginAdmin(){
        adminPages.enterLoginPass("alina.frolova@maxymiser.com","Vfybyuty)1011990z");
        adminPages.logInSubmit();
//        adminPages.choose_configuration_action_log();
    }
    @Step
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void clearAdmin(){
        adminPages.clearActionLog();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Step
    //////////////////////////////////////////////////////////////////////////////////////////
    public void openAdmin(){
        getDriver().manage().window().maximize();
        adminPages.open();

        }
    @Step
    //////////////////////////////////////////////////////////////////////////////////////////
    public void get_action(String name_action){
        mmdriver.trackAction(name_action);

       }

    @Step
    public void should_see_definition_action(String text,String definition) {
        adminPages.openActionLog();
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
    @Step
    //////////////////////////////////////////////////////////////////////////////////////////
    public void get_genaration_campaign(){
        mmdriver.trackAction("T99_Registration_AB");
    }
}
