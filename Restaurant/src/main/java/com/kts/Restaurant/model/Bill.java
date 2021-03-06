package com.kts.Restaurant.model;

import java.util.Date;
import java.util.List;

import com.kts.Restaurant.util.DateStringConverter;
import org.springframework.data.neo4j.core.convert.ConvertWith;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;
import org.springframework.data.neo4j.core.support.DateString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

@Node
public class Bill {
	
	@Id @GeneratedValue
	private Long id;

	private double price;
	
	private double cost;

	@ConvertWith(converter =  DateStringConverter.class)
	private Date date;


	@Relationship(type = "HAD_WAITER", direction = Direction.OUTGOING)
	private User waiter;

	@Relationship(type = "BILLED_ITEM", direction = Direction.OUTGOING)
	public List<BilledItem> items;


	public Bill() {
		super();
	}

	public Bill(double cost,double price, Date date) {
		this.price = price;
		this.cost = cost;
		this.date = date;
	}

	public Bill(Long id, double price, double cost, Date date, List<BilledItem> items, User waiter) {
		super();
		this.id = id;
		this.price = price;
		this.cost = cost;
		this.date = date;
		this.items = items;
		this.waiter = waiter;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public double getPrice() {
		return price;
	}




	public void setPrice(double price) {
		this.price = price;
	}




	public double getCost() {
		return cost;
	}




	public void setCost(double cost) {
		this.cost = cost;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public List<BilledItem> getItems() {
		return items;
	}




	public void setItems(List<BilledItem> items) {
		this.items = items;
	}


	public User getWaiter() {
		return waiter;
	}

	public void setWaiter(User waiter) {
		this.waiter = waiter;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", price=" + price + ", cost=" + cost + ", date=" + date + ", items=" + items + "]";
	}
	
	
	

}
