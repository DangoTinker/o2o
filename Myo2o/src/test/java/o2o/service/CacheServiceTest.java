package o2o.service;

import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.CacheService;

public class CacheServiceTest extends BaseTest {

    @Autowired
    private CacheService cacheService;

    @Test
    public void removeTest(){
        cacheService.removeFromCache("area");
    }

}
