package it.pietrantuono.skyitaly.network.model;

public class User {

    private int id;
    private String nome;
    private String cognome;
    private String comuneNascita;
    private String email;
    private String residenza;
    private String password;

    public User() {
        // TODO Auto-generated constructor stub
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getComuneNascita() {
        return comuneNascita;
    }

    public void setComuneNascita(String comuneNascita) {
        this.comuneNascita = comuneNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
