import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGPractice3 {
    @Test(dataProvider = "getData")
    public void fetchData(String userName, String password) {
        System.out.println(userName);
        System.out.println(password);

    }
    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[3][2];
        // first data set
        data[0][0] = "username";
        data[0][1] = "password";

        // 2nd data set
        data[1][0] = "username1";
        data[1][1] = "password1";

        // 3rs dataset

        data[2][0] = "username2";
        data[2][1] = "password2";
        return data;
    }
}
