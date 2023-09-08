package assetmaintenance_class_master.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import assetmaintenance_class_master.model.dto.AssetMaintenanceClassMaster_DTO;
import assetmaintenance_class_master.model.master.AssetMaintenanceClassMaster;
import assetmaintenance_class_master.model.master.AssetMaintenanceClassMasterPK;
import assetmaintenance_class_master.model.repo.read.AssetMaintenanceClassMasterPublicRead_Repo;

@Service("assetMaintClassPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMaintenanceClassMasterPublicRead_Service implements I_AssetMaintenanceClassMasterPublicRead_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetMaintenanceClassMasterService.class);

	@Autowired
	private AssetMaintenanceClassMasterPublicRead_Repo assetMaintenanceClassMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getAllAssetMaintenanceClasses() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<AssetMaintenanceClassMaster> assetServicePlanList = (CopyOnWriteArrayList<AssetMaintenanceClassMaster>) assetMaintenanceClassMasterPublicReadRepo
							.getAllAssetClasses();
					CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> lMasterss = assetServicePlanList != null
							? this.getAssetMaintenanceClassMasterDtos(assetServicePlanList)
							: null;
					return lMasterss;
				}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getSelectClassesByResources(
			CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<AssetMaintenanceClassMaster> assetServicePlanList = (CopyOnWriteArrayList<AssetMaintenanceClassMaster>) assetMaintenanceClassMasterPublicReadRepo
							.getSelectClassesByResources(ids);
					CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> lMasterss = assetServicePlanList != null
							? this.getAssetMaintenanceClassMasterDtos(assetServicePlanList)
							: null;
					return lMasterss;
				}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getSelectClassesByParties(
			CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<AssetMaintenanceClassMaster> assetServicePlanList = (CopyOnWriteArrayList<AssetMaintenanceClassMaster>) assetMaintenanceClassMasterPublicReadRepo
							.getSelectClassesByParties(ids);
					CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> lMasterss = assetServicePlanList != null
							? this.getAssetMaintenanceClassMasterDtos(assetServicePlanList)
							: null;
					return lMasterss;
				}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> getAssetMaintenanceClassMasterDtos(
			CopyOnWriteArrayList<AssetMaintenanceClassMaster> lMasters) {
		AssetMaintenanceClassMaster_DTO lDTO = null;
		CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>();

		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = this.getAssetMaintenanceClassMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized AssetMaintenanceClassMaster_DTO getAssetMaintenanceClassMaster_DTO(
			AssetMaintenanceClassMaster lMaster) {
		AssetMaintenanceClassMaster_DTO lDTO = new AssetMaintenanceClassMaster_DTO();
		lDTO.setMaintenanceClassSeqNo(lMaster.getId().getMaintenanceClassSeqNo());
		lDTO.setPartySeqNo(lMaster.getId().getPartySeqNo());
		lDTO.setResourceSeqNo(lMaster.getId().getResourceSeqNo());
		return lDTO;
	}

}