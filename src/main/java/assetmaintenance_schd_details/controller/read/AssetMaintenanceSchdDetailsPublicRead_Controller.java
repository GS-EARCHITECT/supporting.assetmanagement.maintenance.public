package assetmaintenance_schd_details.controller.read;

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
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;
import assetmaintenance_schd_details.service.read.I_AssetMaintenanceSchdDetailsPublicRead_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/assetMaintenanceSchdDetailsPublicReadMgmt")
public class AssetMaintenanceSchdDetailsPublicRead_Controller {

	// private static final Logger AssMainSchdDetailsgger =
	// LoggerFactory.getLogger(AssetMaint_AssetMaint_Lontroller.class);

	@Autowired
	private I_AssetMaintenanceSchdDetailsPublicRead_Service assetMaintSchdDetailsPublicReadServ;

	@GetMapping(value = "/getAllAssMainSchdDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAllAssetMaintenance_Details() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getAllAssetMaintenanceSchdDetails();
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssMainSchdDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectAssetMaintenance_Details(
			@RequestBody CopyOnWriteArrayList<Long> aList) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getSelectAssetMaintDetails(aList);
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSchedulesByMaintenance", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByMaintenance(
			@RequestBody CopyOnWriteArrayList<Long> aList) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getSelectSchedulesByMaintenance(aList);
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSchedulesByScheduleIds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByScheduleIds(
			@RequestBody CopyOnWriteArrayList<String> aList) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getSelectSchedulesByScheduleIds(aList);
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectSchedulesByResSrvProds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByResSrvProds(
			@RequestBody CopyOnWriteArrayList<Long> aList) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getSelectSchedulesByResSrvProds(aList);
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsOK", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsOK() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getAssetsOK();
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsDone() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getAssetsDone();
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsNotOK", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotOK() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getAssetsNotOK();
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsNotDone", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotDone() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getAssetsNotDone();
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsWIP", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsWIP() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getAssetsWIP();
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsNotWIP", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotWIP() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getAssetsNotWIP();
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getAssetsBetweenDTTM/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsBetweenDTTM(
			@PathVariable String fr, @PathVariable String to) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> completableFuture = assetMaintSchdDetailsPublicReadServ
				.getAssetsBetweenDTTM(fr, to);
		CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO> assetMaintenanceSchdDetail_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMaintenanceSchdDetail_DTOs, HttpStatus.OK);
	}

}