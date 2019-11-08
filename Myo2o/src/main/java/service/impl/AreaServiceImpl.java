package service.impl;

import cache.JedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AreaDao;
import entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AreaService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private JedisUtil.Keys keys;
    @Autowired
    private JedisUtil.Strings strings;


    @Override
    @Transactional
    public List<Area> getAreaList() {
        ObjectMapper objectMapper=new ObjectMapper();
        if(!keys.exists(AREALISTKEY)){
            List<Area> list=areaDao.queryArea();
            try {
                String json=objectMapper.writeValueAsString(list);
                strings.set(AREALISTKEY,json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return list;
        }else {
            String json=strings.get(AREALISTKEY);
            JavaType javaType=objectMapper.getTypeFactory().constructParametricType(ArrayList.class,Area.class);
            try {
                List<Area> list=objectMapper.readValue(json,javaType);
                return list;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }




    }
}
