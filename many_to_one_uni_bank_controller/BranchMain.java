package com.ty.many_to_one_uni_bank_controller;

import java.util.Scanner;

import com.ty.many_to_one_uni_bank_dao.BranchDao;
import com.ty.many_to_one_uni_bank_dto.Bank;
import com.ty.many_to_one_uni_bank_dto.Branch;

public class BranchMain {

	public static void main(String[] args) {
     	Scanner scanner=new Scanner(System.in);
     	Branch branch=new Branch();
     	//Branch branch1=new Branch();
     	BranchDao dao=new BranchDao();
     	Bank bank=new Bank();
     	boolean condition=true;
    	System.out.println("enter bank name");
		String  bankname=scanner.next();
		bank.setBankName(bankname);
		System.out.println("enter bank id");
		int bankid=scanner.nextInt();
		bank.setBankId(bankid);
		System.out.println("enter the bank ceo");
		String ceo=scanner.next();
		bank.setCEO(ceo);
		System.out.println("enter head office");
		String headOffice=scanner.next();
		
		bank.setHeadOffice(headOffice);
		branch.setBank(bank);
     	
     	do {
     		System.out.println("enter your choice \n1 for save branch\n2 for update branch\n3 for delete branch\n4 for get branch details by id\n5 for get all branch details\n6 exit");
     		int choice=scanner.nextInt();
     		switch (choice) {
			case 1:{
				System.out.println("enter 1 branch details");
				System.out.println("enter branch ifsc");
				String ifsc=scanner.next();
				branch.setIfsc(ifsc);
				System.out.println("enter branch name");
				String name=scanner.next();
				branch.setBranchName(name);
				System.out.println("enetr address");
				String address=scanner.next();
				System.out.println("enter manager name");
				String mName=scanner.next();
				System.out.println("enetr phone number");
				long phone =scanner.nextLong();
				branch.setAddress(address);
				branch.setBranchName(name);
				branch.setIfsc(ifsc);
				branch.setManagerName(mName);
				branch.setPhone(phone);
			
			
				dao.saveBranch(branch);
				
				
			}break;
			case 2:{
				System.out.println("enter branch id");
				int id=scanner.nextInt();
				System.out.println("enter branch name to be updated");
				String branchName=scanner.next();
				branch.setBranchName(branchName);
				System.out.println("enter ifsc code to be updated");
				String ifsc=scanner.next();
				branch.setIfsc(ifsc);
				dao.updateBranch(branch, id);
				
			}break;
			case 3:{
				System.out.println("enter branch id to be delete");
				int id=scanner.nextInt();
				dao.deleteBranch(id);
				
			}break;
			case 4 :{
				System.out.println("enter branch id");
				int id=scanner.nextInt();
				dao.getDetailsBranch(id);
				
			}break;
			case 5:{
				dao.getAllBranchDetails();
			
				
			}break;
			case 6:{
				condition=false;
				
			}break;
			default:
			System.out.println("invalid choice");
			}
			
		} while (condition);
         System.out.println("Thank you...!!!!!");
	}

}
