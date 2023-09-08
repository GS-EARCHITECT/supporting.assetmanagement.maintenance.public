package assetmaintenance_class_master.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import assetmaintenance_class_master.model.master.AssetMaintenanceClassMaster;
import assetmaintenance_class_master.model.master.AssetMaintenanceClassMasterPK;

@Repository("assetMaintenanceClassMasterPublicReadRepo")
public interface AssetMaintenanceClassMasterPublicRead_Repo extends JpaRepository<AssetMaintenanceClassMaster, AssetMaintenanceClassMasterPK> 
{
	@Query(value = "SELECT * FROM ASSET_MASTER a WHERE a.resource_seq_no in :ids order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<AssetMaintenanceClassMaster> getSelectClassesByResources(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ASSET_MASTER a WHERE a.party_seq_no in :ids order by party_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<AssetMaintenanceClassMaster> getSelectClassesByParties(@Param("ids") CopyOnWriteArrayList<Long> ids);

	@Query(value = "SELECT * FROM ASSET_MASTER a order by resource_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<AssetMaintenanceClassMaster> getAllAssetClasses();
	
}