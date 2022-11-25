import java.util.ArrayList;

public class Grafo {
    public ArrayList<Vertice> vertices;
    public ArrayList<Vertice> visitados;
    public boolean direcionado;

    public Grafo(boolean direcionado) {
      vertices = new ArrayList<Vertice>();
      this.direcionado = direcionado;
    }

    public void adicionaVertice(Vertice vertice) {
      vertices.add(vertice);
    }
  
    public void conecta(Vertice vertice1, Vertice vertice2, Aresta aresta) {
      vertice1.adicionaAresta(aresta, vertice2);
      if(!direcionado) vertice2.adicionaAresta(aresta, vertice1);
    }
  
    public String getGrafo() {
      String grafo = "";

      for (Vertice v : vertices) {
        grafo += v.nomeVertice + " -> " + v.direcao.toString() + "\n";
      }

      return grafo;
    }

    public int getSize() {
      return vertices.size();
    }

    public ArrayList<Vertice> getVertices() {
      return vertices;
    }
}
