package org.ocpp.smart.home.services.init

import org.ocpp.client.client.interfaces.IClientInitService
import org.ocpp.smart.home.services.init.interfaces.IClientOnStartService
import org.ocpp.smart.home.events.ClientRegisteredEvent
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class ClientOnStartService @Autowired constructor(
    private val clientInitService: IClientInitService,
    private val applicationEventPublisher: ApplicationEventPublisher
) : IClientOnStartService {

    @Value("\${ocpp.ip.address}")
    lateinit var ipAddress: String

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun startServer() {
        logger.info("Starting OCPP client on IP address '$ipAddress'")
        clientInitService.init(ipAddress = ipAddress)
        applicationEventPublisher.publishEvent(ClientRegisteredEvent(source = this))
    }
}
