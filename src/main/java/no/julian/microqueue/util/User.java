package no.julian.microqueue.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@Table(name = "USER")
public class User {
    @Id
	@Expose
	@SerializedName("id")
	private String id;

	@Expose
	@SerializedName("name")
	private String name;

	@Transient
    private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
