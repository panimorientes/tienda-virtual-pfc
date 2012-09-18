package presentacion.actions;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;
import com.opensymphony.xwork2.ActionSupport;

public class AnadirAlCarro extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Integer> ops;
	private int count;
	private int ref;

	public AnadirAlCarro() {
		super();
		ops = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++)
			ops.add(i);
	}

	public List<Integer> getOps() {
		return ops;
	}

	public void setOps(List<Integer> ops) {
		this.ops = ops;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public String execute() {
		return SUCCESS;
	}

}
