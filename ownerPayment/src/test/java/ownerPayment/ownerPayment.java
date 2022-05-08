package ownerPayment;



public class ownerPayment {
	public class vehicalOwnerPayment {
		int tripInAMonth;
		float NumberOfKillometers;
		float fixedAmount;
		float additionalAmount;
		
		

		private double amount;
		public double getAmount() {
			double amount;
			
		}
		public void setAmount(double amount) {
			this.amount= amount;
		}
		void addvehicalOwnerPayment(double va1){
			this.amount=Math.round(va1*100)/100.0;
		}
		public void paymentDetails() {
			System.out.println("the payment amount is =" +this.amount);
		}
		class creditcardpayments extends addDriverPayments {
			creditcardpayments(double value1, string cardName, string expirationDate, string creditcardNumber ) {
				super(value1);
				// TODO Auto-generated constructor stub
			}

			string cardName , expirationDate, creditcardNumber;
			this.cardName = cardName;
			this.expiratonDate = expiratonDate ;
			this.creditcardNumber = creditcardNumber;
		}
	}
}
