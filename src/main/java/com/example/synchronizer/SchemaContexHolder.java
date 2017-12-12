package com.example.synchronizer;

import com.example.synchronizer.util.SchemaType;
import org.springframework.util.Assert;

public class SchemaContexHolder {

    private static ThreadLocal<SchemaType> contexHolder = new ThreadLocal<>();

    public static void setSchemaType(SchemaType dataSourceName) {
        Assert.notNull(dataSourceName, "Schema type cannot be null.");
        contexHolder.set(dataSourceName);
    }

    public static SchemaType getSchemaType() {
        return contexHolder.get();
    }

    public static void clear() {
        contexHolder.remove();
    }
}
