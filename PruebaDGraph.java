/* PruebaDGraph.java
    CC2 Interciclo - 2021 - lab10 */ 

import java.util.*;
import java.io.*;

public class PruebaDGraph {

	private static boolean[][] randomGraph(int x) {
		// su implementacion
		return null;
	}
	
	private static void distancias(DirectedGraph dg, int estadoInicial, String[] estados) {
		// su implementacion
	}
	
	private static void shortestPath(DirectedGraph dg,int estadoInicial,int estadoFinal,String[] estados){
		// su implementacion
	}
	
	// NO CAMBIAR EL CODIGO DE ESTE METODO
	private static void printGraph(boolean[][] g, String[] e) {

		if ((e.length != 0) && (g.length == e.length)) {
			for (int i=0;i<g.length;i++) {
				if (g[i].length != e.length) {
					System.out.println("datos invalidos");
					return;
				}
			}
			String linea = "   +";
			for (int i=0;i<g.length;i++) linea += "-+";
			String columnas = "    ";
			for (int i=0;i<e.length;i++) columnas += (e[i].charAt(0) + " ");
			System.out.println(columnas);
			System.out.println(linea);
			for (int i=0;i<g.length;i++){
				System.out.print(" " + e[i].charAt(0) + " |");
				for (int j=0;j<g[i].length;j++){
					String value = (g[i][j]) ? "1" : "0";
					System.out.print(value + "|");
				}
				System.out.println();
				System.out.println(linea);
			}
		}
	}
			
			
	// NO CAMBIAR LOS VALORES DE ESTAS VARIABLES
	private static final String[] nombres = {"Arad","Bucharest","Craiova","Drobeta",
											 "Eforie","Fagaras","Giurgiu","Hirsova",
											 "Iasi","Lugoj","Mehadia","Neamt",
											 "Oradea","Pitesti","Rimnicu Vilcea","Sibui",
											 "Timisoara","Urziceni","Vaslui","Zerind"};
	private static final BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
	
	
	// NO CAMBIAR EL CODIGO DE ESTE METODO
	public static void main(String[] args) throws Exception {
		// creando arreglo ciudades a utilizar
		LinkedList<String> todos = new LinkedList<String>();
		for (int i=0;i<nombres.length;i++) todos.add(nombres[i]);
		String[] estados = new String[10];
		Random r = new Random();
		for (int i=0;i<estados.length;i++) {
			estados[i] = todos.remove(r.nextInt(todos.size()));
		}
		System.out.println("ESTADOS A UTILIZAR EN ESTA CORRIDA:");
		for (int i=0;i<estados.length;i++) {
			System.out.println (estados[i].charAt(0) + ": " + estados[i]);
		}
		System.out.println();
		System.out.print("Presione ENTER para continuar...");
		tec.readLine();
	
		// creando conexiones en el grafo aleatoriamente
		boolean[][] matGrafo = randomGraph(10);
		System.out.println("GRAFO GENERADO APARTIR DE ESTADOS");
		printGraph(matGrafo,estados);
		System.out.println();
	
		System.out.print("Presione ENTER para continuar...");
		tec.readLine();
		
		// creando objeto de tipo DirectedGraph
		DirectedGraph dg = new DirectedGraph(matGrafo);
		System.out.println("DIRECTED GRAPH generado apartir de matriz anterior:");
		System.out.println(dg);
		System.out.println();
		System.out.print("Presione ENTER para continuar...");
		tec.readLine();		
		
		// estado aleatorio para encontrar paths mas cortos entre ese estado y todos los demas.
		int estado = r.nextInt(estados.length);
		System.out.println("ESTADO ELEGIDO ALEATORIAMENTE:");
		System.out.println (estados[estado].charAt(0) + ": " + estados[estado]);
		// distancias mas cortas
		System.out.println("Distancias mas cortas desde ese estado a los demas: ");
		distancias(dg,estado,estados);
		System.out.println();
		System.out.print("Precione ENTER para continuar...");
		tec.readLine();		
	
		// distancia entre dos estados
		int estado1 = r.nextInt(estados.length);
		int estado2 = estado1;
		while (estado2 == estado1) estado2 = r.nextInt(estados.length);
		System.out.println("ESTADOS ELEGIDOS ALEATORIAMENTE: ");
		System.out.println("Inicial: " + estados[estado1].charAt(0) + ": " + estados[estado1]);
		System.out.println("Final: " + estados[estado2].charAt(0) + ": " + estados[estado2]);
		System.out.println("PATH:");
		shortestPath(dg,estado1,estado2,estados);
		System.out.println();
	}
}