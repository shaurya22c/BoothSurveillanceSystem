package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity


@Table(name="area")

public class AreaVO
	{
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="areaId")
		private int areaId;
		
		@Column(name="areaName")
		private String areaName;
		
		@Column(name="areaDescription")
		private String areaDescription;
		
		public boolean isStatus() {
			return status;
		}


		public void setStatus(boolean status) {
			this.status = status;
		}


		@Column
		private boolean status=true;
		
		@ManyToOne CityVO cityVO;
		public CityVO getCityVO() {
			return cityVO;
		}


		public void setCityVO(CityVO cityVO) {
			this.cityVO = cityVO;
		}


		


		public int getAreaId() {
			return areaId;
		}


		public void setAreaId(int areaId) {
			this.areaId = areaId;
		}


		public String getAreaName() {
			return areaName;
		}


		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}


		public String getAreaDescription() {
			return areaDescription;
		}


		public void setAreaDescription(String areaDescription) {
			this.areaDescription = areaDescription;
		}

						
	}
