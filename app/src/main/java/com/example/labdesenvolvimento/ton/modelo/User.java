package com.example.labdesenvolvimento.ton.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Lab. Desenvolvimento on 26/10/2017.
 */

public class User implements Serializable{
    public int  providerIdProvider;
    public String FirstName, LastName, Email, Rg, Cpf, Phone, CellPhone, Adress, Cep, Password;
    public Date data;
    public String provider;

    public User() {

    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getProviderIdProvider() {
        return providerIdProvider;
    }

    public void setProviderIdProvider(int providerIdProvider) {
        this.providerIdProvider = providerIdProvider;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        Rg = rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(String cellPhone) {
        CellPhone = cellPhone;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public User( int providerIdProvider, String FirstName, String LastName, String Email, String Rg, String Cpf, String Phone, String CellPhone, String Adress, String Cep, String Password, Date data, String provider) {

        this.providerIdProvider = providerIdProvider;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Rg = Rg;
        this.Cpf = Cpf;
        this.Phone = Phone;
        this.CellPhone = CellPhone;
        this.Cep = Cep;
        this.Password = Password;

        this.data = data;
        this.provider = provider;
        this.Adress = Adress;

    }
}
