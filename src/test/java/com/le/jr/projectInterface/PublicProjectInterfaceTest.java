package com.le.jr.projectInterface;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.le.jr.trade.publictools.data.Message;
import com.lejr.trade.projectcenter.domain.PublicProjectVo;
import com.lejr.trade.projectcenter.domain.vo.DisplayForCVo;
import com.lejr.trade.projectcenter.interfaces.DisplayInterfaces;
import com.lejr.trade.projectcenter.interfaces.PublicProjectInterfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.RetryListener;

import javax.annotation.Resource;


/**
 * Created by zhangxiao3 on 2017/2/4.
 */
@ContextConfiguration(locations = "classpath:spring-config-consumer.xml")
public class PublicProjectInterfaceTest extends AbstractTestNGSpringContextTests{
    private static final Logger logger = LoggerFactory.getLogger(PublicProjectInterfaceTest.class);
    ObjectMapper mapper = new ObjectMapper();

    @Resource
    private PublicProjectInterfaces publicProjectInterfaces;

    @Test(retryAnalyzer = util.RetryListener.class)
    public void testSelectDisplayByDisplayCode() throws  Exception{
        Message<DisplayForCVo> msg = publicProjectInterfaces.selectDisplayByDisplayCode("60200316115");
        System.out.println(mapper.writeValueAsString(msg));
        Assert.assertEquals(msg.getCode(),100);

    }
    @Test
    public void testSelectProjectByProjectCode() throws  Exception{
        Message<PublicProjectVo> msg = publicProjectInterfaces.selectProjectByProjectCode("8341","200000002491",false,false);
        System.out.println(mapper.writeValueAsString(msg));
        Assert.assertEquals(msg.getCode(),100);
    }
   @Test
    public void testCheckVenderCodeIsRelate() throws Exception{
       Message<Boolean> msg = publicProjectInterfaces.checkMerchantCodeIsRelate("200000002491");
       System.out.println(mapper.writeValueAsString(msg));
       Assert.assertEquals(msg.getCode(),200);
    }

    @Test
    public void testCheckMerchantCodeIsRelate() throws Exception{
        Message<Boolean> msg = publicProjectInterfaces.checkMerchantCodeIsRelate("200000010151");
        System.out.println(mapper.writeValueAsString(msg));
        Assert.assertEquals(msg.getCode(),200);
    }
}
