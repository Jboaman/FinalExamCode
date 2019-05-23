package app.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LoanTest {
	
	@Test
	public void totalPayTest1() {
		Loan ln1 = new Loan(0.07, 4.0, 3000, 0);
		assertEquals(ln1.getTotalPay(), 3448.24,0.1);
	}
	
	@Test
	public void totalIntPayTest1() {
		Loan ln2 = new Loan(0.07,4.0,3000,0);
		assertEquals(ln2.getTotalInt(), 448.24, 0.1);
	}
	
	@Test
	public void totalPayTest2() {
		Loan ln3 = new Loan(0.07,4.0,3000,10);
		assertEquals(ln3.getTotalPay(), 3442.06,0.1);
	}
	@Test
	public void totalIntPayTest2() {
		Loan ln4 = new Loan(0.07,4.0,3000,10);
		assertEquals(ln4.getTotalInt(), 442.06,0.1);
	}


}
