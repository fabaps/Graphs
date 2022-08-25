/*   DirectedGraph.java
    CC2 Interciclo 2021 - lab10 */ 

import java.util.LinkedList;

public class DirectedGraph {
	
	// no cambiar estos campos
	private boolean[][] matAdj;
	private int cantEstados;
	
	// no cambiar el codigo de este constructor
	public DirectedGraph(boolean[][] adj) throws NotValidGraph{
		int cantEstados = adj.length;
		for (int i=0; i<adj.length; i++) {
			if (adj[i].length != cantEstados) {
				throw new NotValidGraph(" matriz de adjacencia no cuadrada ");
			}
		}
		this.matAdj = adj;
    this.cantEstados = this.matAdj.length;
	}
	
	public LinkedList<Integer> getAdj(int estado) {
		return null;
	}
	
	public BfsResult bfs(int estado) {
		return null;
	}
	
	public int[] path(int estadoinicial, int estadofinal) {
		return null;
	}
	
	// NO CAMBIAR ESTE CODIGO
	public String toString() {
		String s = "";
		for (int i=0; i<matAdj.length; i++) {
			s += ("Estado " + i + " adjacencias: ");
			for (int j=0; j<matAdj[i].length; j++) {
				if (matAdj[i][j]) s+= (j + " ");
			}
			s += "\n";
		}
		return s;
	}
}

// NO CAMBIAR EL CODIGO DE ESTAS CLASES
class BfsResult {
	public static byte WHITE = 0;
	public static byte GRAY = 1;
	public static byte BLACK = 2;
	int estado;
	byte[] color;
	int[] distance;
	Integer[] predecessor;
	
	public BfsResult(int estado, int cantEstados) {
		this.estado = estado;
		color = new byte[cantEstados];
		distance = new int[cantEstados];
		predecessor = new Integer[cantEstados];
	}
}

class NotValidGraph extends Exception {
	public NotValidGraph(String msg) {
		super(msg);
	}
}