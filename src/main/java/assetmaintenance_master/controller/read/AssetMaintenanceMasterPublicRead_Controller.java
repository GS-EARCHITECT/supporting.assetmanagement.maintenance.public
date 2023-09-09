package assetmaintenance_master.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import assetmaintenance_master.model.dto.AssetMaintenanceMaster_DTO;
import assetmaintenance_master.services.read.I_AssetMaintenanceMasterPublicRead_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/assetMaintenanceMasterPublicReadMgmt")
public class AssetMaintenanceMasterPublicRead_Controller {

	// private static final Logger AssetMaintenancegger =
	// LoggerFactory.getLogger(AssetMaintenance_AssetMaintenance_Lontroller.class);

	@Autowired
	private I_AssetMaintenanceMasterPublicRead_Service assetMaintenanceMasterPublicReadService;

	@GetMapping(value = "/getAllAssetMaintenance", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAllAssetMaintenanceMasters() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAllAssets();
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getSelectAssets(
			@RequestBody CopyOnWriteArrayList<Long> aList) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getSelectAssets(aList);
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsByClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByClasses(
			@RequestBody CopyOnWriteArrayList<Long> aList) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsByClasses(aList);
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsByAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByAssets(
			@RequestBody CopyOnWriteArrayList<Long> aList) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsByAssets(aList);
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsByIds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByIds(
			@RequestBody CopyOnWriteArrayList<String> aList) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsByIds(aList);
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsOK", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsOK() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsOK();
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsDone() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsDone();
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsNotOK", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsNotOK() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsNotOK();
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsNotDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsNotDone() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsNotDone();
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsBetweenPlanDTTM/{fr]/[to]", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsBetweenPlanDTTM(
			@PathVariable String fr, @PathVariable String to) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsBetweenPlanDTTM(fr, to);
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsBetweenActualDTTM/{fr]/[to]", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsBetweenActualDTTM(
			@PathVariable String fr, @PathVariable String to) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> completableFuture = assetMaintenanceMasterPublicReadService
				.getAssetsBetweenActualDTTM(fr, to);
		CopyOnWriteArrayList<AssetMaintenanceMaster_DTO> assetMaintDTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintDTOs, HttpStatus.OK);
	}

}