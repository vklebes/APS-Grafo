public class Aresta {
    public int peso;

    public Aresta(int peso) {
		this.peso = peso;
	}

    public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

    @Override
	public String toString() {
		return "" + peso;
	}
}
