package co.nttdata.prueba.mapping.dto;

public record ClientDto (
        String firstName,
        String secondName,
        String firstLastName,
        String secondLastName,
        String phone,
        String address,
        String residenceCity){
    public String firstName() {
        return firstName;
    }

    public String secondName() {
        return secondName;
    }


    public String firstLastName() {
        return firstLastName;
    }

    public String secondLastName() {
        return secondLastName;
    }


    public String phone() {
        return phone;
    }

    public String address() {
        return address;
    }
    public String residenceCity() {
        return residenceCity;
    }



}

