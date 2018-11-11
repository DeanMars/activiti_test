import com.dean.activiti.ActivitiApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by Linghaidi on 2018/7/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActivitiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BaseTest {
    static {
        System.setProperty("env", "dev");
        System.setProperty("spring.profiles.active", "dev");
    }


}
