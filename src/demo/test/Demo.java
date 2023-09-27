package demo.test;

import org.json.JSONObject;

public class Demo {
	
	public static void main(String args[]) throws Exception
	{
		JSONObject obj = new JSONObject("{\"error_desc\":\"\",\"error_code\":\"\",\"payout_summary_list\":{\"payout_summary_details\":{\"ifsc_code\":\"UTIB0000114\",\"settlement_currency\":\"INR\",\"settlement_date\":\"13-07-2023\",\"trans_currency\":\"INR\",\"utr_no\":\"ICICR22023071300011432\",\"settlement_bank\":\"AXIS BANK\",\"pay_amount\":2757856.17,\"sub_acc_Id\":\"\",\"pay_Id\":1040627909,\"account_no\":923020007881077}}}");
		JSONObject jsonObject = obj.getJSONObject("payout_summary_list").getJSONObject("payout_summary_details");
		System.out.println(jsonObject.toString());
	}
	
}