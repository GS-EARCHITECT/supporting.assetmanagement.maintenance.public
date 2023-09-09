package assetmaintenance_schd_details.service.read;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import assetmaintenance_master.model.dto.AssetMaintenanceMaster_DTO;
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;
import assetmaintenance_schd_details.model.master.AssetMaintenanceSchdDetail;
import assetmaintenance_schd_details.model.repo.read.AssetMainSchdDetailsPublicRead_Repo;

@Service("assetMaintSchdDetailsPublicReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMaintenanceSchdDetailsPublicRead_Service implements I_AssetMaintenanceSchdDetailsPublicRead_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetMaintenanceSchdDetailService.class);
	
	@Autowired
    private AssetMainSchdDetailsPublicRead_Repo assetMainSchdDetailsPublicReadRepo;
	
	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAllAssetMaintenanceSchdDetails() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getAllSchedules();
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
		}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectAssetMaintDetails(CopyOnWriteArrayList<Long> aList) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getSelectSchedules(aList);
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
			return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByMaintenance(CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getSelectSchedulesByMaintenance(ids);
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByScheduleIds( CopyOnWriteArrayList<String> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getSelectSchedulesByScheduleIds(ids);
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByResSrvProds( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getSelectSchedulesByResSrvProds(ids);
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsOK() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getAssetsOK();
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;
	
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsDone() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getAssetsDone();
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;	
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotOK() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getAssetsNotOK();
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotDone() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getAssetsNotDone();
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotWIP() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getAssetsNotWIP();
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;
	}

	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsWIP() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails =  assetMainSchdDetailsPublicReadRepo.getAssetsWIP();
			CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
			return lMasterss;
			}, asyncExecutor);
		return future;
	}
	
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsBetweenDTTM( String fr,  String to) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> future = CompletableFuture.supplyAsync(() -> {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail> assetMaintenanceSchdDetails = assetMainSchdDetailsPublicReadRepo.getAssetsBetweenDTTM(ts_Fr, ts_To);
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterss = assetMaintenanceSchdDetails != null ? this.getAssetMaintenanceSchdDetailDtos(assetMaintenanceSchdDetails) : null;
		return lMasterss;
		}, asyncExecutor);
	return future;

	}
    
	private synchronized CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> getAssetMaintenanceSchdDetailDtos(CopyOnWriteArrayList<AssetMaintenanceSchdDetail> lMasters) {
		AssetMaintenanceSchdDetail_DTO lDTO = null;
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> lMasterDTOs = new CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>();
		
		for (int i = 0; i < lMasters.size(); i++)
		{
			lDTO = this.getAssetMaintenanceSchdDetail_DTO(lMasters.get(i));					
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private synchronized AssetMaintenanceSchdDetail_DTO getAssetMaintenanceSchdDetail_DTO(AssetMaintenanceSchdDetail lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetMaintenanceSchdDetail_DTO lDTO = new AssetMaintenanceSchdDetail_DTO();		
		lDTO.setFrDttm(formatter.format(lMaster.getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lMaster.getToDttm().toLocalDateTime()));
		lDTO.setAssetMaintenanceSeqNo(lMaster.getAssetMaintenanceSeqNo());
		lDTO.setDoneflag(lMaster.getDoneflag());
		lDTO.setOkflag(lMaster.getOkflag());
		lDTO.setRessrvprdSeqNo(lMaster.getRessrvprdSeqNo());
		lDTO.setRuleSeqNo(lMaster.getRuleSeqNo());
		lDTO.setScheduleId(lMaster.getScheduleId());
		lDTO.setScheduleSeqNo(lMaster.getScheduleSeqNo());
		lDTO.setWipflag(lMaster.getWipflag());
		return lDTO;
	}

		
}