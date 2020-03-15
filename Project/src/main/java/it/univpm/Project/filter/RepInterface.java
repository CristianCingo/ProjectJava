package it.univpm.Project.filter;

import java.util.List;

/**
 * Interfaccia generica di una repository di elementi di tipo generico T, contenente dei metodi elementari.
 *
 * @param <T>
 */


public interface RepInterface<T> {
	 void add(T item);
	 void update(T item);
	 void remove(T item);
	 List<T> query(String filter);
	 List<T> getAll();

}
