package Ejemplo1;

import java.util.function.Predicate;

public class MulticonjuntoHeuristic {

	public static Double heuristic(MulticonjuntoVertex v1, Predicate<MulticonjuntoVertex> goal, MulticonjuntoVertex v2) {
		return heuristic2(v1);
	}
	
	public static Double heuristic2(MulticonjuntoVertex v1) {
		Double h = 0.;
		
		if(v1.indice()+1<DatosMultiConjunto.getNumElementos()) {
			Integer h1 = v1.sr_suma_restante() / DatosMultiConjunto.getElemento(v1.indice()+1);
			if(h1*DatosMultiConjunto.getElemento(v1.indice()+1)<v1.sr_suma_restante()) {
				h1 = h1+1;
			}
			h = h1*1.0;
		}
		return h;
	}
}
