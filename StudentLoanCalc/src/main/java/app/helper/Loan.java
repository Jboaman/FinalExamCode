package app.helper;

import java.util.ArrayList;

public class Loan {
	
	private ArrayList<Payment> payments = new ArrayList<Payment>();
	private double totalPay;
	private double totalInt;
	
	public Loan(double dIR, double dTL, double dLA, double dAP) {
		int count = 0;
		double prinpayed = dLA;
		while(prinpayed>=0) {
			count++;
			Payment p = new Payment(dIR, dTL,dLA,dAP,count);
			payments.add(p);
			prinpayed-= p.getPrinpayment();
		}
		for(Payment pay: payments) {
			totalPay+= pay.getIntpayment();
			totalPay+= pay.getPrinpayment();
			totalInt+= pay.getIntpayment();
		}
	}

	public double getTotalPay() {
		return totalPay;
	}

	public double getTotalInt() {
		return totalInt;
	}


}
