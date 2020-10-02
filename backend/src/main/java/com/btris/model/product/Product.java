package com.btris.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

import com.btris.model.user.Vendor;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;
	private String description;
	private int price;
	private String currency;
	private boolean is_approved;
	private String approved_by;
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "product")
	private List<Vendor> vendor;
	
}
