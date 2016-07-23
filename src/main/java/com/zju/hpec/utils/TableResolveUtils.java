package com.zju.hpec.utils;

import com.google.common.collect.Lists;
import com.summer.base.utils.StringUtils;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/14
 * Time: 17:24
 */
public class TableResolveUtils {

    private static final String KEY_FROM = "from";
    private static final String KEY_WHERE = "where";
    private static final String KEY_AS = "as";

    /**
     * 从SQL语句中解析出所有数据表名称,并以数组的形式返回
     * @param sql SQL语句
     * @return @{link String[]}
     */
    public static String[] getTableNamesFromSqlAsArray(String sql){
        return getTableNamesFromSqlAsList(sql).toArray(new String[0]);
    }

    /**
     * 从SQL语句中解析出所有数据表名称,并以列表的形式返回
     * @param sql SQL语句
     * @return @{link List<String>}
     */
    public static List<String> getTableNamesFromSqlAsList(String sql){
        List<String> tableNames = Lists.newArrayList();

        if(StringUtils.isEmpty(sql))
            return tableNames;

        //将SQL语句全部转换为小写字符，以便统一处理
        String sqlTmp = sql.toLowerCase().trim();

        int fromIndex = sqlTmp.indexOf(KEY_FROM);
        int whereIndex = sqlTmp.indexOf(KEY_WHERE);

        String tmp = null;

        if(fromIndex >= 0){
            int start = fromIndex + KEY_FROM.length();
            if(whereIndex > fromIndex){
                tmp = sqlTmp.substring(start,whereIndex);
            }else{//SQL语句中没有where关键字的情况
                tmp = sqlTmp.substring(start);
            }
        }

        if(StringUtils.isNotEmpty(tmp)){
            tmp.trim();
            //去掉SQL语句中的as关键字
            String sqlWithoutAs = tmp.replaceAll(KEY_AS,"");
            //以逗号为分隔符获取多张可能带有别名的表
            String tables[] = sqlWithoutAs.split("\\,");
            for(String tableWithAlias : tables){
                String tableWithAliasTmp = tableWithAlias.trim();
                //以空格为分隔符获取真是表名
                String tableName[] = tableWithAliasTmp.split(" ");
                if(StringUtils.isNotEmpty(tableName[0])){
                    tableNames.add(tableName[0].trim());
                }
            }
        }

        return tableNames;
    }

    public static void main(String[] args) {
        String sql = "select *from table1 as s1,table2 as s2,table3 as s3 where s1.id = s2.id and s2.id = s3.id";
//        List<String> tableNames = getTableNamesFromSqlAsList(sql);
        String[] tableNames = getTableNamesFromSqlAsArray(sql);
        for(String tableName : tableNames)
            System.out.println(tableName);
    }
}
