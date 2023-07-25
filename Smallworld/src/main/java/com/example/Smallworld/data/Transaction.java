package com.example.Smallworld.data;

public class Transaction {
    // Represent your transaction data here.	
    	private int mtn,senderAge,beneficiaryAge,issueId;
		private double amount;
		private String senderFullName,beneficiaryFullName,issueMessage;
		private boolean issueSolved;
		

		
		public int getMtn() {
			return mtn;
		}
		public void setMtn(int mtn) {
			this.mtn = mtn;
		}
		public int getSenderAge() {
			return senderAge;
		}
		public void setSenderAge(int senderAge) {
			this.senderAge = senderAge;
		}
		public int getBeneficiaryAge() {
			return beneficiaryAge;
		}
		public void setBeneficiaryAge(int beneficiaryAge) {
			this.beneficiaryAge = beneficiaryAge;
		}
		public int getIssueId() {
			return issueId;
		}
		public void setIssueId(int issueId) {
			this.issueId = issueId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getSenderFullName() {
			return senderFullName;
		}
		public void setSenderFullName(String senderFullName) {
			this.senderFullName = senderFullName;
		}
		public String getBeneficiaryFullName() {
			return beneficiaryFullName;
		}
		public void setBeneficiaryFullName(String beneficiaryFullName) {
			this.beneficiaryFullName = beneficiaryFullName;
		}
		public String getIssueMessage() {
			return issueMessage;
		}
		public void setIssueMessage(String issueMessage) {
			this.issueMessage = issueMessage;
		}
		public boolean IssueSolved() {
			return issueSolved;
		}
		public void setIssueSolved(boolean issueSolved) {
			this.issueSolved = issueSolved;
		}
		@Override
		public String toString() {
			return "Transaction [mtn=" + mtn + ", senderAge=" + senderAge + ", beneficiaryAge=" + beneficiaryAge
					+ ", issueId=" + issueId + ", amount=" + amount + ", senderFullName=" + senderFullName
					+ ", beneficiaryFullName=" + beneficiaryFullName + ", issueMessage=" + issueMessage
					+ ", issueSolved=" + issueSolved + "]";
		}
		
		
		
}

