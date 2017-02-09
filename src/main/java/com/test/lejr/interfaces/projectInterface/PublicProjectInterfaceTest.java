package com.test.lejr.interfaces.projectInterface;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.le.jr.trade.publictools.data.Message;

import com.lejr.trade.projectcenter.dao.DisplayDao;
import com.lejr.trade.projectcenter.domain.Display;
import com.lejr.trade.projectcenter.domain.PublicProjectVo;
import com.lejr.trade.projectcenter.domain.vo.DisplayForCVo;
import com.lejr.trade.projectcenter.interfaces.PublicProjectInterfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Parameters;

import org.testng.annotations.Test;
import com.test.lejr.util.customerListener.RetryListener;

import javax.annotation.Resource;


/**
 * Created by zhangxiao3 on 2017/2/4.
 */
@ContextConfiguration(locations = {"classpath:env/test/spring-config-consumer.xml","classpath:env/test/spring-config-datasource.xml"})
//,"classpath:env/test/spring-config-datasource.xml"
public class PublicProjectInterfaceTest extends AbstractTestNGSpringContextTests{
    private static final Logger logger = LoggerFactory.getLogger(PublicProjectInterfaceTest.class);
    ObjectMapper mapper = new ObjectMapper();

    @Resource
    private DisplayDao displayDao;

    @Resource
    private PublicProjectInterfaces publicProjectInterfaces;
    @Parameters({"displaycode"})
    @Test(retryAnalyzer = RetryListener.class)
    public void testSelectDisplayByDisplayCode(String displaycode) throws  Exception{
        Message<DisplayForCVo> msg = publicProjectInterfaces.selectDisplayByDisplayCode(displaycode);
        System.out.println(mapper.writeValueAsString(msg));
//        Display display = new MybatisUtil().getDidplaydetail();
//        System.err.println("display:"+display);
//        Assert.assertEquals(msg.getData().getProductCode(), display.getProductCode());
        Display display = displayDao.selectByDisplayCode(displaycode);
        System.err.println("display:"+display);
    }
    @Test
    public void testSelectProjectByProjectCode() throws  Exception{
        Message<PublicProjectVo> msg = publicProjectInterfaces.selectProjectByProjectCode("8341","200000002491",false,false);
        System.out.println(mapper.writeValueAsString(msg));
        Assert.assertEquals(msg.getCode(),200);
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
