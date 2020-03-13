package it.univpm.Project.filter;

import java.util.Collection;

/**
 * Interfaccia generica di un filtro applicato su un campo fieldName 
 * comprato mediante un operator con un value di tipo generico T. 
 * Il filtro restituisce una collezione di oggetti di tipo generico E
 * @param <E>
 * @param <T>
 */

public interface FilterInterface<E,T> {
	abstract Collection<E> filterField(String fieldName, String operator, T value);

}
