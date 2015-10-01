package com.frolova.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

/**
 * Created by Frolova.A on 4/28/15.
 */

@DefaultUrl("")

public class AdminPages extends PageObject {
    private WebDriver driver;
    private String adminCamp,checkCamp,baseUrl,m;

    @FindBy(id = "Login")
    private WebElementFacade login;


    @FindBy(id = "Password")
    private WebElementFacade password;

    @FindBy(css = "div.auth-line > #Login")
    private WebElementFacade submit;

    @FindBy(id = "bDropToArchive")
    private WebElementFacade clear;
    ///////////////////////////////////////////////////////
    @FindBy(css = "div.stateStr")
    private WebElementFacade configuration;
    ///////////////////////////////////////
    @FindBy(id = "HIT")
    private WebElementFacade hit;
    ///////////////////////////////////////
    @FindBy(id = "CITY")
    private WebElementFacade city;
    ///////////////////////////////////////
    @FindBy(id = "PAGE")
    private WebElementFacade page;
    ///////////////////////////////////////
    @FindBy(id = "CAMPAIGN")
    private WebElementFacade campaign;
    ///////////////////////////////////////
    @FindBy(id = "CAMPAIGN_VERSION")
    private WebElementFacade campaign_version;
    ///////////////////////////////////////
    @FindBy(id = "ISGENERATION")
    private WebElementFacade isGeneration;
    ///////////////////////////////////////
    @FindBy(id = "ISCONTENTPAGE")
     private WebElementFacade isContentPage;
    ///////////////////////////////////////
    @FindBy(id = "CRITERIA")
    private WebElementFacade pc;
    ///////////////////////////////////////
    @FindBy(id = "SEGMENTS")
    private WebElementFacade segments;
    ///////////////////////////////////////
    @FindBy(id = "COOKIES")
    private WebElementFacade cookies;
    ///////////////////////////////////////
    @FindBy(id = "REFERRER")
    private WebElementFacade referrer;
    ///////////////////////////////////////
    @FindBy(id = "SERVER")
    private WebElementFacade server;
    ///////////////////////////////////////
    @FindBy(id = "AGENT")
    private WebElementFacade agent;
    ///////////////////////////////////////
    @FindBy(id = "BROWSER")
    private WebElementFacade browser;
    ///////////////////////////////////////
    @FindBy(id = "OS")
    private WebElementFacade os;
    ///////////////////////////////////////
    @FindBy(id = "DEVICETYPE")
    private WebElementFacade deviceType;
    ///////////////////////////////////////
    @FindBy(id = "SITELOCATION")
    private WebElementFacade siteLocation;
    ///////////////////////////////////////
    @FindBy(id = "GENERATIONMETHOD")
    private WebElementFacade generationmethod;
    ///////////////////////////////////////
    @FindBy(id = "bApply")
    private WebElementFacade apply;
    ///////////////////////////////////////
    @FindBy(id = "Elements_0__Variants_0__Weight")
    private WebElementFacade weigtdefault;
    ///////////////////////////////////////
    @FindBy(id = "Elements_0__Variants_1__Weight")
    private WebElementFacade weighta2;
    ///////////////////////////////////////
    @FindBy(id = "Elements_0__Variants_2__Weight")
    private WebElementFacade weighta3;
    ///////////////////////////////////////
    @FindBy(id = "Elements_0__Variants_3__Weight")
    private WebElementFacade weighta4;
    ///////////////////////////////////////
    @FindBy(id = "SaveElement")
    private WebElementFacade saveWeight;
///////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////

    public void enterLoginPass(String log, String pass){
        login.sendKeys(log);
        password.sendKeys(pass);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void logInSubmit(){
        submit.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void clearActionLog(){
        clear.click();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_configuration_action_log(){
        configuration.click();
        campaign.click();
        pc.click();
        apply.click();

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void openActionLog() {
        getDriver().get("");

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void openWeights() {
        getDriver().get("");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void closeDriver(){
        driver.quit();
    }
    /////////////////////////////////////////
    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("body"));
        List<WebElement> results = definitionList.findElements(By.tagName("pre"));
        System.out.println("RESULTS"+results);
        return convert(results, toStrings());
    }
    /*String results = getDriver().getPageSource();
        System.out.println(results);
        return convert(results, toStrings());*/
    /////////////////////////////////////////////////////////////////////////////////////////////
    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void change_weigtsdef(String weigts){
        weigtdefault.clear();
        weigtdefault.sendKeys(weigts);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void change_weigts_a2(String weigts){
        weighta2.clear();
        weighta2.sendKeys(weigts);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void change_weigts_a3(String weigts){
        weighta3.clear();
        weighta3.sendKeys(weigts);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void change_weigts_a4(String weigts){
        weighta4.clear();
        weighta4.sendKeys(weigts);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_button_save_weight(){
        saveWeight.click();

    }

}
