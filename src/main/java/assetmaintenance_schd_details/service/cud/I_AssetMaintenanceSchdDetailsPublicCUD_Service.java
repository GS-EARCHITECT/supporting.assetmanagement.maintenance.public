package assetmaintenance_schd_details.service.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

import assetmaintenance_schd_details.model.dto.AssetMaintenanceSchdDetail_DTO;

public interface I_AssetMaintenanceSchdDetailsPublicCUD_Service
{
    public CompletableFuture<AssetMaintenanceSchdDetail_DTO> newAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO asssetMaintMasterDTO);
    public CompletableFuture<Void> updAssetMaintenanceSchdDetail(AssetMaintenanceSchdDetail_DTO assetMaintenanceSchdDetail_DTO);
    public CompletableFuture<Void> delAllAssetMaintenanceSchdDetails();
    public CompletableFuture<Void> delSelectAssetMaintenanceDetails(CopyOnWriteArrayList<Long> aList);    
    public CompletableFuture<Void> delSelectSchedulesByMaintenance( CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<Void> delSelectSchedulesByScheduleIds( CopyOnWriteArrayList<String> ids);
    public CompletableFuture<Void> delSelectSchedulesByResSrvProds( CopyOnWriteArrayList<Long> ids);
    public CompletableFuture<Void> delAssetsOK();
	public CompletableFuture<Void> delAssetsDone();
	public CompletableFuture<Void> delAssetsNotOK();
	public CompletableFuture<Void> delAssetsNotDone();
	public CompletableFuture<Void> delAssetsWIP();
	public CompletableFuture<Void> delAssetsNotWIP();
	public CompletableFuture<Void> delAssetsBetweenDTTM( String fr,  String to);
}