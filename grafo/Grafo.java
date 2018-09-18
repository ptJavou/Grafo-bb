package grafo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grafo {
	
	private static int[] R;					//array com as distancias de cada vértice com  relação á capital
	private int count;
	
	public int[] calcularDistancias(int[] T) {
		
		R = new int[T.length - 1];			//criei o array R como atributo da classe para poder acessar nas funções mais abaixo
		
		Vertice capital = null;
		
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();		//cria uma lista vazia de vertices 
		
		for(int i = 0 ; i < T.length ; i++) {						//realiza um loop de 0 até T-1
			/**Em cada iteração atribui o valor de i a um novo vértice em seguida adiciona a lista**/
			Vertice vertice = new Vertice();
			vertice.setElemento(i);
			vertices.add(vertice);
		}
		
		
		//Ligação dos vértices, praticamente uma árvore em que a raiz será a capital
		
		for(int i = 0 ; i < T.length ; i++) {		//novamente realiza o loop no array
			Vertice vertice1 = vertices.get(i);		//obtém o vértice da posicao i da lista
			
			for(int j = 0 ; j < T.length ; j++) {		//realizo outro loop para descobrir qual vertice da lista aponta para o vertice1 
				
				if(T[j] == vertice1.getElemento()) {		//verifica se o valor T[j] é igual ao vértice1
					
					Vertice vertice2 = vertices.get(j);		//obtém o vértice que aponta para o vértice1
					
					if(vertice1.getElemento() != vertice2.getElemento()) {	//verifico se os dois vertices são diferentes
						add(vertice1, vertice2); 			//aponta um vértice para o outro e vice versa (ver o método add)
					}else {
						capital = vertice1;					//se for igual é uma capital
					}
					
				}
			}
		}
		//com a árvore montada e a raiz armazenada na variável capital
		//é possivel contar quantos elementos possui em cada camada da árvode a partir da raiz
		//é feito utilizando recursão na função obterQuantidadeVerticesEmCamada
		
		verticesPais = Arrays.asList(capital);				//o vértice pai inicial ou a raiz será a capital
		obterQuantidadeVerticesEmCamada(verticesPais);
		
		return R;
	}
	
	
	//Cada vértice possui uma lista de vertices, que são os vértices que ele aponta
	//essa função adiciona um vértice na lista do outro, um duplo apontamento
	
	public static void add(Vertice vertice1, Vertice vertice2){
		vertice1.addVertice(vertice2);
		vertice2.addVertice(vertice1);
	}
	
	
	
	
	private List<Vertice> verticesPais;							//armazeno todos os vertices pais nessa lista
	
	//realiza o algoritmo BFS, acho que não é a melhor implementação pois a cada vértice verificado
	//preciso checar se não é o vertice pai, ja que o filho também aponta pro pai
	
	public void obterQuantidadeVerticesEmCamada(List<Vertice> camadaVertices) { 
		
		int n = 0;											//contagem de vértices na camada verificada

		ArrayList<Vertice> verticesFilhos = new ArrayList<>();	//armazena os vertices filhos, ou a proxima camada
		
		for(Vertice vertice : camadaVertices) {				//loop na camada de vértices atual
			
			for(Vertice v : vertice.getVertices()) {		//para cada vértice obtem os vértices filhos
				if(isPai(v) == false) {						//verifica se não é o vértice pai
					n++;									//incrementa o numero de vértices nesta camada
					verticesFilhos.add(v);					//adiciona a lista de vertices filhos
				}
			}
			
		}
		
		verticesPais = camadaVertices;						//a camada atual passa a ser a camada pai
		
		if(!verticesFilhos.isEmpty()) {						//quando não houver mais filhos a recursão para
			
			R[count++] = n;									//salva a quantidade de vértices no array resultante
			obterQuantidadeVerticesEmCamada(verticesFilhos);
		}
	}
	
	public boolean isPai(Vertice vertice) {
		for(Vertice pai : verticesPais) {
			if(vertice == pai)
				return true;
		}
		return false;
	}
	
	
}





