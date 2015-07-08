package com.frolova.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static ch.lambdaj.Lambda.convert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Frolova.A on 4/29/15.
 */
//@DefaultUrl("https://registration.grosvenorcasinos.com/WN/P1/Details/2?t=DBEA48EFB96D4A4F8BA96DE7F8")
@NamedUrls(
        {
                @NamedUrl(name = "chanel", url = "http://www.grosvenorcasinos.com{1}?mmcore.opc.enabled=1")

        }
)

public class CampaignPages extends PageObject {
    public WebDriver webdriver;
    private WebDriver driver;
    private String adminCamp,checkCamp,baseUrl,m;
    private String namevalue;


    //////////////////////////////////fields
    @FindBy(id = "clublogin")
    private WebElementFacade checkbox_clublogin;
    //////////////////////////////////
    @FindBy(id = "newlogin")
    private WebElementFacade checkbox_newlogin;
    //////////////////////////////////popup
    @FindBy(css = "a.get-my-details-bonus")
    private WebElementFacade popup_clublogin;
    //////////////////////////////////
    @FindBy(css = "a.join-now-no-bonus")
    private WebElementFacade popup_newlogin;
    //////////////////////////////////
    @FindBy(id = "ClubIdentifier")
    private WebElementFacade membership_field;
    //////////////////////////////////
    @FindBy(id = "PreRegDOBDay")
    private WebElementFacade pre_day_b;
    //////////////////////////////////

    @FindBy(id = "PreRegDOBMonth")
    private  WebElementFacade pre_reg_mon_b;
    //////////////////////////////////
    @FindBy(id = "PreRegDOBYear")
    private WebElementFacade pre_reg_year_b;
    //////////////////////////////////
    @FindBy(id = "FullName_Prefix")
    private WebElementFacade title_select;
    //////////////////////////////////
    @FindBy(id = "FullName_FirstName")
    private WebElementFacade first_name_field;
    //////////////////////////////////
    @FindBy(id = "FullName_LastName")
    private WebElementFacade last_name_field;
    //////////////////////////////////
    @FindBy(id = "DOBDay")
    private WebElementFacade day_b;
    //////////////////////////////////
    @FindBy(id = "DOBMonth")
    private  WebElementFacade mon_b;
    //////////////////////////////////
    @FindBy(id = "DOBYear")
    private WebElementFacade year_b;
    //////////////////////////////////

    @FindBy(id = "Email_EmailAddress")
    private WebElementFacade email_field;
    //////////////////////////////////
    @FindBy(id = "Email_ConfirmEmail")
    private WebElementFacade conf_email_field;
    //////////////////////////////////
    @FindBy(id = "Phone_PhoneNumber")
    private WebElementFacade phone_number;
    //////////////////////////////////
    @FindBy(id = "PostCodeLookup")
    private WebElementFacade post_code_field;
    //////////////////////////////////
    @FindBy(id = "UserName")
    private WebElementFacade user_name_field;
    //////////////////////////////////
    @FindBy(id = "Password_Password")
    private WebElementFacade passwoed_field;
    //////////////////////////////////banner
    @FindBy(xpath = "//div[2]/a/img")
    private WebElementFacade live_join_banner;
    //////////////////////////////////banner
    @FindBy(xpath = "//aside/div/a/img")
    private WebElementFacade poker_join_banner;
    //////////////////////////////////button
    @FindBy(id = "logon_register")
    private WebElementFacade main_join_btn;
    //////////////////////////////////button
    @FindBy(linkText = "REGISTER NOW")
    private WebElementFacade poker_join_btn;
    //////////////////////////////////img1
    @FindBy(css = "div.bottomNavButtonOFF.bottomNavButtonON > span")
    private WebElementFacade main_banner_one;
    //////////////////////////////////img2
    @FindBy(css = "#parallax_mouseinteraction_photoText2 > div.parallax_mouseinteraction_text_line > a.gl-open > img")
    private WebElementFacade main_banner_two;
    //////////////////////////////////img3
    @FindBy(css = "#parallax_mouseinteraction_photoText3 > div.parallax_mouseinteraction_text_line > a.gl-open > img")
    private WebElementFacade main_banner_three;
    //////////////////////////////////img4
    @FindBy(css = "#parallax_mouseinteraction_photoText4 > div.parallax_mouseinteraction_text_line > a.gl-open > img")
    private WebElementFacade main_banner_four;
    //////////////////////////////////img5
    @FindBy(css = "#parallax_mouseinteraction_photoText5 > div.parallax_mouseinteraction_text_line > a.gl-open > img")
    private WebElementFacade main_banner_five;
    //////////////////////////////////img6
    @FindBy(css = "#parallax_mouseinteraction_photoText6 > div.parallax_mouseinteraction_text_line > a.gl-open > img")
    private WebElementFacade main_banner_six;
    //////////////////////////////////button
    @FindBy(css = "a.gl-open > img")
    private WebElementFacade main_play_btn;
    //////////////////////////////////button
    @FindBy(css = "a")
    private WebElementFacade join_play_btn;
    //////////////////////////////////link
    @FindBy(css = "ul.poker-test-list > li > a")
    private WebElementFacade poker_join_link;
   /* //////////////////////////////////btn
    @FindBy(xpath = "//p/a")
    private WebElementFacade live_play_btn;*/
    //////////////////////////////////window
    @FindBy(name = "GameWindow")
    private WebElementFacade window;
    /////////////////////////////////
    @FindBy(xpath = "//input[@id='mm-next-step']")
    private WebElementFacade button_continue;
    /////////////////////////////////
    @FindBy(id = "mm-next-step")
    private WebElementFacade btn_continue_WN;
    /////////////////////////////////
    @FindBy(css ="div.existing-customer-links > #mm-next-step")
    private WebElementFacade btn_continue_WE;
    /////////////////////////////////
    @FindBy(id = "submit1")
    private WebElementFacade submit;
    /////////////////////////////////
    @FindBy(id = "postcode_lookup_btn")
    private WebElementFacade postcode_lookup_btn;
    /////////////////////////////////
    @FindBy(id = "termscheck")
    private WebElementFacade terms ;
    /////////////////////////////////frame
    @FindBy (id = "mm_t99_popup")
    private WebElementFacade frame;
    /////////////////////////////////close frame
    @FindBy (id = "mm_t99_popup")
    private WebElementFacade btn_close_frame;
    /////////////////////////////////
    @FindBy (id = "accoptions")
    private WebElementFacade panel_logged_in;
    /////////////////////////////////
    private String RequiredSystemNameXpath = "(//a[contains(text(),'Play now')][y])";

