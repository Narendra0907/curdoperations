package TestDebugging.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="User")
@Entity
@Data
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userDesg;
    @OneToOne
    private Passport passport;
}
