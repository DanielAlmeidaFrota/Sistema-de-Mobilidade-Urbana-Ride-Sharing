package corrida;

public class CategoriaServico {
	
	private float valor; 
	
	public CategoriaServico() {
		
	}

	public float calcularPreco(String categoria, double distancia) {
        float tarifaBase;
        float multiplicador;

        if (categoria.equalsIgnoreCase("L")) {
            tarifaBase = 9.0f;
            multiplicador = 2.2f; 
        } else {
            
            tarifaBase = 5.0f;
            multiplicador = 1.0f; 
        }

        this.valor = (float) (tarifaBase + ((distancia * 1.5) * multiplicador));
        
        return valor;
   }

		public float getValor() {
			return this.valor;
		}
		
}
	

