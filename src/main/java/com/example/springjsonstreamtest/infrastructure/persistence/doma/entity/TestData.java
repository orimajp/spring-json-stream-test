package com.example.springjsonstreamtest.infrastructure.persistence.doma.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "test_data")
public class TestData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dummy1")
    private String dummy1;

    @Column(name = "dummy2")
    private String dummy2;

    @Column(name = "dummy3")
    private String dummy3;

    @Column(name = "dummy4")
    private String dummy4;

    @Column(name = "dummy5")
    private String dummy5;

    @Column(name = "dummy6")
    private String dummy6;

    @Column(name = "dummy7")
    private String dummy7;

    @Column(name = "dummy8")
    private String dummy8;

    @Column(name = "dummy9")
    private String dummy9;

    @Column(name = "dummy10")
    private String dummy10;

    @Column(name = "dummy11")
    private String dummy11;

    @Column(name = "dummy12")
    private String dummy12;

    @Column(name = "dummy13")
    private String dummy13;

    @Column(name = "dummy14")
    private String dummy14;

    @Column(name = "dummy15")
    private String dummy15;

    @Column(name = "dummy16")
    private String dummy16;

    @Column(name = "dummy17")
    private String dummy17;

    @Column(name = "dummy18")
    private String dummy18;

    @Column(name = "dummy19")
    private String dummy19;

    @Column(name = "dummy20")
    private String dummy20;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
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

    public String getDummy1() {
        return dummy1;
    }

    public void setDummy1(String dummy1) {
        this.dummy1 = dummy1;
    }

    public String getDummy2() {
        return dummy2;
    }

    public void setDummy2(String dummy2) {
        this.dummy2 = dummy2;
    }

    public String getDummy3() {
        return dummy3;
    }

    public void setDummy3(String dummy3) {
        this.dummy3 = dummy3;
    }

    public String getDummy4() {
        return dummy4;
    }

    public void setDummy4(String dummy4) {
        this.dummy4 = dummy4;
    }

    public String getDummy5() {
        return dummy5;
    }

    public void setDummy5(String dummy5) {
        this.dummy5 = dummy5;
    }

    public String getDummy6() {
        return dummy6;
    }

    public void setDummy6(String dummy6) {
        this.dummy6 = dummy6;
    }

    public String getDummy7() {
        return dummy7;
    }

    public void setDummy7(String dummy7) {
        this.dummy7 = dummy7;
    }

    public String getDummy8() {
        return dummy8;
    }

    public void setDummy8(String dummy8) {
        this.dummy8 = dummy8;
    }

    public String getDummy9() {
        return dummy9;
    }

    public void setDummy9(String dummy9) {
        this.dummy9 = dummy9;
    }

    public String getDummy10() {
        return dummy10;
    }

    public void setDummy10(String dummy10) {
        this.dummy10 = dummy10;
    }

    public String getDummy11() {
        return dummy11;
    }

    public void setDummy11(String dummy11) {
        this.dummy11 = dummy11;
    }

    public String getDummy12() {
        return dummy12;
    }

    public void setDummy12(String dummy12) {
        this.dummy12 = dummy12;
    }

    public String getDummy13() {
        return dummy13;
    }

    public void setDummy13(String dummy13) {
        this.dummy13 = dummy13;
    }

    public String getDummy14() {
        return dummy14;
    }

    public void setDummy14(String dummy14) {
        this.dummy14 = dummy14;
    }

    public String getDummy15() {
        return dummy15;
    }

    public void setDummy15(String dummy15) {
        this.dummy15 = dummy15;
    }

    public String getDummy16() {
        return dummy16;
    }

    public void setDummy16(String dummy16) {
        this.dummy16 = dummy16;
    }

    public String getDummy17() {
        return dummy17;
    }

    public void setDummy17(String dummy17) {
        this.dummy17 = dummy17;
    }

    public String getDummy18() {
        return dummy18;
    }

    public void setDummy18(String dummy18) {
        this.dummy18 = dummy18;
    }

    public String getDummy19() {
        return dummy19;
    }

    public void setDummy19(String dummy19) {
        this.dummy19 = dummy19;
    }

    public String getDummy20() {
        return dummy20;
    }

    public void setDummy20(String dummy20) {
        this.dummy20 = dummy20;
    }

}
