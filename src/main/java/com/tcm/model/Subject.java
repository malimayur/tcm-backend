package com.tcm.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	private static final long serialVersionUID = -3009157732242241603L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotEmpty
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Enrollment> enrollment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Set<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}

	@Override
	public String toString() {
		return String.format("Subject[id=%d, name='%s']", id, name);
	}
}