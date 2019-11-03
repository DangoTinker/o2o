package dao;

import entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HeadLineDao {

    public List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLine);
}
