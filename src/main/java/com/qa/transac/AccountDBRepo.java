package com.qa.transac;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.account.Account;
import com.qa.util.JSONUtil;




@Default
@Transactional(SUPPORTS)

public class AccountDBRepo implements AccountRepository {

	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	
	
	@Override
	public String getAllAccounts() 
	{
		Query query = manager.createQuery("Select m from Account m");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String addAccount(String account) 
	{
		Account anAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
		
	} 
	
	@Override
	@Transactional(REQUIRED)
	public String updateAccount (Long id,String update_the_accounts) 
	{
		Account updatedAccount = util.getObjectForJSON(update_the_accounts, Account.class); //
		Account account_from_db = findAccount(id);//
		if (update_the_accounts != null) 
		{
			account_from_db = updatedAccount;
			manager.merge(account_from_db);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}
	
	@Override
	@Transactional(REQUIRED)
	public String deleteAccount (Long id) 
	{
		Account account_in_db = findAccount(id);
		if (account_in_db != null) 
		{
			manager.remove(account_in_db);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
		
	}
	
	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	

}