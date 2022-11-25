import java.util.List;

public class FloydWarshall {

	public Grafo grafo;

    public FloydWarshall(Grafo grafo){
		this.grafo = grafo;
    }

	public void matriz() {
		for (int i = 0; i < grafo.vertices.size(); i++) {
			for (int j = 0; j < grafo.vertices.size(); j++) {
				if (distancia[i][j] == 99999) {
					System.out.print("i ");
				} else {
					System.out.print(distancia[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	public void calcularMenorCaminho() {
		for (int i = 0; i < grafo.vertices.size(); i++) {
			for (int k = 0; k < grafo.vertices.size(); k++) {
				for (int j = 0; j < grafo.vertices.size(); j++) {
					if (menorCaminho[k][i] + menorCaminho[i][j] < menorCaminho[k][j])
						menorCaminho[k][j] = menorCaminho[k][i] + menorCaminho[i][j];
				}
			}
		}
	}
}
