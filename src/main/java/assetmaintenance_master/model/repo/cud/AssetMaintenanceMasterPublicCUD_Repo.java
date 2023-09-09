package assetmaintenance_master.model.repo.cud;

import java.sql.Timestamp;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import assetmaintenance_master.model.master.AssetMaintenanceMaster;

@Repository("assetMaintenanceMasterPublicCUDRepo")
public interface AssetMaintenanceMasterPublicCUD_Repo extends JpaRepository<AssetMaintenanceMaster, Long> 
{
@Modifying
@Query(value = "update ASSET_MAINTENANCE_MASTER set okflag = 'Y' where ASSET_MAINTENANCE_SEQ_NO in :ids",nativeQuery = true) 
void setAssetsOK(@Param(value = "ids") CopyOnWriteArrayList<Long> ids);

@Modifying
@Query(value = "update ASSET_MAINTENANCE_MASTER set doneflag = 'Y' where ASSET_MAINTENANCE_SEQ_NO in :ids",nativeQuery = true) 
void setAssetsDone(@Param(value = "ids") CopyOnWriteArrayList<Long> ids);

@Modifying
@Query(value = "update ASSET_MAINTENANCE_MASTER set okflag = 'N' where ASSET_MAINTENANCE_SEQ_NO in :ids",nativeQuery = true) 
void setAssetsNotOK(@Param(value = "ids") CopyOnWriteArrayList<Long> ids);

@Modifying
@Query(value = "update ASSET_MAINTENANCE_MASTER set doneflag = 'N' where ASSET_MAINTENANCE_SEQ_NO in :ids",nativeQuery = true) 
void setAssetsNotDone(@Param(value = "ids") CopyOnWriteArrayList<Long> ids);

@Query(value = "delete FROM ASSET_MAINTENANCE_MASTER where MAINTENANCE_CLASS_SEQ_NO in :ids",nativeQuery = true) 
void delAssetsByClasses(@Param(value = "ids") CopyOnWriteArrayList<Long> ids);

@Query(value = "delete FROM ASSET_MAINTENANCE_MASTER where asset_SEQ_NO in :ids",nativeQuery = true) 
void delAssetsByAssets(@Param(value = "ids") CopyOnWriteArrayList<Long> ids);

@Query(value = "delete FROM ASSET_MAINTENANCE_MASTER where upper(trim(MAINTENANCE_ID)) in :ids",nativeQuery = true) 
void delAssetsByIds(@Param(value = "ids") CopyOnWriteArrayList<String> ids);

@Query(value = "deleteFROM ASSET_MAINTENANCE_MASTER where upper(trim(okflag))='Y'",nativeQuery = true) 
void delAssetsOK();

@Query(value = "delete FROM ASSET_MAINTENANCE_MASTER where upper(trim(doneflag))='Y'",nativeQuery = true) 
void delAssetsDone();

@Query(value = "delete FROM ASSET_MAINTENANCE_MASTER where upper(trim(okflag))<> 'Y'",nativeQuery = true) 
void delAssetsNotOK();

@Query(value = "delete FROM ASSET_MAINTENANCE_MASTER where upper(trim(doneflag))<> 'Y'",nativeQuery = true) 
void delAssetsNotDone();

@Query(value = "delete FROM ASSET_MAINTENANCE_MASTER where WHERE ((:fr BETWEEN PL_DTTM_FR and PL_DTTM_TO) and (:to BETWEEN PL_DTTM_FR and PL_DTTM_TO))",nativeQuery = true) 
void delAssetsBetweenPlanDTTM(@Param(value = "fr") Timestamp fr, @Param(value = "to") Timestamp to);

@Query(value = "delete FROM ASSET_MAINTENANCE_MASTER where WHERE ((:fr BETWEEN AC_DTTM_FR and AC_DTTM_TO) and (:to BETWEEN AC_DTTM_FR and AC_DTTM_TO))",nativeQuery = true) 
void delAssetsBetweenActualDTTM(@Param(value = "fr") Timestamp fr, @Param(value = "to") Timestamp to);
} 

