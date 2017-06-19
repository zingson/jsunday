package com.ul.biz.waimai.mapper;


import com.ul.biz.waimai.model.Country;

/**
 * Created by creasy on 2017/6/19.
 */
public interface CountryMapper {

    Country getCountryByCountryname(String countryname) throws Exception;

}
