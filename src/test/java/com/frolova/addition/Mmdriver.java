package com.frolova.addition;

import junit.framework.AssertionFailedError;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.*;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


/**
 * Created by Dmitriy on 23-Apr-15.
 */

public class MMDriver {
    private String textToType;
    private WebDriver driver;
    private Integer iframeData;
    private Boolean isPositive = true;
    MMDriver(WebDriver driver){
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }
    MMDriver(){};

    private class CodesCipher{
        private String codes[] = new String[26];
        CodesCipher(){
            codes[0] = "Action is not Tracked";
            codes[1] = "Action is Tracked";
            codes[10] = "Action is Tracked with correct Attribute";
            codes[15] = "Action is Tracked, but with wrong Attribute";
            codes[20] = "Multiple Actions with such Name and Attribute are Tracked";
            codes[25] = "Multiple Actions with such Name are Tracked, some Attributes are correct, but some don't";
        }

        private String getCode(Integer num){
            return codes[num];
        }

    }

    class TextToType{
        TextToType(MMDriver mmdriver){
            this.mmDriver = mmdriver;
        }
        private String textToType;
        private MMDriver mmDriver;
        private TextToType type(String text){
            this.textToType = text;
            return this;
        }
        WebElement to(String cssSelector){
            mmDriver.find(cssSelector).sendKeys(this.textToType);
            return mmDriver.find(cssSelector);
        }
    }
    /**
     * Navigates to the provided url
     * @param url and absolute url you want to navigate to
     */
    public void get(String url){
        driver.get(url);
    }
    /**
     * Switches to Sandbox environment, by installing mmcore.opc.enabled and mmcore.cfgid cookies and reloads the page.
     * These Cookies are required to receive information about action tracking
     */
    public void toSandbox() {
        this.setCookie("mmcore.opc.enabled", "1");
        this.setCookie("mmcore.cfgid", "1");
        this.setCookie("mmcore.opc.enabled", "1");
        driver.navigate().refresh();
    }
    /**
     * Navigates and logs in to UI. Required when you work from outside of office network
     * @param email your @maxymiser email
     * @param password your password you use to lig in to Maxymiser UI
     */
    public void loginToUI(String email, String password){
        driver.get("https://ui61.maxymiser.com");
        this.type(email).to("input#Login");
        this.type(password).to("input#Password");
        this.click("input.primary-button#Login");
    }
    /**
     * Generates given experience, by setting mmcore.fpv cookie.
     * Usually combined with experience iteration method
     * @param experience string combination of experience you want to generate. Chars ";" and ":" should be replaced by "%3B" and "%3A"
     */
    public void generate(String experience){
        this.setCookie("mmcore.fpv", experience);
        driver.navigate().refresh();
    }
//    public void waitTime(Integer seconds){
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    }
    /**
     * Search for element on current webpage by CSS selector only.
     * @param cssSelector Css selector of webelement you want to find
     * @return WebElement found
     * @throws NoSuchElementException
     */
    public WebElement find (String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }
    /**
     * Search for element on current webpage by CSS selector only.
     * @param cssSelector Css selector of webelement you want to find
     * @return List of WebElement found, or empty List
     */
    public List<WebElement> findAll (String cssSelector){
        return driver.findElements(By.cssSelector(cssSelector));
    }
    /**
     * Search for element on current webpage by CSS selector only.
     * @param text linkText that will be used for search
     * @return WebElement found
     * @throws NoSuchElementException
     */
    public WebElement findByText(String text){
        return driver.findElement(By.linkText(text));
    }
    /**
     * Validates if mmcore.js tag is present on the webpage.
     * @return Boolean True if mmcore is present, False if mmcore is not present
     */
    public boolean isMmcorePresent(){
        return driver.findElements(By.cssSelector("script[src*='mmcore.js']")).size() > 0;
    }
    /**
     * Sets appropriate cookie to current domain.
     * @param name Name of a cookie you are about to set
     * @param value Value of the cookie you are about to set
     */
    public void setCookie (String name, String value){
        Cookie newCookie = new Cookie(name, value);
        driver.manage().addCookie(newCookie);
    }
    /**
     * Returns value of a cookie.
     * @param cookieName Name of a cookie wich value you want to receive
     * @return String cookie value in a form of String.
     */
    public String getCookieValue(String cookieName){
        return driver.manage().getCookieNamed(cookieName).getValue();
    }
    /**
     * Perform click on the elemnt found by CSS selector.
     * If element is not clickable by regular means(not visible or overlapped), this method try to click it with JavaScript.
     * If element is not present in current context, this method iterate trough all iFrames, and try to click the element both by regular means or by JavaScript
     * @param cssSelector Css selector of webelement you want to click
     * @throws NoSuchElementException if the Element was not found in any context on the webpage
     */
    public void click(String cssSelector){
        try{
            driver.findElement(By.cssSelector(cssSelector)).click();
        } catch (NoSuchElementException noElem){
            System.out.println("Element with the css selector "+cssSelector+" is not present in current context");
            System.out.println("Looking for iFrames");
            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
            Integer iframes =  driver.findElements(By.tagName("iframe")).size();
            for(int i = 0;i<iframes;i++){
                try{
                    driver.switchTo().frame(i);
                }catch (NoSuchFrameException noFrame){
                    System.out.println("No such frame");
                }
                try{
                    if(this.findAll(cssSelector).size() > 0){
                        driver.findElement(By.cssSelector(cssSelector)).click();
                        driver.switchTo().defaultContent();
                        break;
                    }
                } catch(Exception noSuchElement){
                    System.out.println("Element with the css selector "+cssSelector+" is not clickable in iFrame");
                    System.out.println("Trying to click with JS in iFrame");
                    try{
                        this.executeScript("document.querySelector('" + cssSelector + "').click()");
                    }catch (WebDriverException exception){
                        System.out.println("Cannot click with JS in iFrame either");
                    }
                    driver.switchTo().defaultContent();
                    break;
                }
                int percent = ((i+1)*100)/iframes;
                System.out.print("\r"+percent+"%");
                if(i == iframes-1) {
                    System.out.println("Element with the css selector '"+cssSelector+"' was not found in iFrames");
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    throw new NoSuchElementException("no such element");
                }
                driver.switchTo().defaultContent();
            }
        } catch (WebDriverException notVisible){
            System.out.println("Element with a selector: '"+cssSelector+"' is not clickable on the page: "+driver.getCurrentUrl());
            System.out.println("Trying to click with JS");
            try{
                this.executeScript("document.querySelector('" + cssSelector + "').click()");
            } catch (WebDriverException exeption){
                System.out.println("Cannot click with JS either");
                throw new ElementNotVisibleException("Element is not clicable with any means");
            }

        }

    }
    /**
     * Performs click on the correct CSS selector in appropriate variant.
     * @param varToSelector Array of "Variant_Name:CSS_Selector" combinations
     */
    public void click(String[] varToSelector){
        String currentExp = (String) this.executeScript("var output = \"\";\n" +
                "for(var campaign in mmcore.GenInfo){\n" +
                "    for(var key in mmcore.GenInfo[campaign]){\n" +
                "        output += mmcore.GenInfo[campaign][key];\n" +
                "    }\n" +
                "}\n" +
                "return output;");
        for (int i = 0; i < varToSelector.length; i++) {
            String[] splitedCombos = varToSelector[i].replaceAll(" ","").split(":");
            if(currentExp.contains(splitedCombos[0])){
                this.click(splitedCombos[1]);
            }
        }

    }
    public Map<String,String> decipherIds(String[] namesAndIds){
        Map<String, String> deciphered = new HashMap<String, String>();
        for (int i = 0; i < namesAndIds.length; i++) {
            String[] splitedCombos = namesAndIds[i].split(":");
            deciphered.put(splitedCombos[0], splitedCombos[1]);
        }
        return deciphered;
    }
    /**
     * Executes provided string as a body of Nameless function in current page context.
     * @param script whole Javascript function in a String format
     * @return String
     * @return WebElement
     * @return List
     * @return List
     */
    public Object executeScript(String script){
        return ((JavascriptExecutor) driver).executeScript(script);
    }
    /**
     * Determine the Text you want to type. Followed by method .to()
     * @param text Text you want to type to input
     * @return TextToType object that contains single method .to()
     */
    public TextToType type(String text){
        TextToType type = new TextToType(this);
        type.textToType = text;
        return type;
    }
    private Integer actionScript(String name, String attr){
        Long code = (Long)((JavascriptExecutor) driver).executeScript("function isActionPresent(name, attr) {\n" +
                "    var actionsObjects = [],\n" +
                "        actionsNum = 0,\n" +
                "        filteredArrOfActObjects = [],\n" +
                "        filteredAttrs = [];\n" +
                "    mmcore.cginfo.forEach(function(cg){\n" +
                "        actionsObjects = actionsObjects.concat(cg.Actions);\n" +
                "    });\n" +
                "    filteredArrOfActObjects = actionsObjects.filter(function(actObj){\n" +
                "       return actObj.Name === name; \n" +
                "    });\n" +
                "    if (filteredArrOfActObjects.length == 0){\n" +
                "        return 0;\n" +
                "    }\n" +
                "\n" +
                "    filteredAttrs = filteredArrOfActObjects.filter(function(actObj){\n" +
                "       return actObj.Attribute === attr \n" +
                "    });\n" +
                "    if (filteredAttrs.length){\n" +
                "        if (filteredAttrs.length == 1) {\n" +
                "            return 10\n" +
                "        }else{\n" +
                "            if (filteredArrOfActObjects.length == filteredAttrs.length) {\n" +
                "                return 20\n" +
                "            } else {\n" +
                "                return 25\n" +
                "            }\n" +
                "        }\n" +
                "    }else{\n" +
                "        return 15\n" +
                "    }\n" +
                "    if (attr) {\n" +
                "        return Number(actionsObjects.some(function(actObj){\n" +
                "            return actObj.Name === name && actObj.Attribute === attr;\n" +
                "        }))\n" +
                "    } else {\n" +
                "        return Number(actionsObjects.some(function(actObj){\n" +
                "            return actObj.Name === name;\n" +
                "        }))\n" +
                "    }\n" +
                "}\n" +
                "return isActionPresent('"+name+"','"+attr+"');");
        return code.intValue();
    }
    private Integer actionScript(String name){
        Long code = (Long)((JavascriptExecutor) driver).executeScript("function isActionPresent(name, attr) {\n" +
                "    var actionsObjects = [],\n" +
                "        actionsNum = 0,\n" +
                "        filteredArrOfActObjects = [],\n" +
                "        filteredAttrs = [];\n" +
                "    mmcore.cginfo.forEach(function(cg){\n" +
                "        actionsObjects = actionsObjects.concat(cg.Actions);\n" +
                "    });\n" +
                "    if (attr) {\n" +
                "        return Number(actionsObjects.some(function(actObj){\n" +
                "            return actObj.Name === name && actObj.Attribute === attr;\n" +
                "        }))\n" +
                "    } else {\n" +
                "        return Number(actionsObjects.some(function(actObj){\n" +
                "            return actObj.Name === name;\n" +
                "        }))\n" +
                "    }\n" +
                "    filteredArrOfActObjects = actionsObjects.filter(function(actObj){\n" +
                "       return actObj.Name === name; \n" +
                "    });\n" +
                "    if (filteredArrOfActObjects.length == 0){\n" +
                "        return 0;\n" +
                "    }\n" +
                "\n" +
                "    filteredAttrs = filteredArrOfActObjects.filter(function(actObj){\n" +
                "       return actObj.Attribute === attr \n" +
                "    });\n" +
                "    if (filteredAttrs.length){\n" +
                "        if (filteredAttrs.length == 1) {\n" +
                "            return 10\n" +
                "        }else{\n" +
                "            if (filteredArrOfActObjects.length == filteredAttrs.length) {\n" +
                "                return 20\n" +
                "            } else {\n" +
                "                return 25\n" +
                "            }\n" +
                "        }\n" +
                "    }else{\n" +
                "        return 15\n" +
                "    }\n" +

                "}\n" +
                "return isActionPresent('"+name+"');");
        return code.intValue();
    }

    /**
     * Validate if action with specified name was tracked at current moment on the webpage in current context.
     * codes[0] = "Action is not Tracked";
     * codes[1] = "Action is Tracked";
     * @param name Name of the Action copied from UI or QA tool
     * @return Integer code of the ActionTracking result. See CodesCipher class for details
     */
    public Integer trackAction(String name){
        Integer code = actionScript(name);
        System.out.println(new CodesCipher().getCode(code));
        return code.intValue();
    }
    /**
     * Validate if action with specified name and attribute was tracked at current moment on the webpage in current context.
     * codes[10] = "Action is Tracked with correct Attribute";
     * codes[15] = "Action is Tracked, but with wrong Attribute";
     * codes[20] = "Multiple Actions with such Name and Attribute are Tracked";
     * codes[25] = "Multiple Actions with such Name are Tracked, some Attributes are correct, but some don't";
     * @param name Name of the Action copied from UI or QA tool
     * @return Integer code of the ActionTracking result. See CodesCipher class for details
     */
    public Integer trackAction(String name, String attr){
        Integer code = actionScript(name,attr);
        System.out.println(new CodesCipher().getCode(code));
        return code.intValue();
    }

    /**
     * Takes screenshot, and saves it to the provided path
     * @param location Path to the file you want to save screenshot to. Should end with Filename.png
     */
    public void takeScreenshot (String location){
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(location));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Scrolls to the top of the page, by pressing HOME key
     */
    public void scrollTop(){
        driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
    }

    /**
     * AssertEquals wrapper. Assert if the expected mathc actual result.
     * Doesnt fail your Testrun instantly, but saves flag to fail your test in .close() method
     * @param massage Name of your assert, will be displayed as a title in console
     * @param expected Expected value. Could be of any type
     * @param actual Actual value. Could be of any type, should match Expected type
     */
    public void assertEqual(String massage, Object expected, Object actual){
        try{
            assertEquals(massage, expected, actual);
        } catch(AssertionFailedError e){

            System.out.println(e);
            this.isPositive = false;
        }
    }

    /**
     * Finalize your test run. close the browser, and check if any asserts failed.
     * If any of the assertEquals failed during the test run, the whole test marked as Failed at this point.
     */
    public void close(){
        driver.quit();
        assertTrue(isPositive);
        this.isPositive = true;
    }

    /**
     * Access to core WebDriver.
     * @return original webdriver that is used for test.
     */
    public WebDriver getDriver(){
        return driver;
    }
}

