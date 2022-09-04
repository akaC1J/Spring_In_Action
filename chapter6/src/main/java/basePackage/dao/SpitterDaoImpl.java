package basePackage.dao;

import basePackage.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SpitterDaoImpl implements SpitterDao {

    @Autowired
    DataSource dataSource;

    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        final String SQL_INSERT_SPITTER =
                "insert into spitter (username, password, fullname) values (?, ?, ?)";
        try {
            conn = dataSource.getConnection(); // Получить соединение
            stmt = conn.prepareStatement(SQL_INSERT_SPITTER); // Создать запрос
            stmt.setString(1, spitter.getUsername()); // Связать параметры
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.execute(); // Выполнить запрос
        } catch (SQLException e) { // Обработать исключение (как-нибудь)
            // выполнить что-нибудь... хотя... не уверен, что тут можно сделать
        } finally {
            try {
                if (stmt != null) { // Освободить ресурсы
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Я еще менее уверен, что тут можно сделать
            }
        }
    }

    public void saveSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        final String SQL_UPDATE_SPITTER =
                "update spitter set username = ?, FULL_NAME = ?, password = ?" +
                        "where id = ?";
        try {
            conn = dataSource.getConnection(); // Получить соединение
            stmt = conn.prepareStatement(SQL_UPDATE_SPITTER); // Создать запрос
            stmt.setString(1, spitter.getUsername()); // Связать параметры
            stmt.setString(2, spitter.getFullName());
            stmt.setString(3, spitter.getPassword());
            stmt.setLong(4,spitter.getId());
            stmt.execute(); // Выполнить запрос
        } catch (SQLException e) { // Обработать исключение (как-нибудь)
            // выполнить что-нибудь... хотя... не уверен, что тут можно сделать
        } finally {
            try {
                if (stmt != null) { // Освободить ресурсы
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Я еще менее уверен, что тут можно сделать
            }
        }
    }

    public Spitter getSpitterById(long id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        final String SQL_SELECT_SPITTER =
                "select * from ? where id = 1";
        try {
            conn = dataSource.getConnection(); // Получить соединение
            stmt = conn.prepareStatement(SQL_SELECT_SPITTER); // Создать запрос
            stmt.setString(1,"SPITTER");
            rs = stmt.executeQuery();
            while (rs.next()){
                Spitter spitter = new Spitter();
                spitter.setId(rs.getLong("id"));
                spitter.setUsername(rs.getString("username"));
                spitter.setPassword(rs.getString("password"));
                spitter.setFullName(rs.getString("fullname"));
                return spitter;
            }
        } catch (SQLException e) { // Обработать исключение (как-нибудь)
            // выполнить что-нибудь... хотя... не уверен, что тут можно сделать
        } finally {
            try {
                if(rs != null) {
                    try { // Освободить ресурсы
                        rs.close();
                    } catch (SQLException e) {
                    }
                }

                if (stmt != null) { // Освободить ресурсы
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Я еще менее уверен, что тут можно сделать
            }
        }
        return null;
    }
}
