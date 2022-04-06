package Ejemplo1;

import java.util.List;

import org.jgrapht.GraphPath;

import us.lsi.common.Multiset;

public class SolucionMulticonjunto {

	public static SolucionMulticonjunto of(GraphPath<MulticonjuntoVertex, MulticonjuntoEdge> path) {
		List<Integer> la = path.getEdgeList().stream().map(e->e.action()).toList();
		return SolucionMulticonjunto.of(la);
	}
	
	public static SolucionMulticonjunto of(List<Integer> ls) {
		return new SolucionMulticonjunto(ls);
	}
	
	private Integer suma;
	private Multiset<Integer> solucion;
	private Integer solucionSize;
	
	private SolucionMulticonjunto(List<Integer> ls) {
		suma = 0;
		solucionSize = 0;
		solucion = Multiset.of();
		for (int i = 0; i < ls.size(); i++) {
			if(ls.get(i)>0) {
				Integer v = DatosMultiConjunto.getNumeros().get(i);
				solucion.add(v, ls.get(i));
				suma += v*ls.get(i);
				solucionSize += ls.get(i);
			}
		}
	}
	
	public String toString() {
		int error = Math.abs(DatosMultiConjunto.getSuma()-suma);
		return String.format("MS = %s; Tam = %d; error = %d", solucion, solucionSize, error);
	}
}
