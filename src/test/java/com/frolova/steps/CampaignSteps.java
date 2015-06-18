package com.frolova.steps;

import com.frolova.addition.Mmdriver;
import com.frolova.addition.Temp;
import com.frolova.pages.CampaignPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Cookie;
import org.apache.log4j.Logger;
import java.util.Random;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

/**
 * Created by Frolova.A on 5/19/15.
 */
public class CampaignSteps extends ScenarioSteps {
    CampaignPages campaignPages;
    Mmdriver mmdriver;
    ///////////////////////////////////////////////////////////
    String name = "MM" + Temp.randomtxt(4)+"TATP";
    String username = "MM" +  Temp.randomtxt(4)+"TATP";
    String mail = "MM" + Temp.randomtxt(4) +new Random().nextInt(999)+ "@maxymiser.com";
    String ph = "85895758"+ new Random().nextInt(999);
    private Cookie mmcore;
    private static final org.apache.log4j.Logger log = Logger.getLogger(CampaignSteps.class);
    static {
        DOMConfigurator.configureAndWatch("D:\\Selenium\\Tests\\Rank\\RankT99", 1000);
    }
    @Step
    //////////////////////////////////////////////////////////////////////////////////////////
    public void openSiteMain(String[] url){
        getDriver().manage().window().maximize();
        campaignPages.open("chanel", url);
        campaignPages.addCookies();

    }

    ///////////////////////////////////////////////////////////
    public void openTest( String[] url){
        getDriver().manage().window().maximize();
        campaignPages.open("chanel", url);
    }

    ///////////////////////////////////////////////////////////
    public void click_main_btn_join(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_button_join();

    } ///////////////////////////////////////////////////////////
    public void click_main_main_btn_join(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_button_main_join();

    }
    ///////////////////////////////////////////////////////////
    public void click_live_banner_join(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_live_banner_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_poker_banner_join(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_poker_banner_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_poker_btn_join(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_poker_btn_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_poker_link_join(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_poker_link_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_live_btn_play_main_banner_one(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_live_main_banner_one();
        campaignPages.click_live_btn_play_main_banner();
        campaignPages.click_play_btn_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_live_btn_play_main_banner_two(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_live_main_banner_two();
        campaignPages.click_live_btn_play_main_banner();
        campaignPages.click_play_btn_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_live_btn_play_main_banner_three(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_live_main_banner_three();
        campaignPages.click_live_btn_play_main_banner();
        campaignPages.click_play_btn_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_live_btn_play_main_banner_four(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_live_main_banner_four();
        campaignPages.click_live_btn_play_main_banner();
        campaignPages.click_play_btn_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_live_btn_play_main_banner_five(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_live_main_banner_five();
        campaignPages.click_live_btn_play_main_banner();
        campaignPages.click_play_btn_join();
    }
    ///////////////////////////////////////////////////////////
    public void click_live_btn_play(){
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.click_live_btn_play("2");
        campaignPages.click_play_btn_join();
    }
    ///////////////////////////////////////////////////////////
    @Step
    public void fillPreregWNStep(){
        log.info("Это информационное сообщение!");
        campaignPages.choose_new_login();
        campaignPages.btn_continue_WN();

    }
    ///////////////////////////////////////////////////////////
    @Step
    public void fillPreregWEStep(){
        log.info("Это информационное сообщение!");
        campaignPages.choose_club_login();
        campaignPages.fill_membership("1430184883");
        campaignPages.click_pre_day_b("1");
        campaignPages.click_pre_mon_b("01 - January");
        campaignPages.click_pre_year_b("1991");
        campaignPages.btn_continue_WE();

    }
    ///////////////////////////////////////////////////////////
    @Step
    public void PopUpfillPreregWNStep(){
        log.info("Это информационное сообщение!");
        //delete cookies T66
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.deleteT66Cookies();
        campaignPages.choose_new_login_popup();

    }
    ///////////////////////////////////////////////////////////
    @Step
    public void PopUpfillPreregWEStep(){
        log.info("Это информационное сообщение!");
        campaignPages.deleteAllCookies();
        campaignPages.addCookies();
        campaignPages.deleteT66Cookies();
        campaignPages.choose_club_login_popup();
        campaignPages.fill_membership("1430184883");
        campaignPages.click_pre_day_b("1");
        campaignPages.click_pre_mon_b("1-January");
        campaignPages.click_pre_year_b("1991");
    }
    ///////////////////////////////////////////////////////////
    @Step
    public void fillDefaultStep(){

       campaignPages.title("Mr");
        campaignPages.firstname(name);
        campaignPages.lastname(name);
        campaignPages.bithDay();
        campaignPages.bithMon();
        campaignPages.bithYear();
        campaignPages.email(mail);
        campaignPages.confmail(mail);
        campaignPages.postcode("w1u1bz");
        campaignPages.phonenumber(ph);
        campaignPages.password("qwerty");
        campaignPages.username(username);
        campaignPages.terms();
        campaignPages.submit();

    }
    ///////////////////////////////////////////////////////////
    @Step
    public void fillA2Step(){
        log.info("Это информационное сообщение!");
        campaignPages.see_frame();
        campaignPages.choose_new_login();
        campaignPages.btn_continue_a2();
        campaignPages.title("Mr");
        campaignPages.firstname(name);
        campaignPages.lastname(name);
        campaignPages.bithDay();
        campaignPages.bithMon();
        campaignPages.bithYear();
        campaignPages.email(mail);
        campaignPages.confmail(mail);
        campaignPages.postcode("w1u1bz");
        campaignPages.phonenumber(ph);
        campaignPages.password("qwerty");
        campaignPages.username(username);
        campaignPages.terms();
        campaignPages.submit();

    }
    @Step
    public void should_see_title_page(String text,String resultsTitle) {
        assertThat(campaignPages.getTitleRegPage(), hasItem(containsString(resultsTitle)));

    }

}
