package com.frolova.steps;

import com.frolova.pages.CampaignPages;
import com.frolova.pages.LoginPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Frolova.A on 6/19/15.
 */
public class LoginSteps extends ScenarioSteps {
    LoginPages loginPages;
    CampaignPages campaignPages;
    @Step
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void login(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        getDriver().navigate().refresh();
        loginPages.enterLogin("GreenCatTATP", "qwerty"); 
    }
}
