package service;

import entity.HeadLine;

import java.util.List;

public interface HeadLineService {
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition);
}
