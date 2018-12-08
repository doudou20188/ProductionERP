import com.cskaoyan.domain.Device.DeviceListVO;
import com.cskaoyan.mapper.Device.DeviceMapper;
import com.cskaoyan.service.Devicr.DeviceService;
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
    @Autowired
    DeviceMapper deviceMapper;
    @Autowired
    DeviceService deviceService;


    //    @Autowired
//    DeviceTypeService deviceTypeService;
//    @Test
//    public void Test1(){
//      /*  List<DeviceType> devices = deviceTypeMapper.deviceTypeList();
//        System.out.println(devices);*/
//    }
//    @Test
//    public void Test2(){
//        DeviceTypeListVO deviceTypeListVO = deviceTypeService.deviceTypeList("1", "2");
//        System.out.println(deviceTypeListVO);
//    }
//    @Test
//    public void Test3(){
//        DeviceType deviceType =new DeviceType();
//        deviceType.setDeviceTypeId("07");
//        deviceType.setDeviceTypeModel("a");
//        deviceType.setDeviceTypeProducer("a");
//        deviceType.setDeviceTypeName("a");
//        deviceType.setDeviceTypeQuantity("11");
//        deviceType.setDeviceTypeSpec("s");
//        deviceType.setDeviceTypeWarranty("2018-08-08 08:08:08");
//       Status status=deviceTypeService.insert(deviceType);
//        System.out.println(status);
//    }
    @Test
    public void Test4() {
        DeviceListVO deviceListVO = deviceService.selectList("1", "10");
        System.out.println(deviceListVO);
    }
}
