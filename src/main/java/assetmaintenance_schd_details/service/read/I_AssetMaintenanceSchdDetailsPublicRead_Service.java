package assetmaintenance_schd_details.service.read;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;

public interface I_AssetMaintenanceSchdDetailsPublicRead_Service
{
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAllAssetMaintenanceSchdDetails();
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectAssetMaintDetails(CopyOnWriteArrayList<Long> aList);
    public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByMaintenance( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByScheduleIds( CopyOnWriteArrayList<String> ids);
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getSelectSchedulesByResSrvProds( CopyOnWriteArrayList<Long> ids);
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsOK();
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsDone();
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotOK();
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotDone();
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsWIP();
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsNotWIP();
	public CompletableFuture<CopyOnWriteArrayList<AssetMaintenanceSchdDetail_DTO>> getAssetsBetweenDTTM(String  fr,  String to);    
}