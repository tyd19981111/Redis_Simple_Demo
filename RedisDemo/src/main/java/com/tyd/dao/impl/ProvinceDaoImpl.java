package com.tyd.dao.impl;

import com.tyd.dao.ProvinceDao;
import com.tyd.entity.Province;
import com.tyd.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql = "select * from province ";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}
