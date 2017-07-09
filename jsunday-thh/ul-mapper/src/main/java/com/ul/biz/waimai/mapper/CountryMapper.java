package com.ul.biz.waimai.mapper;


import com.ul.biz.waimai.model.Country;
import com.ul.core.spring.PropertyConfig;
import com.ul.core.spring.datasource.DataSource;

/**
 * Created by creasy on 2017/6/19.
 */
@DataSource(PropertyConfig.DB2)
public interface CountryMapper {

    Country getCountryByCountryname(String countryname) throws Exception;

}
