package xixi.org.example.util;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import xixi.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL="jdbc:mysql://localhost:3306/servlet_blog?user=root&password=0318&useUnicode=true&characterEncoding=UTF-8&useSSL=false";

    private static final DataSource DS=new MysqlDataSource();

    static {
        ((MysqlDataSource)DS).setUrl(URL);
    }

    public static Connection getConnection(){
        try {
            return DS.getConnection();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new AppException("获取数据库连接错误",e);
        }



    }



}
