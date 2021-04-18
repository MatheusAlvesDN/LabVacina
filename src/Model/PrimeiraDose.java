package Model;

import java.util.Calendar;

public class PrimeiraDose extends Status{
	long data;
	Calendar calendar = Calendar.getInstance();
	
	public PrimeiraDose() {
		data = calendar.getTimeInMillis();
	}
	
	public PrimeiraDose(long data) {
		this.data = data;
	}
	
	public String getStatus() {
		return "Primeira dose já aplicada! Na fila para receber a segunda dose!";
	}
	
	public void changeStatus() {
	}
	
	public boolean doseDisp() {
		if((Calendar.getInstance().getTimeInMillis() - data) > 1641600)
			return true;
		return false;
	}
	
	
	public Status newStatus() {
		if((Calendar.getInstance().getTimeInMillis() - data) > 1641600)
			return new SegundaDose();
		return new PrimeiraDose(data);
	}
}
