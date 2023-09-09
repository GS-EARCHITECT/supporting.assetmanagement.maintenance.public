package assetmaintenance_master.services.cud;

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
import assetmaintenance_master.model.repo.cud.AssetMaintenanceMasterPublicCUD_Repo;

@Service("assetMaintenanceMasterPublicCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMaintenanceMasterPublicCUD_Service implements I_AssetMaintenanceMasterPublicCUD_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetMaintenanceMasterService.class);

	@Autowired
	private AssetMaintenanceMasterPublicCUD_Repo assetMaintenanceMasterPublicCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	public CompletableFuture<AssetMaintenanceMaster_DTO> newAssetMaintenanceMaster(AssetMaintenanceMaster_DTO lMaster) {
		CompletableFuture<AssetMaintenanceMaster_DTO> future = CompletableFuture.supplyAsync(() -> {
			AssetMaintenanceMaster_DTO assetMaintenanceMaster_DTO = null;
			if (assetMaintenanceMasterPublicCUDRepo.existsById(lMaster.getAssetMaintenanceSeqNo())) {
				assetMaintenanceMaster_DTO = getAssetMaintenanceMaster_DTO(
						assetMaintenanceMasterPublicCUDRepo.save(this.setAssetMaintenanceMaster(lMaster)));
			}
			return assetMaintenanceMaster_DTO;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> updAssetMaintenanceMaster(AssetMaintenanceMaster_DTO lMaster) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			if (assetMaintenanceMasterPublicCUDRepo.existsById(lMaster.getAssetMaintenanceSeqNo())) {
				AssetMaintenanceMaster assetMaintenanceMaster = this.setAssetMaintenanceMaster(lMaster);
				assetMaintenanceMaster.setAssetMaintenanceSeqNo(lMaster.getAssetMaintenanceSeqNo());
				assetMaintenanceMasterPublicCUDRepo.save(assetMaintenanceMaster);
			}
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> setAssetsOK(CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.setAssetsOK(ids);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> setAssetsNotOK(CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.setAssetsNotOK(ids);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> setAssetsDone(CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.setAssetsDone(ids);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> setAssetsNotDone(CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.setAssetsNotDone(ids);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAllAssetMaintenanceMasters() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delSelectAssets(CopyOnWriteArrayList<Long> aList) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.deleteAllById(aList);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsByClasses(CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.delAssetsByClasses(ids);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsByAssets(CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.delAssetsByAssets(ids);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsByIds(CopyOnWriteArrayList<String> ids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.delAssetsByIds(ids);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsOK() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.delAssetsOK();
			;
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsDone() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.delAssetsDone();
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsNotOK() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.delAssetsNotOK();
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsNotDone() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			assetMaintenanceMasterPublicCUDRepo.delAssetsNotDone();
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsBetweenPlanDTTM(String fr, String to) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
			LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
			Timestamp ts_Fr = Timestamp.valueOf(dateOn);
			Timestamp ts_To = Timestamp.valueOf(dateTo);
			assetMaintenanceMasterPublicCUDRepo.delAssetsBetweenPlanDTTM(ts_Fr, ts_To);
			return;
		}, asyncExecutor);
		return future;
	}

	public CompletableFuture<Void> delAssetsBetweenActualDTTM(String fr, String to) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
			LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
			Timestamp ts_Fr = Timestamp.valueOf(dateOn);
			Timestamp ts_To = Timestamp.valueOf(dateTo);
			assetMaintenanceMasterPublicCUDRepo.delAssetsBetweenActualDTTM(ts_Fr, ts_To);
			return;
		}, asyncExecutor);
		return future;
	}

	private synchronized AssetMaintenanceMaster_DTO getAssetMaintenanceMaster_DTO(AssetMaintenanceMaster lMaster) {
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

	private synchronized AssetMaintenanceMaster setAssetMaintenanceMaster(AssetMaintenanceMaster_DTO lDTO) {
		AssetMaintenanceMaster lMaster = new AssetMaintenanceMaster();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime pldateFr = null;
		LocalDateTime pldateTo = null;
		LocalDateTime acdateFr = null;
		LocalDateTime acdateTo = null;
		pldateFr = LocalDateTime.parse(lDTO.getPlDttmFr(), formatter);
		pldateTo = LocalDateTime.parse(lDTO.getPlDttmTo(), formatter);
		acdateFr = LocalDateTime.parse(lDTO.getAcDttmFr(), formatter);
		acdateTo = LocalDateTime.parse(lDTO.getAcDttmTo(), formatter);
		Timestamp plts_Fr = Timestamp.valueOf(pldateFr);
		Timestamp plts_To = Timestamp.valueOf(pldateTo);
		Timestamp acts_Fr = Timestamp.valueOf(acdateFr);
		Timestamp acts_To = Timestamp.valueOf(acdateTo);
		lMaster.setPlDttmFr(plts_Fr);
		lMaster.setAcDttmFr(acts_Fr);
		lMaster.setPlDttmTo(plts_To);
		lMaster.setAcDttmTo(acts_To);
		lMaster.setAssetSeqNo(lDTO.getAssetSeqNo());
		lMaster.setAssetSeqNo(lDTO.getAssetSeqNo());
		lMaster.setDoneflag(lDTO.getDoneflag());
		lMaster.setMaintenanceClassSeqNo(lDTO.getMaintenanceClassSeqNo());
		lMaster.setMaintenanceId(lDTO.getMaintenanceId());
		lMaster.setOkflag(lDTO.getOkflag());
		return lMaster;
	}

}