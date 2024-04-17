package com.luv2code.aopdemoPntctDclrtns;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.aopdemoPntctDclrtns.dao.AccountDAO;
import com.luv2code.aopdemoPntctDclrtns.dao.MembershipDAO;
import com.luv2code.aopdemoPntctDclrtns.service.TrafficFortuneService;

@SpringBootApplication
public class AopdemoPntctDclrtnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoPntctDclrtnsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {
		
		return runner -> {
			
			// demoTheBeforeAdvice(theAccountDao, theMembershipDAO);
			// demoTheAfterReturningAdvice(theAccountDao);
			// demoTheAfterThrowingAdvice(theAccountDao);
			// demoTheAfterAdvice(theAccountDao);
			// demoTheAroundAdvice(theTrafficFortuneService);
			// demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
			
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");		
		
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
        
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire = true;
		
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");		
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("\nMain Program: demoTheAroundAdvice");
		
		System.out.println("Calling getFortune()");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		
		System.out.println("Finished");
		
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDao) {
		// call method to find the accounts
		List<Account> theAccounts = null;
		
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
		theAccounts = theAccountDao.findAccounts(tripWire);
		}
		catch (Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}
		
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("---");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");			
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDao) {
		
		// call method to find the accounts
				List<Account> theAccounts = null;
				
				try {
					// add a boolean flag to simulate exceptions
					boolean tripWire = true;
				theAccounts = theAccountDao.findAccounts(tripWire);
				}
				catch (Exception exc) {
					System.out.println("\n\nMain Program: ... caught exception: " + exc);
				}
				
				// display the accounts
				System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
				System.out.println("---");
				
				System.out.println(theAccounts);
				
				System.out.println("\n");	
				
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDao) {
		
		// call method to find the accounts
		List<Account> theAccounts = theAccountDao.findAccounts();
		
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("---");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao, MembershipDAO theMembershipDAO) {
		
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		
		theAccountDao.addAccount(myAccount, true);
		theAccountDao.doWork();
		
		// call the accountdao getter/setter methods
		theAccountDao.setName("foobar");
		theAccountDao.setServiceCode("silver");
		
		String name = theAccountDao.getName();
		String code = theAccountDao.getServiceCode();
		
		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
	}

}
