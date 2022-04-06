package Ejemplo1;

import java.util.List;
import java.util.function.Predicate;

import us.lsi.common.List2;
import us.lsi.graphs.virtual.VirtualVertex;

public record MulticonjuntoVertex(Integer indice, Integer sr_suma_restante) implements VirtualVertex<MulticonjuntoVertex, MulticonjuntoEdge, Integer>{
	
	//factorias vacias
	public static MulticonjuntoVertex of() {
		return new MulticonjuntoVertex(0, DatosMultiConjunto.getSuma());
	}
	
	public static MulticonjuntoVertex of(Integer i, Integer sr) {
		return new MulticonjuntoVertex(i, sr);
	}
	
	//metodos auxiliares
	public String toString() {
		return String.format("(Indice: %d, Asignacion actual: %d", this.indice, this.sr_suma_restante);
	}
	
	public Integer max_divisor() {
		Integer max_div = this.sr_suma_restante/DatosMultiConjunto.getElemento(this.indice);
		if(this.sr_suma_restante<0) {
			return 0;
		}
		else {
			return max_div;
		}
	}
	
	//metodos del grafo
	public static MulticonjuntoVertex initial(){
		return new MulticonjuntoVertex(0, DatosMultiConjunto.getSuma());
	}
	
	public static MulticonjuntoVertex lastVertex() {
		return new MulticonjuntoVertex(DatosMultiConjunto.getNumElementos(), 0);
	}
	
	public static Predicate<MulticonjuntoVertex> goal(){
		return v->v.indice() == DatosMultiConjunto.getNumElementos();
	}
	
	public static Predicate<MulticonjuntoVertex> constraint(){
		return v->v.sr_suma_restante()==0;
	}

	@Override
	public List<Integer> actions() {
		List<Integer> alternativas = List2.empty();
		if(this.indice<DatosMultiConjunto.getNumElementos()) {
			if(this.indice == DatosMultiConjunto.getNumElementos() - 1) {
				if(this.sr_suma_restante % DatosMultiConjunto.getElemento(this.indice)==0) {
					alternativas.add(max_divisor());
				}
				else {
					alternativas = List2.rangeList(0, max_divisor()+1);
				}
			}
		}
		return alternativas;
	}

	@Override
	public MulticonjuntoVertex neighbor(Integer a) {
		Integer suma_restante_nueva = sr_suma_restante - (DatosMultiConjunto.getElemento(this.indice)*a);
		return MulticonjuntoVertex.of(this.indice+1, suma_restante_nueva);
	}

	@Override
	public MulticonjuntoEdge edge(Integer a) {
		return MulticonjuntoEdge.of(this, this.neighbor(a), a);
	}
	
}
