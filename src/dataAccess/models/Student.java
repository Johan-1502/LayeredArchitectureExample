package dataAccess.models;

public class Student {
    private String firstName;
    private String lastName;
    private String identityDocument;
    
    public Student(String firstName, String lastName, String identityDocument) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getIdentityDocument() {
        return identityDocument;
    }
    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    @Override
    public String toString() {
        return "Nombre: " + firstName + " " + lastName + ", Documento de identidad: " + identityDocument;
    }

    
}
