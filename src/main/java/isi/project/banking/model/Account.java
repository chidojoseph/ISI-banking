package isi.project.banking.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="ACCOUNT")
public class Account {
	

	@Id
	@Column(name = "ACC_NR")
	private String accNr;
	private Double balance;
	@Column(name = "DAY_LIMIT")
	private Double dayLimit;
	private Double interest;
	@Column(name = "OPEN_DATE")
	private Date openDate;
	private String pesel;
	private String name;
	@ManyToOne
	@JoinColumn(name = "PESEL", insertable = false, updatable = false)
	private Client client;
	
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private Set<Card> cards;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private Set<CashLoan> cashLoans;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private Set<MortgageLoan> mortgageLoans;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private Set<Investment> investments;
	@OneToMany(mappedBy="accNrSender", fetch=FetchType.EAGER)
	private Set<Transfer> transfersFrom;
	@OneToMany(mappedBy="accNrReceiver", fetch=FetchType.EAGER)
	private Set<Transfer> transfersTo;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private Set<Deposit> deposits;
	@OneToMany(mappedBy="accNr", fetch=FetchType.EAGER)
	private Set<Withdraw> withdrawals;
	
	public Account(String pesel, String name) {
		super();
		this.pesel = pesel;
		this.name = name;
		
		// default values:
		this.accNr = "";
		this.balance = 0.;
		this.dayLimit = 0.;
		this.interest = 0.;
		this.openDate = new Date();
	}
	public Account() {
		super();
	}
	
	public String getAccNr() {
		return accNr;
	}
	public void setAccNr(String accNr) {
		this.accNr = accNr;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getDayLimit() {
		return dayLimit;
	}
	public void setDayLimit(Double dayLimit) {
		this.dayLimit = dayLimit;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Card> getCards() {
		return cards;
	}
	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}
	public Set<CashLoan> getCashLoans() {
		return cashLoans;
	}
	public void setCashLoans(Set<CashLoan> cashLoans) {
		this.cashLoans = cashLoans;
	}
	public Set<MortgageLoan> getMortgageLoans() {
		return mortgageLoans;
	}
	public void setMortgageLoans(Set<MortgageLoan> mortgageLoans) {
		this.mortgageLoans = mortgageLoans;
	}
	public Set<Investment> getInvestments() {
		return investments;
	}
	public void setInvestments(Set<Investment> investments) {
		this.investments = investments;
	}
	public Set<Transfer> getTransfersFrom() {
		return transfersFrom;
	}
	public void setTransfersFrom(Set<Transfer> transfersFrom) {
		this.transfersFrom = transfersFrom;
	}
	public Set<Transfer> getTransfersTo() {
		return transfersTo;
	}
	public void setTransfersTo(Set<Transfer> transfersTo) {
		this.transfersTo = transfersTo;
	}
	public Set<Deposit> getDeposits() {
		return deposits;
	}
	public void setDeposits(Set<Deposit> deposits) {
		this.deposits = deposits;
	}
	public Set<Withdraw> getWithdrawals() {
		return withdrawals;
	}
	public void setWithdrawals(Set<Withdraw> withdrawals) {
		this.withdrawals = withdrawals;
	}
}