package com.ul.core.mybatis;

import oracle.jdbc.driver.OraclePreparedStatement;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.StringTypeHandler;
import org.apache.ibatis.type.TypeHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 自定义 TypeHandler 处理Oracle Char类型长度问题
 */
public class OracleCharStringTypeHandler extends StringTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.unwrap(OraclePreparedStatement.class).setFixedCHAR(i, parameter);
    }

}