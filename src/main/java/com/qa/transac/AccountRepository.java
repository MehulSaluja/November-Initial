package com.qa.transac;

public interface AccountRepository {

	String getAllAccounts();

	String updateAccount(Long id, String accountToUpdate);

	String deleteAccount(Long id);

	String addAccount(String account);

}