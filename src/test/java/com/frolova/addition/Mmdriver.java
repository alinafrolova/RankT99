package com.frolova.addition;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dmitriy on 23-Apr-15.
 */
//public class Mmdriver extends ChromeDriver {
//    private String textToType;
//    Mmdriver(){
//        this.manage().window().maximize();
//        this.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        this.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        this.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
//    }
//    private class CodesCipher{
//        private String codes[] = new String[26];
//        CodesCipher(){
//            codes[0] = "Action is not Tracked";
//            codes[1] = "Action is Tracked";
//            codes[10] = "Action is Tracked with correct Attribute";
//            codes[15] = "Action is Tracked, but with wrong Attribute";
//            codes[20] = "Multiple Actions with such Name and Attribute are Tracked";
//            codes[25] = "Multiple Actions with such Name are Tracked, some Attributes are correct, but some don't";
//        }
//
//        private String getCode(Integer num){
//            return codes[num];
//        }
//
//    }
//    class TextToType{
//        TextToType(Mmdriver mmdriver){
//            driver = mmdriver;
//        }
//        private String textToType;
//        private Mmdriver driver;
//        private TextToType type(String text){
//            this.textToType = text;
//            return this;
//        }
//        void to(String cssSelector){
//            driver.findElement(By.cssSelector(cssSelector)).sendKeys(this.textToType);
//        }
//    }
//
//    public void toSandbox(){
////        this.setCookie("mmcore.opc.enabled", "1");
//        this.setCookie("mmcore.cfgid", "1");
//        this.navigate().refresh();
//    }
//    public void loginToUI(String email, String password){
//        this.get("https://ui61.maxymiser.com");
//        this.type(email).to("input#Login");
//        this.type(password).to("input#Password");
//        this.click("input.primary-button#Login");
//    }
//    public WebElement find (String cssSelector) throws Exception{
//        return this.findElement(By.cssSelector(cssSelector));
//    }
//    public List<WebElement> findAll (String cssSelector){
//        return this.findElements(By.cssSelector(cssSelector));
//    }
//    public boolean isMmcorePresent(){
//        return this.findElementsByCssSelector("script[src*='mmcore.js']").size() > 0;
//    }
//    public void setCookie (String name, String value){
//        Cookie newCookie = new Cookie(name, value);
//        this.manage().addCookie(newCookie);
//    }
//    public String getCookieValue(String CookieName){
//        return this.manage().getCookieNamed(CookieName).getValue();
//    }
//    public void click(String cssSelector){
//        try{
//            this.findElement(By.cssSelector(cssSelector)).click();
//        } catch (NoSuchElementException noElem){
//            System.out.println("Element is not present in current context");
//            System.out.println("Looking for iFrames");
//            this.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
//            Integer iframes =  this.findElements(By.tagName("iframe")).size();
//            for(int i = 0;i<iframes;i++){
//                try{
//                    this.switchTo().frame(i);
//                }catch (NoSuchFrameException noFrame){
////                        System.out.println("No such frame");
//                }
//                try{
//                    if(this.findAll(cssSelector).size() > 0){
//                        this.findElement(By.cssSelector(cssSelector)).click();
//                        this.switchTo().defaultContent();
//                        break;
//                    }
//                } catch(Exception noSuchElement){
//                    System.out.println("Element is not clickable in iFrame");
//                    System.out.println("Trying to click with JS in iFrame");
//                    try{
//                        this.executeScript("document.querySelector('" + cssSelector + "').click()");
//                    }catch (WebDriverException exception){
//                        System.out.println("Cannot click with JS in iFrame either");
//                    }
//                    this.switchTo().defaultContent();
//                    break;
//                }
//                int percent = ((i+1)*100)/iframes;
//                System.out.print("\r"+percent+"%");
//                if(i == iframes-1) {
//                    System.out.println("\nElement was not found in iFrames");
//                    this.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//                    throw new NoSuchElementException("no such element");
//                }
//                this.switchTo().defaultContent();
//            }
//        } catch (WebDriverException notVisible){
//            System.out.println("Element with a selector: '"+cssSelector+"' is not clickable on the page: "+this.getCurrentUrl());
//            System.out.println("Trying to click with JS");
//            try{
//                this.executeScript("document.querySelector('" + cssSelector + "').click()");
//            } catch (WebDriverException exeption){
//                System.out.println("Cannot click with JS either");
//                throw new ElementNotVisibleException("Element is not clicable with any means");
//            }
//
//        }
//
//    }
//    public Object executeScript(String script){
//        return ((JavascriptExecutor) this).executeScript(script);
//    }
//    public TextToType type(String text){
//        TextToType type = new TextToType(this);
//        type.textToType = text;
//        return type;
//    }
//    private Integer actionScript(String name, String attr){
//        Long code = (Long)((JavascriptExecutor) this).executeScript("function isActionPresent(name, attr) {\n" +
//                "    var actionsObjects = [],\n" +
//                "        actionsNum = 0,\n" +
//                "        filteredArrOfActObjects = [],\n" +
//                "        filteredAttrs = [];\n" +
//                "    mmcore.cginfo.forEach(function(cg){\n" +
//                "        actionsObjects = actionsObjects.concat(cg.Actions);\n" +
//                "    });\n" +
//                "    filteredArrOfActObjects = actionsObjects.filter(function(actObj){\n" +
//                "       return actObj.Name === name; \n" +
//                "    });\n" +
//                "    if (filteredArrOfActObjects.length == 0){\n" +
//                "        return 0;\n" +
//                "    }\n" +
//                "\n" +
//                "    filteredAttrs = filteredArrOfActObjects.filter(function(actObj){\n" +
//                "       return actObj.Attribute === attr \n" +
//                "    });\n" +
//                "    if (filteredAttrs.length){\n" +
//                "        if (filteredAttrs.length == 1) {\n" +
//                "            return 10\n" +
//                "        }else{\n" +
//                "            if (filteredArrOfActObjects.length == filteredAttrs.length) {\n" +
//                "                return 20\n" +
//                "            } else {\n" +
//                "                return 25\n" +
//                "            }\n" +
//                "        }\n" +
//                "    }else{\n" +
//                "        return 15\n" +
//                "    }\n" +
//                "    if (attr) {\n" +
//                "        return Number(actionsObjects.some(function(actObj){\n" +
//                "            return actObj.Name === name && actObj.Attribute === attr;\n" +
//                "        }))\n" +
//                "    } else {\n" +
//                "        return Number(actionsObjects.some(function(actObj){\n" +
//                "            return actObj.Name === name;\n" +
//                "        }))\n" +
//                "    }\n" +
//                "}\n" +
//                "return isActionPresent('"+name+"','"+attr+"');");
//        return code.intValue();
//    }
//    private Integer actionScript(String name){
////        Integer code = (Integer) ((JavascriptExecutor) this).executeScript("varactionsObjects=[],actionsNum=0,filteredArrOfActObjects=[],filteredAttrs=[],name="+name+",attr="+attr+";mmcore.cginfo.forEach(function(cg){ctionsObjects=actionsObjects.concat(cg.Actions);});filteredArrOfActObjects=ctionsObjects.filter(function(actObj){returnactObj.Name===name;});iffilteredArrOfActObjects.length==0){return0;}filteredAttrs=ilteredArrOfActObjects.filter(function(actObj){returnactObj.Attribute===attr});iffilteredAttrs.length){if(filteredAttrs.length==1){return10}else{iffilteredArrOfActObjects.length==filteredAttrs.length){return20}else{return5}}}else{return15}if(attr){returnumber(actionsObjects.some(function(actObj){returnactObj.Name===name&amp;amp;&amp;amp;ctObj.Attribute===attr;}))}else{returnNumber(actionsObjects.some(function(actObj){eturnactObj.Name===name;}))}");
//        Long code = (Long)((JavascriptExecutor) this).executeScript("function isActionPresent(name, attr) {\n" +
//                "    var actionsObjects = [],\n" +
//                "        actionsNum = 0,\n" +
//                "        filteredArrOfActObjects = [],\n" +
//                "        filteredAttrs = [];\n" +
//                "    mmcore.cginfo.forEach(function(cg){\n" +
//                "        actionsObjects = actionsObjects.concat(cg.Actions);\n" +
//                "    });\n" +
//                "    if (attr) {\n" +
//                "        return Number(actionsObjects.some(function(actObj){\n" +
//                "            return actObj.Name === name && actObj.Attribute === attr;\n" +
//                "        }))\n" +
//                "    } else {\n" +
//                "        return Number(actionsObjects.some(function(actObj){\n" +
//                "            return actObj.Name === name;\n" +
//                "        }))\n" +
//                "    }\n" +
//                "    filteredArrOfActObjects = actionsObjects.filter(function(actObj){\n" +
//                "       return actObj.Name === name; \n" +
//                "    });\n" +
//                "    if (filteredArrOfActObjects.length == 0){\n" +
//                "        return 0;\n" +
//                "    }\n" +
//                "\n" +
//                "    filteredAttrs = filteredArrOfActObjects.filter(function(actObj){\n" +
//                "       return actObj.Attribute === attr \n" +
//                "    });\n" +
//                "    if (filteredAttrs.length){\n" +
//                "        if (filteredAttrs.length == 1) {\n" +
//                "            return 10\n" +
//                "        }else{\n" +
//                "            if (filteredArrOfActObjects.length == filteredAttrs.length) {\n" +
//                "                return 20\n" +
//                "            } else {\n" +
//                "                return 25\n" +
//                "            }\n" +
//                "        }\n" +
//                "    }else{\n" +
//                "        return 15\n" +
//                "    }\n" +
//
//                "}\n" +
//                "return isActionPresent('"+name+"');");
//        return code.intValue();
//    }
//    public Integer trackAction(String name){
//        Integer code = actionScript(name);
//        System.out.println(new CodesCipher().getCode(code));
//        return code;
//    }
//    public Integer trackAction(String name, String attr){
//        Integer code = actionScript(name,attr);
//        System.out.println(new CodesCipher().getCode(code));
//        return code;
//    }
//    public void takeScreenshot (String location){
//        try {
//            FileUtils.copyFile(this.getScreenshotAs(OutputType.FILE), new File("c:/dropbox/google_page.png"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
public class Mmdriver{
    private String textToType;
    private WebDriver driver;
    Mmdriver(WebDriver driver){
        this.driver = driver;
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }
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
        TextToType(Mmdriver mmdriver){
            this.driver = mmdriver.driver;
        }
        private String textToType;
        private WebDriver driver;
        private TextToType type(String text){
            this.textToType = text;
            return this;
        }
        void to(String cssSelector){
            driver.findElement(By.cssSelector(cssSelector)).sendKeys(this.textToType);
        }
    }
    public class WebElementAbstract{
        Integer parentIframeIndex = null;
        private void setParentIframeIndex(Integer index){
            this.parentIframeIndex = index;
        }

        public void click() {

        }
    }
    public void get(String url){
        driver.get(url);
    }

    public void toSandbox(){
//        this.setCookie("mmcore.opc.enabled", "1");
        this.setCookie("mmcore.cfgid", "1");
        this.setCookie("mmcore.opc.enabled", "1");
        driver.navigate().refresh();
    }
    public void loginToUI(String email, String password){
        driver.get("https://ui61.maxymiser.com");
        this.type(email).to("input#Login");
        this.type(password).to("input#Password");
        this.click("input.primary-button#Login");
    }
    public WebElementAbstract find (String cssSelector) {
        WebElementAbstract element = null;
        try{
            element = (WebElementAbstract) driver.findElement(By.cssSelector(cssSelector));
        }catch(NoSuchElementException e){
            driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
            Integer iframes =  driver.findElements(By.tagName("iframe")).size();
            for(int i = 0;i<iframes;i++){
                try{
                    driver.switchTo().frame(i);
                }catch (NoSuchFrameException noFrame){
//                        System.out.println("No such frame");
                }
                try{
                    if(driver.findElements(By.cssSelector(cssSelector)).size() > 0){
                        element = (WebElementAbstract)driver.findElement(By.cssSelector(cssSelector));
                        element.setParentIframeIndex(i);
                        driver.switchTo().defaultContent();
                        return element;
                    }
                } catch(Exception noSuchElement){
                    driver.switchTo().defaultContent();
                    break;
                }
                int percent = ((i+1)*100)/iframes;
                System.out.print("\r"+percent+"%");
                if(i == iframes-1) {
                    System.out.println("\nElement was not found in iFrames");
                    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    throw new NoSuchElementException("no such element");
                }
                driver.switchTo().defaultContent();
            }
        }
        return element;
    }
    public List<WebElement> findAll (String cssSelector){
        return driver.findElements(By.cssSelector(cssSelector));
    }
    public boolean isMmcorePresent(){
        return driver.findElements(By.cssSelector("script[src*='mmcore.js']")).size() > 0;
    }
    public void setCookie (String name, String value){
        Cookie newCookie = new Cookie(name, value);
        driver.manage().addCookie(newCookie);
    }
    public String getCookieValue(String CookieName){
        return driver.manage().getCookieNamed(CookieName).getValue();
    }

    public void click(String cssSelector){
        try{
            this.find(cssSelector).click();
        } catch (Exception noSuchElement) {
            System.out.println("Element is not clickable");
            System.out.println("Executing click with JS");
            Integer ind = this.find(cssSelector).parentIframeIndex;
            driver.switchTo().frame(ind);
            this.executeScript("document.querySelector(" + cssSelector + ").click()");
            driver.switchTo().defaultContent();
        }
    }
    public Object executeScript(String script){
        return ((JavascriptExecutor) driver).executeScript(script);
    }
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
    public Integer trackAction(String name){
        System.out.println("action"+name);
        Integer code = actionScript(name);
        System.out.println("&&&&&&&&&&"+new CodesCipher().getCode(code));
        assertEquals(code.longValue(), 10);
        System.out.println("###########"+code.intValue());
        return code.intValue();
    }
    @Test
    public Integer trackAction(String name, String attr){
        Integer code = actionScript(name,attr);
        System.out.println(new CodesCipher().getCode(code));
        return code.intValue();
    }
    public void takeScreenshot (String location){
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(location));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public WebDriver getDriver(){
        return driver;
    }
}
