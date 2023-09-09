package assetmaintenance_master.controller.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import assetmaintenance_master.model.dto.AssetMaintenanceMaster_DTO;
import assetmaintenance_master.services.cud.I_AssetMaintenanceMasterPublicCUD_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/assetMaintenanceMasterPublicCUDMgmt")
public class AssetMaintenanceMasterPublicCUD_Controller {

	// private static final Logger AssetMaintenancegger =
	// LoggerFactory.getLogger(AssetMaintenance_AssetMaintenance_Lontroller.class);

	@Autowired
	private I_AssetMaintenanceMasterPublicCUD_Service assetMaintenanceMasterPublicCUDService;

	@PostMapping("/new")
	public ResponseEntity<AssetMaintenanceMaster_DTO> newAssetMaintenance(
			@RequestBody AssetMaintenanceMaster_DTO assetMaintDTO) {

		CompletableFuture<AssetMaintenanceMaster_DTO> completableFuture = assetMaintenanceMasterPublicCUDService
				.newAssetMaintenanceMaster(assetMaintDTO);
		AssetMaintenanceMaster_DTO assetMaintDTO2 = completableFuture.join();
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetMaintDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping("/updAssetMaintenance")
	public void updateAssetMaintenance(@RequestBody AssetMaintenanceMaster_DTO assetMaintDTO) {
		assetMaintenanceMasterPublicCUDService.updAssetMaintenanceMaster(assetMaintDTO);
		return;
	}

	@PutMapping("/setAssetsOK")
	public void setAssetsOK(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintenanceMasterPublicCUDService.setAssetsOK(aList);
		return;
	}

	@PutMapping("/setAssetsNotOK")
	public void setAssetsNotOK(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintenanceMasterPublicCUDService.setAssetsNotOK(aList);
		return;
	}

	@PutMapping("/setAssetsDone")
	public void setAssetsDone(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintenanceMasterPublicCUDService.setAssetsDone(aList);
		return;
	}

	@PutMapping("/setAssetsNotDone")
	public void setAssetsNotDone(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintenanceMasterPublicCUDService.setAssetsNotDone(aList);
		return;
	}

	@DeleteMapping("/delSelectAssets")
	public void deleteSelectAssets(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintenanceMasterPublicCUDService.delSelectAssets(aList);
		return;
	}

	@DeleteMapping("/delAssetsByClasses")
	public void delAssetsByClasses(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintenanceMasterPublicCUDService.delAssetsByClasses(aList);
	}

	@DeleteMapping("/delAssetsByAssets")
	public void delAssetsByAssets(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintenanceMasterPublicCUDService.delAssetsByAssets(aList);
	}

	@DeleteMapping("/delAssetsByIds")
	public void delAssetsByIds(@RequestBody CopyOnWriteArrayList<String> sList) {
		assetMaintenanceMasterPublicCUDService.delAssetsByIds(sList);
	}

	@DeleteMapping("/delAssetsOK")
	public void delAssetsOK() {
		assetMaintenanceMasterPublicCUDService.delAssetsOK();
	}

	@DeleteMapping("/delAssetsDone")
	public void delAssetsDone() {
		assetMaintenanceMasterPublicCUDService.delAssetsDone();
	}

	@DeleteMapping("/delAssetsNotOK")
	public void delAssetsNotOK() {
		assetMaintenanceMasterPublicCUDService.delAssetsNotOK();
	}

	@DeleteMapping("/delAssetsNotDone")
	public void delAssetsNotDone() {
		assetMaintenanceMasterPublicCUDService.delAssetsNotDone();
	}

	@DeleteMapping("/delAssetsBetweenPlanDTTM/[fr]/[to]")
	public void delAssetsBetweenPlanDTTM(@PathVariable String fr, @PathVariable String to) {
		assetMaintenanceMasterPublicCUDService.delAssetsBetweenPlanDTTM(fr, to);
	}

	@DeleteMapping("/delAssetsBetweenActualDTTM/[fr]/[to]")
	public void delAssetsBetweenActualDTTM(@PathVariable String fr, @PathVariable String to) {
		assetMaintenanceMasterPublicCUDService.delAssetsBetweenActualDTTM(fr, to);
	}

	@DeleteMapping("/delAllAssetMaintenance")
	public void deleteAllAssetMaintenances() {
		assetMaintenanceMasterPublicCUDService.delAllAssetMaintenanceMasters();
		;
	}
}