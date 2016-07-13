package com.zju.hpec.dbsource.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.summer.base.utils.BeanCloneUtils;
import com.zju.hpec.domain.DBField;
import com.zju.hpec.domain.DBRecord;
import com.zju.hpec.controller.vo.DBRecordVo;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Author: hzduhao
 * Date: 2016/7/13
 * Time: 14:27
 */
public class BeanConvertsTest {

    DBRecord dbRecord = null;

    @Before
    public void before(){
        dbRecord = new DBRecord();

        List<DBField> dbFieldList = Lists.newArrayList();

        DBField dbField1 = new DBField("id",123091);
        DBField dbField2 = new DBField("name","summer");
        DBField dbField3 = new DBField("sex","male");
        DBField dbField4 = new DBField("age",28);
        DBField dbField5 = new DBField("email","summer@sina.com");
        DBField dbField6 = new DBField("phone","15268528314");
        DBField dbField7 = new DBField("address","浙江省杭州市西湖区浙大路38号");

        dbFieldList.add(dbField1);
        dbFieldList.add(dbField2);
        dbFieldList.add(dbField3);
        dbFieldList.add(dbField4);
        dbFieldList.add(dbField5);
        dbFieldList.add(dbField6);
        dbFieldList.add(dbField7);

        dbRecord.setFields(dbFieldList);
    }

    @Test
    public void test(){
        DBRecordVo dbRecordVo = BeanCloneUtils.deepClone(dbRecord,DBRecord.class,DBRecordVo.class);
        System.out.println(JSON.toJSONString(dbRecordVo,true));
    }

}
