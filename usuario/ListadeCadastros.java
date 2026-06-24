package usuario;
import java.util.ArrayList;
import java.util.List;

public class ListadeCadastros<T> {

	private List<T> lista;
	
	public ListadeCadastros() {
		
		this.lista = new ArrayList<>();
	}

	public void adicionar(T item) {

		this.lista.add(item);
	}
	
	public List<T> getLista(){
		return this.lista;
	}
}
