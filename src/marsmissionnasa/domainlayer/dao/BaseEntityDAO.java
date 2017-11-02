package marsmissionnasa.domainlayer.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import marsmissionnasa.domainlayer.entities.Entity;
import marsmissionnasa.domainlayer.indices.Index;

public abstract class BaseEntityDAO<E extends Entity> implements BaseDAO<E> {
	private Index<String, E> index;

	public BaseEntityDAO(Index<String, E> index) {
		this.index = index;
	}

	public E create(E entity) {
		index.add(entity.getId(), entity);
		return entity;
	}
	
	@Override
	public void update(E entity) {
		// Nothing to do
	}

	@Override
	public E read(String id) {
		return (E) index.find(id);
	}
	
	@Override
	public void delete(E entity) {
		index.delete(entity.getId());
	}
	
	@Override
	public List<E> readAll() {
		Set<String> keys = index.keys();
		List<E> elements = new ArrayList<E>(keys.size());
		for (String key : keys) {
			elements.add(index.find(key));
		}
		return elements;
	}
}
