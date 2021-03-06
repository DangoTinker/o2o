package service.impl;

import cache.JedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.HeadLineDao;
import entity.HeadLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.HeadLineService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Autowired
    private HeadLineDao headLineDao;

    @Autowired
    private JedisUtil.Keys keys;
    @Autowired
    private JedisUtil.Strings strings;




    @Override
    @Transactional
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
        ObjectMapper objectMapper=new ObjectMapper();
        String key=HEADLINELISTKEY;
        if(headLineCondition!=null&&headLineCondition.getEnableStatus()!=null){
            key =key +"_"+headLineCondition.getEnableStatus();
        }

        if(!keys.exists(key)){
            List<HeadLine> list=headLineDao.queryHeadLine(headLineCondition);
            try {
                String json=objectMapper.writeValueAsString(list);
                strings.set(key,json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            return list;
        }else{
            String json=strings.get(key);
            JavaType javaType=objectMapper.getTypeFactory().constructParametricType(ArrayList.class,HeadLine.class);
            try {
                List<HeadLine> list=objectMapper.readValue(json,javaType);
                return list;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        }

    }
}
