package org.springframework.roo.addon.dbre.model;

import java.io.Serializable;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Represents a database foreign key.
 * 
 * @author Alan Stewart
 * @since 1.1
 */
public class ForeignKey implements Serializable {
	private static final long serialVersionUID = -7679438879219261466L;

	/** The name of the foreign key, may be <code>null</code>. */
	private String name;

	/** The target table. */
	private Table foreignTable;

	/** The name of the foreign table. */
	private String foreignTableName;

	/** The action to perform when the value of the referenced column changes. */
	private CascadeAction onUpdate = CascadeAction.NONE;

	/** The action to perform when the referenced row is deleted. */
	private CascadeAction onDelete = CascadeAction.NONE;

	/** The references between local and remote columns. */
	private SortedSet<Reference> references = new TreeSet<Reference>();

	ForeignKey() {
	}

	ForeignKey(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Table getForeignTable() {
		return foreignTable;
	}

	public void setForeignTable(Table foreignTable) {
		this.foreignTable = foreignTable;
	}

	public String getForeignTableName() {
		return foreignTableName;
	}

	public void setForeignTableName(String foreignTableName) {
		this.foreignTableName = foreignTableName;
	}

	public CascadeAction getOnUpdate() {
		return onUpdate;
	}

	public void setOnUpdate(CascadeAction onUpdate) {
		this.onUpdate = onUpdate;
	}

	public CascadeAction getOnDelete() {
		return onDelete;
	}

	public void setOnDelete(CascadeAction onDelete) {
		this.onDelete = onDelete;
	}

	public Set<Reference> getReferences() {
		return references;
	}

	public void addReference(Reference reference) {
		if (reference != null) {
			references.add(reference);
		}
	}

	public boolean hasLocalColumn(Column column) {
		for (Reference reference : references) {
			if (reference.getLocalColumn().equals(column)) {
				return true;
			}
		}
		return false;
	}

	public boolean hasForeignColumn(Column column) {
		for (Reference reference : references) {
			if (reference.getForeignColumn().equals(column)) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return String.format("ForeignKey [name=%s, foreignTableName=%s, onUpdate=%s, onDelete=%s, references=%s]", name, foreignTableName, onUpdate, onDelete, references);
	}
}