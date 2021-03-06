package com.exam.dao;

import com.core.database.JDBCAccess;
import com.core.database.JPAAccess;
import com.exam.domain.Level;
import com.exam.domain.Section;
import com.exam.domain.Select;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hubery.chen
 */
@Repository
public class SelectDao {

    private JPAAccess jpaAccess;
    private JDBCAccess jdbcAccess;

    @Transactional
    public int save(Select select) {
        jpaAccess.save(select);
        return select.getId();
    }

    public List<Select> find(List<Integer> ids) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);
        return jpaAccess.find("from " + Select.class.getName() + " where id in (:ids)", params);
    }

    //TODO(Hubery) Level and section average
    public List<Integer> find(Section section, Level level, int num) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from Select where 1=1 ");
        List<Object> params = new ArrayList<>();
        if (!Section.All.equals(section)) {
            params.add(section.toString());
            sql.append(" and section = ? ");
        }
        if (!Level.All.equals(level)) {
            params.add(level.toString());
            sql.append(" and level = ? ");
        }
        params.add(num);
        sql.append(" Order By Rand() Limit ? ");
        return jdbcAccess.find(sql.toString(), new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return resultSet.getInt("Id");
            }
        }, params.toArray());
    }

    @Inject
    public void setJdbcAccess(JDBCAccess jdbcAccess) {
        this.jdbcAccess = jdbcAccess;
    }

    @Inject
    public void setJpaAccess(JPAAccess jpaAccess) {
        this.jpaAccess = jpaAccess;
    }
}
