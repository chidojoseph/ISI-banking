package isi.project.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.project.banking.model.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Integer> {

	public List<Deposit> findByAccountAccNr(String accNr);
}
