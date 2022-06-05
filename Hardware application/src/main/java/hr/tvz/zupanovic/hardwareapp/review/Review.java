package hr.tvz.zupanovic.hardwareapp.review;

import hr.tvz.zupanovic.hardwareapp.hardware.Hardware;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "headline")
    private String headline;

    @Column(name = "text")
    private String text;

    @Column(name = "mark")
    private int mark;

    @ManyToOne
    @JoinColumn(name = "hardware_id")
    private Hardware hardware;

    public Review(int id, String headline, String text, int mark) {
        this.id = id;
        this.headline = headline;
        this.text = text;
        this.mark = mark;
    }

    protected Review() {
    }


    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public int getMark() {
        return mark;
    }
}
