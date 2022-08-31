package pageobject.postsdata.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pageobject.BaseFunc;

import java.util.List;

public class PostPage {

    WebDriver driver;


    private final By POST_NAME = By.xpath(".//div[contains(@class, '_29W')]");
    private final By POST_SUB_NAME = By.xpath(".//div[contains(@class, 'cZPZ')]");
//    private final By POST_USER_NAME = By.xpath(".//div[contains(@id, 'UserInfoTooltip--t3_wiit2u--light')]");

//    private final By POST_COMMENT_COUNT = By.xpath(".//div[contains(@class, '_1Uo')]");
    private final By POST_COMMENTS_COUNT = By.xpath(".//div[contains(@class, '_2M2')]");
    private final By POST_COMMENT_COUNT = By.xpath(".//a[contains(@class, 'wM6s')]");

    private BaseFunc baseFunc;
//    Actions actions = new Actions((WebDriver) baseFunc);


    public PostPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

//    JavascriptExecutor js = (JavascriptExecutor) driver;

    public String getSelectedPostName() {
       WebElement postName = baseFunc.findElement(POST_NAME);
       return postName.getText();
//       Assertions.assertEquals(data, postName.getText());
    }

    public String getSelectedPostSubName() {
        String getTitle = baseFunc.getText(POST_SUB_NAME);
        return getTitle.substring(0, getTitle.indexOf("•")).trim();
    }

//    public String getPostUserName() {
//        List<WebElement> postUserName = baseFunc.findElements(POST_USER_NAME);
//        return postUserName.get(0).getText();
//    }

    public int getSelectedPostCommentsCount() throws InterruptedException {
//        boolean flag = true;
//        long lastHeight = 0;
//        long newHight = 0;
//        while (flag) {
//            //js executor to scroll the page
//            JavascriptExecutor js = ((JavascriptExecutor) driver);
//            lastHeight = (long) js.executeScript("return document.body.scrollHeight");
//            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//            // Do some waiting
//
//            newHight = (long) js.executeScript("return document.body.scrollHeight");
//            if (lastHeight == newHight) {
//                flag = false;
//            }
//
//            lastHeight = newHight;
//        }

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        try {
//            long lastHeight=((Number)js.executeScript("return document.body.scrollHeight")).longValue();
//            while (true) {
//                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//                Thread.sleep(2000);
//
//                long newHeight = ((Number)js.executeScript("return document.body.scrollHeight")).longValue();
//                if (newHeight == lastHeight) {
//                    break;
//                }
//                lastHeight = newHeight;
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            Object lastHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000);

                Object newHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
                if (newHeight.equals(lastHeight)) {
                    break;
                }
                lastHeight = newHeight;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        baseFunc.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
        WebElement postListCommentsCount = baseFunc.findElement(POST_COMMENTS_COUNT);

//        ((JavascriptExecutor) baseFunc).executeScript("arguments[0].scrollIntoView();", POST_COMMENT_COUNT);
        List<WebElement> postCommentsCount = postListCommentsCount.findElements(POST_COMMENT_COUNT);

        Thread.sleep(5000);
        return postCommentsCount.size();


//        WebElement postListCommentsCount = baseFunc.findElement(POST_COMMENTS_COUNT);
//        int scrollToAllElements = Integer.parseInt((String) baseFunc.javaScriptScroll(postListCommentsCount.findElements(POST_COMMENT_COUNT).size()));
////        scrollToAllElements = Integer.parseInt(baseFunc.javaScriptScroll("arguments[0].scrollIntoView();"), scrollToAllElements);
////        ((JavascriptExecutor) baseFunc).executeScript("arguments[0].scrollIntoView();", scrollToAllElements);
////        String countAllComments = String.valueOf(scrollToAllElements);
////        postListCommentsCount.findElements(POST_COMMENT_COUNT);
//        return scrollToAllElements;

//        return ((JavascriptExecutor) baseFunc).executeScript("arguments[0].scrollIntoView();", scrollToAllElements);
    }

//    public PostPage checkIfPostNameIs(String name) {
//        Assertions.assertEquals(name);
//    }


}
