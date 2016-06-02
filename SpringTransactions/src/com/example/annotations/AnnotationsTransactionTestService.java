package com.example.annotations;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.example.transactions.TransactionTestService;

public class AnnotationsTransactionTestService implements TransactionTestService {
	private final static Log log = LogFactory.getLog(AnnotationsTransactionTestService.class);

	@Transactional(readOnly = true)
	public void readOnlyCommitExampleTransaction() {
		log.info("-- AnnotationsTransactionTestService.readOnlyCommitExampleTransaction -- expects transaction commit and read-only");
		// do stuff
	}
	
	@Transactional(readOnly = true)
	public void readOnlyRollbackExampleTransaction() {
		log.info("-- AnnotationsTransactionTestService.readOnlyRollbackExampleTransaction -- expects transaction rollback and read-only");
		// do stuff
		throw new RuntimeException("readOnlyRollbackExampleTransaction Exception");
	}
	
	@Transactional
	public void readWriteCommitExampleTransaction() {
		log.info("-- AnnotationsTransactionTestService.readWriteCommitExampleTransaction -- expects transaction commit");
		// do stuff
	}
	
	@Transactional
	public void readWriteRollbackExampleTransaction() {
		log.info("-- AnnotationsTransactionTestService.readWriteRollbackExampleTransaction -- expects transaction rollback");
		// do stuff
		throw new RuntimeException("readWriteRollbackExampleTransaction Exception");
	}
}
