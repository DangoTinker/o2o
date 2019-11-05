package o2o.dao;

import dao.HeadLineDao;
import entity.HeadLine;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HeadLineTest extends BaseTest {

    @Autowired
    private HeadLineDao dao;

    @Test
    public void queryHeadLineListTest(){
        List<HeadLine> list=dao.queryHeadLine(null);

    }

}
