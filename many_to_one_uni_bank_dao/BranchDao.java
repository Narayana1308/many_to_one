package com.ty.many_to_one_uni_bank_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.many_to_one_uni_bank_dto.Bank;
import com.ty.many_to_one_uni_bank_dto.Branch;


public class BranchDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void saveBranch(Branch branch) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		Bank bank=branch.getBank();
		entityManager.merge(bank);
		entityManager.persist(branch);
		entityTransaction.commit();
	}
	public void updateBranch(Branch branch ,int id) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch1=entityManager.find(Branch.class, id);
		
		if(branch1!=null) {
			branch1.setBranchName(branch.getBranchName());
			branch1.setIfsc(branch.getIfsc());
			entityTransaction.begin();
			entityManager.merge(branch1);
			entityTransaction.commit();
		}
		else {
			System.out.println("does not exist");
		}
	}
	public void deleteBranch(int id){
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Branch branch=entityManager.find(Branch.class, id);
		//Bank bank=branch.getBank();
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			//entityManager.remove(bank);
			entityTransaction.commit();
		}else {
			System.out.println("not exist");
		}
	}
	public  void getDetailsBranch(int id) {
		EntityManager entityManager=getEntityManager();
		Branch branch=entityManager.find(Branch.class, id);
		System.out.println(branch);
		
	}
	public void getAllBranchDetails() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select br from Branch br");
		List<Branch> list=query.getResultList();
		System.out.println(list);
	}

}
