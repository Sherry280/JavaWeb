package org.example.util;

import org.junit.Assert;
import org.junit.Test;
import xixi.org.example.util.DBUtil;

import java.sql.Connection;

public class DBUtilTest {
    @Test
    public void testGetConnection(){
        Connection connection= DBUtil.getConnection();
        System.out.println(connection);
        Assert.assertNotNull(connection);
    }



}
