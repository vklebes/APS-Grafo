import java.util.HashMap;

public class Vertice {
    public String nomeVertice;
    public HashMap<Vertice, Aresta> direcao = new HashMap<Vertice, Aresta>();
	public boolean visitado = false;

    public Vertice(String nomeVertice) {
		this.nomeVertice = nomeVertice;
	}

    public String getNomeVertice() {
		return this.nomeVertice;
	}

	public HashMap<Vertice, Aresta> getDirecao() {
		return direcao;
	}

	public void adicionaAresta(Aresta aresta, Vertice destino) {
		this.direcao.put(destino, aresta);
	}

	public void setVisitado(boolean visitado){
		this.visitado = visitado;
	}

    public String toString() {
		return nomeVertice;
	}
}
