package pageobject.postsdata.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.BaseFunc;

import java.util.List;

public class HomePage {
    private final By FORMAT_BUTTON = By.xpath(".//div[contains(@class, 'U2i')]");
    private final By FORMAT_SELECT = By.xpath(".//div[contains(@class, '_2uYY')]");
    private final By WHOLE_POST = By.xpath(".//div[contains(@class, '_1po')]");

    private final By POST_NAME = By.xpath(".//div[contains(@class, 'y8H')]");
    private final By POST_SUB_NAME = By.xpath(".//a[contains(@class, '_3ry')]");
//    private final By POST_USER_NAME = By.xpath(".//div[contains(@id, 'UserInfo')]");
//    private final By POST_TIME = By.xpath(".//span[contains(@class, '_2VF')]");
    private final By POST_COMMENT_COUNT = By.xpath(".//span[contains(@class, 'FHC')]");
    private final By POST_USER_NAME = By.xpath(".//a[contains(@class, '2tb')]");
    private final By SKIP_POST = By.xpath(".//div[contains(@class, '_3AS')]");




    private final int FORMAT_ID = 0;
    private final int POST_ID = 0;
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public HomePage selectFormat() {
        baseFunc.click(FORMAT_BUTTON);
        baseFunc.findElements(FORMAT_SELECT).get(FORMAT_ID).click();

        return this;
    }

//    public HomePage getPostName() {
//        getPostNameList();
//        return this;
//    }
//
//    public String getPostNameList() {
//        String postName = baseFunc.findElements(POST_NAME).get(0).getText();
//        return postName;
//    }

//    public String getPostById(int id) {
//        return baseFunc.findElements(POST_NAME).get(POST_ID).getText();
//    }

    public String getPostName() {
//        List<WebElement> ads = baseFunc.findElements(SKIP_POST);
//        for (WebElement element : ads) {
//            String ad = element.getText();
//            if (ad.endsWith("•promoted")) {
//
//            }
//        }
        return baseFunc.findElements(POST_NAME).get(POST_ID).getText();

    }

    public String getPostSubName() {
        return baseFunc.findElements(POST_SUB_NAME).get(POST_ID).getText();
    }

//    public String getPostUserName() {
//        List<WebElement> postUserName = baseFunc.findElements(POST_USER_NAME);
//        return postUserName.get(0).getText();
//    }

//    public String getPostTime() {
//        List<WebElement> postTime = baseFunc.findElements(POST_TIME);
//        return postTime.get(0).getText();
//    }

    public String getPostCommentsCount() {
        String getComments = baseFunc.findElements(POST_COMMENT_COUNT).get(POST_ID).getText();
        if (!getComments.contains("k")) {
            getComments.substring(0, getComments.indexOf(" ")).trim();
            return getComments;
        }
        String sum = "00";
        String getNumbers = new String(getComments + sum);
        String getFullNumbers = getNumbers.replaceAll("[^0-9]", "").trim();
        return getFullNumbers;
    }

    public PostPage clickPost() {
        baseFunc.findElements(POST_NAME).get(POST_ID).click();
        return new PostPage(baseFunc);
    }

//    post name
//    sub name
//    op name
//    time since post
//    comment count

//    posted comment count
}
