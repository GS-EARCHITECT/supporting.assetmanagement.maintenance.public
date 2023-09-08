package assetmain_rule_master.model.repo.read;

import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import assetmain_rule_master.model.master.AssetMainRuleMaster;

@Repository("assetMainRuleMasterPublicReadRepo")
public interface AssetMainRuleMasterPublicRead_Repo extends JpaRepository<AssetMainRuleMaster, Long> 
{
	@Query(value = "SELECT * FROM ASSET_MAIN_RULE_MASTER a WHERE a.rule_seq_no in :ids order by rule_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<AssetMainRuleMaster> getSelectRules(@Param("ids") CopyOnWriteArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ASSET_MAIN_RULE_MASTER a  order by rule_seq_no", nativeQuery = true)
	CopyOnWriteArrayList<AssetMainRuleMaster> getAllRules();
	
	
}