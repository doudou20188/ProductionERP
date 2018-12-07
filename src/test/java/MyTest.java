import com.cskaoyan.domain.DeviceTypeListVO;
import com.cskaoyan.service.DeviceTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Demo class
 *
 * @Author lyboy
 * @Date 2018/12/6 17:01
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@WebAppConfiguration
public class MyTest {
   /* @Autowired
    DeviceTypeMapper deviceTypeMapper;*/


    @Autowired
    DeviceTypeService deviceTypeService;
    @Test
    public void Test1(){
      /*  List<DeviceType> devices = deviceTypeMapper.deviceTypeList();
        System.out.println(devices);*/
    }
    @Test
    public void Test2(){
        DeviceTypeListVO deviceTypeListVO = deviceTypeService.deviceTypeList("1", "2");
        System.out.println(deviceTypeListVO);
    }
}
