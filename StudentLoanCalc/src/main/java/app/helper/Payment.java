package app.helper;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.poi.ss.formula.functions.Finance;
import org.apache.poi.ss.formula.functions.FinanceLib;



public class Payment {
	
	private double prinpaymnt;
	private double intpayment; 
	
	public Payment(double dIR, double dTL, double dLA, double dAP, int period) {
        
        double ppay = dAP+Math.abs(Finance.ppmt(dIR/12,period,(int)dTL*12,dLA,0.0,0));
        double ipay= Math.abs(Finance.ipmt(dIR/12,period,(int) dTL*12,dLA,0.0,0));
        prinpaymnt= round(ppay, 5);
        intpayment = round(ipay, 5);
	}
	
	private static double round(double value, int places) {
	 
	    BigDecimal bd = new BigDecimal(Double.toString(value));
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public double getPrinpayment() {
		return prinpaymnt;
	}

	public double getIntpayment() {
		return intpayment;
	}

	public void setPrinpaymnt(double prinpaymnt) {
		this.prinpaymnt = prinpaymnt;
	}
	


}
