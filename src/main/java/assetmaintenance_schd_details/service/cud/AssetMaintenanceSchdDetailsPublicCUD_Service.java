package assetmaintenance_schd_details.service.cud;

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
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;
import assetmaintenance_schd_details.model.master.AssetMaintenanceSchdDetail;
import assetmaintenance_schd_details.model.repo.cud.AssetMainSchdDetailsPublicCUD_Repo;

@Service("assetMaintSchdDetailsPublicCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMaintenanceSchdDetailsPublicCUD_Service implements I_AssetMaintenanceSchdDetailsPublicCUD_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetMaintenanceSchdDetailService.class);
	
	@Autowired
    private AssetMainSchdDetailsPublicCUD_Repo assetMainSchdDetailsPublicCUDRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	public CompletableFuture<AssetMaintenanceSchdDetail_DTO> newAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO lMaster) 
	{
		CompletableFuture<AssetMaintenanceSchdDetail_DTO> future = CompletableFuture.supplyAsync(() -> {
		AssetMaintenanceSchdDetail_DTO assetMaintenanceSchdDetail_DTO = null; 	
		if(!assetMainSchdDetailsPublicCUDRepo.existsById(lMaster.getScheduleSeqNo()))
		{
		assetMaintenanceSchdDetail_DTO = this.getAssetMaintenanceSchdDetail_DTO(assetMainSchdDetailsPublicCUDRepo.save(this.setAssetMaintenanceSchdDetail(lMaster)));
		}
		return assetMaintenanceSchdDetail_DTO;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> updAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO assetMaintenanceSchdDetail_DTO) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		if(assetMaintenanceSchdDetail_DTO!=null)
		{		
		if (assetMainSchdDetailsPublicCUDRepo.existsById(assetMaintenanceSchdDetail_DTO.getScheduleSeqNo()))
		{
			AssetMaintenanceSchdDetail assetMaintenanceSchdDetail = this.setAssetMaintenanceSchdDetail(assetMaintenanceSchdDetail_DTO); 
			assetMaintenanceSchdDetail.setScheduleSeqNo(assetMaintenanceSchdDetail_DTO.getScheduleSeqNo());
			assetMainSchdDetailsPublicCUDRepo.save(assetMaintenanceSchdDetail);
		}
		}
		return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAllAssetMaintenanceSchdDetails() 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		assetMainSchdDetailsPublicCUDRepo.deleteAll();
		return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delSelectAssetMaintenanceDetails(CopyOnWriteArrayList<Long> aList) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.deleteAllById(aList);
			return;
			}, asyncExecutor);
			return future;	
	}

	public CompletableFuture<Void> delSelectSchedulesByMaintenance( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delSelectSchedulesByMaintenance(ids);
			return;
			}, asyncExecutor);
			return future;	
	
	}
	
	public CompletableFuture<Void> delSelectSchedulesByScheduleIds( CopyOnWriteArrayList<String> ids) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delSelectSchedulesByScheduleIds(ids);
			return;
			}, asyncExecutor);
			return future;	
	}
	
	public CompletableFuture<Void> delSelectSchedulesByResSrvProds( CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delSelectSchedulesByResSrvProds(ids);
			return;
			}, asyncExecutor);
			return future;		
	}
	
	public CompletableFuture<Void> delAssetsOK()
	{
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delAssetsOK();
			return;
			}, asyncExecutor);
			return future;		

	}
	
    public CompletableFuture<Void> delAssetsDone()
    {
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delAssetsDone();
			return;
			}, asyncExecutor);
			return future;		

	}
    
    public CompletableFuture<Void> delAssetsNotOK()
    {
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delAssetsNotOK();
			return;
			}, asyncExecutor);
			return future;
	}
    
    public CompletableFuture<Void> delAssetsNotDone()
    {
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delAssetsNotDone();
			return;
			}, asyncExecutor);
			return future;
	}	
	
    public CompletableFuture<Void> delAssetsWIP()
    {
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delAssetsWIP();
			return;
			}, asyncExecutor);
			return future;
	}
    
    public CompletableFuture<Void> delAssetsNotWIP()
    {
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMainSchdDetailsPublicCUDRepo.delAssetsNotWIP();
			return;
			}, asyncExecutor);
			return future;

	}
    
    public CompletableFuture<Void> delAssetsBetweenDTTM( String fr,  String to) 
	{
    	CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		assetMainSchdDetailsPublicCUDRepo.delAssetsBetweenDTTM(ts_Fr, ts_To);		
		return;
		}, asyncExecutor);
		return future;
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

	private synchronized AssetMaintenanceSchdDetail setAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO lDTO) {
		AssetMaintenanceSchdDetail lMaster = new AssetMaintenanceSchdDetail();		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = LocalDateTime.parse(lDTO.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		lMaster.setFrDttm(ts_Fr);
		lMaster.setToDttm(ts_To);
		lMaster.setAssetMaintenanceSeqNo(lDTO.getAssetMaintenanceSeqNo());
		lMaster.setDoneflag(lDTO.getDoneflag());
		lMaster.setOkflag(lDTO.getOkflag());
		lMaster.setRessrvprdSeqNo(lDTO.getRessrvprdSeqNo());
		lMaster.setRuleSeqNo(lDTO.getRuleSeqNo());
		lMaster.setScheduleId(lDTO.getScheduleId());
		lMaster.setWipflag(lDTO.getWipflag());
		return lMaster;
	}
	
}