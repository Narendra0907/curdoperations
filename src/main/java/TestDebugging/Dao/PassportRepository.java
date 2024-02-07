package TestDebugging.Dao;

import TestDebugging.Entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository  extends JpaRepository<Passport,Integer> {

}
