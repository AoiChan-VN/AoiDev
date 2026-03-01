package aoichan.crystal.storage;

import aoichan.crystal.AoiMain;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class DatabasePool {

    private final HikariDataSource dataSource;

    public DatabasePool(AoiMain plugin) {

        HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:sqlite:" +
                plugin.getDataFolder() + "/data.db");

        config.setMaximumPoolSize(10);
        config.setPoolName("GemsPool");

        dataSource = new HikariDataSource(config);
    }

    public StorageProvider createProvider() {
        return new SQLiteStorage(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void shutdown() {
        dataSource.close();
    }
}
