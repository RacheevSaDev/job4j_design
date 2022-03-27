package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException {
        connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("login"), properties.getProperty("password"));
    }

    public void createTable(String tableName) {
        try (var statement = connection.createStatement()) {
            String sql = String.format(
                    "CREATE TABLE IF NOT EXISTS %s();", tableName);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable(String tableName) {
        try (var statement = connection.createStatement()) {
            String sql = String.format("DROP TABLE IF EXISTS %s;", tableName);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addColumn(String tableName, String columnName, String type) {
        try (var statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE %s ADD COLUMN IF NOT EXISTS %s %s;",
                    tableName, columnName, type);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropColumn(String tableName, String columnName) {
        try (var statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE IF EXISTS %s DROP COLUMN IF EXISTS %s;",
                    tableName, columnName);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        try (var statement = connection.createStatement()) {
            String sql = String.format("ALTER TABLE IF EXISTS %s RENAME COLUMN %s TO %s;",
                    tableName, columnName, newColumnName);
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Config conf = new Config("app.properties");
        conf.load();
        Properties properties = new Properties();
        properties.setProperty("classname", conf.value("classname"));
        properties.setProperty("url", conf.value("url"));
        properties.setProperty("login", conf.value("login"));
        properties.setProperty("password", conf.value("password"));
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("test_table");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "test_table"));
        tableEditor.addColumn("test_table", "id", "serial primary key");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "test_table"));
        tableEditor.addColumn("test_table", "name", "varchar(255)");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "test_table"));
        tableEditor.renameColumn("test_table", "name", "ФИО");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "test_table"));
        tableEditor.dropColumn("test_table", "ФИО");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "test_table"));
        tableEditor.dropTable("test_table");
        System.out.println(tableEditor.getTableScheme(tableEditor.connection, "test_table"));
    }
}