package Model;

import java.io.Serializable;

public final class Client implements Cloneable , Serializable{
	
	private static final long serialVersionUID = 1L;
	private String fullName;
	private String phoneNumber;
	
	public Client(String fullName, String phoneNumber) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//14
	@Override
	public boolean equals(Object obj) {
		if(this.getClass().equals(obj.getClass())) {
			if(this.phoneNumber.equals(((Client)obj).phoneNumber)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Client: Full name: " + fullName + " , Phone number: " + phoneNumber + " .";
	}

	@Override
	protected Client clone() throws CloneNotSupportedException {
		Client temp = (Client)super.clone();
		temp.fullName = fullName + "";
		temp.phoneNumber = phoneNumber + "";
		return temp;
	}
	
	
	
	
	
	

}
