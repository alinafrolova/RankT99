package com.frolova.features;

import com.frolova.steps.AdminSteps;
import com.frolova.steps.CampaignSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by иарвар on 15.06.2015.
 */
@RunWith(SerenityRunner.class)
public class A2Story {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;


    @Steps
    CampaignSteps campaignSteps;

    @Steps
    AdminSteps adminSteps;
//    @Before
//     @WithDriver("chrome")
//    public void a_work_with_admin(){
//
//        adminSteps.openAdmin();
//        adminSteps.loginAdmin();
//        adminSteps.clearAdmin();
//
//    }
    @Test
    @WithDriver("iexplorer")
    public void work_with_campaign_poker_main_click_btn(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_main_btn_join();
        campaignSteps.fillA2Step();
    }
}
