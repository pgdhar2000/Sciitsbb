package com.sciits.blockbuster.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sciits.blockbuster.model.BaseData;

@Entity
@Table(name = "mbc_share_holder_details")
public class MbcShareHolderDetails extends BaseData {
		private static final long serialVersionUID = 5252390487367465535L;
		
		@Id
		@GeneratedValue
		@Column(name = "MBC_SHARE_HOLDER_ID", length = 20, nullable = false)
		private Long mbcShareHolderId;
		
		@Column(name = "SHARE_HOLDER_TYPE", length = 1, nullable = false)
		private char shareHolderType;
		
		@Column(name = "SHARE_HOLDER_NAME", length = 30, nullable = true)
		private String shareHolderName;
		
		@Column(name = "TOTAL_SHARES", length = 11, nullable = false)
		private Long totalShares;
		
		@OneToOne
		private CountryDetails countryDetails;
		
		@Column(name = "STATUS", length = 1, nullable = false)
		private char status;
		
		@Column(name = "PHONE", length = 15, nullable = false)
		private String phone;
		
		@OneToOne
		private MbcDetails mbcDetails;

		public MbcShareHolderDetails(){}
		
		public MbcShareHolderDetails(Long mbcShareHolderId, char shareHolderType, String shareHolderName,
				Long totalShares, CountryDetails countryDetails, char status, String phone, MbcDetails mbcDetails) {
			super();
			this.mbcShareHolderId = mbcShareHolderId;
			this.shareHolderType = shareHolderType;
			this.shareHolderName = shareHolderName;
			this.totalShares = totalShares;
			this.countryDetails = countryDetails;
			this.status = status;
			this.phone = phone;
			this.mbcDetails = mbcDetails;
		}

		public Long getMbcShareHolderId() {
			return mbcShareHolderId;
		}

		public void setMbcShareHolderId(Long mbcShareHolderId) {
			this.mbcShareHolderId = mbcShareHolderId;
		}

		public char getShareHolderType() {
			return shareHolderType;
		}

		public void setShareHolderType(char shareHolderType) {
			this.shareHolderType = shareHolderType;
		}

		public String getShareHolderName() {
			return shareHolderName;
		}

		public void setShareHolderName(String shareHolderName) {
			this.shareHolderName = shareHolderName;
		}

		public Long getTotalShares() {
			return totalShares;
		}

		public void setTotalShares(Long totalShares) {
			this.totalShares = totalShares;
		}

		public CountryDetails getCountryDetails() {
			return countryDetails;
		}

		public void setCountryDetails(CountryDetails countryDetails) {
			this.countryDetails = countryDetails;
		}

		public char getStatus() {
			return status;
		}

		public void setStatus(char status) {
			this.status = status;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public MbcDetails getMbcDetails() {
			return mbcDetails;
		}

		public void setMbcDetails(MbcDetails mbcDetails) {
			this.mbcDetails = mbcDetails;
		}
}
