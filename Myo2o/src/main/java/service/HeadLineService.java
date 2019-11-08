package service;

import entity.HeadLine;

import java.util.List;

public interface HeadLineService {

    public static final String HEADLINELISTKEY ="headlinelist";

    public List<HeadLine> getHeadLineList(HeadLine headLineCondition);
}
