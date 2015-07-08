package com.frolova.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

/**
 * Created by Frolova.A on 6/19/15.
 */
@DefaultUrl("http://www.grosvenorcasinos.com/")
public class LoginPages  {

    @FindBy(id = "UserName")
    private WebElementFacade userName;

    @FindBy(id = "Password")
    private WebElementFacade password;

    @FindBy(id = "logon_btn")
    private WebElementFacade logon_btn;

    public void enterLogin(String log, String pass){
        userName.clear();
        userName.sendKeys(log);
        password.sendKeys(pass);
        logon_btn.click();
    }
}
