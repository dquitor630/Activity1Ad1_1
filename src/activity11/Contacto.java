package activity11;


import java.io.Serializable;
import java.time.LocalDate;

public class Contacto implements Serializable {
    private String contactName, address;
    private int phone, postalCode;
    private LocalDate birthDate;
    private boolean lease;
    private double leaseQuantity;

    @Override
    public String toString() {
        return "Contacto{" +
                "contactName='" + contactName + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", postalCode=" + postalCode +
                ", birthDate=" + birthDate +
                ", lease=" + lease +
                ", leaseQuantity=" + leaseQuantity +
                '}';
    }

    public Contacto(String contactName, int phone, String address, int postalCode, boolean lease, double leaseQuantity, LocalDate birthDate){
        this.contactName = contactName;
        this.phone = phone;
        this.address = address;
        this.postalCode = postalCode;
        this.lease = lease;
        this.leaseQuantity = leaseQuantity;
        this.birthDate = birthDate;
    }

    public String getContactName() {
        return contactName;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public boolean isLease() {
        return lease;
    }

    public double getLeaseQuantity() {
        return leaseQuantity;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
