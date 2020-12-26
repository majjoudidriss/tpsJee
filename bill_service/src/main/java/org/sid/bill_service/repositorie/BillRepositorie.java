package org.sid.bill_service.repositorie;

import org.sid.bill_service.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillRepositorie extends JpaRepository<Bill,Long> {
}
