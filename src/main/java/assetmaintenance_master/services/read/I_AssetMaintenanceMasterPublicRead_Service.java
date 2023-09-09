package assetmaintenance_master.services.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import assetmaintenance_master.model.dto.AssetMaintenanceMaster_DTO;

public interface I_AssetMaintenanceMasterPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAllAssets();
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getSelectAssets(CopyOnWriteArrayList<Long> aList);
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByClasses( CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByAssets( CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsByIds(CopyOnWriteArrayList<String> ids);
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsOK();
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsDone();
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsNotOK();
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsNotDone();
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsBetweenPlanDTTM( String fr,  String to);
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceMaster_DTO>> getAssetsBetweenActualDTTM( String fr,  String to);    
  }