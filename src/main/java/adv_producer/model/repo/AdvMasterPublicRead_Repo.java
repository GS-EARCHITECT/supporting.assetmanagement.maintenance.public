package adv_producer.model.repo;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import adv_producer.model.master.AdvMaster;

@Transactional(propagation=Propagation.REQUIRES_NEW)
@Repository("advMasterPublicReadRepo")
public interface AdvMasterPublicRead_Repo extends JpaRepository<AdvMaster, Long> 
{
	@Query(value = "SELECT * FROM ADV_MASTER a WHERE a.ADV_SEQ_NO in :ids order by ADV_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AdvMaster> getSelectAds(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ADV_MASTER a order by ADV_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AdvMaster> getAllAds();

}