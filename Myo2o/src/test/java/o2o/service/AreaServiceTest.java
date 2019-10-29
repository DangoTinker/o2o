package o2o.service;

import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.AreaService;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaListTest(){
        assertEquals("西苑",areaService.getAreaList().get(0).getAreaName());

    }

}
