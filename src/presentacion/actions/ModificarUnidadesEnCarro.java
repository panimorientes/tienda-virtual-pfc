package presentacion.actions;

import java.util.LinkedList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ModificarUnidadesEnCarro extends ActionSupport {
		
	private List<String> uds;
	
	private String udCount;
	
	private static final long serialVersionUID = 1L;

	public ModificarUnidadesEnCarro(){
		uds = new LinkedList<String>();
		for(int i=1; i <= 20; i++){
			uds.add("" + i);
		}
	}
	
	public String execute(){
		return SUCCESS;		
	}

	public String getUdCount() {
		return udCount;
	}

	public void setUdCount(String udCount) {
		this.udCount = udCount;
	}

	public List<String> getUds() {
		return uds;
	}

	public void setUds(List<String> uds) {
		this.uds = uds;
	}

}