    private WebElement live_play_btn (String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("y", substitutionValue)));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////
    Cookie mmcore = new Cookie("mmcore.opc.enabled", "1");
    Cookie cfgid = new Cookie("mmcore.cfgid", "1");
    Cookie mm_t66_counter = new Cookie("mm-t66-counter", "1");
    Cookie mm_t66_generated = new Cookie("mm-t66-generated", "true");
    private String CurrURL;
    private String DefURL;


    /////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void deleteT66Cookies() {
        getDriver().manage().deleteCookie(mm_t66_counter);
        getDriver().manage().deleteCookie(mm_t66_generated);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void addCookies(){

        getDriver().manage().addCookie(mmcore);
        System.out.println("enabled");
        getDriver().manage().addCookie(cfgid);



    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void check_cookie(){
        Set<Cookie> allCookies = getDriver().manage().getCookies();
        System.out.println(allCookies);
        for (Cookie loadedCookie : allCookies) {
            System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));

        }
    }
    /////////////////////////////////////////
    public List<String> getTitleRegPage() {
        WebElementFacade TitleList = find(By.id("loggedin"));
        System.out.println(TitleList);
        List<WebElement> resultsTitle = TitleList.findElements(By.tagName("span"));
        System.out.println(resultsTitle);
        return convert(resultsTitle, toStrings());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_button_join(){

      main_join_btn.isPresent();
        getDriver().navigate().refresh();
      String btn_join = main_join_btn.getText();
        System.out.println(btn_join);
      getDriver().navigate().refresh();
      assertEquals(btn_join, "Join");
      main_join_btn.click();

    }
    public void click_button_main_join(){

        main_join_btn.isPresent();
        getDriver().navigate().refresh();
        String btn_join = main_join_btn.getText();
        System.out.println(btn_join);
        getDriver().navigate().refresh();
        assertEquals(btn_join, "JOIN");
        main_join_btn.click();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_live_banner_join(){

        live_join_banner.isPresent();
        getDriver().navigate().refresh();
        live_join_banner.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_poker_banner_join(){

        poker_join_banner.isPresent();
        getDriver().navigate().refresh();
        poker_join_banner.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_poker_btn_join(){

        poker_join_btn.isPresent();
        getDriver().navigate().refresh();
        poker_join_btn.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_poker_link_join(){

        poker_join_link.isPresent();
        getDriver().navigate().refresh();
        poker_join_link.click();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_live_main_banner_one(){

        main_banner_one.isPresent();
        main_banner_one.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_live_main_banner_two(){

        main_banner_two.isPresent();
        main_banner_two.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_live_main_banner_three(){

        main_banner_three.isPresent();
        main_banner_three.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_live_main_banner_four(){

        main_banner_four.isPresent();
        main_banner_four.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_live_main_banner_five(){

        main_banner_five.isPresent();
        main_banner_five.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_live_main_banner_six(){

        main_banner_one.isPresent();
        main_banner_one.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_live_btn_play_main_banner(){
        main_play_btn.isPresent();
        String btn_play = main_play_btn.getAttribute("src");
        System.out.println(btn_play);
        assertEquals(btn_play, "http://www.grosvenorcasinos.com/Content/Images/sliders/cta-play-now-yellow.png");
        main_play_btn.click();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_play_btn_join(){
        getDriver().switchTo().defaultContent();
        waitFor(join_play_btn);
        String btn_join = join_play_btn.getText();
        System.out.println(btn_join);
        assertEquals(btn_join, "JOIN NOW");
        join_play_btn.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_new_login(){
        CurrURL = getDriver().getCurrentUrl();
        System.out.println(CurrURL);
        DefURL = "https://registration.grosvenorcasinos.com/";
        if (CurrURL == DefURL) {
            System.out.println("The strings are equal.");
            String chc_newl = getDriver().findElement(By.cssSelector("h2")).getText();
            System.out.println(chc_newl);
            assertEquals(chc_newl, "READY TO JOIN? GREAT!");
            checkbox_newlogin.isPresent();
            checkbox_newlogin.click();
        } else {
            System.out.println("The strings are unequal.");
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_club_login(){
        String chc_newl = getDriver().findElement(By.cssSelector("h2")).getText();
        System.out.println(chc_newl);
        assertEquals(chc_newl, "READY TO JOIN? GREAT!");
        checkbox_clublogin.isPresent();
        checkbox_clublogin.click();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_new_login_popup(){

            popup_newlogin.isPresent();
            popup_newlogin.click();


    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_club_login_popup(){
        String chc_newl = getDriver().findElement(By.cssSelector("h2")).getText();
        System.out.println(chc_newl);
        assertEquals(chc_newl, "CASINO MEMBERS GET £40!");
        popup_clublogin.isPresent();
        popup_clublogin.click();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void see_frame(){

        frame.isPresent();
        boolean wait_submit,wait_continue;
        wait_submit= btn_close_frame.isPresent();
        getDriver().manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
            while (wait_submit=false)
            {
                wait_submit= btn_close_frame.isDisplayed();
                System.out.println(wait_submit);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().switchTo().frame("mm_t99_reg_frame");
        wait_continue= btn_continue_WN.isDisplayed();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
            while (wait_continue=false)
            {
                wait_continue= btn_continue_WN.isDisplayed();
                System.out.println(wait_continue);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btn_close_frame.click();

        String chc_newl = getDriver().findElement(By.cssSelector("h2")).getAttribute("src");
        System.out.println(chc_newl);
        assertEquals(chc_newl, "//service.maxymiser.net/cm/images-eu/1/1/1/3AA8C16822B3302F9060E02F5F86B75A149161E570BDACAE986A6255951B3A7A/grosvenorcasinos-com/T99-Registration-AB/pre_reg_header_text.png");


    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void fill_membership(String membership){
        membership_field.isPresent();
        boolean  actual;

//        actual = membership_field.containsText("");
//        assertFalse(actual);
        membership_field.clear();
        membership_field.sendKeys(membership);
        actual = membership_field.containsText(membership);
        assertFalse(actual);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_pre_day_b(String day){
        pre_day_b.isPresent();
        pre_day_b.click();
        pre_day_b.isSelected();
        pre_day_b.selectByVisibleText(day);

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_pre_mon_b(String mon){
        pre_reg_mon_b.isPresent();
        pre_reg_mon_b.click();
        pre_reg_mon_b.isSelected();
        pre_reg_mon_b.selectByVisibleText(mon);

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_pre_year_b(String year){
        pre_reg_year_b.isPresent();
        pre_reg_year_b.click();
        pre_reg_year_b.isSelected();
        pre_reg_year_b.selectByVisibleText(year);
        pre_reg_year_b.click();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public void btn_continue_WN(){
        boolean wait_submit;
        wait_submit= btn_continue_WN.isPresent();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        btn_continue_WN.isPresent();
        btn_continue_WN.click();
        waitForWithRefresh();
        withTimeoutOf(5, TimeUnit.SECONDS).elementIsDisplayed(By.tagName("h2"));

        while (wait_submit=false)
        {
            wait_submit= btn_continue_WN.isDisplayed();
            System.out.println(wait_submit);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void btn_continue_WE(){
        boolean wait_submit;
        wait_submit= btn_continue_WE.isPresent();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        btn_continue_WE.isPresent();
        btn_continue_WE.click();
        waitForWithRefresh();
        withTimeoutOf(5, TimeUnit.SECONDS).elementIsDisplayed(By.tagName("h2"));

        while (wait_submit=false)
        {
            wait_submit= btn_continue_WE.isDisplayed();
            System.out.println(wait_submit);
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void btn_continue_a2(){
        boolean wait_submit;
        wait_submit= btn_continue_WN.isPresent();
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            Thread.sleep(3000);
            while (wait_submit=false)
            {
                wait_submit= btn_continue_WN.isDisplayed();
                System.out.println(wait_submit);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btn_continue_WN.isPresent();
        btn_continue_WN.click();
        waitForWithRefresh();
        withTimeoutOf(5, TimeUnit.SECONDS).elementIsDisplayed(By.tagName("h2"));


    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void title (String title){
        title_select.isPresent();
        title_select.click();
        title_select.isSelected();
        title_select.selectByVisibleText(title);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void firstname(String name){
        first_name_field.isPresent();
        namevalue = first_name_field.getAttribute("value");
        if (namevalue.length()==0)
        {
            first_name_field.click();
            first_name_field.sendKeys(name);
        }

        boolean  actual;
        actual = first_name_field.containsText(name);
        assertFalse(actual);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void lastname(String name){
        last_name_field.isPresent();
        namevalue = last_name_field.getAttribute("value");
        if (namevalue.length()==0)
        {
            last_name_field.click();
            last_name_field.sendKeys(name);
        }

        boolean  actual;
        actual = last_name_field.containsText(name);
        assertFalse(actual);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public void bithDay(){
        day_b.isPresent();
        day_b.click();
        day_b.isSelected();
        day_b.selectByVisibleText("1");

    }
    ///////////////////////////////////////////////////////////////////////////////////////////select
    public void bithMon(){
        mon_b.selectByVisibleText("01 - January");

    }
    ///////////////////////////////////////////////////////////////////////////////////////////select
    public void bithYear(){
        year_b.selectByVisibleText("1990");

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void email(String mail){
        email_field.isPresent();
        namevalue = email_field.getAttribute("value");
        if (namevalue.length()==0)
        {
            email_field.click();
            email_field.sendKeys(mail);
        }

        boolean  actual;
        actual = email_field.containsText(mail);
        assertFalse(actual);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void confmail(String email){
        conf_email_field.isPresent();
        namevalue = conf_email_field.getAttribute("value");
        if (namevalue.length()==0)
        {
            conf_email_field.click();
            conf_email_field.sendKeys(email);
        }

        boolean  actual;
        actual = conf_email_field.containsText(email);
        assertFalse(actual);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void phonenumber(String phone){
        phone_number.isPresent();
        namevalue = phone_number.getAttribute("value");
        if (namevalue.length()==0)
        {
            phone_number.click();
            phone_number.sendKeys(phone);
        }
        boolean  actual;
        actual = phone_number.containsText(phone);
        assertFalse(actual);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void postcode(String postcode){
        post_code_field.isPresent();
        namevalue = post_code_field.getAttribute("value");
        if (namevalue.length()==0)
        {
            post_code_field.click();
            post_code_field.sendKeys(postcode);
            postcode_lookup_btn.isPresent();
            postcode_lookup_btn.click();
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void username(String username){
        user_name_field.isPresent();
        namevalue = user_name_field.getAttribute("value");
        if (namevalue.length()==0)
        {
            user_name_field.click();
            user_name_field.sendKeys(username);

        }
        boolean  actual;
        actual = user_name_field.containsText(username);
        assertFalse(actual);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void password(String password){
        passwoed_field.isPresent();
        namevalue = passwoed_field.getAttribute("value");
        if (namevalue.length()==0)
        {
            passwoed_field.click();
            passwoed_field.sendKeys(password);

        }
        boolean  actual;
        actual = passwoed_field.containsText(password);
        assertFalse(actual);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void terms(){
        terms.isPresent();
        while (!terms.isSelected()){
            terms.click();
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void submit(){
        boolean wait_submit;
        submit.click();
        waitForWithRefresh();
        withTimeoutOf(5, TimeUnit.SECONDS).elementIsDisplayed(By.id("accoptions"));
        wait_submit= panel_logged_in.isPresent();
        while (wait_submit=false)
        {
            wait_submit= panel_logged_in.isDisplayed();
            System.out.println(wait_submit);
        }
        }
    public void click_live_btn_play(String NameParametersBtn){
        WebElement RequiredNameParameters = live_play_btn(RequiredSystemNameXpath, NameParametersBtn);
        System.out.println("NameParametersBtn"+NameParametersBtn);
        System.out.println("RequiredNameParameters"+RequiredNameParameters);
        RequiredNameParameters.click();
    }



}
