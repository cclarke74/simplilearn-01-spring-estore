package com.simplilearn.estore.jpa;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the SHIPMENTS database table.
 * 
 */
@Entity
@Table(name="SHIPMENTS")
@NamedQuery(name="Shipment.findAll", query="SELECT s FROM Shipment s")
public class Shipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shipmentId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date expectedDeliveryDate;

	private String shipmentCompany;

	@Temporal(TemporalType.TIMESTAMP)
	private Date shipmentDate;

	private String shipmentMethod;

	private int shipmentStatus;

	private String shipmentTitle;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;

	public Shipment() {
	}

	public int getShipmentId() {
		return this.shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Date getExpectedDeliveryDate() {
		return this.expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public String getShipmentCompany() {
		return this.shipmentCompany;
	}

	public void setShipmentCompany(String shipmentCompany) {
		this.shipmentCompany = shipmentCompany;
	}

	public Date getShipmentDate() {
		return this.shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getShipmentMethod() {
		return this.shipmentMethod;
	}

	public void setShipmentMethod(String shipmentMethod) {
		this.shipmentMethod = shipmentMethod;
	}

	public int getShipmentStatus() {
		return this.shipmentStatus;
	}

	public void setShipmentStatus(int shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	public String getShipmentTitle() {
		return this.shipmentTitle;
	}

	public void setShipmentTitle(String shipmentTitle) {
		this.shipmentTitle = shipmentTitle;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}