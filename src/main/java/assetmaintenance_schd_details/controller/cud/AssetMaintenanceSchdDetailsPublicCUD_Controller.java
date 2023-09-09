package assetmaintenance_schd_details.controller.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;
import assetmaintenance_schd_details.service.cud.I_AssetMaintenanceSchdDetailsPublicCUD_Service;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/assetMaintenanceSchdDetailsPublicCUDMgmt")
public class AssetMaintenanceSchdDetailsPublicCUD_Controller {

	// private static final Logger AssMainSchdDetailsgger =
	// LoggerFactory.getLogger(AssetMaint_AssetMaint_Lontroller.class);

	@Autowired
	private I_AssetMaintenanceSchdDetailsPublicCUD_Service assetMaintSchdDetailsPublicCUDServ;

	@PostMapping("/new")
	public ResponseEntity<AssetMaintenanceSchdDetail_DTO> newAssetMaint(
			@RequestBody AssetMaintenanceSchdDetail_DTO assetMaintDetailsDTO) {
		CompletableFuture<AssetMaintenanceSchdDetail_DTO> completableFuture = assetMaintSchdDetailsPublicCUDServ
				.newAssetMaintenanceSchdDetail(assetMaintDetailsDTO);
		AssetMaintenanceSchdDetail_DTO assetMaintDetailsDTO2 = completableFuture.join();
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetMaintDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping("/updAssetMaint")
	public void updateAssetMaint(@RequestBody AssetMaintenanceSchdDetail_DTO assetMaintSchdDetailDTO) {
		assetMaintSchdDetailsPublicCUDServ.updAssetMaintenanceSchdDetail(assetMaintSchdDetailDTO);
	}

	@DeleteMapping("/delSelectAssMainSchdDetails")
	public void deleteSelectAssMainSchdDetails(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintSchdDetailsPublicCUDServ.delSelectAssetMaintenanceDetails(aList);
	}

	@DeleteMapping("/delSelectSchedulesByMaintenance")
	public void delSelectSchedulesByMaintenance(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintSchdDetailsPublicCUDServ.delSelectSchedulesByMaintenance(aList);
	}

	@DeleteMapping("/delSelectSchedulesByScheduleIds")
	public void delSelectSchedulesByScheduleIds(@RequestBody CopyOnWriteArrayList<String> aList) {
		assetMaintSchdDetailsPublicCUDServ.delSelectSchedulesByScheduleIds(aList);
	}

	@DeleteMapping("/delSelectSchedulesByResSrvProds")
	public void delSelectSchedulesByResSrvProds(@RequestBody CopyOnWriteArrayList<Long> aList) {
		assetMaintSchdDetailsPublicCUDServ.delSelectSchedulesByResSrvProds(aList);
	}

	@DeleteMapping("/delAssetsOK")
	public void delAssetsOK() {
		assetMaintSchdDetailsPublicCUDServ.delAssetsOK();
	}

	@DeleteMapping("/delAssetsNotOK")
	public void delAssetsNotOK() {
		assetMaintSchdDetailsPublicCUDServ.delAssetsNotOK();
	}

	@DeleteMapping("/delAssetsDone")
	public void delAssetsDone() {
		assetMaintSchdDetailsPublicCUDServ.delAssetsDone();
		;
	}

	@DeleteMapping("/delAssetsNotDone")
	public void delAssetsNotDone() {
		assetMaintSchdDetailsPublicCUDServ.delAssetsNotDone();
	}

	@DeleteMapping("/delAssetsWIP")
	public void delAssetsWIP() {
		assetMaintSchdDetailsPublicCUDServ.delAssetsWIP();
	}

	@DeleteMapping("/delAssetsNotWIP")
	public void delAssetsNotWIP() {
		assetMaintSchdDetailsPublicCUDServ.delAssetsNotWIP();
	}

	@DeleteMapping("/delAssetsNotWIP/{fr}/{to}")
	public void delAssetsBetweenDTTM(String fr, String to) {
		assetMaintSchdDetailsPublicCUDServ.delAssetsBetweenDTTM(fr, to);
	}

	@DeleteMapping("/delAllAssMainSchdDetails")
	public void deleteAllAssetMaint() {
		assetMaintSchdDetailsPublicCUDServ.delAllAssetMaintenanceSchdDetails();
	}
}