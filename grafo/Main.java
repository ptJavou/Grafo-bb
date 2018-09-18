package grafo;

public class Main {

	public static void main(String[] args) {
		
		int[] T = {9,1,4,9,0,4,8,9,0,1};							//Array de entrada
										
		Grafo grafo = new Grafo();
		int[] R = grafo.calcularDistancias(T);
		
		for(int i = 0 ; i < R.length ; i++) {						//printa o resultado final
			System.out.print(R[i]);
		}
	}
}
