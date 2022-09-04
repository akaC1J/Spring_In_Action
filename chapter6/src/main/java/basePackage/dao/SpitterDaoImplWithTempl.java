package basePackage.dao;

import basePackage.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class SpitterDaoImplWithTempl extends NamedParameterJdbcDaoSupport implements SpitterDao{

    private final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, full_name,email,update_by_email) " +
             "values (?, ?, ?, ?, ?)";

    private final String SQL_INSERT_SPITTER_NAMED =
            "insert into spitter (username, password, full_name,email,update_by_email) " +
                    "values(:username, :password, :full_name,:email,:update_by_email)";

    private final String SQL_UPDATE_SPITTER =
            "update spitter set username = ?, fullname = ?, password = ?, email = ?, update_by_email = ?" +
                    "where id = ?";

    private final String SQL_SELECT_SPITTER =
            "select * from SPITTER where id = ?";

    //Можно опустить при использование базовых классов родителей спринг

    /*private JdbcTemplate template;
    private NamedParameterJdbcTemplate templateNamed;
    public SpitterDaoImplWithTempl(JdbcTemplate template, NamedParameterJdbcTemplate templateNamed) {
        this.template = template;
        this.templateNamed = templateNamed;
    }*/

    /*@Override
    Без именнованных параметров
    public void addSpitter(Spitter spitter) {
        template.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
    }*/

    //Именнованные параметры
    @Override
    public void addSpitter(Spitter spitter) {
        Map<String, Object> params = new HashMap<>();
        params.put("username",spitter.getUsername());
        params.put("password",spitter.getPassword());
        params.put("full_name",spitter.getFullName());
        params.put("email",spitter.getEmail());
        params.put("update_by_email",spitter.isUpdateByEmail());
        getNamedParameterJdbcTemplate().update(SQL_INSERT_SPITTER_NAMED,params);
    }

    @Autowired
    private void setDS(DataSource dataSource){
        setDataSource(dataSource);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        getJdbcTemplate().update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail(),
                spitter.getId());

    }

    @Override
    public Spitter getSpitterById(long id) {
        return getJdbcTemplate().queryForObject(SQL_SELECT_SPITTER,
                (rs, rowNum) -> {
                    Spitter spitter = new Spitter();
                    spitter.setId(rs.getLong("id"));
                    spitter.setUsername(rs.getString("username"));
                    spitter.setFullName(rs.getString("full_name"));
                    spitter.setPassword(rs.getString("password"));
                    spitter.setEmail(rs.getString("email"));
                    spitter.setUpdateByEmail(rs.getBoolean("update_by_email"));
                    return spitter;
                },
                id);

    }
}
