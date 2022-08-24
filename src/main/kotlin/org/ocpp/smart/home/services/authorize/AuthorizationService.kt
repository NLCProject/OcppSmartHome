package org.ocpp.smart.home.services.authorize

import org.ocpp.client.client.interfaces.IClientRequestService
import org.ocpp.smart.home.configuration.SmartHomeConfiguration
import org.ocpp.smart.home.events.ClientAuthorizedEvent
import org.ocpp.smart.home.services.authorize.interfaces.IAuthorizationService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class AuthorizationService @Autowired constructor(
    private val clientRequestService: IClientRequestService,
    private val applicationEventPublisher: ApplicationEventPublisher
) : IAuthorizationService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun authorize() {
        logger.info("Authorizing client")
        clientRequestService.authorize(idTag = SmartHomeConfiguration.idTag)
        applicationEventPublisher.publishEvent(ClientAuthorizedEvent(source = this))
    }
}
