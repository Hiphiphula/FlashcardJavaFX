package application;

public class AnsQues extends GlobalVariable{
	String Ans;
	String Ques;
	
	public AnsQues(String Ans, String Ques)
	{
		super();
		this.Ans = Ans;
		this.Ques = Ques;
	}
	
	public String getAns() {
		return Ans;
	}

	public void setAns(String ans) {
		Ans = ans;
	}

	public String getQues() {
		return Ques;
	}

	public void setQues(String ques) {
		Ques = ques;
	}
	
	
	
}
