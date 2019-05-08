package kg.gov.mf.loan.doc.repository;

import kg.gov.mf.loan.doc.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("Select a from Account a where a.internalName = ?1 AND a.name LIKE %?2% order by a.name")
    List<Account> getByName(String internalName, String name);
}
