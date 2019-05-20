package app.helper;

import java.text.DecimalFormat;

import org.apache.poi.ss.formula.functions.Finance;



public class Payment {
	
	private double prinpaymnt;
	private double intpayment; 
	
	public Payment(double dIR, double dTL, double dLA, double dAP, int period) {
		prinpaymnt= dAP+Math.abs(Finance.ppmt(dIR/12,period,(int)dTL*12,dLA,0.0,0));
		intpayment = Math.abs(Finance.ipmt(dIR/12,period,(int)dTL*12,dLA,0.0,0));
	}

	public double getPrinpayment() {
		return prinpaymnt;
	}

	public double getIntpayment() {
		return intpayment;
	}


}
