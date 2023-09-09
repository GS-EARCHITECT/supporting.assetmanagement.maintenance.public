package assetmaintenance_master.services.read;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import assetmaintenance_master.model.dto.AssetMaintenanceMaster_DTO;
import assetmaintenance_master.model.master.AssetMaintenanceMaster;
import assetmaintenance_master.model.repo.read.AssetMaintenanceMasterPublicRead_Repo;

@Service("assetMaintenanceMasterPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMaintenanceMasterPublicRead_Service implements I_AssetMaintenanceMasterPublicRead_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetMaintenanceMasterService.class);
	
	@Autowired
    private AssetMaintenanceMasterPublicRead_Repo assetMaintenanceMasterPublicReadRepo;
		
	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAllAssets() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
					CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAllAssets();
					CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
					return lMasterss;
				}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getSelectAssets(CopyOnWriteArrayList<Long> aList) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getSelectAssets(aList);
			CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByClasses(CopyOnWriteArrayList<Long> aList) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getSelectAssets(aList);
			CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByAssets(CopyOnWriteArrayList<Long> aList) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAssetsByAssets(aList);
			CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByIds(CopyOnWriteArrayList<String> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAssetsByIds(ids);
			CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsOK() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAssetsOK();
			CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsDone() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAssetsDone();
			CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsNotOK() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAssetsNotOK();
			CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsNotDone() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAssetsNotDone();
			CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null	? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
			return lMasterss;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsBetweenPlanDTTM( String fr,  String to) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAssetsBetweenPlanDTTM(ts_Fr, ts_To);
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null ? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
		return lMasterss;
		}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsBetweenActualDTTM( String fr,  String to) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> future = CompletableFuture.supplyAsync(() -> {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		CopyOnWriteArrayList<AssetMaintenanceMaster> assetMaintenanceMasters = assetMaintenanceMasterPublicReadRepo.getAssetsBetweenActualDTTM(ts_Fr, ts_To);
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterss = assetMaintenanceMasters != null ? this.getAssetMaintenanceMasterDtos(assetMaintenanceMasters) : null;
		return lMasterss;
		}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> getAssetMaintenanceMasterDtos(CopyOnWriteArrayList<AssetMaintenanceMaster> lMasters) 
	{
		AssetMaintenanceMaster_DTO lDTO = null;
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> lMasterDTOs = new CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>();

		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = this.getAssetMaintenanceMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized AssetMaintenanceMaster_DTO getAssetMaintenanceMaster_DTO(AssetMaintenanceMaster lMaster) 
	{
		AssetMaintenanceMaster_DTO lDTO = new AssetMaintenanceMaster_DTO();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");				
		lDTO.setAssetSeqNo(lMaster.getAssetSeqNo());
		lDTO.setPlDttmFr(formatter.format(lMaster.getPlDttmFr().toLocalDateTime()));
		lDTO.setAcDttmFr(formatter.format(lMaster.getAcDttmFr().toLocalDateTime()));
		lDTO.setAssetMaintenanceSeqNo(lMaster.getAssetMaintenanceSeqNo());
		lDTO.setPlDttmTo(formatter.format(lMaster.getPlDttmTo().toLocalDateTime()));
		lDTO.setAcDttmTo(formatter.format(lMaster.getAcDttmTo().toLocalDateTime()));
		lDTO.setDoneflag(lMaster.getDoneflag());
		lDTO.setMaintenanceClassSeqNo(lMaster.getMaintenanceClassSeqNo());
		lDTO.setMaintenanceId(lMaster.getMaintenanceId());
		lDTO.setOkflag(lMaster.getOkflag());
		return lDTO;
	}
	
}