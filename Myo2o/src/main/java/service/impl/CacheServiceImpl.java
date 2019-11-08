package service.impl;

import cache.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CacheService;

import java.util.Set;
@Service
public class CacheServiceImpl implements CacheService {
    @Autowired
    private JedisUtil.Keys keys;


    @Override
    public void removeFromCache(String keyPrefix) {
        Set<String> set=keys.keys(keyPrefix+"*");
        for(String str:set){
            keys.del(str);
        }
    }
}
