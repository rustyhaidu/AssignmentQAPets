package tests.APITests.models;

import java.util.Objects;

public class Pet {

    private int id;
    private String name;
    private String status;

    public Pet() {

    }

    public Pet(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public Pet(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return getId() == pet.getId() &&
                Objects.equals(getName(), pet.getName()) &&
                Objects.equals(getStatus(), pet.getStatus());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getStatus());
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
