package com.ul.core.mybatis;

import oracle.jdbc.driver.OraclePreparedStatement;
import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义 TypeHandler 处理Oracle Char类型空格
 */

@MappedTypes({String.class})
@MappedJdbcTypes({JdbcType.CHAR})
public class OracleCharStringTypeHandler extends StringTypeHandler {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.unwrap(OraclePreparedStatement.class).setFixedCHAR(i, parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String s = rs.getString(columnName);
        return s==null?"":s.trim();
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String s = rs.getString(columnIndex);
        return s==null?"":s.trim();
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String s = cs.getString(columnIndex);
        return s==null?"":s.trim();
    }

}