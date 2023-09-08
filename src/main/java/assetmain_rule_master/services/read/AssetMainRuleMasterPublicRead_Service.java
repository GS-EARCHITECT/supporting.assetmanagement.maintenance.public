package assetmain_rule_master.services.read;

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
import assetmain_rule_master.model.dto.AssetMainRuleMaster_DTO;
import assetmain_rule_master.model.master.AssetMainRuleMaster;
import assetmain_rule_master.model.repo.read.AssetMainRuleMasterPublicRead_Repo;

@Service("assetMainRuleMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMainRuleMasterPublicRead_Service implements I_AssetMainRuleMasterPublicRead_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetMainRuleMasterService.class);

	@Autowired
	private AssetMainRuleMasterPublicRead_Repo assetMainRuleMasterPublicReadRepo;

	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> getAllAssetMainRules() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<AssetMainRuleMaster> assetMainRuleMasters = assetMainRuleMasterPublicReadRepo.getAllRules();
					CopyOnWriteArrayList<AssetMainRuleMaster_DTO> lMasterss = assetMainRuleMasters != null	? this.getAssetMainRuleMasterDtos(assetMainRuleMasters) : null;
					return lMasterss;
				}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> getSelectRules(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> future = CompletableFuture
				.supplyAsync(() -> {
					CopyOnWriteArrayList<AssetMainRuleMaster> assetMainRuleMasters = assetMainRuleMasterPublicReadRepo.getSelectRules(ids);
					CopyOnWriteArrayList<AssetMainRuleMaster_DTO> lMasterss = assetMainRuleMasters != null	? this.getAssetMainRuleMasterDtos(assetMainRuleMasters) : null;
					return lMasterss;
				}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<AssetMainRuleMaster_DTO> getAssetMainRuleMasterDtos(CopyOnWriteArrayList<AssetMainRuleMaster> lMasters) {
		AssetMainRuleMaster_DTO lDTO = null;
		CopyOnWriteArrayList<AssetMainRuleMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<AssetMainRuleMaster_DTO>();

		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = this.getAssetMainRuleMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized AssetMainRuleMaster_DTO getAssetMainRuleMaster_DTO(AssetMainRuleMaster lMaster) {
		AssetMainRuleMaster_DTO lDTO = new AssetMainRuleMaster_DTO();
		lDTO.setDateSeqNo(lMaster.getDateSeqNo());
		lDTO.setDaysPlus(lMaster.getDaysPlus());
		lDTO.setDow(lMaster.getDow());
		lDTO.setEom(lMaster.getEom());
		lDTO.setEoy(lMaster.getEoy());
		lDTO.setNoOfOccurences(lMaster.getNoOfOccurences());
		lDTO.setRuleSeqNo(lMaster.getRuleSeqNo());
		return lDTO;
	}

}