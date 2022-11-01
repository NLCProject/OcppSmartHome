package org.ocpp.smart.home.services.init.interfaces

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener

/**
 * Service to start OCPP client on start up.
 */
interface IClientOnStartService {

    /**
     * Start OCPP client and publish OCPP register event.
     */
    @EventListener(ApplicationReadyEvent::class)
    fun startServer()
}
