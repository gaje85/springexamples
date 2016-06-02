package com.example.template;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.example.transactions.TransactionTestService;



public class TemplateTransactionTestService implements TransactionTestService {
	private final static Log log = LogFactory.getLog(TemplateTransactionTestService.class);
	
	private PlatformTransactionManager transactionManager = null;
	
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public void readOnlyCommitExampleTransaction() {
		log.info("-- TemplateTransactionTestService.readOnlyCommitExampleTransaction -- expects transaction commit and read-only");
		final TransactionTemplate tt = new TransactionTemplate(transactionManager);
		tt.setReadOnly(true);
		tt.execute(new TransactionCallbackWithoutResult() {
			public void doInTransactionWithoutResult(TransactionStatus status) {
				log.info("-- doInTransactionWithoutResult -- expects transaction commit");
				// do stuff
			}
		});
	}
	
	public void readOnlyRollbackExampleTransaction() {
		log.info("-- TemplateTransactionTestService.readOnlyRollbackExampleTransaction -- expects transaction rollback and read-only");
		final TransactionTemplate tt = new TransactionTemplate(transactionManager);
		tt.setReadOnly(true);
		tt.execute(new TransactionCallbackWithoutResult() {
			public void doInTransactionWithoutResult(TransactionStatus status) {
				log.info("-- doInTransactionWithoutResult -- expects transaction rollback");
				// do stuff
				status.setRollbackOnly();
			}
		});
	}
	
	public void readWriteCommitExampleTransaction() {
		log.info("-- TemplateTransactionTestService.readWriteCommitExampleTransaction -- expects transaction commit");
		final TransactionTemplate tt = new TransactionTemplate(transactionManager);
		tt.execute(new TransactionCallbackWithoutResult() {
			public void doInTransactionWithoutResult(TransactionStatus status) {
				log.info("-- doInTransactionWithoutResult -- expects transaction commit");
				// do stuff
			}
		});
	}
	
	public void readWriteRollbackExampleTransaction() {
		log.info("-- TemplateTransactionTestService.readWriteRollbackExampleTransaction -- expects transaction rollback");
		final TransactionTemplate tt = new TransactionTemplate(transactionManager);
		tt.execute(new TransactionCallbackWithoutResult() {
			public void doInTransactionWithoutResult(TransactionStatus status) {
				log.info("-- doInTransactionWithoutResult -- expects transaction rollback");
				// do stuff
				status.setRollbackOnly();
			}
		});
	}
}

