package common;


/**
 * @author chengyongjun
 * @date 5/29/20 7:04 AM
 */
public class ConnectionInfo {
    private String user;

    private String password;

    private String host;

    private String port;

    private String defaultDB;

    private String connectionUrl;

    private Integer connectionCount;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public Integer getConnectionCount() {
        return connectionCount;
    }

    public void setConnectionCount(Integer connectionCount) {
        this.connectionCount = connectionCount;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDefaultDB() {
        return defaultDB;
    }

    public void setDefaultDB(String defaultDB) {
        this.defaultDB = defaultDB;
    }
}
