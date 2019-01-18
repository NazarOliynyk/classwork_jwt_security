package oktenweb.dao;



import oktenweb.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 18.01.19.
 */
public interface ContactDAO  extends JpaRepository<Contact, Integer> {
}

