package Aufgabe_23;

public class Graphen {
	private double[][] am;
	
	public Graphen(int n){
		am = new double[n][n];
		for (int i = 0; i < am.length; i++) {
			for (int j = 0; j < am[i].length; j++) {
				am[i][j] = 0;
			}
		}
	}
	public void setEdge(int id1, int id2, double value){
		if ((id1 < am.length && id1 >= 0)&&(id2 < am[id1].length && id2 >= 0)) {
			if (value < 1) {
				am[id1][id2] = 0;
				am[id2][id1] = 0;
			} else if(value >=1){
				am[id1][id2] = 1;
				am[id2][id1] = 1;
			}// TODO Ansehen (Da wir das gestern im Tutorium hatten, habe ich die auskommentierte Symmetrie wieder eingebunden.)
		}
	}
	public String toString(){
		String temp = "";
		for (int i = 0; i < am.length; i++) {
			for (int j = 0; j < am[i].length; j++) {
				temp += "Value at: " + i + "/" + j + "=" + am[i][j] + "\n";
			}
		}
		return temp;
		
		//TODO Denkt mal dar�ber nach, ob das vielleicht besser w�re  
//		String temp = "";
//		for (int i = 0; i < am.length; i++) {
//			for (int j = 0; j < am[i].length; j++) {
//				temp += am[i][j] + " ";
//			}
//			temp += "\n";
//		}
//		return temp;
	}
	public Graphen generateTransitiveClosure(){
//		Graphen temp = this;
		Graphen temp = new Graphen(am.length);
		for (int i = 0; i < temp.am.length; i++) {
			temp.am[i] = am[i].clone();
		}
		// TODO �berpr�fen - Ich bin davon ausgegangen, Leon h�tte hier sonst alles richtig gemacht.
		for (int k = 0; k < am.length; k++) {
			for (int i = 0; i < am.length; i++) {
				if (am[i][k] == 1) {
					for (int j = 0; j < am.length; j++) {
						if (am[k][j] == 1) {
							temp.setEdge(i, j, 1);
							temp.setEdge(j, i, 1);
						}
					}
				}
			}
		}
		return temp;
	}
	public String doDepthFirstSearch(){
		//TODO Kein Plan, Leute. :D
		return null;
	}
	public void eliminateCycle(){
		//TODO �berpr�fen
		for (int i = 0; i < am.length; i++) {
			if(am[i][i] > 0)
				am[i][i] = 0;
		}
	}
}
