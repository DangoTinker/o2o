package dao.split;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


import java.sql.SQLException;


public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDataSourceType();
    }


}
