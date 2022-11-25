import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        List<Vertice> vertices = new ArrayList<Vertice>();
        boolean direcionado = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("./src/configs.txt"));
            
            String line = reader.readLine();
            System.out.println("Direcionado? " + line);
            String isDirecionado = line;

            if(isDirecionado.toLowerCase().equals("s")){
                direcionado = true;
            }

            line = reader.readLine();

            int numeroDeVertices = Integer.parseInt(line);
            line = reader.readLine();
            
            for(int i = 0; i < numeroDeVertices; i++){
                Vertice vertice = new Vertice(line.trim());
                vertices.add(vertice);
                line = reader.readLine();
            }

            Grafo grafo = new Grafo(direcionado);
            for(Vertice v : vertices){
                grafo.adicionaVertice(v);
            }

            while(line != null){
                line = line.replaceAll(" ", "");
                System.out.println(line);
                String s1 = line.split(",")[0].toString();
                String s2 = line.split(",")[1].toString();

                int peso = Integer.parseInt(line.split(",")[2]);

                boolean foundV1 = false;
                boolean foundV2 = false;
                int indexOfV1 = -1;
                int indexOfV2 = -1;
                for(Vertice v : vertices){
                    if(v.nomeVertice.equals(s1)){
                        foundV1 = true;
                        indexOfV1 = vertices.indexOf(v);

                    } else if(v.nomeVertice.equals(s2)){
                        foundV2 = true;
                        indexOfV2 = vertices.indexOf(v);
                    }

                    if(foundV1 && foundV2){
                        System.out.println("______");

                        grafo.conecta(vertices.get(indexOfV1), vertices.get(indexOfV2), new Aresta(peso));
                        foundV1 = false;
                        foundV2 = false;
                    }
                }

                line = reader.readLine();
            }
            reader.close();

            FloydWarshall floyd = new FloydWarshall(grafo);
		    floyd.calcularMenorCaminho();

        } catch(IOException e) {
            e.printStackTrace();
        }

        
    }
}
