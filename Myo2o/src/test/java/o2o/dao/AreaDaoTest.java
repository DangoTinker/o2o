package o2o.dao;

import dao.AreaDao;
import entity.Area;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.DESUtil;

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

//
//    @Test
//    public void tt(){
//        String user="work";
//        String password="123456";
//
//        String res1=DESUtil.getEncryptString(user);
//        String res2=DESUtil.getDecryptString(res1);
//        System.out.println(res1+" "+res2);
//        res1=DESUtil.getEncryptString(password);
//        res2=DESUtil.getDecryptString(res1);
//        System.out.println(res1+" "+res2);
//
//    }

}
