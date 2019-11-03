package service.impl;

import dao.HeadLineDao;
import entity.HeadLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.HeadLineService;

import java.util.List;

@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Autowired
    private HeadLineDao headLineDao;

    @Override
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
        return headLineDao.queryHeadLine(headLineCondition);
    }
}