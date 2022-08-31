package pageobject.postsdata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pageobject.BaseFunc;
import pageobject.postsdata.pages.HomePage;
import pageobject.postsdata.pages.PostPage;

import static org.junit.jupiter.api.Assertions.*;

public class PostsTest {
    private final String URL = "reddit.com";

    private final int POST_ID = 0;

    private BaseFunc baseFunc = new BaseFunc();

    @BeforeEach
    public void openWebPage() {
        baseFunc.openPage(URL);

    }

    @Test
    public void checkPostData() throws InterruptedException {
        HomePage homePage = new HomePage(baseFunc);

        homePage.selectFormat();
        String postName = homePage.getPostName();
        String postSubName = homePage.getPostSubName();
        String postCommentsCount = homePage.getPostCommentsCount();
        PostPage thePost = homePage.clickPost();

        assertEquals(postName, thePost.getSelectedPostName(), "Wrong title");
        assertEquals(postSubName, thePost.getSelectedPostSubName(), "Wrong sub name");
        assertEquals(postCommentsCount, thePost.getSelectedPostCommentsCount(), "Wrong comments count");

//        String selectedPostName = homePage.getPostName();
//        String SelectedPostSubName = homePage.getPostSubName();
//        String selectedPostCommentsCount = homePage.getPostCommentsCount();
//
//        clickPost.getSelectedPostName()
//                .getSelectedPostSubName()
//                .getSelectedPostCommentsCount();
//
//        assertEquals(postName, get);
//

//        homePage.selectFormat()
//                .getPostName()
//                .getPostSubName()
//                .getPostCommentsCount()
//                .clickPost()
//                .getSelectedPostName(homePage.getPostName());


    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
