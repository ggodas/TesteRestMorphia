package com.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.code.morphia.annotations.Entity;

@Entity("abastecimento")
@XmlRootElement
public class Abastecimento extends BaseEntity {

	private long numIndexDownload;
	private long codAbastecimento;
	private Date datAbast;
	private long codPosto;
	private float vlrUnit;
	private String endePost;
	private String fabric;
	
	
	public long getNumIndexDownload() {
		return numIndexDownload;
	}
	public void setNumIndexDownload(long numIndexDonload) {
		this.numIndexDownload = numIndexDonload;
	}
	public long getCodAbastecimento() {
		return codAbastecimento;
	}
	public void setCodAbastecimento(long codAbastecimento) {
		this.codAbastecimento = codAbastecimento;
	}
	public Date getDatAbast() {
		return datAbast;
	}
	public void setDatAbast(Date datAbast) {
		this.datAbast = datAbast;
	}
	public long getCodPosto() {
		return codPosto;
	}
	public void setCodPosto(long codPosto) {
		this.codPosto = codPosto;
	}
	public float getVlrUnit() {
		return vlrUnit;
	}
	public void setVlrUnit(float vlrUnit) {
		this.vlrUnit = vlrUnit;
	}
	public String getEndePost() {
		return endePost;
	}
	public void setEndePost(String endePost) {
		this.endePost = endePost;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
}
