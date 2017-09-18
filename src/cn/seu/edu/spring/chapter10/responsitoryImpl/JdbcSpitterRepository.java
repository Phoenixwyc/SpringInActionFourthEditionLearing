package cn.seu.edu.spring.chapter10.responsitoryImpl;

import cn.seu.edu.spring.chapter10.domain.Spitter;
import cn.seu.edu.spring.chapter10.responsitory.SpitterRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/18.
 */
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String INSERT_SPITTER = "insert into Spitter (username, password, fullname, email, updateByEmail) values (?, ?, ?, ?, ?)";

    private static final String SELECT_SPITTER = "select id, username, password, fullname, email, updateByEmail from Spitter";

    private JdbcTemplate jdbcTemplate;

    public JdbcSpitterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(id) from Spitter", Long.class);
    }

    @Override
    public Spitter save(Spitter spitter) {
        Long id = spitter.getId();
        if (id == null) {
            long spitterId = insertSpitterAndReturnId(spitter);
            return new Spitter(spitterId, spitter.getUsername(), spitter.getPassword(), spitter.getFullname(), spitter.getEmail(), spitter.isUpdateByEmail());
        } else {
            jdbcTemplate.update("UPDATE Spitter SET username=?, password=?, fullname=?, email=?, updateByEmail=? WHERE id=?",
                    spitter.getUsername(),
                    spitter.getPassword(),
                    spitter.getFullname(),
                    spitter.getEmail(),
                    spitter.isUpdateByEmail(),
                    id);

        }
        return spitter;
    }

    @Override
    public Spitter findOne(long id) {
        return jdbcTemplate.queryForObject(SELECT_SPITTER + " where id=?", new SpitterRowMapper(), id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return jdbcTemplate.queryForObject("select id, username, password, fullname, email, updateByEmail from Spitter where username=?", new SpitterRowMapper(), username);
    }

    @Override
    public List<Spitter> findAll() {
        return jdbcTemplate.query("select id, username, password, fullname, email, updateByEmail from Spitter order by id", new SpitterRowMapper());
    }

    private long insertSpitterAndReturnId(Spitter spitter) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Spitter");
        simpleJdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<>();
        args.put("username", spitter.getUsername());
        args.put("password", spitter.getPassword());
        args.put("fullname", spitter.getFullname());
        args.put("email", spitter.getEmail());
        args.put("updateByEmail", spitter.isUpdateByEmail());
        long spitterId = simpleJdbcInsert.executeAndReturnKey(args).longValue();
        return spitterId;
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {

        @Override
        public Spitter mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String fullName = resultSet.getString("fullname");
            String email = resultSet.getString("email");
            boolean updateByEmail = resultSet.getBoolean("updateByEmail");
            return new Spitter(id, username, password, fullName, email, updateByEmail);
        }
    }
}
