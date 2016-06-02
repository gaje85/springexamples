package com.example.ptm;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.transactions.TransactionTestService;



public class PtmTransactionTest {
	private final static Log log = LogFactory.getLog(PtmTransactionTest.class);
	
	public static void main(String[] args) {
		log.info("-- Starting Spring Programmatic PlatformTransactionManager Example --");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/com/example/ptm/ptm-test.xml");
		TransactionTestService transactionTestService = (TransactionTestService)ctx.getBean("transactionTestService");
		transactionTestService.readOnlyCommitExampleTransaction();
		transactionTestService.readOnlyRollbackExampleTransaction();
		transactionTestService.readWriteCommitExampleTransaction();
		transactionTestService.readWriteRollbackExampleTransaction();
	}
}
