package org.ocpp.smart.home.services.heartbeat

import org.ocpp.client.client.interfaces.IClientRequestService
import org.ocpp.smart.home.services.heartbeat.interfaces.IHeartbeatService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class HeartbeatService @Autowired constructor(
    private val clientRequestService: IClientRequestService
): IHeartbeatService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Scheduled(fixedRate = 5_000, initialDelay = 5_000)
    override fun sendHeartbeat() {
        logger.info("Sending heartbeat")
        clientRequestService.heartbeat()
    }
}
