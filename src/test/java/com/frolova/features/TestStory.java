package com.frolova.features;

import com.frolova.steps.CampaignSteps;
import com.frolova.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Frolova.A on 5/14/15.
 */
@RunWith(SerenityRunner.class)
public class TestStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;


    @Steps
    CampaignSteps campaignSteps;
    @Steps
    LoginSteps loginSteps;

    @Test
    @WithDriver("chrome")
    public void b_work_with_campaign(){
        campaignSteps.openSiteMain(new String[] {"/"});
        loginSteps.login();
        campaignSteps.should_see_name("username"," ");


    }
}
