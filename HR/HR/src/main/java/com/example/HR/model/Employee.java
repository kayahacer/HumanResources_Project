package com.example.HR.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Bu benim model sınıfım

@Entity // bu sınıfın model sınıfı olduğunu belirtiyor
public class Employee {

    @Id // Bu anastasyon, 'id' alanının birincil anahtar olduğunu belirtir
    @GeneratedValue(strategy = GenerationType.IDENTITY) // bu 'id' alanının otomatik olarak artılacağını belirtir.

    private Long Id; // Çalışanın bensersiz kimliği
    private String name; // Çalışanın adı
    private String position; // Çalışanın pozisyonu

    // Getter ve Setter metotları
    //Getter özel alanların değerini okumak için kulllanılır
    //Setter özel alanların değerini ayarlamak için kullanılır


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
