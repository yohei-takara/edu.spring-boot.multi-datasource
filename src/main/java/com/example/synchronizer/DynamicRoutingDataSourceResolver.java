package com.example.synchronizer;

import com.example.synchronizer.util.Const;
import com.example.synchronizer.util.SchemaType;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSourceResolver extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        if (SchemaContexHolder.getSchemaType() == null) {
            return Const.STAGING_DATA_SOURCE;
        } else if (SchemaContexHolder.getSchemaType() == SchemaType.STAGING) {
            return Const.STAGING_DATA_SOURCE;
        } else if (SchemaContexHolder.getSchemaType() == SchemaType.PRODUCTION) {
            return Const.PRODUCTION_DATA_SOURCE;
        } else {
            return Const.STAGING_DATA_SOURCE;
        }
    }
}
