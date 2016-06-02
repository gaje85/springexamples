package com.example.transactions;


public interface TransactionTestService {
	public void readOnlyCommitExampleTransaction();
	
	public void readOnlyRollbackExampleTransaction();
	
	public void readWriteCommitExampleTransaction();
	
	public void readWriteRollbackExampleTransaction();
}
