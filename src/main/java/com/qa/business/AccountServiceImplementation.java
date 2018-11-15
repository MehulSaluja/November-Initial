package com.qa.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.transac.AccountRepository; //

public class AccountServiceImplementation implements AccountService
{
	private static final Logger LOGGER = Logger.getLogger(AccountService.class);
	
	@Inject
	private AccountRepository repo;
	
	public String getAllAccounts() {
		LOGGER.info("In AccountServiceImplementation getAllAccounts ");
		return repo.getAllAccounts();
	}

	@Override
	public String addAccount(String account) {
		return repo.addAccount(account);
	}

	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);

	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
		
	}


}
