package com.o2o.Service;

import com.o2o.BaseTest;
import com.o2o.DO.AreaDO;
import com.o2o.Dao.AreaDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaServiceTest extends BaseTest{
    @Autowired
    private AreaService areaService;
    @Test
    public void getAreaList(){
        List<AreaDO>list = areaService.getAreaList();
        assertEquals("西苑",list.get(0).getAreaName());

    }
}
