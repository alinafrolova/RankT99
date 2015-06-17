package com.frolova.features;

import com.frolova.steps.CampaignSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Frolova.A on 6/13/15.
 */
@RunWith(SerenityRunner.class)
public class DefaultStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;


    @Steps
    CampaignSteps campaignSteps;

    @Test
    @WithDriver("chrome")
    public void work_with_campaign_poker_main_click_btn(){
        campaignSteps.openSiteMain(new String[] {"Poker"});
        campaignSteps.click_main_btn_join();
        campaignSteps.fillDefaultStep();

    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_poker_click_banner(){

        campaignSteps.openSiteMain(new String[] {"Poker"});
        campaignSteps.click_poker_banner_join();
        campaignSteps.fillDefaultStep();
    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_poker_click_btn(){

        campaignSteps.openSiteMain(new String[] {"Poker"});
        campaignSteps.click_poker_btn_join();
        campaignSteps.fillDefaultStep();
    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_poker_click_link(){

        campaignSteps.openSiteMain(new String[] {"Poker"});
        campaignSteps.click_poker_link_join();
        campaignSteps.fillDefaultStep();
    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_live_main_click_btn(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_main_btn_join();
        campaignSteps.fillDefaultStep();
    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_live_click_banner(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_live_banner_join();
        campaignSteps.fillDefaultStep();
    }
}
