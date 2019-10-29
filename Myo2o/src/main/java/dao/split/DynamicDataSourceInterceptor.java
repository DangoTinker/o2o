package dao.split;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

@Intercepts(
        {
                @Signature(type=Executor.class,method = "update",args={MappedStatement.class,Object.class}),
                @Signature(type=Executor.class,method = "query",args={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})
        }
)

public class DynamicDataSourceInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);
    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        boolean tran= TransactionSynchronizationManager.isActualTransactionActive();
        String datasource=DynamicDataSourceHolder.DB_MASTER;
        Object[] objects=invocation.getArgs();
        MappedStatement ms= (MappedStatement) objects[0];
        if(tran!=true){


            System.out.println("ms.getSqlCommandType()的结果: "+ms.getSqlCommandType().toString());
            if(ms.getSqlCommandType().equals(SqlCommandType.SELECT)){
                if(ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)){
                    datasource=DynamicDataSourceHolder.DB_MASTER;
                }else{
                    BoundSql boundSql=ms.getSqlSource().getBoundSql(objects[1]);
                    String sql=boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]"," ");
                    if(sql.matches(REGEX)){
                        datasource=DynamicDataSourceHolder.DB_MASTER;
                    }else{
                       datasource=DynamicDataSourceHolder.DB_SLAVE;
                    }

                }
            }


        }else{
            datasource=DynamicDataSourceHolder.DB_MASTER;
        }

        logger.debug("设置方法："+ms.getId()+" "+datasource+" "+ms.getSqlCommandType());
        System.out.println("拦截器内datasouce: "+datasource);
        DynamicDataSourceHolder.setDataSource(datasource);
        return invocation.proceed();

    }

    @Override
    public Object plugin(Object o) {
        if(o instanceof Executor){
            return Plugin.wrap(o,this);
        }
        return o;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
