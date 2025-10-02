package react_backend.be_project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import react_backend.be_project.Entity.Contact;

public interface Contactrepo extends JpaRepository<Contact,Long> {
}
