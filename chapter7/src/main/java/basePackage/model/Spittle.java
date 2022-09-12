package basePackage.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="SPITTLE")
public class Spittle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="spitter_id")
    private Spitter spitter;

    @Column(name="spittle_text")
    @NotNull
    private String text;

    @Column(name="posted_time")
    @DateTimeFormat(pattern="hh:mma MMM d, YYYY")
    private Date when;

    public Spittle() {
        this.spitter = new Spitter();  // HARD-CODED FOR NOW
        this.spitter.setId((long)1);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Date getWhen() {
        return this.when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public Spitter getSpitter() {
        return this.spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }

}
