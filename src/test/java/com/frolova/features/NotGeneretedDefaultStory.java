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
public class NotGeneretedDefaultStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;


    @Steps
    CampaignSteps campaignSteps;

    @Test
    @WithDriver("chrome")
    public void work_with_campaign_live_click_btn_play(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_live_btn_play();

        ////choose generation campaign
    }
    ///click_live_btn_play_main_banner
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_live_main_click_btn_play(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_live_btn_play_main_banner_one();
        ////choose generation campaign
    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_live_main_click_btn_play_two(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_live_btn_play_main_banner_two();
        ////choose generation campaign
    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_live_main_click_btn_play_three(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_live_btn_play_main_banner_three();
        ////choose generation campaign
    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_live_main_click_btn_play_four(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_live_btn_play_main_banner_four();
        ////choose generation campaign
    }
    @Test
    @WithDriver("chrome")
    public void work_with_campaign_live_main_click_btn_play_five(){

        campaignSteps.openSiteMain(new String[] {"live-casino"});
        campaignSteps.click_live_btn_play_main_banner_five();
        ////choose generation campaign
    }
}
