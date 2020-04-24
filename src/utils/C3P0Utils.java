package utils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
public class C3P0Utils {
	//通过读取c3p0-config文件获取连接池对象
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//提供一个dataSource数据源
	public static DataSource getDataSource(){
		return dataSource;
	}
	//创建一个ThreadLocal对象，以当前线程作为key
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	//提供当前线程中的Connection
	public static Connection getConnection() throws SQLException{
		Connection conn = threadLocal.get();
		if (null==conn) {
			conn  = dataSource.getConnection();
			threadLocal.set(conn);
		}
		return conn;
	}
}