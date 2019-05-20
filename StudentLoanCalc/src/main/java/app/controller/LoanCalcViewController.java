package app.controller;

import app.StudentCalc;
import app.helper.Loan;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import org.apache.poi.ss.formula.functions.*;


public class LoanCalcViewController implements Initializable   {

	private StudentCalc SC = null;
	
	@FXML
	private TextField LoanAmount;

	
	@FXML
	private Label lblTotalPayemnts;
	
	@FXML
	private Label lblTotalInterest;
	
	@FXML
	private DatePicker PaymentStartDate;
	
	@FXML
	private TextField AdditionalPayment;
	
	@FXML
	private TextField InterestRate;
	
	@FXML
	private TextField NbrOfYears;
	
	private static DecimalFormat df = new DecimalFormat("0.00");
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void setMainApp(StudentCalc sc) {
		this.SC = sc;
	}
	
	/**
	 * btnCalcLoan - Fire this event when the button clicks
	 * 
	 * @version 1.0
	 * @param event
	 */
	@FXML
	private void btnCalcLoan(ActionEvent event) {

		System.out.println("Amount: " + LoanAmount.getText());
		double dLoanAmount = Double.parseDouble(LoanAmount.getText());
		System.out.println("Amount: " + dLoanAmount);
		
		double dInterestRate = Double.parseDouble(InterestRate.getText());
		double dTermLoan = Double.parseDouble(NbrOfYears.getText());
		double dAdditionalPayment = Double.parseDouble(AdditionalPayment.getText());
		
		Loan l = new Loan(dInterestRate, dTermLoan,dLoanAmount,dAdditionalPayment);
		
		double TotalPay = l.getTotalPay();
		double TotalInterest = l.getTotalInt();
		
		double rTP = (double) Math.round(TotalPay * 100) / 100;
		double rTI = (double) Math.round(TotalInterest * 100) / 100;
		
		
		lblTotalPayemnts.setText(Double.toString(rTP));
		lblTotalInterest.setText(Double.toString(rTI));
		
		LocalDate localDate = PaymentStartDate.getValue();
	 
		System.out.println(localDate);
	}
}
