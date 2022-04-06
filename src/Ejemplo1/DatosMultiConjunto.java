package Ejemplo1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import us.lsi.common.Files2;

public class DatosMultiConjunto {

	public static int SUMA;
	public static List<Integer> numeros;
	
	public static void iniDatos(String linea) {
		String[] tokens = linea.split(":");
		SUMA = Integer.parseInt(tokens[1].trim());
		SortedSet<Integer> nums = new TreeSet<>();
		for (String x:tokens[0].split(",")) {
			nums.add(Integer.parseInt(x.trim()));
		}
		numeros = new ArrayList<>(numeros);
	}
	
	public static void heuristicSort() {
		Collections.sort(numeros,(v1,v2)->v2.compareTo(v1));
	}
	
	public static Integer getSuma() {
		return SUMA;
	}
	
	public static Integer getNumElementos() {
		return numeros.size();
	}
	
	public static Integer getElemento(Integer i) {
		return numeros.get(i);
	}
	
	public static Integer getMultiplicidad(Integer i) {
		Integer res = 0;
		if(getElemento(i)>0 && SUMA >= getElemento(i)) {
			res = SUMA/getElemento(i);
		}
		return res;
	}
	
	public static List<Integer> getNumeros(){
		return numeros;
	}
	
	//test
	public static void main(String[] args) {
		Files2.linesFromFile("ficherosEjemplos/Ejemplo1DatosEntrada.txt").forEach(e->iniDatos(e));
	}
}
