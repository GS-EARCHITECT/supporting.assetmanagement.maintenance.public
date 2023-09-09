package assetmaintenance_master.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import assetmaintenance_master.model.dto.AssetMaintenanceMaster_DTO;

public interface I_AssetMaintenanceMasterPublicCUD_Service
{
    public CompletableFuture<AssetMaintenanceMaster_DTO> newAssetMaintenanceMaster(AssetMaintenanceMaster_DTO assetMaintenanceMaster_DTO);
    public CompletableFuture<Void> updAssetMaintenanceMaster(AssetMaintenanceMaster_DTO assetMaintenanceMaster_DTO);
    public CompletableFuture<Void> setAssetsOK( CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<Void> setAssetsDone( CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<Void> setAssetsNotOK( CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<Void> setAssetsNotDone( CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<Void> delSelectAssets(CopyOnWriteArrayList<Long> aList);
    public CompletableFuture<Void> delAssetsByClasses(CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<Void> delAssetsByAssets(CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<Void> delAssetsByIds(CopyOnWriteArrayList<String> ids);
    public CompletableFuture<Void> delAssetsOK();
    public CompletableFuture<Void> delAssetsDone();
    public CompletableFuture<Void> delAssetsNotOK();
    public CompletableFuture<Void> delAssetsNotDone();
    public CompletableFuture<Void> delAssetsBetweenPlanDTTM( String fr,  String to);
    public CompletableFuture<Void> delAssetsBetweenActualDTTM( String fr,  String to);
    public CompletableFuture<Void> delAllAssetMaintenanceMasters();
  }