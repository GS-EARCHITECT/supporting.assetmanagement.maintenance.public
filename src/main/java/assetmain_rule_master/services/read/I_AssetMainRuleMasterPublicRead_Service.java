package assetmain_rule_master.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import assetmain_rule_master.model.dto.AssetMainRuleMaster_DTO;

public interface I_AssetMainRuleMasterPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> getAllAssetMainRules();
    public CompletableFuture<CopyOnWriteArrayList<AssetMainRuleMaster_DTO>> getSelectRules(CopyOnWriteArrayList<Long> ids);
}