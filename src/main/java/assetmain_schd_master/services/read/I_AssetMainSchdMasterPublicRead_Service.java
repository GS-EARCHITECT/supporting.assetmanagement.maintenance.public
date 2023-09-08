package assetmain_schd_master.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import assetmain_schd_master.model.dto.AssetMainSchdMaster_DTO;

public interface I_AssetMainSchdMasterPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> getAllAssetMainSchds();
    public CompletableFuture<CopyOnWriteArrayList<AssetMainSchdMaster_DTO>> getSelectSchds(CopyOnWriteArrayList<Long> ids);
}