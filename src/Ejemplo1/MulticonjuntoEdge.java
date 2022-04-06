package Ejemplo1;

import us.lsi.graphs.virtual.SimpleEdgeAction;

public record MulticonjuntoEdge(MulticonjuntoVertex source, MulticonjuntoVertex target, Integer action, Double weight)
		implements SimpleEdgeAction<MulticonjuntoVertex, Integer> {
	public static MulticonjuntoEdge of(MulticonjuntoVertex v1, MulticonjuntoVertex v2, Integer a) {
		return new MulticonjuntoEdge(v1, v2, a, a * 1.);
	}
}
