package assetmaintenance_class_master.controller.read;

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
import org.springframework.http.MediaType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import assetmaintenance_class_master.model.dto.AssetMaintenanceClassMaster_DTO;
import assetmaintenance_class_master.model.master.AssetMaintenanceClassMasterPK;
import assetmaintenance_class_master.services.read.I_AssetMaintenanceClassMasterPublicRead_Service;

@RestController
@RequestMapping("/assetMaintClassMasterPublicReadMgmt")
public class AssetMaintenanceClassMasterPublicRead_Controller {

	// private static final Logger AssetMaintenanceClassgger =
	// LoggerFactory.getLogger(AssetMaintenanceClassClass_AssetMaintenanceClassClass_Lontroller.class);

	@Autowired
	private I_AssetMaintenanceClassMasterPublicRead_Service assetMaintClassMasterPublicReadServ;

	@GetMapping(value = "/getAllAssetMaintenanceClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getAllAssetMaintenanceClassMasters() {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> completableFuture = assetMaintClassMasterPublicReadServ
				.getAllAssetMaintenanceClasses();
		CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> accServPlanClassDTOs = completableFuture.join();
		return new ResponseEntity<>(accServPlanClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssetMaintenanceClassesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getSelectAssetMaintenanceClassMastersByParties(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> completableFuture = assetMaintClassMasterPublicReadServ
				.getSelectClassesByParties(ids);
		CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> accServPlanClassDTOs = completableFuture.join();
		return new ResponseEntity<>(accServPlanClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssetMaintenanceClassesByResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getSelectAssetMaintenanceClassMastersByResources(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> completableFuture = assetMaintClassMasterPublicReadServ
				.getSelectClassesByResources(ids);
		CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> accServPlanClassDTOs = completableFuture.join();
		return new ResponseEntity<>(accServPlanClassDTOs, HttpStatus.OK);
	}

}