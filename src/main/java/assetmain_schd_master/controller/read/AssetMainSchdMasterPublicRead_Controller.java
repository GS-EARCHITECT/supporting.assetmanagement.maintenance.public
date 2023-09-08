package assetmain_schd_master.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import assetmain_schd_master.model.dto.AssetMainSchdMaster_DTO;
import assetmain_schd_master.model.master.AssetMainSchdMasterPK;
import assetmain_schd_master.services.read.I_AssetMainSchdMasterPublicRead_Service;
import org.springframework.http.MediaType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/assetMainSchdPublicReadMgmt")
public class AssetMainSchdMasterPublicRead_Controller {

	// private static final Logger AssetMainSchdgger =
	// LoggerFactory.getLogger(AssetMainSchdSchd_AssetMainSchdSchd_Lontroller.class);

	@Autowired
	private I_AssetMainSchdMasterPublicRead_Service assetMainSchdMasterPublicReadServ;

	@GetMapping(value = "/getAllAssetMainSchd", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> getAllAssetMainSchdMasters() {
		CompletableFuture<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> completableFuture = assetMainSchdMasterPublicReadServ
				.getAllAssetMainSchds();
		CopyOnWriteArrayList<AssetMainSchdMaster_DTO> assetMainSchdMaster_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMainSchdMaster_DTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssetMainSchds", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> getSelectAssetMainSchdMasters(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> completableFuture = assetMainSchdMasterPublicReadServ
				.getSelectSchds(ids);
		CopyOnWriteArrayList<AssetMainSchdMaster_DTO> assetMainSchdMaster_DTOs = completableFuture.join();
		return new ResponseEntity<>(assetMainSchdMaster_DTOs, HttpStatus.OK);
	}

}