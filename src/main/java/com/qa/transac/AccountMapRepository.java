package com.qa.transac;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.account.Account;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative

public class AccountMapRepository implements AccountRepository 
{
	@Inject
	private JSONUtil util;
	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Account> accountMap;
	private Long ID;

	
	
	public AccountMapRepository() 
	{
		this.accountMap = new HashMap<Long,Account>();
		ID = INITIAL_COUNT;
		
	}
	

	@Override
	public String getAllAccounts() {
		return util.getJSONForObject(accountMap.values());
	}

	@Override
	public String addAccount (String account) { //
		ID++;
		Account newAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put(ID, newAccount);
		return account;
	}

	@Override
	public String updateAccount(Long id, String accountToUpdate) {
		Account newAccount = util.getObjectForJSON(accountToUpdate, Account.class);
		accountMap.put(id, newAccount);
		return accountToUpdate;
	}

	@Override
	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}
	
	private void initAccountMap( ) 
	{
		Account account = new Account ((long)1, "Mehul", "Saluja", 1234);
		accountMap.put(1L, account);
	}






}
	
	

