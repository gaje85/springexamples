package com.example.ptm;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.example.transactions.TransactionTestService;



public class PtmTransactionTestService implements TransactionTestService {
	private final static Log log = LogFactory.getLog(PtmTransactionTestService.class);
	
	private PlatformTransactionManager transactionManager = null;
	
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public void readOnlyCommitExampleTransaction() {
		log.info("-- PtmTransactionTestService.readOnlyCommitExampleTransaction -- expects transaction commit and read-only");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setReadOnly(true);
		TransactionStatus status = transactionManager.getTransaction(def);
		// do stuff
		transactionManager.commit(status);
	}
	
	public void readOnlyRollbackExampleTransaction() {
		log.info("-- PtmTransactionTestService.readOnlyRollbackExampleTransaction -- expects transaction rollback and read-only");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setReadOnly(true);
		TransactionStatus status = transactionManager.getTransaction(def);
		// do stuff
		transactionManager.rollback(status);
	}
	
	public void readWriteCommitExampleTransaction() {
		log.info("-- PtmTransactionTestService.readWriteCommitExampleTransaction -- expects transaction commit");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		// do stuff
		transactionManager.commit(status);
	}
	
	public void readWriteRollbackExampleTransaction() {
		log.info("-- PtmTransactionTestService.readWriteRollbackExampleTransaction -- expects transaction rollback");
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		// do stuff
		transactionManager.rollback(status);
	}
}
