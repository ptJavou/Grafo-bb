package grafo;

import java.util.ArrayList;

public class Vertice {

	private int elemento;  									//numero do vértice ou nome da cidade
	private ArrayList<Vertice> vertices = new ArrayList<>();//array de vértices filhos
	
	public Vertice(int elemento) {
		this.elemento = elemento;
	}
	
	public Vertice() {
		
	}

	public int getElemento() {
		return elemento;
	}

	public void setElemento(int elemento) {
		this.elemento = elemento;
	}

	public void addVertice(Vertice vertice) {
		vertices.add(vertice);
	}
	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}
	
}
