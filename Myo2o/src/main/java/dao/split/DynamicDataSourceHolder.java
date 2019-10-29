package dao.split;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceHolder {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    private static ThreadLocal<String> threadLocal=new ThreadLocal<String>();
    public static final String DB_MASTER="master";
    public static final String DB_SLAVE="slave";

    public static void setDataSource(String dataSource){
        logger.debug("使用的datasource:"+dataSource);
        threadLocal.set(dataSource);
    }

    public static String getDataSourceType(){
        String datasource=threadLocal.get();
        if(datasource==null){
            return DB_MASTER;
        }
        return datasource;
    }

    public static void removeDataSource(){
        threadLocal.remove();
    }

}
