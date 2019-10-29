package o2o.dao;

import dao.AreaDao;
import entity.Area;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class AreaDaoTest extends BaseTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryAreaTest(){

        List<Area> list=areaDao.queryArea();
        assertEquals(2,list.size());
        System.out.println(list.get(0).getAreaName());
    }

}
