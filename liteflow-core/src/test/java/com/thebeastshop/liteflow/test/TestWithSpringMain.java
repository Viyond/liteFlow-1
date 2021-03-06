package com.thebeastshop.liteflow.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thebeastshop.liteflow.core.FlowExecutor;
import com.thebeastshop.liteflow.entity.data.Slot;


/**
 * 此示例演示了如何在spring中用liteflow
 * 如果是springboot请参考flowtest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class TestWithSpringMain {

	@Resource(name="flowExecutor")
	private FlowExecutor flowExecutor;

	@Test
	public void test1() throws Exception {
		Slot slot = flowExecutor.execute("chain1", "it's a request");
		System.out.println(slot);
		System.out.println("done!");
		System.in.read();
	}

	@Test
	public void test2() throws Exception {
		try {
			Slot slot = flowExecutor.execute("chain3", "it's a request");
			System.out.println(slot);
			System.in.read();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test3() throws Exception {
		try {
			while(true) {
				Slot slot = flowExecutor.execute("chain3", "it's a request");
				Thread.sleep(2000);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
