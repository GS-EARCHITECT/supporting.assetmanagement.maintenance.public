package assetmaintenance_class_master.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import assetmaintenance_class_master.model.dto.AssetMaintenanceClassMaster_DTO;

public interface I_AssetMaintenanceClassMasterPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getAllAssetMaintenanceClasses();
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getSelectClassesByResources(CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceClassMaster_DTO>> getSelectClassesByParties(CopyOnWriteArrayList<Long> ids);    
}