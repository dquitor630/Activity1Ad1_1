package activity8;

import java.time.LocalDate;

public class Contacto {
    private String contactName;
    private int phone;
    private String address;
    private LocalDate birthDate;
    private int postalCode;
    private boolean lease;
    private double leaseQuantity;
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
