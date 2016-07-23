package com.zju.hpec.utils;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 16/7/23 下午2:53
 * @Description
 */
public class SqlUtils {

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    /**
     * 转义SQL语句中所有空格
     * @param sql
     * @return String
     */
    public static String convertAllSpaceInSql(String sql){
        if(null == sql || "".equals(sql))
            return "";
        return sql.replaceAll("\\s","%20");
    }

    public static void main(String[] args) {
        String sql = "select *from user";
        System.out.println(convertAllSpaceInSql(sql));
    }

}
