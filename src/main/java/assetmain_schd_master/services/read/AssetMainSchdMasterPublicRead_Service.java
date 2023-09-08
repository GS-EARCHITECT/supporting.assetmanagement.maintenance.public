package assetmain_schd_master.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import assetmain_schd_master.model.dto.AssetMainSchdMaster_DTO;
import assetmain_schd_master.model.master.AssetMainSchdMaster;
import assetmain_schd_master.model.repo.read.AssetMainSchdMasterPublicRead_Repo;

@Service("assetMainSchdMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMainSchdMasterPublicRead_Service implements I_AssetMainSchdMasterPublicRead_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetMainSchdMasterService.class);

	@Autowired
	private AssetMainSchdMasterPublicRead_Repo assetMainSchdMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> getAllAssetMainSchds()
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<AssetMainSchdMaster> assetMainSchdMasters = assetMainSchdMasterPublicReadRepo.getAllScheduleMasters();
					CopyOnWriteArrayList<AssetMainSchdMaster_DTO> lMasterss = assetMainSchdMasters != null ? this.getAssetMainSchdMasterDtos(assetMainSchdMasters)	: null;
					return lMasterss;
				}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> getSelectSchds(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<AssetMainSchdMaster> assetMainSchdMasters = assetMainSchdMasterPublicReadRepo.getSelectScheduleMasters(ids);
					CopyOnWriteArrayList<AssetMainSchdMaster_DTO> lMasterss = assetMainSchdMasters != null ? this.getAssetMainSchdMasterDtos(assetMainSchdMasters)	: null;
					return lMasterss;
				}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<AssetMainSchdMaster_DTO> getAssetMainSchdMasterDtos(CopyOnWriteArrayList<AssetMainSchdMaster> lMasters) {
		AssetMainSchdMaster_DTO lDTO = null;
		CopyOnWriteArrayList<AssetMainSchdMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<AssetMainSchdMaster_DTO>();

		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = this.getAssetMainSchdMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized AssetMainSchdMaster_DTO getAssetMainSchdMaster_DTO(AssetMainSchdMaster lMaster) {
		AssetMainSchdMaster_DTO lDTO = new AssetMainSchdMaster_DTO();
		lDTO.setLapseDays(lMaster.getLapseDays());
		lDTO.setNoOfOccurences(lMaster.getNoOfOccurences());
		lDTO.setRessrvprdSeqNo(lMaster.getId().getRessrvprdSeqNo());
		lDTO.setRuleSeqNo(lMaster.getId().getRuleSeqNo());
		return lDTO;
	}

}