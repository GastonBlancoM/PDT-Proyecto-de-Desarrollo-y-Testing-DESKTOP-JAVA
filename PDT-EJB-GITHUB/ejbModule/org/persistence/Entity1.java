package org.persistence;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Entity1 implements Serializable {

	private static final long serialVersionUID = 1L;

	public Entity1() {
	}

	@Id
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}