package com.test.lejr.util.customerListener;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

/**
 * Created by zhangxiao3 on 2017/2/7.
 */
public class MyReporterListenerAdapter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

    }
}
