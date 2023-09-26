package adv_producer.services;

import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import adv_producer.model.master.AdvMaster;
import adv_producer.model.master.AdvMaster_DTO;
import adv_producer.model.repo.AdvMasterPublicRead_Repo;

@Service("advBroadcastServiceServ")
public class AdvSchdBroadcast_Service implements I_AdvSchdBroadcast_Service 
{
	private static final Logger logger = LoggerFactory.getLogger(AdvSchdBroadcast_Service.class);

	@Autowired
	private AdvMasterPublicRead_Repo advMasterPublicReadRepo;

	@Value("${topic.name.adproducer}")
	private String topicmyAd;

	@Autowired
	private KafkaTemplate<String, AdvMaster_DTO> kafkaTemplateRequest;

	@Scheduled(fixedRate = 3000)
	public void runBatch() {
		// For Each Asset - Get All Res Prod Servs
		AdvMaster advMaster = null;
		CopyOnWriteArrayList<AdvMaster> advMasters = advMasterPublicReadRepo.getAllAds();
		
		if (advMasters != null && advMasters.size() > 0) 
		{
			logger.info("running for size :"+advMasters.size());
			
			for (int i = 0; i < advMasters.size(); i++) 
			{
				advMaster = advMasters.get(i);				
				sendToAdListener(advMaster);
			}
		}
		return;
	}

	public synchronized void sendToAdListener(AdvMaster advMaster) 
	{
		AdvMaster_DTO advMaster_DTO = new AdvMaster_DTO();
		advMaster_DTO.setAd(advMaster.getAd());
		advMaster_DTO.setAdvSeqNo(advMaster.getAdvSeqNo());		
		ListenableFuture<SendResult<String, AdvMaster_DTO>> future = kafkaTemplateRequest.send(topicmyAd,advMaster_DTO);
		future.addCallback(new ListenableFutureCallback<SendResult<String, AdvMaster_DTO>>() {

			@Override
			public void onSuccess(final SendResult<String, AdvMaster_DTO> message) 
			{
				logger.info("Ad No :" + message.getProducerRecord().value().getAdvSeqNo());				
	//			logger.info("updated schedule for ruleline :" + message.getProducerRecord().value().getReferenceSeqNo());
			}

			@Override
			public void onFailure(final Throwable throwable) {
				logger.error("unable to send message= ", throwable);
			}
		});
		return;
	}
}
