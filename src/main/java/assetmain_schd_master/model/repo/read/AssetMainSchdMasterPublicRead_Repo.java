package assetmain_schd_master.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import assetmain_schd_master.model.master.AssetMainSchdMaster;
import assetmain_schd_master.model.master.AssetMainSchdMasterPK;

@Repository("assetMainSchdMasterPublicReadRepo")
public interface AssetMainSchdMasterPublicRead_Repo extends JpaRepository<AssetMainSchdMaster, AssetMainSchdMasterPK> 
{
	@Query(value = "SELECT * FROM ASSET_MAIN_SCHD_MASTER a WHERE a.RESSRVPRD_SEQ_NO in :ids order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AssetMainSchdMaster> getSelectScheduleMasters(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ASSET_MAIN_SCHD_MASTER a order by RESSRVPRD_SEQ_NO", nativeQuery = true)
	CopyOnWriteArrayList<AssetMainSchdMaster> getAllScheduleMasters();
}