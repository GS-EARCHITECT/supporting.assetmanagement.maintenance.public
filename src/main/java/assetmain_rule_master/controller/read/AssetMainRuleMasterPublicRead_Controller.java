package assetmain_rule_master.controller.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import assetmain_rule_master.model.dto.AssetMainRuleMaster_DTO;
import assetmain_rule_master.services.read.I_AssetMainRuleMasterPublicRead_Service;
import org.springframework.http.MediaType;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/assetMainRuleMasterPublicReadMgmt")
public class AssetMainRuleMasterPublicRead_Controller {

	// private static final Logger AssetMainRulegger =
	// LoggerFactory.getLogger(AssetMainRuleRule_AssetMainRuleRule_Lontroller.class);

	@Autowired
	private I_AssetMainRuleMasterPublicRead_Service assetMainRuleMasterPublicReadServ;

	@GetMapping(value = "/getAllAssetMainRule", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> getAllAssetMainRuleMasters() {
		CompletableFuture<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> completableFuture = assetMainRuleMasterPublicReadServ
				.getAllAssetMainRules();
		CopyOnWriteArrayList<AssetMainRuleMaster_DTO> accServPlanRuleDTOs = completableFuture.join();
		return new ResponseEntity<>(accServPlanRuleDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssetMainRules", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> getSelectAssetMainRuleMasters(
			@RequestBody CopyOnWriteArrayList<Long> ids) {
		CompletableFuture<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> completableFuture = assetMainRuleMasterPublicReadServ
				.getSelectRules(ids);
		CopyOnWriteArrayList<AssetMainRuleMaster_DTO> accServPlanRuleDTOs = completableFuture.join();
		return new ResponseEntity<>(accServPlanRuleDTOs, HttpStatus.OK);
	}

}