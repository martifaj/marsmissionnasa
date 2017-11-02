package marsmissionnasa.domainlayer.dao;

import java.util.List;

import marsmissionnasa.domainlayer.entities.Entity;

public interface BaseDAO<E extends Entity> {
	public E create(E entity);
	public E read(String id);
	public List<E> readAll();
	public void update(E entity);
	public void delete(E entity);
}
