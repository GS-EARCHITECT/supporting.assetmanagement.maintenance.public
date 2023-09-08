package assetmaintenance_class_master.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import assetmaintenance_class_master.model.dto.AssetMaintenanceClassMaster_DTO;
import assetmaintenance_class_master.services.read.I_AssetMaintenanceClassMasterPublicRead_Service;
import org.springframework.http.MediaType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/assetMaintClassMasterPublicReadMgmt")
public class AssetMainClassMasterPublicRead_Controller 
{

	// private static final Logger AssetMainClassgger =
	// LoggerFactory.getLogger(AssetMainClassClass_AssetMainClassClass_Lontroller.class);

	@Autowired
	private I_AssetMaintenanceClassMasterPublicRead_Service assetMaintenanceClassMasterPublicReadServ;

	@GetMapping(value = "/getAllAssetMainClasses", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getAllAssetMainClassMasters() 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> completableFuture = assetMaintenanceClassMasterPublicReadServ.getAllAssetMaintenanceClasses();
		CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> accServPlanClassDTOs = completableFuture.join();
		return new ResponseEntity<>(accServPlanClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectClassesByResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getSelectClassesByResources(@RequestBody CopyOnWriteArrayList<Long> ids) 
	{
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> completableFuture = assetMaintenanceClassMasterPublicReadServ.getSelectClassesByResources(ids);
		CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> accServPlanClassDTOs = completableFuture.join();
		return new ResponseEntity<>(accServPlanClassDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectClassesByParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getSelectClassesByParties(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> completableFuture = assetMaintenanceClassMasterPublicReadServ.getSelectClassesByParties(ids);
		CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO> accServPlanClassDTOs = completableFuture.join();
		return new ResponseEntity<>(accServPlanClassDTOs, HttpStatus.OK);}

}